/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author dgsantos
 */


@Entity
public class Treino implements Serializable {
    
    
    
    @Id @GeneratedValue
    private int idTreino;
    
    
    
    @OneToOne
    private Usuario usuario;
    
  
    
    
    @ManyToMany
    private Collection<Grupo> grupos;
    

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }
    
    
}
