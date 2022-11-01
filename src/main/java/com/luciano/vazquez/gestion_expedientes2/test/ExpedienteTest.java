/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.test;

import com.luciano.vazquez.gestion_expedientes2.bo.ExpedienteBO;
import com.luciano.vazquez.gestion_expedientes2.entity.Expediente;
import java.sql.SQLException;

/**
 *
 * @author Exo
 */
public class ExpedienteTest {

    ExpedienteBO ebo = new ExpedienteBO();
    Expediente exp = new Expediente();
    String mensaje = "";
    int proximoId = 0;

    public void insertar() throws ClassNotFoundException, SQLException {
        exp.setEstado("EN TRAMITE");
        exp.setFecha("2020/08/02");
        exp.setFojas(2);
        exp.setTipo("RECLAMO");
        exp.setReferencia("SOLICITA RECAMBIO LUMINARIA");
        exp.setIdUsuario(4);
        mensaje = ebo.insert(exp);
        System.out.println(mensaje);

    }

    public void update() throws ClassNotFoundException, SQLException {
        exp.setIdExpediente(3);
        exp.setEstado("SUBSANACION");
        exp.setFecha("2020/05/11");
        exp.setFojas(3);
        exp.setTipo("RECLAMO");
        exp.setReferencia("SOLICITA BAJADA DE LUZ");
        exp.setIdUsuario(4);
        mensaje = ebo.update(exp);
        System.out.println(mensaje);

    }

    public int proximoId() throws ClassNotFoundException, SQLException {
        proximoId = ebo.proximoIdExpediente();
        System.out.println("ID: " + proximoId);
        return 0;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ExpedienteTest test = new ExpedienteTest();
        //test.insertar();
        //test.update();
        test.proximoId();
    }

}
