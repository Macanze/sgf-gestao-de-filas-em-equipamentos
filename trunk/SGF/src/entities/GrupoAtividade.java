/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author dgsantos
 */

@Entity
public class GrupoAtividade implements Serializable {
    
    
    
    
    @Id @GeneratedValue
    private int idAtividade;
    
  
    @OneToOne
    private Grupo grupo;
  
    @OneToOne
    private Atividade atividade;
    
    
    private int tempo;
    
   

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

   

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    
    
    
    
}
