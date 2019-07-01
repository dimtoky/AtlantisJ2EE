/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.jsonObjectFormat;

import com.atlantis.Entity.Devices;
import com.atlantis.Entity.Userdevices;
import java.util.List;

/**
 *
 * @author root
 */
public class DeviceJson {
    
        private String state;
        
        private List<Userdevices> devices;

    public List<Userdevices> getDevices() {
        return devices;
    }

    public void setDevices(List<Userdevices> devices) {
        this.devices = devices;
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
