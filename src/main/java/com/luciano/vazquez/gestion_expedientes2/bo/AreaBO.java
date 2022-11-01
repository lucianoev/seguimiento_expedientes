/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.bo;

import com.luciano.vazquez.gestion_expedientes2.dao.AreaDAO;
import java.util.ArrayList;

/**
 *
 * @author Exo
 */
public class AreaBO {

    private final AreaDAO repArea = new AreaDAO();
    private ArrayList<String> usuariosList = new ArrayList<>();

    public ArrayList<String> ObtenerUsuariosList(String area) {

        usuariosList = repArea.obtenerUsuariosList(area);

        return usuariosList;
    }

    public String obtenerNombreArea(int area) {
        String nombreArea;
        nombreArea = repArea.obtenerNombreArea(area);
        return nombreArea;
    }

    public int obtenerIdArea(String area) {
        int idArea;
        idArea = repArea.obtenerIdArea(area);
        return idArea;
    }
}
