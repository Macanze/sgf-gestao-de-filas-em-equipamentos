/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cicero
 */
@Entity
@Table (name = "EXERCICIO")
public class Exercicio {
    @Id @Column (name = "ID") 
    private long id;
    @Column (name = "NOME_EXERCICIO")
    private String nomeExercicio;
    @Column (name = "TIPO_EXERCICIO")
    private int tipoExercicio;
    
    private Collection<Equipamento> equipamentos;

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public int getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(int tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }

    public Collection<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Collection<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

}
