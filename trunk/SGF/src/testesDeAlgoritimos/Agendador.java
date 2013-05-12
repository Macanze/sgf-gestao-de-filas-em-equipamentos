/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testesDeAlgoritimos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author dgsantos
 */
public class Agendador {

    public ArrayList<Recurso> listaRecursos;
    private ArrayList<Atividade> listaAtividade;
    Date horaInicio = null;

    public Agendador(ArrayList<Recurso> listaRecursos) {
        this.listaRecursos = listaRecursos;
    }

    public void agendarUsuario(Usuario u) {


        this.listaAtividade = u.listaAtividade;

        processar();


    }

    private void processar() {
        

        for (int i = 0; i < listaAtividade.size(); i++) {
            Atividade atividade = listaAtividade.get(i);


            if (horaInicio != null) {
                atividade.setHoraInicio(horaInicio);
            } else {
                atividade.setHoraInicio(Calendar.getInstance().getTime());
            }


            Recurso recurso = buscarRecurso(atividade.idAtividade);
            if (recurso != null) {
                recurso.alocar(atividade);

                horaInicio = atividade.getHoraFim();
                atualizarListaRecurso(recurso);
                atividade.setAgendada(true);
                listaAtividade.set(i, atividade);
            }
        }
        processarNaoAlocados();
    }

    /**
     * Processa a lista de atividades do usu�rio
     */
    private void processarNaoAlocados() {     

        for (int i = 0; i < listaAtividade.size(); i++) {
            Atividade atividade = listaAtividade.get(i);

            if (!atividade.isAgendada()) {
                if (horaInicio != null) {
                    atividade.setHoraInicio(horaInicio);
                } else {
                    atividade.setHoraInicio(Calendar.getInstance().getTime());
                }


                Recurso recurso = buscarRecursoDisponivel(atividade.idAtividade);
                if (recurso != null) {
                    recurso.alocar(atividade);

                    horaInicio = atividade.getHoraFim();
                    atualizarListaRecurso(recurso);
                    atividade.setAgendada(true);
                }
            }




        }

horaInicio = null;

    }

    private Recurso buscarRecursoDisponivel(int idAtividade) {


        Recurso rec = null;
        for (int i = 0; i < listaRecursos.size(); i++) {
            Recurso temp = listaRecursos.get(i);
            if (temp.id == idAtividade && temp.semaforo == 0) {
                rec = temp;
                return rec;
            } else if (rec == null) {
                rec = temp;
            } else if (rec.id == idAtividade && rec.semaforo != 0) {


                if (temp.getTempo() < rec.getTempo()) {
                    rec = temp;
                }

            }

        }



        return rec;
    }

    private Recurso buscarRecurso(int idAtividade) {


        Recurso rec = null;
        for (int i = 0; i < listaRecursos.size(); i++) {
            Recurso temp = listaRecursos.get(i);
            if (temp.id == idAtividade && temp.semaforo == 0) {
                rec = temp;
                return rec;
            }
        }

        return rec;
    }

    private void atualizarListaRecurso(Recurso recurso) {


        int i = 0;
        boolean alterou = false;
        while (!alterou) {
            Recurso temp = listaRecursos.get(i);
            if (temp.id == recurso.id && temp.seq == recurso.seq) {
                listaRecursos.set(i, recurso);
                alterou = true;
            }

            i++;
        }


    }
}
