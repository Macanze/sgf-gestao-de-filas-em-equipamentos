/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dgsantos
 */
@Entity
@Table(name = "TREINOATV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treinoatv.findAll", query = "SELECT t FROM Treinoatv t"),
    @NamedQuery(name = "Treinoatv.findByTempo", query = "SELECT t FROM Treinoatv t WHERE t.tempo = :tempo"),
    @NamedQuery(name = "Treinoatv.findById", query = "SELECT t FROM Treinoatv t WHERE t.treinoatvPK.id = :id"),
    @NamedQuery(name = "Treinoatv.findByTreinoIdtreino", query = "SELECT t FROM Treinoatv t WHERE t.treinoatvPK.treinoIdtreino = :treinoIdtreino"),
    @NamedQuery(name = "Treinoatv.findByTreinoIduser", query = "SELECT t FROM Treinoatv t WHERE t.treinoatvPK.treinoIduser = :treinoIduser")})
public class Treinoatv implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TreinoatvPK treinoatvPK;
    @Column(name = "TEMPO")
    private Integer tempo;
    @JoinColumns({
        @JoinColumn(name = "usr_trn", referencedColumnName = "usr_trn"),
        @JoinColumn(name = "IDTREINO", referencedColumnName = "IDTREINO")})
    @ManyToOne
    private Treino treino;
    @JoinColumn(name = "ATIVIDADE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Atividade atividadeId;

    public Treinoatv() {
    }

    public Treinoatv(TreinoatvPK treinoatvPK) {
        this.treinoatvPK = treinoatvPK;
    }

    public Treinoatv(int id, int treinoIdtreino, int treinoIduser) {
        this.treinoatvPK = new TreinoatvPK(id, treinoIdtreino, treinoIduser);
    }

    public TreinoatvPK getTreinoatvPK() {
        return treinoatvPK;
    }

    public void setTreinoatvPK(TreinoatvPK treinoatvPK) {
        this.treinoatvPK = treinoatvPK;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Atividade getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Atividade atividadeId) {
        this.atividadeId = atividadeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treinoatvPK != null ? treinoatvPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treinoatv)) {
            return false;
        }
        Treinoatv other = (Treinoatv) object;
        if ((this.treinoatvPK == null && other.treinoatvPK != null) || (this.treinoatvPK != null && !this.treinoatvPK.equals(other.treinoatvPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Treinoatv[ treinoatvPK=" + treinoatvPK + " ]";
    }
    
}
