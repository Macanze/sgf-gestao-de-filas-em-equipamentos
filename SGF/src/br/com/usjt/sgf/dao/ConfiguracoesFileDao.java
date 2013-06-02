/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.dao;

import br.com.usjt.sgf.entity.Configuracao;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Douglas
 */
public class ConfiguracoesFileDao {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Configuracao configuracao;

    public void salvar(Configuracao configuracao) throws IOException {
        
        //faz a criptografia dos dados 
        configuracao.db_dbname = Cript.encrypt(configuracao.db_dbname);
        configuracao.db_hostname = Cript.encrypt(configuracao.db_hostname);
        configuracao.db_instance = Cript.encrypt(configuracao.db_instance);
        configuracao.db_password = Cript.encrypt(configuracao.db_password);
        configuracao.db_portnumb = Cript.encrypt(configuracao.db_portnumb);
        configuracao.db_url = Cript.encrypt(configuracao.db_url);
        configuracao.db_username = Cript.encrypt(configuracao.db_username);
        configuracao.cfg_admin = Cript.encrypt(configuracao.cfg_admin);
        
        
        //salva o objeto em um arquivo
        output = new ObjectOutputStream(new FileOutputStream("bin\\config.sgf")); //abre o objeto
        output.writeObject(configuracao); //grava  no objeto aberto
        output.close(); //fecha o objeto
    }
    
    
    public Configuracao lerConfiguracoes() throws IOException, ClassNotFoundException{
        //faz a leitura do arquivo e o carrega no objeto
        input = new ObjectInputStream(new FileInputStream("bin\\config.sgf")); //abre o objeto
        configuracao = (Configuracao) input.readObject(); //realiza a leitura do objeto
        input.close(); 
        
        //faz a decriptografia dos dados
        configuracao.db_dbname = Cript.decrypt(configuracao.db_dbname);
        configuracao.db_hostname = Cript.decrypt(configuracao.db_hostname);
        configuracao.db_instance = Cript.decrypt(configuracao.db_instance);
        configuracao.db_password = Cript.decrypt(configuracao.db_password);
        configuracao.db_portnumb = Cript.decrypt(configuracao.db_portnumb);
        configuracao.db_url = Cript.decrypt(configuracao.db_url);
        configuracao.db_username = Cript.decrypt(configuracao.db_username);
        configuracao.cfg_admin = Cript.decrypt(configuracao.cfg_admin);
        
        return configuracao;
    }
}
