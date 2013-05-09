/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testesDeAlgoritimos;

import java.util.ArrayList;

/**
 *
 * @author dgsantos
 */
public class Teste {
    
    
    
    public static void main(String args[]){
        
        Usuario usuario = new Usuario(1, "Douglas Santos");
        Usuario usuario2 = new Usuario(2, "Sandra de S� ");
        
        
        
        Atividade bicicleta = new Atividade(01, "Bicicleta", 10);
        Atividade esteira = new Atividade(02, "Esteira", 15);
        usuario.addAtividade(bicicleta);
        usuario.addAtividade(esteira);
        
        
        
          Atividade bicicleta1 = new Atividade(01, "Bicicleta", 10);
        Atividade esteira1 = new Atividade(02, "Esteira", 15);
        usuario2.addAtividade(bicicleta1);
        usuario2.addAtividade(esteira1);
        
        
        Recurso recBike = new Recurso(01, 01, "Bicicleta", 0);
        Recurso recBike1 = new Recurso(01, 02, "Bicicleta1", 0);
        Recurso recStep = new Recurso(02, 01, "Esteira   ", 0);
        
        ArrayList<Recurso> listaRecursos = new ArrayList<>();
        listaRecursos.add(recStep);
        listaRecursos.add(recBike);
        listaRecursos.add(recBike1);
        
        Agendador agendador = new Agendador(listaRecursos);
        agendador.agendarUsuario(usuario);
        agendador.agendarUsuario(usuario2);
        
        
    }
    
    
    
}
