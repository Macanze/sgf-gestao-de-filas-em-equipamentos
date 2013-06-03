/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.AtividadeDao;
import br.com.usjt.sgf.entity.Atividade;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class AtividadeModel {
    
    
    
    private Atividade atividade;
    private AtividadeDao dao;

    public AtividadeModel(Atividade atividade) {
        this.atividade = atividade;
        dao = new AtividadeDao();
    }
    
    
    
    public void persist(){
        dao.persist(atividade);
    }
    
    public void update(){
        dao.update(atividade);
    }
    
    public List findAll(){
        return dao.listAll();
    }
    
    public List listByName(){
        
        Object obj[][] = new Object[1][2];
        obj[0][0] = "nome";
        obj[0][1] = "%"+atividade.getNome()+"%";
       
        return dao.list("Atividade.findByNome", obj);
        
        
    }

    
    public void remove() {
        dao.remove(atividade);
    }
    
}
