/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author dgsantos
 */
public class DaoService {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;

    public DaoService() {

        this.factory = Persistence.createEntityManagerFactory("sgfpu");
        this.manager = factory.createEntityManager();


    }

   
    
    public void begin(){
        this.manager.getTransaction().begin();
    }
    

    public void fecharConexao() {
        manager.getTransaction().commit();
        factory.close();
    }

    public void rollBack() {
        this.manager.getTransaction().rollback();
    }

    public void insert(Object obj) throws PersistenceException {

        manager.getTransaction().begin();
        manager.persist(obj);
        manager.getTransaction().commit();

    }

   

    public List select(Object temp) {
        

        String className = temp.getClass().getName();
        String tableName = className.substring(className.lastIndexOf(".") + 1, className.length());
        String sql = "SELECT e FROM " + tableName + " e";
        Query createQuery = manager.createQuery(sql);
        List list = createQuery.getResultList();
        
        return list;

    }

    public void delete(Object obj) {
        manager.getTransaction().begin();
        manager.remove(obj);
        manager.getTransaction().commit();

    }

    public Object find(Object temp, int id) {
        Object find = manager.find(temp.getClass(), id);
        //  manager.detach(find);
        return find;
    }

    public void commit() {
        manager.getTransaction().commit();
    }
    
    
    public void query(){
        
    }

    public List selectQuery(String sql) {
          Query createQuery = manager.createQuery(sql);
        List list = createQuery.getResultList();
        
        return list;
    }
}
