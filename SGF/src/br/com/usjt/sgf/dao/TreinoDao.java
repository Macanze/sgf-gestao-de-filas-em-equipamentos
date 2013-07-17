/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.dao;

import br.com.usjt.sgf.dao.util.HibernateUtil;
import br.com.usjt.sgf.entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;


/**
 *
 * @author Douglas
 */
public class TreinoDao {
    
      private EntityManager manager;       
    public TreinoDao() {
        
        this.manager = new HibernateUtil().getManager();
        
    }
    
    /**
     * 
     */
    public void persist(Treino treino){
        manager.getTransaction().begin();
        
        TreinoPK treinoPK = new TreinoPK();
        treinoPK.setUsrTrn(treino.getUsuario().getId());
        treinoPK.setIdtreino((novoIdTreino(treino)));
        treino.setTreinoPK(treinoPK);
    
        manager.persist(treino);
        manager.getTransaction().commit();         
    }
    
    public void update(Treino treino){    
        manager.getTransaction().begin();
        Treino find = manager.find(treino.getClass(), treino.getTreinoPK());
        find.setDescricao(treino.getDescricao());
        find.setGrupoCollection(treino.getGrupoCollection());
        ArrayList<TreinoAtividade> listaIncluso = new ArrayList<>(find.getTreinoAtividadeCollection());
        ArrayList<TreinoAtividade> listaAtualizado= new ArrayList<>(treino.getTreinoAtividadeCollection());
        ArrayList<Grupo> arrayList = new ArrayList<>(treino.getGrupoCollection());
        JOptionPane.showMessageDialog(null, arrayList.size());
        for(int i  = 0 ; i < listaIncluso.size();i++){
            TreinoAtividade trn = listaIncluso.get(i);
            
            if(!listaAtualizado.contains(trn)){
              
                manager.remove(trn);
            }
          }
        
        for(TreinoAtividade trn: listaAtualizado){
            
            
            if(!listaIncluso.contains(trn)){ 
                
               int id= novoIdTreinoAtividade(treino);
               TreinoAtividadePK trnAtv = new TreinoAtividadePK(treino.getTreinoPK().getIdtreino(), id, treino.getTreinoPK().getUsrTrn());
                
                trn.setTreinoatvPK(trnAtv);
                manager.persist(trn);
            
            }
            
        }
        
        
        
        
        manager.getTransaction().commit();
        
        
    }
    
    public void remove(Treino treino){
        manager.getTransaction().begin();
        Treino find = manager.find(treino.getClass(), treino.getTreinoPK());
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
        
         Query createQuery = manager.createNamedQuery("Treino.findAll");
        
         return createQuery.getResultList();
        
    }

    private int novoIdTreino(Treino treino) {
        
        
        String sql = "SELECT MAX(t.treinoPK.idtreino) FROM Treino t WHERE t.treinoPK.usrTrn = "+treino.getUsuario().getId();
        TypedQuery<Integer> query = manager.createQuery(sql, Integer.class);
        Integer singleResult = query.getSingleResult();
        if(singleResult!=null){
            return (singleResult+1);
        }else{
            return 1;
        }
        
    }

    /**
     * 
     * @param treino
     * @return 
     */
    private int novoIdTreinoAtividade(Treino treino) {
        
        String sql = "SELECT MAX(t.treinoatvPK.id) FROM Treinoatv t WHERE t.treinoatvPK.treinoIdtreino = "+treino.getTreinoPK().getIdtreino()+" "
                + "AND t.treinoatvPK.treinoIduser = "+ treino.getTreinoPK().getUsrTrn();
        
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
