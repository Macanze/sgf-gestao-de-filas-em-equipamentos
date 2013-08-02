/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.AtividadeGrupo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author dgsantos
 */
public class AtividadeGrupoHibernateDao {
    private final DaoUtil daoUtil;

    public AtividadeGrupoHibernateDao() {
        this.daoUtil = new DaoUtil();
    }

  
    
    public void insert(AtividadeGrupo recurso){
        
        try{
                    daoUtil.insert(recurso);
        }catch(PersistenceException ex){
            JOptionPane.showMessageDialog(null, ex);
        }

     }

    public ArrayList<AtividadeGrupo> buscarRecursos() {
        List listAll = daoUtil.listAll("AtividadeGrupo.findAll");
        ArrayList<AtividadeGrupo> listaRecurso = new ArrayList<>(listAll);
        
        return listaRecurso;
    }

    public void delete(AtividadeGrupo grupoSelecionado) {
       daoUtil.begin();
        AtividadeGrupo temp = (AtividadeGrupo) daoUtil.find(grupoSelecionado, grupoSelecionado.getId());
        daoUtil.delete(temp);
        daoUtil.commit();
        
    }

    public void update(AtividadeGrupo grupoSelecionado) {
        daoUtil.begin();
        AtividadeGrupo temp = (AtividadeGrupo) daoUtil.find(grupoSelecionado, grupoSelecionado.getId());
       
      
        temp.setNome(grupoSelecionado.getNome());
        temp.setStatus(grupoSelecionado.getStatus());
       
        
        daoUtil.commit();
        
        
        
        
        
    }
    
    
    
    
    
    
}
