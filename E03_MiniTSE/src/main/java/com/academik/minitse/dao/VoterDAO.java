package com.academik.minitse.dao;

import com.academik.minitse.model.Voter;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author esvux
 */
@RequestScoped
public class VoterDAO {
    
    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;
    
    @Transactional
    public void register(Voter newVoter){
        em.persist(newVoter);
    }

    @Transactional
    public List<Voter> findAll() {
        //JPQL
        TypedQuery<Voter> query = em.createQuery(
                //Equivalente a SELECT * FROM votante
                "SELECT v FROM Voter v", 
                Voter.class
        );
        List<Voter> result = query.getResultList();
        return result;
    }

    public Voter findById(String id) {
        Voter voter = em.find(Voter.class, id);
        return voter;
    }

    @Transactional
    public Voter update(Voter voter) {
        Voter updated = em.merge(voter);
        return updated;
    }

    @Transactional
    public void delete(String id) {
        Voter voterToDelete = em.find(Voter.class, id);
        em.remove(voterToDelete);
    }
    
    @Transactional
    public List<Voter> findVoted(String id){
        //JPQL
        TypedQuery<Voter> query = em.createQuery(
                "SELECT v.voted from Voter v WHERE v.dpi = :codigo",
                Voter.class
        );
        query.setParameter("codigo", id);
        List<Voter> result = query.getResultList();
        return result;
    }
    
    
}
