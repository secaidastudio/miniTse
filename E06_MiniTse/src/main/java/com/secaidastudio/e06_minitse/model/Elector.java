package com.secaidastudio.e06_minitse.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "elector")
public class Elector implements Serializable{

    @Id
    private long idElector;
    
    @Column
    private String dpi;
    @Column (name = "num_padron",nullable = false)
    private String numPadron;
    @Column(nullable = false)
    private String nombres;
    @Column(nullable = false)
    private String apellidos;
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(nullable = false)
    private String genero;
    @Column(nullable = false)
    private String direccion;
    @Column (name = "extra_direccion")
    private String extraDireccion;
    @Column(name = "id_mesa", nullable = false)
    private long idMesa;

    public long getIdElector() {
        return idElector;
    }

    public void setIdElector(long idElector) {
        this.idElector = idElector;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNumPadron() {
        return numPadron;
    }

    public void setNumPadron(String numPadron) {
        this.numPadron = numPadron;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(long idMesa) {
        this.idMesa = idMesa;
    }
}
