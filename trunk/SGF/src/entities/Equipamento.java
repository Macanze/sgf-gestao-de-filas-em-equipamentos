//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Equipamento.java
//  @ Date : 20/5/2013
//  @ Author : 
//
//
package entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="Recurso")
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30, nullable = false, unique = true)
    private String nome;
    @Column(length = 100, nullable = false, unique = false)
    private String descricao;
    @Column(nullable=false)
    private boolean status;
    
    @ManyToMany
    private Collection<Atividade> listaAtividades;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Atividade> getListaAtividades() {
        return listaAtividades;
    }

    public void setListaAtividades(Collection<Atividade> listaAtividades) {
        this.listaAtividades = listaAtividades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

 
    
    

    public void addAtividade(Atividade atv) {

        if (listaAtividades != null) {
            listaAtividades.add(atv);
        } else {
            this.listaAtividades = new ArrayList<>();
            listaAtividades.add(atv);
        }

    }
}
