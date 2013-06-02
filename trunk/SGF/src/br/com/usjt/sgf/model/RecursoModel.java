/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.util.HibernateDaoUtil;
import br.com.usjt.sgf.entity.Recurso;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class RecursoModel {

    
    private Recurso recurso;
    private final HibernateDaoUtil dao;
    
    
    public RecursoModel(Recurso atv) {
        
        this.dao = new HibernateDaoUtil();
        this.recurso = atv;
    }
    
    
    public void persist(){
        dao.persist(recurso);
    }
    
    public List<Recurso> listByName(){
        
        //recurso.setNome("%"+recurso.getNome()+"%");
        String parameter[][] = new String[1][2];
        parameter[0][0] = "nome";
        parameter[0][1] = "%"+recurso.getNome()+"%";
        List<Recurso> listByQuery =(List<Recurso>) dao.listByQuery("Recurso.findByNome", parameter);
        
        return listByQuery;
    }

    public void update() {
        
        Recurso temp = find();
        temp.setDescricao(recurso.getDescricao());
        temp.setStatus(recurso.getStatus());
        temp.setNome(recurso.getNome());
        temp.setAtividadeRelacionada(recurso.getAtividadeRelacionada());
        dao.update(temp);
    }
    
    public void remove() {
        recurso = find();
        dao.remove(recurso);
    }
    
    private Recurso find(){
        return (Recurso)dao.find(recurso,recurso.getId());
        
    }
    
    
    
}
