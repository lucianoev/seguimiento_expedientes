/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.luciano.vazquez.gestion_expedientes2.entity.Usuario;

/**
 *
 * @author Exo
 */
public class UsuarioDAO {

    Usuario sesionUsuario = new Usuario();
    Usuario usuario = new Usuario();

    public boolean loginUsuario(String usuario, String contraseña) {
        boolean login = false;
        String sql = "SELECT id_usuario, nombre, email, celular, id_area FROM usuario WHERE username=? and password=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                login = true;
                sesionUsuario.setIdUsuario(rs.getInt(1));
                sesionUsuario.setNombre(rs.getString(2));
                sesionUsuario.setMail(rs.getString(3));
                sesionUsuario.setCelular(rs.getString(4));
                sesionUsuario.setIdArea(rs.getInt(5));
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return login;
    }

    public Usuario sesionUsuario() {
        return sesionUsuario;
    }

    
    public Usuario buscarUsuario(int valor) {

        String sql = "SELECT id_usuario, nombre, email, celular, id_area FROM usuario WHERE id_usuario=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, valor);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setMail(rs.getString(3));
                usuario.setCelular(rs.getString(4));
                usuario.setIdArea(rs.getInt(5));
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }
    
    
    
    public int obtenerIdUsuario (String usuario){
        int idUsuario = 0;
        
        String sql = "SELECT id_usuario FROM usuario WHERE nombre=?";
        
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, usuario);

            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                idUsuario = rs.getInt("id_usuario"); 
            }

        } catch (Exception e) {
            System.out.println("ERROR AL RECUPERAR ID DEL USUARIO" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    return idUsuario;
    }
}
