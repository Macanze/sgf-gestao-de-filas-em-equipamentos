/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import entities.Usuario;
import enumerators.TipoDocumento;
import enumerators.TipoUsuario;

/**
 *
 * @author kalango
 */
public class ExecutaTesteUnitario {
    public static void main (String[] args){
         Usuario usuario = new Usuario();
         usuario.setAltura(1.70f);
         usuario.setCodDocumento("poiuytre");
         usuario.setEmail("cicero@bol");
         usuario.setEndereco("kjuhgfdfghjk");
         usuario.setNome("kalango");
         usuario.setPeso(180f);
         usuario.setTelefoneCelular("123456-87654");
         usuario.setTipoDocumento(TipoDocumento.CPF);
         usuario.setTipoUsuario(TipoUsuario.ALUNO);
         System.out.println("usuário criado");
         System.out.println(""+usuario.getNome());
         UsuarioDAO usuarioDao = new UsuarioDAO();
         usuarioDao.cadastraUsuario(usuario);
         System.out.println("usuário criado");
         System.out.println(""+usuario.getNome());
    } 
}
