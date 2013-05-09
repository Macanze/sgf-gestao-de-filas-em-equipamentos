/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testesDeAlgoritimos;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 *
 * @author dgsantos
 */
public class Usuario {

    public int id;
    public String nome;
    public ArrayList<Atividade> listaAtividade;

    
    /**
     * Construtor
     * @param id id do usu�rio
     * @param nome nome do usuario
     */
    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.listaAtividade = new ArrayList<>();
                
    }
    
    public void addAtividade(Atividade atv){
        atv.setIdUsuario(this.id);
        atv.setNomeUsuario(this.nome);
        
        listaAtividade.add(atv);
        
    }
    
    
    
    
    
}
