/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kalango
 */
public class UsuarioDAO {
    public void cadastraUsuario(Usuario usario) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sgfpu");
        EntityManager fManager = factory.createEntityManager();
        fManager.persist(usario);
        fManager.getTransaction().begin();
        fManager.getTransaction().commit();
        fManager.close();
    }
}