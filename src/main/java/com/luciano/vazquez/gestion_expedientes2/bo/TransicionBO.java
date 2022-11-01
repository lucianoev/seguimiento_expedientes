/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.bo;

import com.luciano.vazquez.gestion_expedientes2.entity.Transicion;
import com.luciano.vazquez.gestion_expedientes2.dao.TransicionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Exo
 */
public class TransicionBO {

    private String mensaje = "";
    private TransicionDAO paseDao = new TransicionDAO();
    private ArrayList<Transicion> listadoPases = new ArrayList();

    public String insert(Transicion pase) {

        try {
            mensaje = paseDao.insert(pase);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return mensaje;
    }

    public ArrayList<Transicion> buscarPases(int idExpediente) {

        listadoPases = paseDao.buscarPases(idExpediente);
        return listadoPases;
    }

    public Transicion obtenerUltimoPase(int idExpediente) {
        Transicion ultimoPase;
        ultimoPase = paseDao.obtenerUltimoPase(idExpediente);
        return ultimoPase;
    }
    
     public void listarPases(JTable listado, int expediente) {
         paseDao.listarPases(listado, expediente);
     }
     public void listarExpedientesQuePoseeUsuario(JTable listado, int idUsuario) {
      paseDao.listarExpedientesQuePoseeUsuario(listado, idUsuario);
     }

}
