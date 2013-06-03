/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "Atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findById", query = "SELECT a FROM Atividade a WHERE a.id = :id"),
    @NamedQuery(name = "Atividade.findByDescr", query = "SELECT a FROM Atividade a WHERE a.descr = :descr"),
    @NamedQuery(name = "Atividade.findByNome", query = "SELECT a FROM Atividade a WHERE a.nome like :nome"),
    @NamedQuery(name = "Atividade.findByStatus", query = "SELECT a FROM Atividade a WHERE a.status = :status")})
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCR")
    private String descr;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STATUS")
    private Boolean status;
    @JoinTable(name = "Recurso_Atividade", joinColumns = {
        @JoinColumn(name = "atividadeRelacionada_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Recurso_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Recurso> recursoCollection;
    @OneToMany(mappedBy = "atividade", fetch = FetchType.EAGER)
    private Collection<Treinoatv> treinoatvCollection;
    @OneToMany(mappedBy = "atividade", fetch = FetchType.EAGER)
    private Collection<Grupoatv> grupoatvCollection;

    public Atividade() {
    }

    public Atividade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Recurso> getRecursoCollection() {
        return recursoCollection;
    }

    public void setRecursoCollection(Collection<Recurso> recursoCollection) {
        this.recursoCollection = recursoCollection;
    }

    @XmlTransient
    public Collection<Treinoatv> getTreinoatvCollection() {
        return treinoatvCollection;
    }

    public void setTreinoatvCollection(Collection<Treinoatv> treinoatvCollection) {
        this.treinoatvCollection = treinoatvCollection;
    }

    @XmlTransient
    public Collection<Grupoatv> getGrupoatvCollection() {
        return grupoatvCollection;
    }

    public void setGrupoatvCollection(Collection<Grupoatv> grupoatvCollection) {
        this.grupoatvCollection = grupoatvCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Atividade[ id=" + id + " ]";
    }
    
}
