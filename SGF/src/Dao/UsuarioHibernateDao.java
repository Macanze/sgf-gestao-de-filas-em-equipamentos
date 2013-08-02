/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author dgsantos
 */
public class UsuarioHibernateDao {
    private final DaoUtil daoUtil;

    public UsuarioHibernateDao() {
        this.daoUtil = new DaoUtil();
    }
    
    public void insert(Usuario recurso){
        
        try{
                    daoUtil.insert(recurso);
        }catch(PersistenceException ex){
            JOptionPane.showMessageDialog(null, ex);
        }

     }

    public ArrayList<Usuario> buscarRecursos() {
        List listAll = daoUtil.listAll("Usuario.findAll");
        ArrayList<Usuario> listaRecurso = new ArrayList<>(listAll);
        
        return listaRecurso;
    }

    public void delete(Usuario usuarioSelecionado) {
       daoUtil.begin();
        Usuario temp = (Usuario) daoUtil.find(usuarioSelecionado, usuarioSelecionado.getId());
        daoUtil.delete(temp);
        daoUtil.commit();
        
    }

    public void update(Usuario usuarioSelecionado) {
        daoUtil.begin();
        Usuario temp = (Usuario) daoUtil.find(usuarioSelecionado, usuarioSelecionado.getId());
       
        temp.setBairro(usuarioSelecionado.getBairro());
        temp.setCelular(usuarioSelecionado.getCelular());
        temp.setCep(usuarioSelecionado.getCep());
        temp.setCidade(usuarioSelecionado.getCidade());
        temp.setComplemento(usuarioSelecionado.getComplemento());
        temp.setContato(usuarioSelecionado.getContato());
        temp.setCpf(usuarioSelecionado.getCpf());
        temp.setEmail(usuarioSelecionado.getEmail());
        temp.setEndereco(usuarioSelecionado.getEndereco());
        temp.setEstado(usuarioSelecionado.getEstado());
        temp.setMatricula(usuarioSelecionado.getMatricula());
        temp.setNascimento(usuarioSelecionado.getNascimento());
        temp.setNome(usuarioSelecionado.getNome());
        temp.setNumero(usuarioSelecionado.getNumero());
        temp.setSenha(usuarioSelecionado.getSenha());
        temp.setTelefone(usuarioSelecionado.getTelefone());
        
       
        
        daoUtil.commit();
        
        
        
        
        
    }
    
    
    public Usuario efetuarLogin(Usuario usuarioSelecionado){
        
        
        //@NamedQuery(name = "Usuario.findByMatricula", query = "SELECT u FROM Usuario u WHERE u.matricula = :matricula"),
        try{
            String query = "SELECT u FROM Usuario u WHERE u.matricula = "+usuarioSelecionado.getMatricula();
            Usuario usuario =(Usuario) daoUtil.singleByQuery(query);
            return usuario;
        }catch(Exception ex){
            return null;
        }
        
        
    }
    
    
    
}
