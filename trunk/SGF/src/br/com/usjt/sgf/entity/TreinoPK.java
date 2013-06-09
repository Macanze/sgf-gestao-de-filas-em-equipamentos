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
public class TreinoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "usr_trn")
    private int usrTrn;
    @Basic(optional = false)
    @Column(name = "IDTREINO")
    private int idtreino;

    public TreinoPK() {
    }

    public TreinoPK(int usrTrn, int idtreino) {
        this.usrTrn = usrTrn;
        this.idtreino = idtreino;
    }

    public int getUsrTrn() {
        return usrTrn;
    }

    public void setUsrTrn(int usrTrn) {
        this.usrTrn = usrTrn;
    }

    public int getIdtreino() {
        return idtreino;
    }

    public void setIdtreino(int idtreino) {
        this.idtreino = idtreino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usrTrn;
        hash += (int) idtreino;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TreinoPK)) {
            return false;
        }
        TreinoPK other = (TreinoPK) object;
        if (this.usrTrn != other.usrTrn) {
            return false;
        }
        if (this.idtreino != other.idtreino) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.TreinoPK[ usrTrn=" + usrTrn + ", idtreino=" + idtreino + " ]";
    }
    
}
