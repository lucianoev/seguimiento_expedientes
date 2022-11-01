/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.dao;

import com.luciano.vazquez.gestion_expedientes2.entity.Externo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Exo
 */
public class ExternoDAO {

    private Externo iniciante = new Externo();
    private String mensaje = "";
    private boolean ini;

    private static final String INSERT_QUERY = "INSERT INTO externo (dni, nombre, apellido, domicilio, telefono, email)" + "VALUES (?,?,?,?,?,?)";

    public String insert(Externo externo) throws ClassNotFoundException {
        try {
            PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, externo.getDni());
            preparedStatement.setString(2, externo.getNombre());
            preparedStatement.setString(3, externo.getApellido());
            preparedStatement.setString(4, externo.getDomicilio());
            preparedStatement.setString(5, externo.getTelefono());
            preparedStatement.setString(6, externo.getEmail());

            preparedStatement.execute();
            mensaje = "Creado Correctamente";
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "No se pudo crear" + ex.getMessage();
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return mensaje;
    }

    
    public Externo buscarIniciante(int dni) {
        
        String sql = "SELECT nombre, apellido, domicilio, telefono, email, dni FROM externo WHERE dni=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, dni);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                iniciante.setNombre(rs.getString(1));
                iniciante.setApellido(rs.getString(2));
                iniciante.setDomicilio(rs.getString(3));
                iniciante.setTelefono(rs.getString(4));
                iniciante.setEmail(rs.getString(5));
                iniciante.setDni(rs.getInt(6));
                System.out.println("Iniciante recuperado de la base");
            } else {
                iniciante=null;
                System.out.println("No se posee iniciante externo, es expte interno");
            }

        } catch (Exception e) {
            mensaje = "No se pudo recuperar datos de Iniciante Externo" + e.getMessage();
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return iniciante;
    }

    //EN UI "NUEVO EXPEDIENTE" RETORNA TRUE SI EL INICIANTE YA INICIO UN EXPEDIENTE ANTERIORMENTE
    public boolean buscarInicianteBoolean(int dni) {
        
        String sql = "SELECT nombre, apellido, domicilio, telefono, email, dni FROM externo WHERE dni=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, dni);
            ResultSet rs = pst.executeQuery();

            ini = rs.next();
            
        } catch (Exception e) {
            mensaje = "No se pudo recuperar datos de Iniciante Externo" + e.getMessage();
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return ini;
    }
}
