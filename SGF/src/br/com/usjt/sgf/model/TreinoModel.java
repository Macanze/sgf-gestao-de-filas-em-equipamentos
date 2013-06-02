/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.util.HibernateDaoUtil;
import br.com.usjt.sgf.entity.Treino;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class TreinoModel {

    
    private Treino treino;
    private final HibernateDaoUtil dao;
    
    
    public TreinoModel(Treino atv) {
        
        this.dao = new HibernateDaoUtil();
        this.treino = atv;
    }
    
    
    public void persist(){
        dao.persist(treino);
    }
    
    public List<Treino> listByName(){
        
        //treino.setNome("%"+treino.getNome()+"%");
        String parameter[][] = new String[1][2];
        parameter[0][0] = "nome";
       // parameter[0][1] = "%"+treino.getDescricao()+"%";
        List<Treino> listByQuery =(List<Treino>) dao.listByQuery("Treino.findByNome", parameter);
        
        return listByQuery;
    }

    public void update() {
        
     //   Treino temp = find();
    //    temp.setDescricao(treino.getDescricao());
   //     temp.setStatus(treino.getStatus());
   //     temp.setNome(treino.getNome());
     //   temp.setAtividadeRelacionada(treino.getAtividadeRelacionada());
  //      dao.update(temp);
    }
    
    public void remove() {
     //   treino = find();
        dao.remove(treino);
    }
    
  
    
    
    
}
