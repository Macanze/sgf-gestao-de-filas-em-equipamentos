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
@Table(name = "GRUPO_ATIVIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupoatv.findAll", query = "SELECT g FROM Grupoatv g"),
    @NamedQuery(name = "Grupoatv.findByIdatividade", query = "SELECT g FROM Grupoatv g WHERE g.grupoatvPK.idatividade = :idatividade"),
    @NamedQuery(name = "Grupoatv.findByTempo", query = "SELECT g FROM Grupoatv g WHERE g.tempo = :tempo"),
    @NamedQuery(name = "Grupoatv.findByAtividadeId", query = "SELECT g FROM Grupoatv g WHERE g.grupoatvPK.atividadeId = :atividadeId"),
    @NamedQuery(name = "Grupoatv.findByGrupoId", query = "SELECT g FROM Grupoatv g WHERE g.grupoatvPK.grupoId = :grupoId")})
public class GrupoAtividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoAtividadePK grupoAtividadePK;
    @Column(name = "TEMPO")
    private Integer tempo;
    @JoinColumn(name = "GRUPO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Grupo grupo;
    @JoinColumn(name = "ATIVIDADE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Exercicio atividade;

    public GrupoAtividade() {
    }

    public GrupoAtividade(GrupoAtividadePK grupoAtividadePK) {
        this.grupoAtividadePK = grupoAtividadePK;
    }

    public GrupoAtividade(int idatividade, int atividadeId, int grupoId) {
        this.grupoAtividadePK = new GrupoAtividadePK(idatividade, atividadeId, grupoId);
    }

    public GrupoAtividadePK getGrupoatvPK() {
        return grupoAtividadePK;
    }

    public void setGrupoatvPK(GrupoAtividadePK grupoatvPK) {
        this.grupoAtividadePK = grupoatvPK;
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

    public Exercicio getAtividade() {
        return atividade;
    }

    public void setAtividade(Exercicio atividade) {
        this.atividade = atividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoAtividadePK != null ? grupoAtividadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoAtividade)) {
            return false;
        }
        GrupoAtividade other = (GrupoAtividade) object;
        if ((this.grupoAtividadePK == null && other.grupoAtividadePK != null) || (this.grupoAtividadePK != null && !this.grupoAtividadePK.equals(other.grupoAtividadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Grupoatv[ grupoAtividadePK=" + grupoAtividadePK + " ]";
    }
    
}
