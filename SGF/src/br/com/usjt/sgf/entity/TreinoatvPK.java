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
public class TreinoatvPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "TREINO_IDTREINO")
    private int treinoIdtreino;
    @Basic(optional = false)
    @Column(name = "TREINO_IDUSER")
    private int treinoIduser;

    public TreinoatvPK() {
    }

    public TreinoatvPK(int id, int treinoIdtreino, int treinoIduser) {
        this.id = id;
        this.treinoIdtreino = treinoIdtreino;
        this.treinoIduser = treinoIduser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTreinoIdtreino() {
        return treinoIdtreino;
    }

    public void setTreinoIdtreino(int treinoIdtreino) {
        this.treinoIdtreino = treinoIdtreino;
    }

    public int getTreinoIduser() {
        return treinoIduser;
    }

    public void setTreinoIduser(int treinoIduser) {
        this.treinoIduser = treinoIduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) treinoIdtreino;
        hash += (int) treinoIduser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TreinoatvPK)) {
            return false;
        }
        TreinoatvPK other = (TreinoatvPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.treinoIdtreino != other.treinoIdtreino) {
            return false;
        }
        if (this.treinoIduser != other.treinoIduser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.TreinoatvPK[ id=" + id + ", treinoIdtreino=" + treinoIdtreino + ", treinoIduser=" + treinoIduser + " ]";
    }
    
}
