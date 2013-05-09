/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testesDeAlgoritimos;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dgsantos
 */
public class Atividade {

    public int idUsuario;
    public String nomeUsuario;
    public int idAtividade;
    public String nomeAtividade;
    public int tempoNecessario;
    public Date horaInicio;
    public Date horaFim;
    public boolean agendada;

    public Atividade(int idAtividade, String nomeAtividade, int tempoNecessario ) {
        
        this.idAtividade = idAtividade;
        this.nomeAtividade = nomeAtividade;
        this.tempoNecessario = tempoNecessario;

    }


   

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    

    public int getTempoNecessario() {
        return tempoNecessario;
    }

    public void setTempoNecessario(int tempoNecessario) {
        this.tempoNecessario = tempoNecessario;
    }

    public boolean isAgendada() {
        return agendada;
    }

    public void setAgendada(boolean agendada) {
        this.agendada = agendada;
    }

    
    
    
    
    public void calcularHoraFim() {

        long minutes = (this.tempoNecessario * 60) * 1000;

        horaFim = new Date(horaInicio.getTime() + minutes);

    }

    void getTempoRestante() {
        long horaAtual = Calendar.getInstance().getTimeInMillis();
        long horafinal = getHoraFim().getTime();
        
       long restante= horafinal - horaAtual;
        double time = (restante/1000/60);
        JOptionPane.showMessageDialog(null, time);
        
    }
    
    
    
    
}
