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
@Table(name="mesaVotacion")
public class MesaVotacion implements Serializable {
    
    @Id
    private long idMesa;
    @Column(name = "num_mesa", nullable = false)
    private long numMesa;
    @Column(name = "cant_nulos", nullable = false)
    private long cantnulos;
    @Column(name = "cant_blancos", nullable = false)
    private long cantBlancos;
    @Column(name = "id_centro",nullable = false)
    private long idCentro;

    public long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(long idMesa) {
        this.idMesa = idMesa;
    }

    public long getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(long numMesa) {
        this.numMesa = numMesa;
    }

    public long getCantnulos() {
        return cantnulos;
    }

    public void setCantnulos(long cantnulos) {
        this.cantnulos = cantnulos;
    }

    public long getCantBlancos() {
        return cantBlancos;
    }

    public void setCantBlancos(long cantBlancos) {
        this.cantBlancos = cantBlancos;
    }

    public long getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(long idCentro) {
        this.idCentro = idCentro;
    }
    
}
