/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces.model;

import java.sql.Date;

/**
 *
 * @author luis.leon
 */
public class Usuario {

    private int id;
    private int id_t_Persona;
    private String usuario;
    private String Contrasena;
    private int id_t_lv_estadousuario;
    private String creadoPor;
    private Date creadoEn;
    private String modificadoPor;
    private Date modificadoEn;
    private int rol;

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }  
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_t_Persona() {
        return id_t_Persona;
    }

    public void setId_t_Persona(int id_t_Persona) {
        this.id_t_Persona = id_t_Persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getId_t_lv_estadousuario() {
        return id_t_lv_estadousuario;
    }

    public void setId_t_lv_estadousuario(int id_t_lv_estadousuario) {
        this.id_t_lv_estadousuario = id_t_lv_estadousuario;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getModificadoEn() {
        return modificadoEn;
    }

    public void setModificadoEn(Date modificadoEn) {
        this.modificadoEn = modificadoEn;
    }

   
    

}
