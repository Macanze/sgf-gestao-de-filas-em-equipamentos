/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Recurso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author dgsantos
 */
public class RecursoHibernateDao {
    private final DaoUtil daoUtil;

    public RecursoHibernateDao() {
        this.daoUtil = new DaoUtil();
    }
    
    public void insert(Recurso recurso){
        
        try{
                    daoUtil.insert(recurso);
        }catch(PersistenceException ex){
            JOptionPane.showMessageDialog(null, ex);
        }

     }

    public ArrayList<Recurso> buscarRecursos() {
        List listAll = daoUtil.listAll("Recurso.findAll");
        ArrayList<Recurso> listaRecurso = new ArrayList<>(listAll);
        
        return listaRecurso;
    }

    public void delete(Recurso recursoSelecionado) {
       daoUtil.begin();
        Recurso temp = (Recurso) daoUtil.find(recursoSelecionado, recursoSelecionado.getId());
        daoUtil.delete(temp);
        daoUtil.commit();
        
    }

    public void update(Recurso recursoSelecionado) {
        daoUtil.begin();
        Recurso temp = (Recurso) daoUtil.find(recursoSelecionado, recursoSelecionado.getId());
        temp.setNome(recursoSelecionado.getNome());
        temp.setStatus(recursoSelecionado.getStatus());
        temp.setAtividadeCollection(recursoSelecionado.getAtividadeCollection());
        daoUtil.commit();
        
        
        
        
        
    }
    
    
    
    
    
    
}
