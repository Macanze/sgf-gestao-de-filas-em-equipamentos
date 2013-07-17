/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.dao;

import br.com.usjt.sgf.dao.util.HibernateUtil;
import br.com.usjt.sgf.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class UsuarioDao {

    private EntityManager manager;
 
    public UsuarioDao() {
        
        this.manager = new HibernateUtil().getManager();
        
    }

    /**
     * 
     */
    public void persist(Usuario usuario){
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();         
    }
    
    public void update(Usuario usuario){
        
        manager.getTransaction().begin();
        Usuario find = manager.find(usuario.getClass(), usuario.getId());
        find.setDescricao(usuario.getDescricao());
        find.setTreinoCollection(usuario.getTreinoCollection());
        find.setNome(usuario.getNome());
        find.setStatus(usuario.getStatus());
        manager.getTransaction().commit();    
    }
    
    public void remove(Usuario usuario){
        manager.getTransaction().begin();
        Usuario find = manager.find(usuario.getClass(), usuario.getId());
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
        
         Query createQuery = manager.createNamedQuery("Usuario.findAll");
        
         return createQuery.getResultList();
        
    }
}
