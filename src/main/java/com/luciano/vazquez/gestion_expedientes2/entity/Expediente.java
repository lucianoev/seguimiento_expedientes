/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.entity;

import java.util.List;

/**
 *
 * @author Exo
 */
public class Expediente {
    private int idExpediente;
    private int idUsuario;
    private int idIniciante;
    private String fecha;
    private String referencia;
    private String estado;
    private String tipo;
    private int fojas;

   
    

    public Expediente() {
    }

    public Expediente(int idExpediente, int idUsuario, int idIniciante, String fecha, String referencia, String estado, String tipo, List<Transicion> historial, int fojas) {
        this.idExpediente = idExpediente;
        this.idUsuario = idUsuario;
        this.idIniciante = idIniciante;
        this.fecha = fecha;
        this.referencia = referencia;
        this.estado = estado;
        this.tipo = tipo;
        this.fojas = fojas;
    }

    public int getIdExpediente() {
        return idExpediente;
    }
    
     public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

 
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdIniciante() {
        return idIniciante;
    }

    public void setIdIniciante(int idIniciante) {
        this.idIniciante = idIniciante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFojas() {
        return fojas;
    }

    public void setFojas(int fojas) {
        this.fojas = fojas;
    }
    
    
   
}
