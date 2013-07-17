/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dgsantos
 */
@Entity
@Table(name = "EXERCICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EXERCICIO.findAll", query = "SELECT a FROM EXERCICIO a"),
    @NamedQuery(name = "EXERCICIO.findById", query = "SELECT a FROM EXERCICIO a WHERE a.id = :id"),
    @NamedQuery(name = "EXERCICIO.findByDescricao", query = "SELECT a FROM EXERCICIO a WHERE a.DESCRICAO = :DESCRICAO"),
    @NamedQuery(name = "EXERCICIO.findByNome", query = "SELECT a FROM EXERCICIO a WHERE a.nome like :nome"),
    @NamedQuery(name = "EXERCICIO.findByStatus", query = "SELECT a FROM EXERCICIO a WHERE a.status = :status")})
public class Exercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRICAO")
    private String descr;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STATUS")
    private Boolean status;
    
    @OneToMany(mappedBy = "atividadeId")
    private Collection<TreinoAtividade> treinoatvCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividade")
    private Collection<GrupoAtividade> grupoatvCollection;

    @Transient
    public  int tempoNecessario;
    
    @Transient
    public Date horaInicio;
    
    
    @Transient 
    public Date horaFim;
    
    @Transient
    public int semaforo;
    
    public Exercicio() {
    }

    public Exercicio(Integer id) {
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
    public Collection<TreinoAtividade> getTreinoatvCollection() {
        return treinoatvCollection;
    }

    public void setTreinoatvCollection(Collection<TreinoAtividade> treinoatvCollection) {
        this.treinoatvCollection = treinoatvCollection;
    }

    @XmlTransient
    public Collection<GrupoAtividade> getGrupoatvCollection() {
        return grupoatvCollection;
    }

    public void setGrupoatvCollection(Collection<GrupoAtividade> grupoatvCollection) {
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
        if (!(object instanceof Exercicio)) {
            return false;
        }
        Exercicio other = (Exercicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.usjt.sgf.entity.Atividade[ id=" + id + " ]";
    }

    public int getTempoRestante() {
        Date horaAtual = Calendar.getInstance().getTime();
        
        long timeInMillis = horaAtual.getTime();
         
        
        //Se a hora de inicio for depois da hora atual retorna negativo
         if(horaInicio.before(horaAtual)){
             long time = horaInicio.getTime();
              return (int)((-1)*(((time - timeInMillis)/60)/1000));
         }else{
             
             long tempo = horaFim.getTime()-timeInMillis;
             return (int) ((tempo/60)/1000);
             
             
         }
    
     
        
    }
    
    
    
    
    
    
}
