package com.academik.minitse.beans;

import com.academik.minitse.dao.DepartmentDAO;
import com.academik.minitse.dao.MunicipalityDAO;
import com.academik.minitse.dao.VotingPlaceDAO;
import com.academik.minitse.model.Department;
import com.academik.minitse.model.Municipality;
import com.academik.minitse.model.VotingPlace;
import com.academik.minitse.model.VotingTable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "votingPlaceCreateBean")
@ViewScoped
public class VotingPlaceCreateBean implements Serializable {

    @Inject
    DepartmentDAO daoDept;

    @Inject
    MunicipalityDAO daoMun;

    @Inject
    VotingPlaceDAO daoVotingPlace;

    private Long selectedDepartmentId;
    private Long selectedMunicipalityId;
    private String tempName;
    
    @Size(min = 10, max = 500, message = "El campo direccion debe tener entre 10 y 500 caracteres")
    private String tempAddress;
    private String tempExtraAddress;
    
    private List<Department> allDepartments;
    private List<Municipality> allMunicipalities;
    private Integer tempInitialRange;
    private Integer tempFinalRange;

    @PostConstruct
    public void init() {
        allDepartments = daoDept.findAll();
    }    
    
    
    

    public final void changeDepartment(final AjaxBehaviorEvent event) {
        //Si la opcion seleccionada en Departamento es null, limpiar el combobox de Municipio
        if (selectedDepartmentId == null) {
            selectedMunicipalityId = null;
            allMunicipalities = Collections.EMPTY_LIST;
            return;
        }
        //Obtengo los municipios por el departamento seleccionado
        Department dept = new Department();
        dept.setId(selectedDepartmentId);
        allMunicipalities = daoMun.findByDepartment(dept);
    }

    
    public void register() {
        VotingPlace place = new VotingPlace();
        place.setName(tempName);
        place.setAddress(tempAddress);
        place.setExtraAddress(tempExtraAddress);
        place.setInitialRange(tempInitialRange);
        place.setFinalRange(tempFinalRange);
        
        
        
        Municipality m = new Municipality(selectedMunicipalityId);
        place.setMunicipality(m);        
        
        
        List<VotingTable> tables = new ArrayList<>();
        for(int i=tempInitialRange; i<=tempFinalRange; i++) {
            VotingTable t = new VotingTable();
            t.setTableNum(i);
            t.setVotingPlace(place);
            tables.add(t);
        }
        place.setTables(tables);
        daoVotingPlace.create(place);
        clearForm();
    }

    private void clearForm() {
        tempName = null;
        tempAddress = null;
        tempExtraAddress = null;
        selectedDepartmentId = null;
        selectedMunicipalityId = null;
        allDepartments = daoDept.findAll();
        allMunicipalities = Collections.EMPTY_LIST;
    }

    public Long getSelectedDepartmentId() {
        return selectedDepartmentId;
    }

    public void setSelectedDepartmentId(Long selectedDepartmentId) {
        this.selectedDepartmentId = selectedDepartmentId;
    }

    public Long getSelectedMunicipalityId() {
        return selectedMunicipalityId;
    }

    public void setSelectedMunicipalityId(Long selectedMunicipalityId) {
        this.selectedMunicipalityId = selectedMunicipalityId;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
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

    public List<Department> getAllDepartments() {
        return allDepartments;
    }

    public void setAllDepartments(List<Department> allDepartments) {
        this.allDepartments = allDepartments;
    }

    public List<Municipality> getAllMunicipalities() {
        return allMunicipalities;
    }

    public void setAllMunicipalities(List<Municipality> allMunicipalities) {
        this.allMunicipalities = allMunicipalities;
    }

    public Integer getTempInitialRange() {
        return tempInitialRange;
    }

    public void setTempInitialRange(Integer tempInitialRange) {
        this.tempInitialRange = tempInitialRange;
    }

    public Integer getTempFinalRange() {
        return tempFinalRange;
    }

    public void setTempFinalRange(Integer tempFinalRange) {
        this.tempFinalRange = tempFinalRange;
    }

}
