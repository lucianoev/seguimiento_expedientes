/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.test;

import com.luciano.vazquez.gestion_expedientes2.bo.ExpedienteBO;
import com.luciano.vazquez.gestion_expedientes2.bo.ExternoBO;
import com.luciano.vazquez.gestion_expedientes2.entity.Expediente;
import com.luciano.vazquez.gestion_expedientes2.entity.Externo;
import java.sql.SQLException;

/**
 *
 * @author Exo
 */
public class ExternoTest {
     ExternoBO ebo = new ExternoBO();
    Externo ext = new Externo();
    String mensaje = "";
    
   /* public void insertar () throws ClassNotFoundException, SQLException{
        ext.setDni(24846123);
        ext.setNombre("LUCIANO");
        ext.setApellido("VAZQUEZ");
        ext.setDomicilio("RUTA 41");
        ext.setTelefono("3834279577");
        ext.setEmail("lucvaz@gmail.com");
       
        mensaje = ebo.insert(ext);
        System.out.println(mensaje);
 
    }*/
 
    
  
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ExternoTest test = new ExternoTest();
        //test.insertar();
        
    }
    
}
