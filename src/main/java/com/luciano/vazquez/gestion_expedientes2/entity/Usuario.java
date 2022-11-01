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
public class Usuario {
    private int idUsuario;
    private int idArea;
    private String nombre;
    private String mail;
    private String celular;

    public Usuario(int idUsuario, int idArea, String nombre, String mail, String celular) {
        this.idUsuario = idUsuario;
        this.idArea = idArea;
        this.nombre = nombre;
        this.mail = mail;
        this.celular = celular;
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}
