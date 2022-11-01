/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.bo;

import com.luciano.vazquez.gestion_expedientes2.entity.Expediente;
import com.luciano.vazquez.gestion_expedientes2.dao.ExpedienteDAO;
import javax.swing.JTable;

/**
 *
 * @author Exo
 */
public class ExpedienteBO {
    
    private String mensaje = "";
    private boolean busqueda;
    private ExpedienteDAO exp = new ExpedienteDAO();
    private Expediente expediente = new Expediente();
    
    public String insert(Expediente expediente) {
        try {
            mensaje = exp.insert(expediente);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return mensaje;
    }
    
    public String update(Expediente expediente) {
        try {
            mensaje = exp.update(expediente);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return mensaje;
    }
    
    public String delete(Expediente expediente) {
        
        try {
            mensaje = exp.delete(expediente);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return mensaje;
    }
    
    public void listarExpedienteporID(JTable listado, int valor) {
        exp.listarExpedientePorID(listado, valor);
    }
    
    public void listarExpedienteporDNI(JTable listado, int valor) {
        exp.listarExpedientePorDNI(listado, valor);
    }

    
    public int proximoIdExpediente() {
        int proximoId = 0;
        try {
            proximoId = exp.proximoIdExpediente();
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return proximoId;
    }
    
    public boolean buscarExpedienteBoolean(int valor) {
        busqueda = exp.buscarExpedienteBoolean(valor);
        return busqueda;
    }
    
    public Expediente buscarExpediente(int valor) {
        expediente = exp.buscarExpediente(valor);
        return expediente;
    }

    public void listarExpedientePorUsuario(JTable listado, int idUsuario) {
        exp.listarExpedientePorUsuario(listado, idUsuario);
    }
}
