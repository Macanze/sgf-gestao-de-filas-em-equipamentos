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
@Table(name = "TREINOATIVIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TreinoAtividade.findAll", query = "SELECT t FROM TreinoAtividade t"),
    @NamedQuery(name = "TreinoAtividade.findByTempo", query = "SELECT t FROM TreinoAtividade t WHERE t.tempo = :tempo"),
    @NamedQuery(name = "TreinoAtividade.findById", query = "SELECT t FROM TreinoAtividade t WHERE t.treinoatvPK.id = :id"),
    @NamedQuery(name = "TreinoAtividade.findByTreinoIdtreino", query = "SELECT t FROM TreinoAtividade t WHERE t.treinoatvPK.treinoIdtreino = :treinoIdtreino"),
    @NamedQuery(name = "TreinoAtividade.findByTreinoIduser", query = "SELECT t FROM TreinoAtividade t WHERE t.treinoatvPK.treinoIduser = :treinoIduser")})
public class TreinoAtividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TreinoAtividadePK treinoAtividadePK;
    @Column(name = "TEMPO")
    private Integer tempo;
    @JoinColumns({
        @JoinColumn(name = "usr_trn", referencedColumnName = "usr_trn"),
        @JoinColumn(name = "IDTREINO", referencedColumnName = "IDTREINO")})
    @ManyToOne
    private Treino treino;
    @JoinColumn(name = "ATIVIDADE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Exercicio atividadeId;

    public TreinoAtividade() {
    }

    public TreinoAtividade(TreinoAtividadePK treinoatvPK) {
        this.treinoAtividadePK = treinoatvPK;
    }

    public TreinoAtividade(int id, int treinoIdtreino, int treinoIduser) {
        this.treinoAtividadePK = new TreinoAtividadePK(id, treinoIdtreino, treinoIduser);
    }

    public TreinoAtividadePK getTreinoatvPK() {
        return treinoAtividadePK;
    }

    public void setTreinoatvPK(TreinoAtividadePK treinoatvPK) {
        this.treinoAtividadePK = treinoatvPK;
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

    public Exercicio getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Exercicio atividadeId) {
        this.atividadeId = atividadeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treinoAtividadePK != null ? treinoAtividadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TreinoAtividade)) {
            return false;
        }
        TreinoAtividade other = (TreinoAtividade) object;
        if ((this.treinoAtividadePK == null && other.treinoAtividadePK != null) || (this.treinoAtividadePK != null && !this.treinoAtividadePK.equals(other.treinoAtividadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Treinoatv[ treinoatvPK=" + treinoAtividadePK + " ]";
    }
    
}
