package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.dao.VoteDAO;
import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.dao.VotingTableDAO;
import com.academik.minitse.model.PoliticalParty;
import com.academik.minitse.model.PoliticalParty_;
import com.academik.minitse.model.Vote;
import static com.academik.minitse.model.Vote_.politicalParty;
import static com.academik.minitse.model.Vote_.votingTable;
import com.academik.minitse.model.Voter;
import com.academik.minitse.model.VotingTable;
import com.academik.minitse.model.VotingTable_;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "voteSubmitBean")
@RequestScoped
public class VoteSubmitBean {

    @Inject
    PoliticalPartyDAO dao;

    @Inject
    VoterDAO vDao;

    @Inject
    Voter votedDAO;

    @Inject
    VoteDAO voteDAO;

    @Inject
    VotingTableDAO vtDao;

    private List<Voter> voters;
    private List<PoliticalParty> parties;
    private Long selectedVoteOption;
    private String tempDpi;

    public String getTempDpi() {
        return tempDpi;
    }

    public void setTempDpi(String tempDpi) {
        this.tempDpi = tempDpi;
    }

    public List<PoliticalParty> getParties() {
        parties = dao.findAll();
        return parties;
    }

    public void setParties(List<PoliticalParty> parties) {
        this.parties = parties;
    }

    public Long getSelectedVoteOption() {
        return selectedVoteOption;
    }

    public void setSelectedVoteOption(Long selectedVoteOption) {
        this.selectedVoteOption = selectedVoteOption;
    }

    public List<Voter> findingVoted() {
        voters = vDao.findVoted(tempDpi);
        return voters;
    }
    
    
    
    
    
    
    
    
    
    
    
    

    public String vote() {

        

        
        //VERIFICAR SI EL DPI EXISTE
        Voter result = vDao.findById(tempDpi);
        
        
        if (result == null) {
            return "error-page";
        }

        //VERIFICAR SI YA VOTO
        if (result.getVoted()) {
            return "error-page_1";
        }
//Buscar el partido politico basado en la eleccion del usuario
        PoliticalParty resultPP = dao.findById(selectedVoteOption);
       //Long idPP = resultPP.getId();
        //System.out.println("El ID del partido politico es: "+idPP);
        
        // Creacion del objeto de tipo Mesa de votacion
        VotingTable vt = vtDao.findByDpi(Long.parseLong(tempDpi));
        
        //PROCEDER A CREAR EL OBJETO VOTO
        //Cambiar el estado de ya_voto a true
        result.setVoted(Boolean.TRUE);
        Voter yaVoto = vDao.update(result);
               
        //VERIFICAR SI EL VOTO ES EN BLANCO 
        if (selectedVoteOption == -1) {
            vt.setBlankQuantity(vt.getBlankQuantity()+1);
            vtDao.update(vt);
        }else

        //VERIFICAR SI EL VOTO ES NULO
        if (selectedVoteOption == -2) {
            vt.setNullQuantity(vt.getNullQuantity()+1);
            vtDao.update(vt);
        } else {

        
        
        Vote v = new Vote();
        v.setPoliticalParty(resultPP);
        v.setVotingTable(vt);
        voteDAO.register(v);
        }
        
        return "voters";

    }

}
