/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.bo;

import com.luciano.vazquez.gestion_expedientes2.entity.Usuario;
import com.luciano.vazquez.gestion_expedientes2.dao.UsuarioDAO;

/**
 *
 * @author Exo
 */
public class UsuarioBO {

    private String mensaje = "";
    private UsuarioDAO usu = new UsuarioDAO();
    Usuario recupusuario;
    Usuario usuario = new Usuario();

    public boolean loginUsuario(String usuario, String contraseña) {
        boolean login = false;
        try {
            login = usu.loginUsuario(usuario, contraseña);
        } catch (Exception e) {
            mensaje = mensaje + "ERROR AL LOGUEARSE" + e.getMessage();
        }
        return login;
    }

    public Usuario sesionUsuario() {
        recupusuario = usu.sesionUsuario();
        return recupusuario;
    }

    public Usuario buscarUsuario(int valor) {
        usuario = usu.buscarUsuario(valor);
        return usuario;
    }

    public int obtenerIdUsuario(String usuario) {
        int idUsuario;
        idUsuario = usu.obtenerIdUsuario(usuario);
        return idUsuario;
    }

}
