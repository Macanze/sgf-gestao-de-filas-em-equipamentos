/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "GRUPOATV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupoatv.findAll", query = "SELECT g FROM Grupoatv g"),
    @NamedQuery(name = "Grupoatv.findByIdatividade", query = "SELECT g FROM Grupoatv g WHERE g.idatividade = :idatividade"),
    @NamedQuery(name = "Grupoatv.findByTempo", query = "SELECT g FROM Grupoatv g WHERE g.tempo = :tempo")})
public class Grupoatv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "IDATIVIDADE")
    private Integer idatividade;
    @Column(name = "TEMPO")
    private Integer tempo;
    @JoinColumn(name = "GRUPO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Grupo grupo;
    @JoinColumn(name = "ATIVIDADE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Atividade atividade;

    public Grupoatv() {
    }

    public Grupoatv(Integer idatividade) {
        this.idatividade = idatividade;
    }

    public Integer getIdatividade() {
        return idatividade;
    }

    public void setIdatividade(Integer idatividade) {
        this.idatividade = idatividade;
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
        hash += (idatividade != null ? idatividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoatv)) {
            return false;
        }
        Grupoatv other = (Grupoatv) object;
        if ((this.idatividade == null && other.idatividade != null) || (this.idatividade != null && !this.idatividade.equals(other.idatividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Grupoatv[ idatividade=" + idatividade + " ]";
    }
    
}
