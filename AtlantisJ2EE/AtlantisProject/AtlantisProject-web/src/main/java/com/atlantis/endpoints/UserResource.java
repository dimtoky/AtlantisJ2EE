/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.endpoints;

import com.atlantis.DAO.DevicesFacadeLocal;
import com.atlantis.DAO.MetricsFacadeLocal;
import com.atlantis.DAO.UserFacadeLocal;
import com.atlantis.Entity.User;
import com.atlantis.FirebaseInit;
import com.atlantis.jsonObjectFormat.DeviceJson;
import com.atlantis.jsonObjectFormat.UserJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("user")
@RequestScoped
public class UserResource {

    @Context
    private UriInfo context;

    @EJB
    private DevicesFacadeLocal devicesFacade;

    @EJB
    private MetricsFacadeLocal metricsFacade;

    @EJB
    private UserFacadeLocal userFacade;

    @Inject
    FirebaseInit firebase;

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.atlantis.endpoints.UserResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello world";
    }

    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserJson addUser(String value) {
        UserJson jUser = null;

        try {
            jUser = objectMapper.readValue(value, UserJson.class);
            System.out.println(jUser.getUidToken());
            /*FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(jUser.getUidToken(), true);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();*/
            List<User> test = userFacade.findAllbyUid(jUser.getUidToken());

            if (test.isEmpty()) {
                User user = new User();
                user.setEmail(jUser.getEmail());
                user.setUsername(jUser.getUsername());
                user.setToken(jUser.getUidToken());
                user.setCreatedAt(new Date());
                userFacade.create(user);
                jUser.setIdUser(user.getIduser());
                jUser.setState("Success");
                return jUser;
            } else {
                jUser.setState("User already exist");
                return jUser;
            }
        } catch (IOException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            jUser.setState("ERROR");
            return jUser;
        }
     

    }

    @Path("/connect")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DeviceJson connectUser(String value) {
        DeviceJson device = null;
        try {
            UserJson jUser = objectMapper.readValue(value, UserJson.class);
            /*FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(jUser.getUidToken(), true);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();*/
            List<User> test = userFacade.findAllbyUid(jUser.getUidToken());

            if (!test.isEmpty()) {
                User user = userFacade.findbyUid(jUser.getUidToken());
                device.setDevices(user.getUserdevicesList());
                device.setState("Success");
                return device;
            } else {
                device.setState("Can't find User");
                return device;
            }
        } catch (IOException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            device.setState("ERROR");
            return device;
        }
        

    }

   
}
