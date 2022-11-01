/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luciano.vazquez.gestion_expedientes2.entity;

/**
 *
 * @author Exo
 */
public class Transicion {

    private int idPase;
    private int idExpediente;
    private int id_area_actual;
    private int id_area_anterior;
    private int id_usuario_actual;
    private int id_usuario_anterior;
    private String fecha;
    private String situacion;
    private String observacion;
    private int fojas;

    public Transicion(int idPase, int id_area_actual, int id_area_anterior, int id_usuario_actual, int id_usuario_anterior, String fecha, String situacion, String observacion, int fojas) {
        this.idPase = idPase;
        this.id_area_actual = id_area_actual;
        this.id_area_anterior = id_area_anterior;
        this.id_usuario_actual = id_usuario_actual;
        this.id_usuario_anterior = id_usuario_anterior;
        this.fecha = fecha;
        this.situacion = situacion;
        this.observacion = observacion;
        this.fojas = fojas;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public Transicion(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public Transicion() {
        
    }

    public int getIdPase() {
        return idPase;
    }

    public void setIdPase(int pase) {
        this.idPase = pase;
    }

    public int getId_area_actual() {
        return id_area_actual;
    }

    public void setId_area_actual(int id_area_actual) {
        this.id_area_actual = id_area_actual;
    }

    public int getId_area_anterior() {
        return id_area_anterior;
    }

    public void setId_area_anterior(int id_area_anterior) {
        this.id_area_anterior = id_area_anterior;
    }

    public int getId_usuario_actual() {
        return id_usuario_actual;
    }

    public void setId_usuario_actual(int id_usuario_actual) {
        this.id_usuario_actual = id_usuario_actual;
    }

    public int getId_usuario_anterior() {
        return id_usuario_anterior;
    }

    public void setId_usuario_anterior(int id_usuario_anterior) {
        this.id_usuario_anterior = id_usuario_anterior;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getFojas() {
        return fojas;
    }

    public void setFojas(int fojas) {
        this.fojas = fojas;
    }

}
