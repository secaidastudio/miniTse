package com.academik.minitse.dao;

import com.academik.minitse.model.PoliticalParty;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author oscar
 */
@RequestScoped
public class PoliticalPartyDAO {
    
    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;
    
    @Transactional
    public void register(PoliticalParty newParty){
        em.persist(newParty);
    }

    @Transactional
    public List<PoliticalParty> findAll() {
        TypedQuery<PoliticalParty> query = em.createQuery(
        "SELECT pp FROM PoliticalParty pp", PoliticalParty.class
        );
        List<PoliticalParty> result = query.getResultList();
        return result;
    }
    
}
