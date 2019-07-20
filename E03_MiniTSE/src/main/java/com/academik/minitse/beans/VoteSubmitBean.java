package com.academik.minitse.beans;

import com.academik.minitse.dao.VoteDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oscar
 */
@ManagedBean(name = "voteSubmitBean")
@RequestScoped
public class VoteSubmitBean {
    
    @Inject 
    VoteDAO dao;
    
    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;
    
    
    
    
    
    
    
}
