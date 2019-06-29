/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.MsgModels;

/**
 *
 * @author root
 */
public class DeviceMsg {

    private int id;
    
    private String deviceName;

    private String deviceType;
    
    private String deviceAddress;
    
    private String createdAt;

    /**
     * Get the value of createdAt
     *
     * @return the value of createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the value of createdAt
     *
     * @param createdAt new value of createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * Get the value of deviceAddress
     *
     * @return the value of deviceAddress
     */
    public String getDeviceAddress() {
        return deviceAddress;
    }

    /**
     * Set the value of deviceAddress
     *
     * @param deviceAddress new value of deviceAddress
     */
    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }


    /**
     * Get the value of deviceType
     *
     * @return the value of deviceType
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * Set the value of deviceType
     *
     * @param deviceType new value of deviceType
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of deviceName
     *
     * @return the value of deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Set the value of deviceName
     *
     * @param deviceName new value of deviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

}
