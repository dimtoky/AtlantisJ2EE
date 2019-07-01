/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.MDB;

import com.atlantis.MsgModels.DeviceMsg;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author cesi
 */
@Stateless
public class MobileMetricsSyncBean {

    private static String factoryString = "jms/mobileMetricsConnectionFactory";
    private static String topicString = "jms/mobileMetrics";
    Connection connection;
    InitialContext jndi;

    public MobileMetricsSyncBean() {

        try {
            jndi = new InitialContext();

            // Getting JMS connection from the server
            ConnectionFactory connectionFactory = (ConnectionFactory) jndi
                    .lookup(factoryString);
            connection = connectionFactory.createConnection();
            connection.start();
            // Creating session for seding messages

            // Getting the queue
        } catch (NamingException | JMSException ex) {
            Logger.getLogger(MobileMetricsSyncBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DeviceMsg messageReceive(String macaddr) {
        try {

            Destination destination = (Destination) jndi.lookup(topicString);
            // MessageConsumer is used for receiving (consuming) messages

            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            System.out.println(macaddr);

            MessageConsumer consumer = session.createConsumer(destination, "macaddr = '" + macaddr + "'");

            Message message;
            message = consumer.receive(5000);
            if (message == null) {
                System.out.println("pas de messages pour le device " + macaddr);
            } else {
                TextMessage tmessage = (TextMessage) message;
                ObjectMapper objectMapper = new ObjectMapper();
            DeviceMsg devicemsg = objectMapper.readValue(tmessage.getText(), DeviceMsg.class);
                System.out.println(devicemsg);
              

                return devicemsg;
            }
            //System.out.println(message);

            
        } catch (JMSException | NamingException | IOException ex) {
            Logger.getLogger(MobileMetricsSyncBean.class.getName()).log(Level.SEVERE, null, ex);
        }

       return null;
    }

    @PreDestroy
    public void unConnect() {
        try {
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(MobileMetricsSyncBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
