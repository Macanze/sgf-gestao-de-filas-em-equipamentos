/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.UsuarioDao;
import br.com.usjt.sgf.entity.Usuario;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class UsuarioModel {
    
    
    
    private Usuario usuario;
    private UsuarioDao dao;

    public UsuarioModel(Usuario usuario) {
        this.usuario = usuario;
        dao = new UsuarioDao();
    }
    
    
    
    public void persist(){
        dao.persist(usuario);
    }
    
    public void update(){
        dao.update(usuario);
    }
    
    public List findAll(){
        return dao.listAll();
    }
    
    public List listByName(){
        
        Object obj[][] = new Object[1][2];
        obj[0][0] = "nome";
        obj[0][1] = "%"+usuario.getNome()+"%";
       
        return dao.list("Usuario.findByNome", obj);
        
        
    }

    
    public void remove() {
        dao.remove(usuario);
    }
    
}
