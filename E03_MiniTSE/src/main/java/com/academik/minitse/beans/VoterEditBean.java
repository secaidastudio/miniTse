package com.academik.minitse.beans;

import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.model.Voter;
import com.academik.minitse.utils.NabJSFUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author oscar
 */
@ManagedBean(name = "voterEditBean")
@ViewScoped
public class VoterEditBean implements Serializable {

    @Inject
    VoterDAO daoVoter;

    private Voter voter;
    private String tempDpi;
    private String tempFirstName;
    private String tempLastName;
    private Date tempBirthday;
    private String tempGender;
    private String tempAddress;
    private String tempExtraAddress;

    @PostConstruct
    public void init() {
        String idAsString = NabJSFUtil.getParameter("selected_id");
        if (idAsString == null) {
            try {
                NabJSFUtil.redirectTo("voters.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }

        String id = idAsString;
        voter = daoVoter.findById(id);
        tempDpi = voter.getDpi();
        tempFirstName = voter.getFirstName();
        tempLastName = voter.getLastName();
        tempGender = voter.getGender();
        tempBirthday = voter.getBirthday();
        tempAddress = voter.getAddress();
        tempExtraAddress = voter.getExtraAddress();
        
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

    public Date getTempBirthday() {
        return tempBirthday;
    }

    public void setTempBirthday(Date tempBirthday) {
        this.tempBirthday = tempBirthday;
    }

    public String getTempGender() {
        return tempGender;
    }

    public void setTempGender(String tempGender) {
        this.tempGender = tempGender;
    }

    public String getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
    }

    public String getTempExtraAddress() {
        return tempExtraAddress;
    }

    public void setTempExtraAddress(String tempExtraAddress) {
        this.tempExtraAddress = tempExtraAddress;
    }
    
    public void saveChanges(){
        voter.setDpi(tempDpi);
        voter.setFirstName(tempFirstName);
        voter.setLastName(tempLastName);
        voter.setGender(tempGender);
        voter.setBirthday(tempBirthday);
        voter.setAddress(tempAddress);
        voter.setExtraAddress(tempExtraAddress);
        
        voter = daoVoter.update(voter);
    }

}
