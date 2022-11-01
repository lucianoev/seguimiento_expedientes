/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.bo;

import com.luciano.vazquez.gestion_expedientes2.entity.Externo;
import com.luciano.vazquez.gestion_expedientes2.dao.ExternoDAO;

/**
 *
 * @author Exo
 */
public class ExternoBO {

    private String mensaje = "";
    private ExternoDAO ext = new ExternoDAO();
    Externo iniciante = new Externo();
    private boolean ini;

    public String insert(Externo externo) {

        try {
            mensaje = ext.insert(externo);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return mensaje;
    }

    public Externo buscarIniciante(int dni) {
        try {
            iniciante = ext.buscarIniciante(dni);
        } catch (Exception e) {
            mensaje = mensaje + "ERROR AL RECUPERAR INICIANTE EXTERNO" + e.getMessage();
        }
        return iniciante;
    }

    public boolean buscarInicianteBoolean(int dni) {
        ini = ext.buscarInicianteBoolean(dni);
        return ini;
    }

}
