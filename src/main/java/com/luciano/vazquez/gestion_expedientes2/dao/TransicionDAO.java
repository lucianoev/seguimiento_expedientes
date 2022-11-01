/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.dao;

import com.luciano.vazquez.gestion_expedientes2.entity.Transicion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Exo
 */
public class TransicionDAO {

    private String mensaje = "";
    private final ArrayList<Transicion> listadoPases = new ArrayList();

    
    //INSERT NUEVO PASE
    private static final String INSERT_QUERY = "INSERT INTO pase (id_usuario_actual, id_area_actual, id_usuario_anterior, id_area_anterior, fecha, situacion, observacion, fojas, id_expediente)"
            + "VALUES (?,?,?,?,?,?,?,?,?)";

    public String insert(Transicion pase) throws ClassNotFoundException {
        try {
            PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(INSERT_QUERY);
            //preparedStatement.setInt(1, pase.getIdPase());
            preparedStatement.setInt(1, pase.getId_usuario_actual());
            preparedStatement.setInt(2, pase.getId_area_actual());
            preparedStatement.setInt(3, pase.getId_usuario_anterior());
            preparedStatement.setInt(4, pase.getId_area_anterior());
            preparedStatement.setString(5, pase.getFecha());
            preparedStatement.setString(6, pase.getSituacion());
            preparedStatement.setString(7, pase.getObservacion());
            preparedStatement.setInt(8, pase.getFojas());
            preparedStatement.setInt(9, pase.getIdExpediente());

            preparedStatement.execute();
            mensaje = "PASE GUARDADO Correctamente";
        } catch (Exception e) {
            mensaje = "No se pudo GUARDAR PASE" + e.getMessage();
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mensaje;
    }

    //DEVUELVE ARRAY DE PASES DE UN EXPEDIENTE
    public ArrayList<Transicion> buscarPases(int idExpediente) {

        String sql = "SELECT * FROM pase WHERE id_expediente=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, idExpediente);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Transicion pase = new Transicion();

                pase.setIdPase(rs.getInt("id_pase"));
                pase.setId_area_actual(rs.getInt("id_area_actual"));
                pase.setId_area_anterior(rs.getInt("id_area_anterior"));
                pase.setId_usuario_actual(rs.getInt("id_usuario_actual"));
                pase.setId_usuario_anterior(rs.getInt("id_usuario_anterior"));
                pase.setFojas(rs.getInt("fojas"));
                pase.setObservacion(rs.getString("observacion"));
                pase.setSituacion(rs.getString("situacion"));
                pase.setFecha(rs.getString("fecha"));

                listadoPases.add(pase);
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
        return listadoPases;
    }

    // DEVUELVE ULTIMO PASE DE UN EXPEDIENTE, SI NO TIENE PASES DEVUELVE NULL
    public Transicion obtenerUltimoPase(int idExpediente) {
        Transicion ultimoPase = new Transicion();
        String sql = "SELECT * FROM pase WHERE id_pase=(SELECT MAX(id_pase) FROM pase WHERE id_expediente=?)";

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, idExpediente);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                ultimoPase.setIdPase(rs.getInt("id_pase"));
                ultimoPase.setId_area_actual(rs.getInt("id_area_actual"));
                ultimoPase.setId_area_anterior(rs.getInt("id_area_anterior"));
                ultimoPase.setId_usuario_actual(rs.getInt("id_usuario_actual"));
                ultimoPase.setId_usuario_anterior(rs.getInt("id_usuario_anterior"));
                ultimoPase.setFojas(rs.getInt("fojas"));
                ultimoPase.setObservacion(rs.getString("observacion"));
                ultimoPase.setSituacion(rs.getString("situacion"));
                ultimoPase.setFecha(rs.getString("fecha"));

            } else {

                ultimoPase = null;
            }

        } catch (Exception e) {
            System.out.println("ERROR AL RECUPERAR ULTIMO PASE: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ultimoPase;
    }
    
    
    //CARGA TABLA DE PASES AL CONSULTAR EXPEDIENTE
    public void listarPases(JTable listado, int expediente) {
        DefaultTableModel model;
        String[] columnas = {"Origen", "Destino", "Enviado por", "Recibido por", "Fecha", "Situación","Fojas","Observación"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT area1.nombre, area2.nombre, usuario1.nombre, usuario2.nombre, fecha, situacion, fojas, observacion FROM pase INNER JOIN area AS area1 ON pase.id_area_anterior = area1.id_area INNER JOIN area AS area2 ON pase.id_area_actual = area2.id_area INNER JOIN usuario AS usuario1 ON pase.id_usuario_anterior=usuario1.id_usuario INNER JOIN usuario AS usuario2 ON pase.id_usuario_actual=usuario2.id_usuario WHERE id_expediente=? ORDER BY pase.id_pase";
        String[] filas = new String[8];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, expediente);

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            listado.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //CARGA TABLA DE EXPEDIENTES ACTUALES DEL PANEL DE USUARIO
    public void listarExpedientesQuePoseeUsuario(JTable listado, int idUsuario) {
        DefaultTableModel model;
        String[] columnas = {"N° Expediente", "Referencia", "Tipo", "Recibido en Fecha", "Estado", "Fojas"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT pase.id_expediente, referencia, tipo, pase.fecha, estado, pase.fojas FROM pase INNER JOIN expediente ON expediente.id_expediente=pase.id_expediente WHERE pase.id_usuario_actual=? AND id_pase=(SELECT MAX(id_pase) FROM pase WHERE expediente.id_expediente=pase.id_expediente) ORDER BY pase.fecha";
        String[] filas = new String[6];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, idUsuario);

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            listado.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
