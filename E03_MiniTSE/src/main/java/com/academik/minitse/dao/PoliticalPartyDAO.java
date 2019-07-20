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
    
    @Transactional
    public PoliticalParty update(PoliticalParty party){
        PoliticalParty updated = em.merge(party);
        return updated;
    }
    
    @Transactional
    public void delete(Long id){
        PoliticalParty partyToDelete = em.find(PoliticalParty.class, id);
        em.remove(partyToDelete);
    }

    public PoliticalParty findById(Long id) {
        PoliticalParty party = em.find(PoliticalParty.class, id);
        return party;
    }
}
