/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.test;

import com.luciano.vazquez.gestion_expedientes2.bo.ExternoBO;
import com.luciano.vazquez.gestion_expedientes2.bo.TransicionBO;
import com.luciano.vazquez.gestion_expedientes2.entity.Externo;
import com.luciano.vazquez.gestion_expedientes2.entity.Transicion;
import java.sql.SQLException;

/**
 *
 * @author Exo
 */
public class PaseTest {

    TransicionBO pbo = new TransicionBO();
    Transicion pase = new Transicion();
    String mensaje = "";

    public void insertar() throws ClassNotFoundException, SQLException {
        pase.setId_usuario_actual(29);
        pase.setId_area_actual(7);
        pase.setId_usuario_anterior(45);
        pase.setId_area_anterior(9);
        pase.setSituacion("Para protocolizar");
        pase.setFecha("2020/05/06");
        pase.setObservacion("Falta adjuntar dni");
        pase.setFojas(6);
        pase.setIdExpediente(24);
        

        mensaje = pbo.insert(pase);
        System.out.println(mensaje);

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PaseTest test = new PaseTest();
        test.insertar();

    }

}
