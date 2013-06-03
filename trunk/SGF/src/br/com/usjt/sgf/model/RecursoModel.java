/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.AtividadeDao;
import br.com.usjt.sgf.dao.RecursoDao;
import br.com.usjt.sgf.entity.Recurso;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class RecursoModel {
    
    
    
    private Recurso atividade;
    private RecursoDao dao;

    public RecursoModel(Recurso atividade) {
        this.atividade = atividade;
        dao = new RecursoDao();
    }
    
    
    
    public void persist(){
        dao.persist(atividade);
    }
    
    public void update(){
        dao.update(atividade);
    }
    
    public List listAll(){
        return dao.listAll();
    }
    
    public List findByName(){
        
        Object obj[][] = new Object[1][2];
        obj[0][0] = "nome";
        obj[0][1] = "%"+atividade.getNome()+"%";
       
        return dao.list("Recurso.findByNome", obj);
        
        
    }

    
    public void remove() {
        dao.remove(atividade);
    }
    
}
