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
@Table(name = "centroVotacion")
public class CentroVotacion implements Serializable{
    
    @Id
    private long idCentro;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(name = "extra_direccion")
    private String extraDireccion;
    @Column(name = "id_municipio",nullable = false)
    private long idMunicipio;

    public long getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(long idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getExtraDireccion() {
        return extraDireccion;
    }

    public void setExtraDireccion(String extraDireccion) {
        this.extraDireccion = extraDireccion;
    }

    public long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
}
