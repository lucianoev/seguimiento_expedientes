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
public class Area {
            private int idArea;
            private int jerarquía;
            private String nombre;

    public Area(int idArea, int jerarquía, String nombre) {
        this.idArea = idArea;
        this.jerarquía = jerarquía;
        this.nombre = nombre;
    }

    public Area() {
       
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getJerarquía() {
        return jerarquía;
    }

    public void setJerarquía(int jerarquía) {
        this.jerarquía = jerarquía;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
            
}
