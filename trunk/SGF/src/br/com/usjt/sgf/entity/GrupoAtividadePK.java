/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dgsantos
 */
@Embeddable
public class GrupoAtividadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ATIVIDADE_ID")
    private int atividadeId;
    @Basic(optional = false)
    @Column(name = "GRUPO_ID")
    private int grupoId;

    public GrupoAtividadePK() {
    }

    public GrupoAtividadePK(int id, int atividadeId, int grupoId) {
        this.id = id;
        this.atividadeId = atividadeId;
        this.grupoId = grupoId;
    }

    public int getIdatividade() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(int atividadeId) {
        this.atividadeId = atividadeId;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) atividadeId;
        hash += (int) grupoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoAtividadePK)) {
            return false;
        }
        GrupoAtividadePK other = (GrupoAtividadePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.atividadeId != other.atividadeId) {
            return false;
        }
        if (this.grupoId != other.grupoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.GrupoAtividadePK[ id=" + id + ", atividadeId=" + atividadeId + ", grupoId=" + grupoId + " ]";
    }
    
}
