/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.jsonObjectFormat;

import com.atlantis.Entity.Metrics;
import java.util.List;

/**
 *
 * @author root
 */
public class MetricJson {

    private String state;

    private List<Metrics> metrics;

    private int deviceID;
    
    private String metricValue;
    
    private String UidToken;

    /**
     * Get the value of metricValue
     *
     * @return the value of metricValue
     */
    public String getMetricValue() {
        return metricValue;
    }

    /**
     * Set the value of metricValue
     *
     * @param metricValue new value of metricValue
     */
    public void setMetricValue(String metricValue) {
        this.metricValue = metricValue;
    }


    /**
     * Get the value of deviceID
     *
     * @return the value of deviceID
     */
    public int getDeviceID() {
        return deviceID;
    }

    /**
     * Set the value of deviceID
     *
     * @param deviceID new value of deviceID
     */
    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    

    /**
     * Get the value of UidToken
     *
     * @return the value of UidToken
     */
    public String getUidToken() {
        return UidToken;
    }

    /**
     * Set the value of UidToken
     *
     * @param UidToken new value of UidToken
     */
    public void setUidToken(String UidToken) {
        this.UidToken = UidToken;
    }

    public List<Metrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metrics> metrics) {
        this.metrics = metrics;
    }

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    public String getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(String state) {
        this.state = state;
    }

}
