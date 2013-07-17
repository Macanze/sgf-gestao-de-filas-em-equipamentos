/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.dao;

import br.com.usjt.sgf.dao.util.HibernateUtil;
import br.com.usjt.sgf.entity.Atividade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class AtividadeDao { 
    private EntityManager manager;
    public AtividadeDao() {
        this.manager = new HibernateUtil().getManager();
    }

    public void persist(Atividade atividade){
        manager.getTransaction().begin();
        manager.persist(atividade);
        manager.getTransaction().commit();         
    }
       
    public void update(Atividade atividade){
        manager.getTransaction().begin();
        Atividade find = manager.find(atividade.getClass(), atividade.getId());
        find.setDescr(atividade.getDescr());     
        find.setNome(atividade.getNome());
        find.setStatus(atividade.getStatus());
        manager.getTransaction().commit();   
    }
    
    public void remove(Atividade atividade){
        manager.getTransaction().begin();
        Atividade find = manager.find(atividade.getClass(), atividade.getId());
        manager.remove(find);
        manager.getTransaction().commit();                
    }
    
    /**
     * Realiza uma consulta de acordo com os parametros
     * @param queryNamed - NamedQuery associada a entidade
     * @param parameters - vetor com os parametros
     * @return lista com os resultdos da consulta
     */
    public List list(String queryNamed, Object[][] parameters){
        Query createQuery = manager.createNamedQuery(queryNamed);
        
        for(int i = 0 ; i<parameters.length;i++){
            createQuery.setParameter(parameters[i][0].toString(), parameters[i][1]);
        }
                       
        return createQuery.getResultList();        
    }
    
    public List listAll(){
         Query createQuery = manager.createNamedQuery("Atividade.findAll");
         return createQuery.getResultList();
    }
}