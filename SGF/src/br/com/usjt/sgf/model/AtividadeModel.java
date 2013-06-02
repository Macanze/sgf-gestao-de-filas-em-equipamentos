/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.util.HibernateDaoUtil;
import br.com.usjt.sgf.entity.Atividade;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class AtividadeModel {

    
    private Atividade atividade;
    private final HibernateDaoUtil dao;
    
    
    public AtividadeModel(Atividade atv) {
        
        this.dao = new HibernateDaoUtil();
        this.atividade = atv;
    }
    
    
    public void persist(){
        dao.persist(atividade);
    }
    
    public List<Atividade> listByName(){
        
        //atividade.setNome("%"+atividade.getNome()+"%");
        String parameter[][] = new String[1][2];
        parameter[0][0] = "nome";
        parameter[0][1] = "%"+atividade.getNome()+"%";
        List<Atividade> listByQuery =(List<Atividade>) dao.listByQuery("Atividade.findByNome", parameter);
        
        return listByQuery;
    }
    
    
    
   
    
    
    

    public void update() {
        
        Atividade temp = find();
        temp.setDescr(atividade.getDescr());
        temp.setStatus(atividade.getStatus());
        temp.setNome(atividade.getNome());
        dao.update(temp);
    }
    
    public void remove() {
        atividade = find();
        dao.remove(atividade);
    }
    
    private Atividade find(){
        return (Atividade)dao.find(atividade,atividade.getId());
        
    }
    
    
    
}
