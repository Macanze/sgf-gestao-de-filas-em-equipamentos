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
@Table(name = "GRUPOATV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupoatv.findAll", query = "SELECT g FROM Grupoatv g"),
    @NamedQuery(name = "Grupoatv.findByIdatividade", query = "SELECT g FROM Grupoatv g WHERE g.grupoatvPK.idatividade = :idatividade"),
    @NamedQuery(name = "Grupoatv.findByTempo", query = "SELECT g FROM Grupoatv g WHERE g.tempo = :tempo"),
    @NamedQuery(name = "Grupoatv.findByAtividadeId", query = "SELECT g FROM Grupoatv g WHERE g.grupoatvPK.atividadeId = :atividadeId"),
    @NamedQuery(name = "Grupoatv.findByGrupoId", query = "SELECT g FROM Grupoatv g WHERE g.grupoatvPK.grupoId = :grupoId")})
public class Grupoatv implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoatvPK grupoatvPK;
    @Column(name = "TEMPO")
    private Integer tempo;
    @JoinColumn(name = "GRUPO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Grupo grupo;
    @JoinColumn(name = "ATIVIDADE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Atividade atividade;

    public Grupoatv() {
    }

    public Grupoatv(GrupoatvPK grupoatvPK) {
        this.grupoatvPK = grupoatvPK;
    }

    public Grupoatv(int idatividade, int atividadeId, int grupoId) {
        this.grupoatvPK = new GrupoatvPK(idatividade, atividadeId, grupoId);
    }

    public GrupoatvPK getGrupoatvPK() {
        return grupoatvPK;
    }

    public void setGrupoatvPK(GrupoatvPK grupoatvPK) {
        this.grupoatvPK = grupoatvPK;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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
        hash += (grupoatvPK != null ? grupoatvPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoatv)) {
            return false;
        }
        Grupoatv other = (Grupoatv) object;
        if ((this.grupoatvPK == null && other.grupoatvPK != null) || (this.grupoatvPK != null && !this.grupoatvPK.equals(other.grupoatvPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Grupoatv[ grupoatvPK=" + grupoatvPK + " ]";
    }
    
}
