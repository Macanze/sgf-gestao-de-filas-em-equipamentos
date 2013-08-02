/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Atividade;
import entidades.AtividadeGrupo;
import entidades.Recurso;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author dgsantos
 */
public class AtividadeHibernateDao {
    private final DaoUtil daoUtil;

    public AtividadeHibernateDao() {
        this.daoUtil = new DaoUtil();
    }

  
    
    public void insert(Atividade recurso){
        
        try{
                    daoUtil.insert(recurso);
        }catch(PersistenceException ex){
            JOptionPane.showMessageDialog(null, ex);
        }

     }

    public ArrayList<Atividade> buscarRecursos() {
        List listAll = daoUtil.listAll("Atividade.findAll");
        ArrayList<Atividade> listaRecurso = new ArrayList<>(listAll);
        
        return listaRecurso;
    }

    public void delete(Atividade atividadeSelecionado) {
       daoUtil.begin();
        Atividade temp = (Atividade) daoUtil.find(atividadeSelecionado, atividadeSelecionado.getId());
        daoUtil.delete(temp);
        daoUtil.commit();
        
    }

    public void update(Atividade atividadeSelecionado) {
        daoUtil.begin();
        Atividade temp = (Atividade) daoUtil.find(atividadeSelecionado, atividadeSelecionado.getId());
       
      
        temp.setNome(atividadeSelecionado.getNome());
        temp.setDescricao(atividadeSelecionado.getDescricao());
        temp.setFoto(atividadeSelecionado.getFoto());
        
        AtividadeGrupo grupo = (AtividadeGrupo) daoUtil.find(atividadeSelecionado.getGrupoId(), atividadeSelecionado.getGrupoId().getId());
        
        
        temp.setGrupoId(grupo);
        temp.setStatus(atividadeSelecionado.getStatus());
       
        
        daoUtil.commit();
        
        
        
        
        
    }

    public ArrayList<Atividade> findByGroup(Atividade atividade, Recurso recurso) {
        
        
        if(recurso!=null){
            recurso = new Recurso(0);
        }
        
        
        
        
        
        
          ArrayList<Atividade> listaAtividade;
           try{
            String query = "SELECT * FROM Atividade a, Recurso_Atividade b"
                    + " WHERE a.id = b.atividade_id "
                    + "AND a.id not in( SELECT ATIVIDADE_ID FROM Recurso_Atividade c WHERE RECURSO_ID =  "+ recurso.getId()+") ";
            
            if(atividade.getGrupoId()!=null){
                query= query+ " AND a.grupo_Id = "+atividade.getGrupoId().getId();
            }
               List listByQuery = daoUtil.SqlQuery(query,Atividade.class);
            
            
            
            if(listByQuery!=null){
                System.out.println("Entrou 1")  ;
              listaAtividade = new ArrayList<>(listByQuery);
            }else{
                System.out.println("Entrou 2")  ;
                
                listaAtividade = new ArrayList<>(daoUtil.listByQuery("SELECT a FROM Atividade a"));
                           
            }
            
            
            
            
            
            
            
            return listaAtividade;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
        
        
    }
    
    
    
    
    
    
}
