/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.AtividadeDao;
import br.com.usjt.sgf.dao.GrupoDao;
import br.com.usjt.sgf.entity.Grupo;
import br.com.usjt.sgf.entity.GrupoAtividade;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class GrupoModel {
    
    
    
    private Grupo atividade;
    private GrupoDao dao;

    public GrupoModel(Grupo atividade) {
        this.atividade = atividade;
        dao = new GrupoDao();
    }

    public GrupoModel() {
        dao = new GrupoDao();
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
    
    public List listByNome(){
        
        Object obj[][] = new Object[1][2];
        obj[0][0] = "nome";
        obj[0][1] = "%"+atividade.getNome()+"%";
       
        return dao.list("Grupo.findByNome", obj);
        
        
    }

    
    public void remove() {
        dao.remove(atividade);
    }

    public void persistAtividade(GrupoAtividade grpAtv) {
        dao.persistAtividade(grpAtv);
    }
    
}
