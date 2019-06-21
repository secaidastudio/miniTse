package com.secaidastudio.e06_minitse.dao;

import com.secaidastudio.e06_minitse.model.Voter;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oscar
 */
@RequestScoped
public class VoterDAO {
    
    @PersistenceContext(unitName = "MiniTse_PU")
    EntityManager em;
    
    public void register(Voter newVoter){
        em.persist(newVoter);
    }
}
