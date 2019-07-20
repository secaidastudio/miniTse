package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.model.PoliticalParty;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author oscar
 */
@ManagedBean(name = "listPoliticalPartiesBean")
@ViewScoped
public class ListPoliticalPartiesBean implements Serializable{
    
    @Inject
    PoliticalPartyDAO daoPoliticalParty;
    
    private List<PoliticalParty> allParties;
   
    @PostConstruct
    public void init(){
        allParties = daoPoliticalParty.findAll();
    }

    public List<PoliticalParty> getAllParties() {
        return allParties;
    }
    
    public void delete(Long id){
        daoPoliticalParty.delete(id);
        allParties = daoPoliticalParty.findAll();
    }
    
    

    

    

    
    
}
