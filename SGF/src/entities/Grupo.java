/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import dao.DaoService;

/**
 *
 * @author dgsantos
 */

@Entity
public class Grupo implements Serializable {
    
    
    @Id @GeneratedValue
    private int id;
    
    
    private String nome;
    
    @Column (length=244, nullable=false,unique=true)
    private String descricao;
    
    private boolean status;

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
    
    

    public List query(){
        
        String sql = "SELECT g FROM GrupoAtv g WHERE grupo = "+this.getId();
       return new DaoService().selectQuery(sql);
        
        
        
    }
    

    
}
