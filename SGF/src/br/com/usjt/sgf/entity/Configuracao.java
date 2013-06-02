/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usjt.sgf.entity;

import java.io.Serializable;

/**
 *
 * @author Douglas
 */
public class Configuracao implements Serializable{
    
    
    public final String DRIVE_ORACLE = "jdbc:sqlserver://localhost:1433;databaseName=SGFPU";
    
    
    
    
    
    //Configurações de banco de dados;
    public String db_hostname;
    public String db_instance;
    public String db_password;
    public String db_portnumb;
    public String db_username;
    public String db_dbname;
    
    public int    db_server;
    
    public String db_url;
    public String drive;
    public String cfg_admin;
    
    
    public void retornarDrive(){
        
        
    switch(db_server){
        
        case 0:
            db_url = "jdbc:sqlserver://"+db_hostname+":"+db_portnumb+";databaseName="+db_dbname;
            drive ="com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
            break;
        case 1: 
            db_url = "";
            break;
        }
        
    }
    
    
    
    
    
    
    
}
