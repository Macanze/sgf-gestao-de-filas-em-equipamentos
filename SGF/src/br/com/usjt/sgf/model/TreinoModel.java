/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.AtividadeDao;
import br.com.usjt.sgf.dao.RecursoDao;
import br.com.usjt.sgf.dao.TreinoDao;
import br.com.usjt.sgf.entity.Recurso;
import br.com.usjt.sgf.entity.Treino;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class TreinoModel {
    
    
    
    private Treino treino;
    private TreinoDao dao;

    public TreinoModel(Treino treino) {
        this.treino = treino;
        dao = new TreinoDao();
    }
    
    
    
    public void persist(){
        dao.persist(treino);
    }
    
    public void update(){
        
                
        dao.update(treino);
    }
    
    public List listAll(){
        return dao.listAll();
    }
    
    public List findById(){
        
        Object obj[][] = new Object[1][2];
        obj[0][0] = "usrTrn";
        obj[0][1] = +treino.getUsuario().getId();
       
        return dao.list("Treino.findByUsrTrn", obj);
        
        
    }

    
    public void remove() {
        dao.remove(treino);
    }
    
}
