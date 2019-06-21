package com.secaidastudio.e06_minitse.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "departamento")
public class Departamento implements Serializable{
    
    @Id
    private long idDepartamento;
    @Column(nullable = false)
    private String nombre;

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
