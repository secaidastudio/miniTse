package com.secaidastudio.e06_minitse.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author oscar
 */
@Entity
public class Municipio implements Serializable {
   
    @Id
    private long idMunicipio;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(name = "id_departamento", nullable = false)
    private long idDepartamento;

    public long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
