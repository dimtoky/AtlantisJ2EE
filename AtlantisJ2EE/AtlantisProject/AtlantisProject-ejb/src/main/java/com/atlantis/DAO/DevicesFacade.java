/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.DAO;

import com.atlantis.Entity.Devices;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class DevicesFacade extends AbstractFacade<Devices> implements DevicesFacadeLocal {

    @PersistenceContext(unitName = "com.atlantis_AtlantisProject-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevicesFacade() {
        super(Devices.class);
    }
    
    @Override
    public List<Devices> findbyaddress(String macaddr) {
        TypedQuery<Devices> query = em.createNamedQuery("Devices.findByMacAddress", Devices.class).setParameter("macAddress",macaddr);
        List<Devices> device = query.getResultList();
        return device;
    }
}
