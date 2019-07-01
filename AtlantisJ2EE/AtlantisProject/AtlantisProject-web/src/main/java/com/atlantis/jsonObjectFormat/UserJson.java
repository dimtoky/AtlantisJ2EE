/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.jsonObjectFormat;

/**
 *
 * @author root
 */
public class UserJson {

    private int idUser;

    private String state;

    private String email;

    private String uidToken;

    private String username;

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
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

    /**
     * Get the value of uidToken
     *
     * @return the value of uidToken
     */
    public String getUidToken() {
        return uidToken;
    }

    /**
     * Set the value of uidToken
     *
     * @param uidToken new value of uidToken
     */
    public void setUidToken(String uidToken) {
        this.uidToken = uidToken;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of idUser
     *
     * @return the value of idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Set the value of idUser
     *
     * @param idUser new value of idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
