/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.test;

import com.luciano.vazquez.gestion_expedientes2.bo.UsuarioBO;
import com.luciano.vazquez.gestion_expedientes2.dao.UsuarioDAO;

/**
 *
 * @author Exo
 */
public class LoginTest {
    UsuarioBO usubo = new UsuarioBO();
    UsuarioDAO repusu = new UsuarioDAO();
    
    public boolean login(){
        boolean login = false;
        String nombre;
        login = usubo.loginUsuario("flaco", "1234");
        if (login){
            System.out.println("INICIO EXITOSO");  
            nombre = usubo.sesionUsuario().getNombre();
            System.out.println(" " + nombre);
        }else{
            System.out.println("ERROR AL INICIAR");
        }
        
        
        return login;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        LoginTest test = new LoginTest();
        //test.insertar();
        //test.update();
        test.login();
    }
}
