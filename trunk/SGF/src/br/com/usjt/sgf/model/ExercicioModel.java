/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.model;

import br.com.usjt.sgf.dao.ExercicioDao;
import br.com.usjt.sgf.entity.Exercicio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class ExercicioModel {

    
    
    
    
    private Exercicio atividade;
    private ExercicioDao dao;

    public ExercicioModel(Exercicio atividade) {
        this.atividade = atividade;
        dao = new ExercicioDao();
    }
    
    
    
    public void persist(){
        dao.persist(atividade);
    }
    
    public void update(){
        dao.update(atividade);
    }
    
    public List findAll(){
        return dao.listAll();
    }
    
    public List listByName(){
        
        Object obj[][] = new Object[1][2];
        obj[0][0] = "nome";
        obj[0][1] = "%"+atividade.getNome()+"%";
       
        return dao.list("Atividade.findByNome", obj);
        
        
    }

    
    public void remove() {
        dao.remove(atividade);
    }
    
    
    public static Date calcularHoraFim(Exercicio atv) {
        long time = atv.horaInicio.getTime();
        long add = (atv.tempoNecessario*60 * 1000);
        
        Date horaFim = new Date(time+add);
        return horaFim;
    }
    
}
