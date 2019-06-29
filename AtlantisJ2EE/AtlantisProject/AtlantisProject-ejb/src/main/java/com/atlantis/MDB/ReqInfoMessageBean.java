/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.MDB;

import com.atlantis.DAO.DevicesFacadeLocal;
import com.atlantis.Entity.Devices;
import com.atlantis.MsgModels.DeviceMsg;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/reqInfo"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "REQINFO"),
    @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-51590091651894963472.15.9")
})
public class ReqInfoMessageBean implements MessageListener {

    @EJB
    private DevicesFacadeLocal devicesFacade;

    Date date= new Date();
    
    public ReqInfoMessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tmessage = (TextMessage) message;
            ObjectMapper objectMapper = new ObjectMapper();
            DeviceMsg devicemsg = objectMapper.readValue(tmessage.getText(), DeviceMsg.class);

            System.out.println(devicemsg.getDeviceAddress());
            System.out.println(devicemsg.getDeviceType());
            List<Devices> dbdevice = devicesFacade.findbyaddress(devicemsg.getDeviceAddress());
            if (dbdevice.isEmpty()) {
                Devices devices = new Devices();
                devices.setDeviceName(devicemsg.getDeviceType()+devicemsg.getDeviceAddress());
                devices.setDeviceType(devicemsg.getDeviceType());
                devices.setMacAddress(devicemsg.getDeviceAddress());
                Timestamp ts = new Timestamp(date.getTime());
                devices.setCreatedAt(ts);
                devicesFacade.create(devices);
            } else {

            }

        } catch (JMSException | IOException ex) {
            Logger.getLogger(ReqInfoMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
