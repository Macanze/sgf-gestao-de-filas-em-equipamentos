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
public class Equipamento implements Serializable {
    @Id @Column (name = "ID")
    private long id;
    @Column(name = "NOME_EQUIPAMENTO")
    private String nomeEquipamento;
    @Column (name = "MANUTENCAO")
    private boolean manutencao;
    @Transient
    private boolean ocupado;
    
}
