/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.dao;

import com.luciano.vazquez.gestion_expedientes2.entity.Expediente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Exo
 */
public class ExpedienteDAO {

    private String mensaje = "";
    private boolean buscar;
    private Expediente expediente;

    private static final String INSERT_QUERY = "INSERT INTO expediente (id_expediente, id_usuario, id_iniciante, estado, fecha, referencia, tipo, fojas)"
            + "VALUES(id_expediente=LAST_INSERT_ID(id_expediente+1),?,?,?,?,?,?,?)";

    public String insert(Expediente expediente) throws ClassNotFoundException {
        try {
            PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, expediente.getIdUsuario());
            preparedStatement.setInt(2, expediente.getIdIniciante());
            preparedStatement.setString(3, expediente.getEstado());
            preparedStatement.setString(4, expediente.getFecha());
            preparedStatement.setString(5, expediente.getReferencia());
            preparedStatement.setString(6, expediente.getTipo());
            preparedStatement.setInt(7, expediente.getFojas());
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

    private static final String UPDATE_QUERY = "UPDATE expediente SET estado = ?, fecha = ?, referencia = ?, tipo = ?, fojas = ? WHERE id_expediente = ?";

    public String update(Expediente expediente) throws ClassNotFoundException {
        try {
            PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, expediente.getEstado());
            preparedStatement.setString(2, expediente.getFecha());
            preparedStatement.setString(3, expediente.getReferencia());
            preparedStatement.setString(4, expediente.getTipo());
            preparedStatement.setInt(5, expediente.getFojas());
            preparedStatement.setInt(6, expediente.getIdExpediente());
            preparedStatement.execute();
            mensaje = "Modificado Correctamente";
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "No se pudo modificar" + ex.getMessage();
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mensaje;
    }

    private static final String DELETE_QUERY = "DELETE FROM expediente WHERE id_expediente = ?";

    public String delete(Expediente expediente) throws ClassNotFoundException {
        try {
            PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, expediente.getIdExpediente());
            preparedStatement.execute();
            mensaje = "Borrado Correctamente";
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "No se pudo borrar" + ex.getMessage();
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mensaje;
    }

    public void listarExpedientePorID(JTable listado, int valor) {
        DefaultTableModel model;
        String[] columnas = {"N° Expediente", "Iniciado por", "Tipo", "Fecha", "Estado", "Fojas"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_expediente, nombre, tipo, fecha, estado, fojas FROM expediente INNER JOIN usuario ON expediente.id_usuario = usuario.id_usuario WHERE id_expediente=?";
        String[] filas = new String[6];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, valor);

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

    public void listarExpedientePorDNI(JTable listado, int valor) {
        DefaultTableModel model;
        String[] columnas = {"N° Expediente", "Nombre", "Apellido", "Tipo", "Fecha", "Estado", "Fojas"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_expediente, nombre, apellido, tipo, fecha, estado, fojas FROM expediente INNER JOIN externo ON expediente.id_iniciante = externo.dni WHERE id_iniciante=?";
        String[] filas = new String[7];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, valor);

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
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

    public int proximoIdExpediente() {

        Statement st = null;
        ResultSet rs = null;
        int proximoId = 0;
        String sql = "SELECT MAX(id_expediente)+1 FROM expediente";

        try {
            st = ConexionDAO.getConnection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                proximoId = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("ERROR AL RECUPERAR PROXIMO ID " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return proximoId;
    }

    public boolean buscarExpedienteBoolean(int valor) {
        String sql = "SELECT * FROM expediente WHERE id_expediente=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, valor);

            ResultSet rs = pst.executeQuery();

            buscar = rs.next();

        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR EXPEDIENTE: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return buscar;
    }

    public Expediente buscarExpediente(int valor) {
        expediente = new Expediente();
        String sql = "SELECT * FROM expediente WHERE id_expediente=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, valor);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                expediente.setIdExpediente(rs.getInt(1));
                expediente.setIdUsuario(rs.getInt(2));
                expediente.setTipo(rs.getString(3));
                expediente.setReferencia(rs.getString(4));
                expediente.setEstado(rs.getString(5));
                expediente.setFecha(rs.getString(6));
                expediente.setFojas(rs.getInt(7));
                expediente.setIdIniciante(rs.getInt(8));
            }

        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR EXPEDIENTE: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return expediente;
    }
    
    //CARGA TABLA DE EXPEDIENTES INICIADOS DEL PANEL DE USUARIO
     public void listarExpedientePorUsuario(JTable listado, int idUsuario) {
        DefaultTableModel model;
        String[] columnas = {"N° Expediente", "Referencia", "Tipo", "Fecha", "Estado", "Fojas"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_expediente, referencia, tipo, fecha, estado, fojas FROM expediente WHERE id_usuario=?";
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
