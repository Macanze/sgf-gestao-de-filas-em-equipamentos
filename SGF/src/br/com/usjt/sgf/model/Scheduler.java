/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.entity.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * @author Douglas
 */
public class Scheduler {
    private  ArrayList<Equipamento> recursos;
    private ArrayList<Atividade> filaAtividade;
    private Usuario usuario;
    private Date horaInicio;

    public Scheduler() {
        this.recursos = new ArrayList<>(new RecursoModel().listAll());
        filaAtividade = new ArrayList<>();
    }
    
    
    
   public ArrayList<Equipamento> processar(Treino treino){
       

       this.usuario = treino.getUsuario();
       
       ArrayList<Atividade> listaAtividades = new ArrayList<>();
       
       ArrayList<TreinoAtividade> listaAtividadesTreino = new ArrayList<>(treino.getTreinoAtividadeCollection());
        ArrayList<Grupo> listaGrupo = new ArrayList<>(treino.getGrupoCollection());
       for(TreinoAtividade temp: listaAtividadesTreino){
            Atividade atividade = temp.getAtividadeId();
            atividade.tempoNecessario = temp.getTempo();
           listaAtividades.add(atividade);
       }
       for(Grupo grp : listaGrupo){
            ArrayList<GrupoAtividade> listaAtvTemp = new ArrayList<>(grp.getGrupoatvCollection());
            for(GrupoAtividade grpAtv: listaAtvTemp){
                Atividade atividade = grpAtv.getAtividade();
                atividade.tempoNecessario = grpAtv.getTempo();
                listaAtividades.add(atividade);
            }
                    
       }
       
       System.out.println("processando: "+listaAtividades.size());
  
       
       processarList(listaAtividades);
       
       return recursos;
       
   }

    
    private void processarList(ArrayList<Atividade> listaAtividades) {
    
       // Collections.sort(listaAtividades, new CompareTo());
        
        this.horaInicio = null;
        for(Atividade atv: listaAtividades){
            
            
            if(horaInicio==null){
                horaInicio = Calendar.getInstance().getTime();
            }
                       
            
            System.out.println("Atividade:"+atv.getId()+"-"+ atv.getNome()+" tempo: "+atv.tempoNecessario);
            

            Equipamento recursoSelecionado = processarAtividade(atv);
            
            if(recursoSelecionado!=null){
                atv.horaInicio = horaInicio;            
                atv.horaFim = AtividadeModel.calcularHoraFim(atv);
                recursoSelecionado.filaAtendimento.add(atv);
        
                System.out.println("Atividade agendada em:"+ recursoSelecionado.getNome());
                System.out.println("Das:"+atv.horaInicio);
                System.out.println("As :"+atv.horaFim);
            
            horaInicio = atv.horaFim;
            }
            
            
            
            
        }
        
        
        
        
        
        
        
        
    }

    private Equipamento processarAtividade(Atividade atv) {
        
        Equipamento selecionado = null;
        for(int i =0; i <recursos.size();i++){
            
            Equipamento rec = recursos.get(i);
            //ArrayList<Atividade> lista = new ArrayList<>(rec.getAtividadeCollection());
            boolean contains = RecursoModel.contains(rec, atv);
            
            if(contains){
                
                
                if(rec.filaAtendimento==null){
                    rec.filaAtendimento =new ArrayList<>();
                   
                   
                    
                    return rec;
                    
                }else if(rec.filaAtendimento.isEmpty()){
                    
                    return rec;
                }else{
                    if(selecionado==null){
                        selecionado = rec;
                    }else{
                        int tempo = RecursoModel.tempoRestante(rec);
                        int tempoSelecionado = RecursoModel.tempoRestante(selecionado);
                        
                        
                        
                        
                        
                        
                        if(tempo<tempoSelecionado){
                            selecionado = rec;
                        }
                    }
                               
                }
              
            }
        
        }
        
        if(selecionado!=null){
            return selecionado;
        }
        return null;
 
    }
    
    
    
      public class CompareTo implements Comparator<Atividade> {  
       
     
      

        @Override
        public int compare(Atividade o1, Atividade o2) {
             int retorno = 0;    
            if(o1 == null || o2 == null)    
                return retorno;    
                
            Atividade atv1 = (Atividade) o1;    
            Atividade atv2 = (Atividade) o2;    
            
            if(atv1.tempoNecessario<(atv2.tempoNecessario)) {    
                retorno = 1;    
            } else if(atv1.tempoNecessario== atv2.tempoNecessario){    
                retorno = 0;    
            } else {    
                retorno = -1;    
            }    
             return retorno;    
        }
    }  
    
    
    
    
    
    
}
