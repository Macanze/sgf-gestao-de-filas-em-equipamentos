package testesDeAlgoritimos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author dgsantos
 */
public class Ordenador {
    
    
    
    /**
     * Ordena todos os recursos
     * @param recursos
     * @return 
     */
    public ArrayList<Recurso> ordenarFilas(ArrayList<Recurso> recursos){
       
        
        for(Recurso rec : recursos){
      
            rec = ordernarRecursos(rec);
            
            
            
        }
   
        return recursos;
    }

    
    /**
     * Ordena a fila de um recurso
     * @param rec
     * @return 
     */
    private Recurso ordernarRecursos(Recurso rec) {
        
        if(rec.listaAtividade!=null){
   
        
            Collections.sort(rec.listaAtividade, new CompareTo());  
            
        return rec;
        }else{
            return null;
        }
        
    }
    
    
 
    
    
    
    public class CompareTo implements Comparator<Atividade> {  
       
     
      

        @Override
        public int compare(Atividade o1, Atividade o2) {
             int retorno = 0;    
            if(o1 == null || o2 == null)    
                return retorno;    
                
            Atividade atv1 = (Atividade) o1;    
            Atividade atv2 = (Atividade) o2;    
            
            if(atv1.horaFim.after(atv2.horaFim)) {    
                retorno = 1;    
            } else if(atv1.horaFim== atv2.horaFim){    
                retorno = 0;    
            } else {    
                retorno = -1;    
            }    
             return retorno;    
        }
    }  
    
    
    
}
