package testesDeAlgoritimos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import testesDeAlgoritimos.Atividade;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author dgsantos
 */
public class Recurso {

    private SimpleDateFormat sf = new SimpleDateFormat("hh:mm");
    public int id;
    public int seq;
    public String nome;
    public int semaforo;
    public boolean status;
    public ArrayList <Atividade> listaAtividade;

    public Recurso(int id, int seq, String nome, int semaforo) {
        this.id = id;
        this.seq = seq;
        this.nome = nome;
        this.semaforo = semaforo;
        this.listaAtividade = new ArrayList <>();

    }

    public void alocar(Atividade atv) {
           alocarRecurso(atv);
            ordernarFila();
          
    }

    /**
     * Ordena a fila de um recurso
     *
     * @param rec
     * @return
     */
    private void ordernarFila() {

        if (listaAtividade != null) {
            Collections.sort(listaAtividade, new CompareTo());
            System.out.println("Recurso ordenado");
            //  buscarIntervalos();
        }
        
        if(listaAtividade.isEmpty()){
            semaforo = 0;
        }

    }

       
    private void alocarRecurso(Atividade atv) {
       
        atv.calcularHoraFim();
        atv.setAgendada(true);

        boolean add = listaAtividade.add(atv);
        if (add) {
            this.semaforo=1;
            System.out.println(this.nome+"\nUsuario:"+atv.nomeUsuario +"\n"+atv.getHoraInicio()+"\n"+atv.getHoraFim());
        }
    }

  public double getTempo(){
      
      
      double time = 0;
      
      if(listaAtividade.size()==1){
            Atividade atividade = listaAtividade.get(0);
            atividade.getTempoRestante();
          
      }
      
      
      
      
      return  time;
  }

    public class CompareTo implements Comparator<Atividade> {

        @Override
        public int compare(Atividade o1, Atividade o2) {
            int retorno = 0;
            if (o1 == null || o2 == null) {
                return retorno;
            }

            Atividade atv1 = (Atividade) o1;
            Atividade atv2 = (Atividade) o2;

            if (atv1.horaFim.after(atv2.horaFim)) {
                retorno = 1;
            } else if (atv1.horaFim == atv2.horaFim) {
                retorno = 0;
            } else {
                retorno = -1;
            }
            return retorno;
        }
    }
}
