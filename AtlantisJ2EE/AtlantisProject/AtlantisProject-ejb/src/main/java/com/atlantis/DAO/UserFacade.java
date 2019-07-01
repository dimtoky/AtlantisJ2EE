/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlantis.DAO;

import com.atlantis.Entity.User;
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
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "com.atlantis_AtlantisProject-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
     @Override
    public List<User> findAllbyUid(String Uid) {
        TypedQuery<User> query = em.createNamedQuery("User.findByToken", User.class).setParameter("token",Uid);
        List<User> user = query.getResultList();
        return user;
    }
    
     @Override
    public User findbyUid(String Uid) {
        TypedQuery<User> query = em.createNamedQuery("User.findByToken", User.class).setParameter("token",Uid);
        User user = query.getSingleResult();
        return user;
    }
    
}
