/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "TREINOATV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treinoatv.findAll", query = "SELECT t FROM Treinoatv t"),
    @NamedQuery(name = "Treinoatv.findByTempo", query = "SELECT t FROM Treinoatv t WHERE t.tempo = :tempo"),
    @NamedQuery(name = "Treinoatv.findByTreinoIdtreino", query = "SELECT t FROM Treinoatv t WHERE t.treinoatvPK.treinoIdtreino = :treinoIdtreino"),
    @NamedQuery(name = "Treinoatv.findById", query = "SELECT t FROM Treinoatv t WHERE t.treinoatvPK.id = :id"),
    @NamedQuery(name = "Treinoatv.findByTreinoIduser", query = "SELECT t FROM Treinoatv t WHERE t.treinoatvPK.treinoIduser = :treinoIduser")})
public class Treinoatv implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId 
    protected TreinoatvPK treinoatvPK;
    @Column(name = "TEMPO")
    private Integer tempo;
    @JoinColumns({
        @JoinColumn(name = "TREINO_IDUSER", referencedColumnName = "usr_trn", insertable = false, updatable = false),
        @JoinColumn(name = "TREINO_IDTREINO", referencedColumnName = "IDTREINO", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Treino treino;
    @JoinColumn(name = "ATIVIDADE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Atividade atividade;

    public Treinoatv() {
    }

    public Treinoatv(TreinoatvPK treinoatvPK) {
        this.treinoatvPK = treinoatvPK;
    }

    public Treinoatv(int treinoIdtreino, int id, int treinoIduser) {
        this.treinoatvPK = new TreinoatvPK(treinoIdtreino, id, treinoIduser);
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

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
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
