/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.endpoints;

import com.atlantis.DAO.DevicesFacadeLocal;
import com.atlantis.DAO.MetricsFacadeLocal;
import com.atlantis.DAO.UserFacadeLocal;
import com.atlantis.Entity.Devices;
import com.atlantis.Entity.User;
import com.atlantis.FirebaseInit;
import com.atlantis.MDB.MobileMetricsSyncBean;
import com.atlantis.MsgModels.DeviceMsg;
import com.atlantis.jsonObjectFormat.MetricJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("Metrics")
@RequestScoped
public class MetricsResource {

    

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
    
    @Inject 
    MobileMetricsSyncBean metricsbean;
    
    ObjectMapper objectMapper = new ObjectMapper();
    /**
     * Creates a new instance of MetricsResource
     */
    public MetricsResource() {
    }

    /**
     * Retrieves representation of an instance of com.atlantis.endpoints.MetricsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

   @Path("/raw")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MetricJson getRawMetrics(String value) {
        MetricJson jMetrics = null;
        try {
            jMetrics = objectMapper.readValue(value, MetricJson.class);
            System.out.println(jMetrics.getUidToken());
            /*FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(jUser.getUidToken(), true);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();*/
            List<User> test = userFacade.findAllbyUid(jMetrics.getUidToken());

            if (!test.isEmpty()) {
                Devices device = devicesFacade.find(jMetrics.getDeviceID());
                DeviceMsg messageReceive = metricsbean.messageReceive(device.getMacAddress());
                jMetrics.setMetricValue(messageReceive.getMetricValue());
                jMetrics.setState("SUCCESS");
                return jMetrics;
            } else {
                jMetrics.setState("User not found");
                return jMetrics;
            }
        } catch (IOException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            jMetrics.setState("ERROR");
            return jMetrics;
        }
    }

    @Path("/calculated")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MetricJson getCalculatedMetrics(String value) {
        MetricJson jMetrics = null;

        try {
            jMetrics = objectMapper.readValue(value, MetricJson.class);
            System.out.println(jMetrics.getUidToken());
            /*FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(jUser.getUidToken(), true);
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();*/
            List<User> test = userFacade.findAllbyUid(jMetrics.getUidToken());

            if (!test.isEmpty()) {
                Devices device = devicesFacade.find(jMetrics.getDeviceID());

                jMetrics.setState("SUCCESS");
                return jMetrics;
            } else {
                jMetrics.setState("User not found");
                return jMetrics;
            }
        } catch (IOException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            jMetrics.setState("ERROR");
            return jMetrics;
        }  
    }

}
