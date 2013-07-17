/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.ExercicioDao;
import br.com.usjt.sgf.dao.EquipamentoDao;
import br.com.usjt.sgf.entity.Exercicio;
import br.com.usjt.sgf.entity.Equipamento;
import java.util.*;

/**
 *
 * @author Douglas
 */
public class EquipamentoModel {
    private Equipamento recurso;
    private EquipamentoDao dao;

    public EquipamentoModel(Equipamento atividade) {
        this.recurso = atividade;
        dao = new EquipamentoDao();
    }

    EquipamentoModel() {
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
        
    public static boolean contains(Equipamento equipamento, Exercicio atividade){
        
        ArrayList<Exercicio> lista = new ArrayList<>(equipamento.getAtividadeCollection());
        
        for(Exercicio temp: lista){
              if(temp.getId()==atividade.getId()){
                return true;
            }
        }
        
        return false;
    }
    
     public static int tempoRestante(Equipamento equipamento) {    
       int count = 0;
        ArrayList<Exercicio> fila = (equipamento.filaAtendimento);
        Object obj[] = null ;  
        if(fila.isEmpty()){
            return 0;
        }else{
            obj = new Object[fila.size()];
            Date data = Calendar.getInstance().getTime();
            long horaAtual = Calendar.getInstance().getTimeInMillis();
            
            Exercicio atividade1 = null;
            for(int i = 0 ;i<fila.size();i++){
                Exercicio atividade2 = fila.get(i);
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
