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
public class TreinoAtividade implements Serializable {
    
    
    
   
    
    @Id @GeneratedValue
    private int id;
    @ManyToOne
    private Treino treino;
    @OneToOne
    private Atividade atividade;
    
    private int tempo;
    
    
    
    
    
}
