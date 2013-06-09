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
public class GrupoatvPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "IDATIVIDADE")
    private int idatividade;
    @Basic(optional = false)
    @Column(name = "ATIVIDADE_ID")
    private int atividadeId;
    @Basic(optional = false)
    @Column(name = "GRUPO_ID")
    private int grupoId;

    public GrupoatvPK() {
    }

    public GrupoatvPK(int idatividade, int atividadeId, int grupoId) {
        this.idatividade = idatividade;
        this.atividadeId = atividadeId;
        this.grupoId = grupoId;
    }

    public int getIdatividade() {
        return idatividade;
    }

    public void setIdatividade(int idatividade) {
        this.idatividade = idatividade;
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
        hash += (int) idatividade;
        hash += (int) atividadeId;
        hash += (int) grupoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoatvPK)) {
            return false;
        }
        GrupoatvPK other = (GrupoatvPK) object;
        if (this.idatividade != other.idatividade) {
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
        return "br.com.usjt.sgf.entity.GrupoatvPK[ idatividade=" + idatividade + ", atividadeId=" + atividadeId + ", grupoId=" + grupoId + " ]";
    }
    
}
