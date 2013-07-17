/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.dao.util;


import br.com.usjt.sgf.entity.Exercicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class HibernateDaoUtil {


    
      private  EntityManager manager;

    public HibernateDaoUtil() {
        this.manager = new HibernateUtil().getManager();
        
    }
    
    
    
    
    public void persist(Object obj) {
        begin();
        manager.persist(obj);
        commit();
    }

    
    public void remove(Object obj) {
      begin();
     
      
      manager.remove(obj);
      commit();
    }

    
    public Object find(Object obj, int id) {
        begin();
        return         manager.find(obj.getClass(), id);
    }

    
    public List list(Object obj) {
     return null;
    }

   
    public List listByQuery(String sqlQuery, Object[][] parameters) {
        
        
        Query query = manager.createNamedQuery(sqlQuery);
        
        
        for(int i = 0 ; i < parameters.length;i++){
            query.setParameter(parameters[i][0].toString(), parameters[i][1]);
        }
        
        
        
        
        
        return query.getResultList();
    }
    
    
    public void begin(){
        
        if(!manager.getTransaction().isActive()){
            manager.getTransaction().begin();
        }
        
    }
    
    public void commit(){
        if(manager.getTransaction().isActive()){
            manager.getTransaction().commit();
        }
    }

    public void update(Object atividade)
    {
        
        
        
        
        commit();
        manager.close();
        
        
        
    }

    public int findNewId(String table, String field) {
        
        
        
        
        
        
        
        return 0;
    }
    
    
    
    
}
