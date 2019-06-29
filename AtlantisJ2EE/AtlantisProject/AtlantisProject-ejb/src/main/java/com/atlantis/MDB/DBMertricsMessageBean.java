/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.MDB;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/dbMetrics"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "DBMETRICS"),
    @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-51590091651894963472.15.9")
})
public class DBMertricsMessageBean implements MessageListener {
    
    public DBMertricsMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
