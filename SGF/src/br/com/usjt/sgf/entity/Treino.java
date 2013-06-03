/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "TREINO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treino.findAll", query = "SELECT t FROM Treino t"),
    @NamedQuery(name = "Treino.findByDescricao", query = "SELECT t FROM Treino t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Treino.findByUsrTrn", query = "SELECT t FROM Treino t WHERE t.treinoPK.usrTrn = :usrTrn"),
    @NamedQuery(name = "Treino.findByIdtreino", query = "SELECT t FROM Treino t WHERE t.treinoPK.idtreino = :idtreino")})
public class Treino implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TreinoPK treinoPK;
    @Column(name = "DESCRICAO")
    private String descricao;
    @ManyToMany(mappedBy = "treinoCollection", fetch = FetchType.EAGER)
    private Collection<Grupo> grupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treino", fetch = FetchType.EAGER)
    private Collection<Treinoatv> treinoatvCollection;
    @JoinColumn(name = "usr_trn", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Treino() {
    }

    public Treino(TreinoPK treinoPK) {
        this.treinoPK = treinoPK;
    }

    public Treino(int usrTrn, int idtreino) {
        this.treinoPK = new TreinoPK(usrTrn, idtreino);
    }

    public TreinoPK getTreinoPK() {
        return treinoPK;
    }

    public void setTreinoPK(TreinoPK treinoPK) {
        this.treinoPK = treinoPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    @XmlTransient
    public Collection<Treinoatv> getTreinoatvCollection() {
        return treinoatvCollection;
    }

    public void setTreinoatvCollection(Collection<Treinoatv> treinoatvCollection) {
        this.treinoatvCollection = treinoatvCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treinoPK != null ? treinoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treino)) {
            return false;
        }
        Treino other = (Treino) object;
        if ((this.treinoPK == null && other.treinoPK != null) || (this.treinoPK != null && !this.treinoPK.equals(other.treinoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Treino[ treinoPK=" + treinoPK + " ]";
    }
    
}
