/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author dgsantos
 */


@Entity
public class Treino implements Serializable {
    
    
    
    @Id @GeneratedValue
    private int idTreino;
    
   
    @ManyToOne(optional=false)
    @JoinColumn(name="usr_trn")
    private Usuario usuario;
    
    
 
    
    

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

  

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


   
    
    
    
    
}
