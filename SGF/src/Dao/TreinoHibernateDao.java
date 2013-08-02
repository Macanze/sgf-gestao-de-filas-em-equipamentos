/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Treino;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;


/**
 *
 * @author dgsantos
 */
public class TreinoHibernateDao {
    private final DaoUtil daoUtil;

    public TreinoHibernateDao() {
        this.daoUtil = new DaoUtil();
    }

  
    
    public void insert(Treino recurso){
        
        try{
         
         
         daoUtil.insert(recurso);
        }catch(PersistenceException ex){
            JOptionPane.showMessageDialog(null, ex);
        }

     }

    public ArrayList<Treino> buscarRecursos() {
        List listAll = daoUtil.listAll("Treino.findAll");
        ArrayList<Treino> listaRecurso = new ArrayList<>(listAll);
        
        return listaRecurso;
    }

    public void delete(Treino atividadeSelecionado) {
       daoUtil.begin();
      //  Treino temp = (Treino) daoUtil.find(atividadeSelecionado, atividadeSelecionado.getId());
      //  daoUtil.delete(temp);
        daoUtil.commit();
        
    }

    public void update(Treino atividadeSelecionado) {
      /*  daoUtil.begin();
        //Treino temp = (Treino) daoUtil.find(atividadeSelecionado, atividadeSelecionado.getTreinoPK()));
        temp.setDescricao(atividadeSelecionado.getDescricao());
        AtividadeGrupo grupo = (AtividadeGrupo) daoUtil.find(atividadeSelecionado.getGrupoId(), atividadeSelecionado.getGrupoId().getId());
        temp.setStatus(atividadeSelecionado.getStatus());
        daoUtil.commit(); */
                
    }
    
    
    public int novoId(Usuario usuario){
        
        int novoId = 0;
        
        
        try{
            String sql = "SELECT MAX(ID) FROM TREINO WHERE ID_USUARIO = "+usuario.getId();
            novoId =(int) daoUtil.SqlSingleResult(sql);
        }catch(Exception ex){
            
        }
        
        
        
        return (novoId+1);
    }


    
    
    
}
