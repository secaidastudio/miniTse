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
@Table(name = "voto")
public class Voto implements Serializable{
    
    @Id
    private long idVoto;
    @Column(name = "id_mesa", nullable = false)
    private long idMesa;
    @Column(name = "id_partido", nullable = false)
    private long idPartido;

    public long getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(long idVoto) {
        this.idVoto = idVoto;
    }

    public long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(long idMesa) {
        this.idMesa = idMesa;
    }

    public long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(long idPartido) {
        this.idPartido = idPartido;
    }
    
    
}
