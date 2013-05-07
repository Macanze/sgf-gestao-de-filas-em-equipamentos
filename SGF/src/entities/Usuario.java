/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import enumerators.TipoUsuario;
import enumerators.TipoDocumento;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author cicero
 */
@Entity
public class Usuario implements Serializable{
    static final long serialVersionUID = 987698765456789L;   
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column (name = "ID")
    private Long id;
    @Column (name = "NOME")
    private String nome;
    @Column (name = "DOCUMENTO")
    private String codigoDocumento;
    @Column (name = "EMAIL")
    private String email;
    @Column (name = "TELEFONE_COMERCIAL")
    private String telefoneComercial;
    @Column (name = "TELEFONE_RESIDENCIAL")
    private String telefoneResidencial;
    @Column (name = "TELEFONE_CELULAR")
    private String telefoneCelular;
    @Column (name = "TIPO_DOCUMENTO")
    private TipoDocumento tipoDocumento;
    @Column (name = "TIPO_USUARIO")
    private TipoUsuario tipoUsuario;
    @Column (name = "PESO_USUARIO")
    private float peso;
    @Column (name = "ALTURA_USUARIO")
    private float altura;
    @Column (name="ENDERECO")
    private String endereco;

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
        
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getTelefonerResidencial() {
        return telefoneResidencial;
    }

    public void setTelefonerResidencial(String telefonerResidencial) {
        this.telefoneResidencial = telefonerResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodDocumento() {
        return codigoDocumento;
    }

    public void setCodDocumento(String codDocumento) {
        this.codigoDocumento = codDocumento;
    }

    public Long getId() {
        return id;
    }
}