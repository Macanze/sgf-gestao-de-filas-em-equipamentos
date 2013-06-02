/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.util.HibernateDaoUtil;
import br.com.usjt.sgf.entity.Grupo;
import br.com.usjt.sgf.entity.Grupoatv;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class GrupoModel {

    
    private Grupo grupo;
    private final HibernateDaoUtil dao;
    
    
    public GrupoModel(Grupo atv) {
        
        this.dao = new HibernateDaoUtil();
        this.grupo = atv;
    }
    
    
    public void persist(){
        dao.persist(grupo);
    }
    
    public List<Grupo> listByName(){
        
        //recurso.setNome("%"+recurso.getNome()+"%");
        String parameter[][] = new String[1][2];
        parameter[0][0] = "nome";
        parameter[0][1] = "%"+grupo.getNome()+"%";
        List<Grupo> listByQuery =(List<Grupo>) dao.listByQuery("Grupo.findByNome", parameter);
        
        return listByQuery;
    }

    public void update() {
        
        Grupo temp = find();
        temp.setDescricao(grupo.getDescricao());
        temp.setStatus(grupo.getStatus());
        temp.setNome(grupo.getNome());
        temp.setGrupoatvCollection(grupo.getGrupoatvCollection());
        dao.update(temp);
    }
    
    public void remove() {
        grupo = find();
        dao.remove(grupo);
    }
    
    public Grupo find(){
        return (Grupo)dao.find(grupo,grupo.getId());
        
    }
    private void persistGrupoatv(){
        
    }

    public void commit() {
        dao.commit();
    }

    public void persistAtv(Grupoatv grpAtv) {
        dao.persist(grpAtv);
    }
    
    
    
}
