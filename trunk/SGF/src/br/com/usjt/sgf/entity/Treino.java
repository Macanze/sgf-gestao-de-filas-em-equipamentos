/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dgsantos
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
    @OneToMany(mappedBy = "treino")
    private Collection<TreinoAtividade> treinoatvCollection;
    @JoinColumn(name = "usr_trn", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    
    @OneToMany
    private Collection<Grupo> grupoCollection;

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
    public Collection<TreinoAtividade> getTreinoatvCollection() {
        return treinoatvCollection;
    }

    public void setTreinoatvCollection(Collection<TreinoAtividade> treinoatvCollection) {
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

    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }
    
    
    
    
}
