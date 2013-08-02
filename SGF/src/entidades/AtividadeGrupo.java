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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dgsantos
 */
@Entity
@Table(name = "Atividade_Grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtividadeGrupo.findAll", query = "SELECT a FROM AtividadeGrupo a"),
    @NamedQuery(name = "AtividadeGrupo.findById", query = "SELECT a FROM AtividadeGrupo a WHERE a.id = :id"),
    @NamedQuery(name = "AtividadeGrupo.findByNome", query = "SELECT a FROM AtividadeGrupo a WHERE a.nome = :nome"),
    @NamedQuery(name = "AtividadeGrupo.findByStatus", query = "SELECT a FROM AtividadeGrupo a WHERE a.status = :status")})
public class AtividadeGrupo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STATUS")
    private Boolean status;

    @OneToMany(mappedBy = "grupoId")
    private Collection<Atividade> atividadeCollection;
    
    
    public AtividadeGrupo() {
    }

    public AtividadeGrupo(Integer id) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        if (!(object instanceof AtividadeGrupo)) {
            return false;
        }
        AtividadeGrupo other = (AtividadeGrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AtividadeGrupo[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Atividade> getAtividadeCollection() {
        return atividadeCollection;
    }

    public void setAtividadeCollection(Collection<Atividade> atividadeCollection) {
        this.atividadeCollection = atividadeCollection;
    }
    
}
