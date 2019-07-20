package com.academik.minitse.dao;

import com.academik.minitse.model.Vote;
import com.academik.minitse.model.Voter;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author oscar
 */
@RequestScoped
public class VoteDAO {
    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;
    
@Transactional    
    public void register(Vote vote){
        em.persist(vote);
        
    }
    
}
