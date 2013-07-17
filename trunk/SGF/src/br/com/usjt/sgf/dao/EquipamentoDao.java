/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.dao;

import br.com.usjt.sgf.dao.util.HibernateUtil;
import br.com.usjt.sgf.entity.Equipamento;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class EquipamentoDao {
    
    private EntityManager manager;

    public EquipamentoDao() {
        
        this.manager = new HibernateUtil().getManager();
        
    }   
    /**
     * 
     */
    public void persist(Equipamento atividade){
        manager.getTransaction().begin();
        manager.persist(atividade);
        manager.getTransaction().commit();         
    }
    
    
    public void update(Equipamento recurso){
        
        manager.getTransaction().begin();
        Equipamento find = manager.find(recurso.getClass(), recurso.getId());
        System.out.println(find.getNome());
        find.setDescricao(recurso.getDescricao());
        find.setNome(recurso.getNome());
        find.setStatus(recurso.getStatus());
        find.setAtividadeCollection(recurso.getAtividadeCollection());
        
        manager.persist(find);
        manager.getTransaction().commit();
           
    }
    
    public void remove(Equipamento atividade){
        manager.getTransaction().begin();
        Equipamento find = manager.find(atividade.getClass(), atividade.getId());
        manager.remove(find);
        manager.getTransaction().commit();                
    }
    
    /**
     * Realiza um consulta de acordo com os parametros
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
        
         Query createQuery = manager.createNamedQuery("Recurso.findAll");
        
         return createQuery.getResultList();
        
    }
    
    
    
    
}
