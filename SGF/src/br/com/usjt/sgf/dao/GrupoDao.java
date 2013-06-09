/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.dao;

import br.com.usjt.sgf.dao.util.HibernateUtil;
import br.com.usjt.sgf.entity.Grupo;
import br.com.usjt.sgf.entity.Grupoatv;
import br.com.usjt.sgf.entity.GrupoatvPK;
import br.com.usjt.sgf.entity.Treino;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Douglas
 */
public class GrupoDao {
    
      private EntityManager manager;

    
    
       
    /**
       * 
       */
    public GrupoDao() {
        
        this.manager = new HibernateUtil().getManager();
        
    }
    
    
    
    
    /**
     * 
     */
    public void persist(Grupo atividade){
        manager.getTransaction().begin();
        manager.persist(atividade);
        manager.getTransaction().commit();         
    }
    
    
    public void update(Grupo atividade){
        
        manager.getTransaction().begin();
        Grupo find = manager.find(atividade.getClass(), atividade.getId());
        find.setDescricao(atividade.getDescricao());
        find.setGrupoatvCollection(atividade.getGrupoatvCollection());
        find.setNome(atividade.getNome());
        find.setStatus(atividade.getStatus());
        manager.getTransaction().commit();
        
        
    }
    
    public void remove(Grupo atividade){
        manager.getTransaction().begin();
        Grupo find = manager.find(atividade.getClass(), atividade.getId());
        manager.remove(find);
        manager.getTransaction().commit();                
    }
    
    /**
     * Realiza um consulta de acordo com os parametros
     * @param queryNamed - NamedQuery associada a entidade
     * @param parameters - vetor com os parametros
     * @return lista com os resultdos da consulta
     */
    public List list(String queryNamed, Object[][] parameters){
        Query createQuery = manager.createNamedQuery(queryNamed);
        
        for(int i = 0 ; i<parameters.length;i++){
            createQuery.setParameter(parameters[i][0].toString(), parameters[i][1]);
        }
                       
        return createQuery.getResultList();        
    }
    
    public List listAll(){
        
         Query createQuery = manager.createNamedQuery("Grupo.findAll");
        
         return createQuery.getResultList();
        
    }

    public void persistAtividade(Grupoatv grpAtv) {
        GrupoatvPK grupoatvPK = new GrupoatvPK();
        grupoatvPK.setGrupoId(grpAtv.getGrupo().getId());
        grupoatvPK.setAtividadeId(grpAtv.getAtividade().getId());
        grupoatvPK.setIdatividade(novoIdAtividade(grupoatvPK));
        
                
        grpAtv.setGrupoatvPK(grupoatvPK);
        manager.getTransaction().begin();
        manager.persist(grpAtv);
        manager.getTransaction().commit();
        
    }
    
    
    /**
     * 
     * @param treino
     * @return 
     */
    private int novoIdAtividade(GrupoatvPK treino) {
        
        String sql = "SELECT MAX(t.grupoatvPK.idatividade) FROM Grupoatv t WHERE t.grupoatvPK.grupoId = "+treino.getGrupoId()+" "
                + "AND t.grupoatvPK.atividadeId = "+ treino.getAtividadeId();
        
        System.out.println(sql);
        TypedQuery<Integer> query = manager.createQuery(sql, Integer.class);
        Integer singleResult = query.getSingleResult();
        if(singleResult!=null){
            return (singleResult+1);
        }else{
            return 1;
        }
    }
    
    
    
    
}
