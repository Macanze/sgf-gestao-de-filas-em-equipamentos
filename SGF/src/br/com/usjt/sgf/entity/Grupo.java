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
@Table(name = "GRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findById", query = "SELECT g FROM Grupo g WHERE g.id = :id"),
    @NamedQuery(name = "Grupo.findByDescricao", query = "SELECT g FROM Grupo g WHERE g.descricao = :descricao"),
    @NamedQuery(name = "Grupo.findByNome", query = "SELECT g FROM Grupo g WHERE g.nome like :nome"),
    @NamedQuery(name = "Grupo.findByStatus", query = "SELECT g FROM Grupo g WHERE g.status = :status")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STATUS")
    private Boolean status;
    @JoinTable(name = "TREINO_GRUPO", joinColumns = {
        @JoinColumn(name = "Grupo_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Treino_UsrTrn", referencedColumnName = "usr_trn"),
        @JoinColumn(name = "Treino_IDTREINO", referencedColumnName = "IDTREINO")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Treino> treinoCollection;
    @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
    private Collection<Grupoatv> grupoatvCollection;

    public Grupo() {
    }

    public Grupo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    public Collection<Treino> getTreinoCollection() {
        return treinoCollection;
    }

    public void setTreinoCollection(Collection<Treino> treinoCollection) {
        this.treinoCollection = treinoCollection;
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
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Grupo[ id=" + id + " ]";
    }
    
}
