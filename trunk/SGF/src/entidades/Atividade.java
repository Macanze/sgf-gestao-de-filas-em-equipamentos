/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dgsantos
 */
@Entity
@Table(name = "Atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findById", query = "SELECT a FROM Atividade a WHERE a.id = :id"),
    @NamedQuery(name = "Atividade.findByNome", query = "SELECT a FROM Atividade a WHERE a.nome = :nome"),
    @NamedQuery(name = "Atividade.findByDescricao", query = "SELECT a FROM Atividade a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Atividade.findByStatus", query = "SELECT a FROM Atividade a WHERE a.status = :status")})

public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "STATUS")
    private Boolean status;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @JoinTable(name = "Recurso_Atividade", joinColumns = {
        @JoinColumn(name = "ID_ATIVIDADE", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_RECURSO", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Recurso> recursoCollection;
    @JoinColumn(name = "GRUPO_ID", referencedColumnName = "ID")
    @ManyToOne
    private AtividadeGrupo grupoId;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Recurso> getRecursoCollection() {
        return recursoCollection;
    }

    public void setRecursoCollection(Collection<Recurso> recursoCollection) {
        this.recursoCollection = recursoCollection;
    }

    public AtividadeGrupo getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(AtividadeGrupo grupoId) {
        this.grupoId = grupoId;
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
        return "entidades.Atividade[ id=" + id + " ]";
    }
    
}
