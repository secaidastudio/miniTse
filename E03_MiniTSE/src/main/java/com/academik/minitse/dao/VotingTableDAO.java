package com.academik.minitse.dao;


import com.academik.minitse.model.VotingTable;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


/**
 *
 * @author oscar
 */

@RequestScoped
public class VotingTableDAO {
    
    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;
    
    public VotingTable findByDpi(Long id){
        VotingTable vt = em.find(VotingTable.class, id);
        return vt;
    }

    @Transactional
    public VotingTable update(VotingTable votingTable){
        VotingTable updated = em.merge(votingTable);
        return updated;
    }
}
