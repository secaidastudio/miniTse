package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.model.PoliticalParty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author oscar
 */
@ManagedBean(name = "registerPoliticalPartyBean")
@RequestScoped
public class RegisterPoliticalPartyBean {
    
    @Inject
    PoliticalPartyDAO dao;
    
    private String tempName;
    private String tempCandidate;

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
    
    public String register(){
        PoliticalParty p = new PoliticalParty();
        p.setName(tempName);
        p.setCandidate(tempCandidate);
        
        dao.register(p);
        return "politicalParties";
    }
}
