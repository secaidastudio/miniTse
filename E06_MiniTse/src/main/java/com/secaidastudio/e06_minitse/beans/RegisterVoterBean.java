package com.secaidastudio.e06_minitse.beans;

import com.secaidastudio.e06_minitse.dao.VoterDAO;
import com.secaidastudio.e06_minitse.model.Voter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author oscar
 */
@ManagedBean (name = "registerVoterBean")
@RequestScoped
public class RegisterVoterBean {
    
    private VoterDAO dao;
    
    private String tempDpi;
    private String tempFirstName;
    private String tempLastName;
    private Double tempHeight;

    public VoterDAO getDao() {
        return dao;
    }

    public void setDao(VoterDAO dao) {
        this.dao = dao;
    }

    public String getTempDpi() {
        return tempDpi;
    }

    public void setTempDpi(String tempDpi) {
        this.tempDpi = tempDpi;
    }

    public String getTempFirstName() {
        return tempFirstName;
    }

    public void setTempFirstName(String tempFirstName) {
        this.tempFirstName = tempFirstName;
    }

    public String getTempLastName() {
        return tempLastName;
    }

    public void setTempLastName(String tempLastName) {
        this.tempLastName = tempLastName;
    }

    public Double getTempHeight() {
        return tempHeight;
    }

    public void setTempHeight(Double tempHeight) {
        this.tempHeight = tempHeight;
    }
    
    public String register(){
        Voter v = new Voter();
        v.setDpi(tempDpi);
        v.setFirstName(tempFirstName);
        v.setLastName(tempLastName);
        v.setHeight(tempHeight);
        return "voters";
        
    }
    
}
