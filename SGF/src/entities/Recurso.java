/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author cicero
 */
@Entity
@Table (name = "EQUIPAMENTO")
public class Recurso implements Serializable {

    @Id @Column (name = "ID")
    private long id;
    @Column(name = "NOME_EQUIPAMENTO")
    private String nomeEquipamento;
    @Column (name = "MANUTENCAO")
    private boolean manutencao;
    @Transient
    private boolean semaforo;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public boolean isManutencao() {
        return manutencao;
    }

    public void setManutencao(boolean manutencao) {
        this.manutencao = manutencao;
    }

    public boolean isSemaforo() {
        return semaforo;
    }

    public void setSemaforo(boolean semaforo) {
        this.semaforo = semaforo;
    }
}
