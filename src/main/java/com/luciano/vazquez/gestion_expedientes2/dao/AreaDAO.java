/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.dao;


import com.luciano.vazquez.gestion_expedientes2.bo.AreaBO;
import com.luciano.vazquez.gestion_expedientes2.entity.Area;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Exo
 */
public class AreaDAO {
    
  
    
    private final ArrayList<String> usuariosList = new ArrayList<>();
  
    public ArrayList<String> obtenerUsuariosList(String area){
        String sql = "SELECT nombre FROM usuario WHERE id_area=(SELECT id_area FROM area WHERE nombre=?)";
        
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, area);

            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                usuariosList.add(rs.getString("nombre")); 
            }

        } catch (Exception e) {
            System.out.println("ERROR AL RECUPERAR USUARIOS DEL AREA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    return usuariosList;
    }
    
    public String obtenerNombreArea (int area){
        String nombreArea="";
        
        String sql = "SELECT nombre FROM area WHERE id_area=?";
        
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, area);

            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                nombreArea = rs.getString("nombre"); 
            }

        } catch (Exception e) {
            System.out.println("ERROR AL RECUPERAR NOMBRE DEL AREA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    return nombreArea;
    }
    
    public int obtenerIdArea (String area){
        int idArea = 0;
        
        String sql = "SELECT id_area FROM area WHERE nombre=?";
        
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, area);

            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                idArea = rs.getInt("id_area"); 
            }

        } catch (Exception e) {
            System.out.println("ERROR AL RECUPERAR ID DEL AREA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    return idArea;
    }
}




