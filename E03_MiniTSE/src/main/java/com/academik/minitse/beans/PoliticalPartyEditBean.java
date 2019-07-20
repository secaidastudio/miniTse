package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.model.PoliticalParty;
import com.academik.minitse.utils.NabJSFUtil;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author oscar
 */
@ManagedBean(name = "politicalPartyEditBean")
@ViewScoped
public class PoliticalPartyEditBean {
    
    @Inject
    PoliticalPartyDAO daoParty;
    
    private PoliticalParty party;
    private Long tempId;
    
    private String tempName;
    
    private String tempCandidate;
    
    @PostConstruct
    public void init(){
        String idAsString = NabJSFUtil.getParameter("selected_id");
        if (idAsString == null) {
            try{
                NabJSFUtil.redirectTo("politicalParties.xhtml");
            }catch(IOException ex){
                ex.printStackTrace();
            }
            return;
        }
        
        Long id = Long.parseLong(idAsString);
        party = daoParty.findById(id);
        tempName = party.getName();
        tempCandidate = party.getCandidate();
    }

    public Long getTempId() {
        return tempId;
    }

    public void setTempId(Long tempId) {
        this.tempId = tempId;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public String getTempCandidate() {
        return tempCandidate;
    }

    public void setTempCandidate(String tempCandidate) {
        this.tempCandidate = tempCandidate;
    }
    
    public void saveChanges(){
        party.setName(tempName);
        party.setCandidate(tempCandidate);
        party = daoParty.update(party);
    }
}
