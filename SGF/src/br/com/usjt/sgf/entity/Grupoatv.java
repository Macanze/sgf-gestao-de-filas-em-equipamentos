/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceProperty;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cascade;

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
    @ManyToOne
    private Grupo grupoId;
    @JoinColumn(name = "ATIVIDADE_ID", referencedColumnName = "ID")
    
    
    @ManyToOne
    private Atividade atividadeId;

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

    public Grupo getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Grupo grupoId) {
        this.grupoId = grupoId;
    }

    public Atividade getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Atividade atividadeId) {
        this.atividadeId = atividadeId;
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
    
    public Object[] toArray(){
        
        
        Object obj[] = new Object[5];
        obj[0] = getAtividadeId().getNome();
        obj[1] = getAtividadeId().getDescr();
        obj[2] = getTempo();
        
        return obj;
    }
    
    
}
