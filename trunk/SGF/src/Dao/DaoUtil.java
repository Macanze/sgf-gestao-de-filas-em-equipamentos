/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author dgsantos
 */
public class DaoUtil {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;

    public DaoUtil() {

        this.factory = Persistence.createEntityManagerFactory("PROJETOPU");
        this.manager = factory.createEntityManager();
        transaction = manager.getTransaction();

    }

    public void begin() {
        
        if(!transaction.isActive()){
            transaction.begin();
        }
     }
    
    public void commit(){
        if(transaction.isActive()){
            manager.flush();
            transaction.commit();
        }
    }


    public void rollBack() {
       if(transaction.isActive()){
           transaction.rollback();
       }
    }

    public void insert(Object obj) throws PersistenceException {
        
        begin();
        manager.persist(obj);
        commit();

    }

    public void delete(Object obj) {
        begin();
        
        manager.remove(obj);
        commit();

    }
       

    public Object find(Object temp, int id) {
        Object find = manager.find(temp.getClass(), id);
        //  manager.detach(find);
        return find;
    }

   
    public List listAll(String query) {
        Query createQuery = manager.createNamedQuery(query);
        List list = createQuery.getResultList();

        return list;
    }

    public Object singleByQuery(String query) {
        Query createQuery = manager.createQuery(query);
        return createQuery.getSingleResult();
        
    }
    
    
    public List listByQuery(String query) {
        Query createQuery = manager.createQuery(query);
        
        return createQuery.getResultList();
        
    }
    
    public List SqlQuery(String sql,Class c){
         Query createQuery = manager.createNativeQuery(sql,c);
        
        return createQuery.getResultList();
    }

    public Object SqlSingleResult(String sql) {
       Query createQuery = manager.createNativeQuery(sql);
       
       return createQuery.getSingleResult();
    }
    
    
}
