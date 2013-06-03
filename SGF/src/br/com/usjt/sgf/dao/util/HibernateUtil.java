/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.dao.util;
import br.com.usjt.sgf.dao.ConfiguracoesFileDao;
import br.com.usjt.sgf.entity.Configuracao;
import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

 

/**

*

* @author dgsantos

*/

public class HibernateUtil {

    private EntityManagerFactory factory;
    private Configuracao config;

 

    public HibernateUtil() {

     configurarConexao();

   

    }

   

    

    

    

     private void configurarConexao() {

              

        try{ 

           this.factory = Persistence.createEntityManagerFactory("SGFPU", getConf());

        } catch ( PersistenceException e ){ 

            throw new ExceptionInInitializerError(e); 

        } 

     

    } 

  

  

  

    public  Map getConf(){ 

        try {
            this.config = new ConfiguracoesFileDao().lerConfiguracoes();

                    

                

                Map prop = new HashMap(); 

                prop.put("javax.persistence.jdbc.url", config.db_url); 

                prop.put("javax.persistence.jdbc.password", config.db_password); 

                prop.put("javax.persistence.jdbc.user", config.db_username); 

                prop.put("javax.persistence.jdbc.driver", config.drive); 

                

          

        // aqui voce pode setar todas as PROPIEDADES, onde no map vc passa o nome do objeto, depois valor  prop.put([b]nome[/b], [b]valor[/b]) 

                return prop;

        } catch (FileNotFoundException ex) {

          

        } catch (ClassNotFoundException ex) {

          

        } catch (IOException ex) {

          

        }

        return null;

    }

 

   public  EntityManager getManager() {
        EntityManager manager= factory.createEntityManager();
        return manager;

    }
}