/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.AtividadeDao;
import br.com.usjt.sgf.dao.EquipamentoDao;
import br.com.usjt.sgf.entity.Atividade;
import br.com.usjt.sgf.entity.Equipamento;
import java.util.*;

/**
 *
 * @author Douglas
 */
public class RecursoModel {

   
    
    
    
    private Equipamento recurso;
    private EquipamentoDao dao;

    public RecursoModel(Equipamento atividade) {
        this.recurso = atividade;
        dao = new EquipamentoDao();
    }

    RecursoModel() {
        dao = new EquipamentoDao();
        
    }
    
    
    
    public void persist(){
        dao.persist(recurso);
    }
    
    public void update(){
        dao.update(recurso);
    }
    
    public List listAll(){
        return dao.listAll();
    }
    
    public List findByName(){
        
        Object obj[][] = new Object[1][2];
        obj[0][0] = "nome";
        obj[0][1] = "%"+recurso.getNome()+"%";
       
        return dao.list("Recurso.findByNome", obj);
        
        
    }

    
    public void remove() {
        dao.remove(recurso);
    }
    
    
    
    public static boolean contains(Equipamento rec,Atividade atv){
        
        ArrayList<Atividade> lista = new ArrayList<>(rec.getAtividadeCollection());
        
        for(Atividade temp: lista){
              if(temp.getId()==atv.getId()){
                return true;
            }
            
            
        }
        
        return false;
    }
    
    
     public static int tempoRestante(Equipamento rec) {
        
       int count = 0;
        ArrayList<Atividade> fila = (rec.filaAtendimento);
       
        Object obj[] = null ;
        
        
        if(fila.isEmpty()){
            return 0;
           
        }else{
            obj = new Object[fila.size()];
            Date data = Calendar.getInstance().getTime();
            long horaAtual = Calendar.getInstance().getTimeInMillis();
            
            Atividade atividade1 = null;
            for(int i = 0 ;i<fila.size();i++){
                Atividade atividade2 = fila.get(i);
                if(atividade1==null){
                    atividade1 = atividade2;
                    
                    long time = atividade1.horaInicio.getTime() - horaAtual;
                    int tempo = (int)(time/60)/1000;
                    
                    
                    if(data.before(atividade1.horaInicio)){
                        tempo = tempo*(-1);
                    }
                    
                    obj[i] = tempo;
                }else{
                    
                    long time1 = atividade2.horaInicio.getTime() - atividade1.horaFim.getTime();
                    
                    int tempo = (int)(time1/60)/1000;
                    
                    obj[i] = tempo;
                }
            }
            
            
        }
       System.out.println(Arrays.toString(obj));
       
         
       
         
       return count;
    }
    
    
    
}
