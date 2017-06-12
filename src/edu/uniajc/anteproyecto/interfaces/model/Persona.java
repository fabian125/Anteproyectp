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
public class Persona {
    private int id;
    private int id_T_LV_TIPOIDENTIFICACION;
    private int numeroidentificacion;
    private String nombres;
    private String primerapellido;
    private String segundoapellido;
    private String telefonofijo;
    private String telefonocelular;
    private String email;
    private int id_T_LV_TIPOUSUARIO;
    private String creadopor;
    private Date creadoen;
    private String modificadopor;
    private Date modificadoEn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_T_LV_TIPOIDENTIFICACION() {
        return id_T_LV_TIPOIDENTIFICACION;
    }

    public void setId_T_LV_TIPOIDENTIFICACION(int id_T_LV_TIPOIDENTIFICACION) {
        this.id_T_LV_TIPOIDENTIFICACION = id_T_LV_TIPOIDENTIFICACION;
    }

    public int getNumeroidentificacion() {
        return numeroidentificacion;
    }

    public void setNumeroidentificacion(int numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getTelefonofijo() {
        return telefonofijo;
    }

    public void setTelefonofijo(String telefonofijo) {
        this.telefonofijo = telefonofijo;
    }

    public String getTelefonocelular() {
        return telefonocelular;
    }

    public void setTelefonocelular(String telefonocelular) {
        this.telefonocelular = telefonocelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_T_LV_TIPOUSUARIO() {
        return id_T_LV_TIPOUSUARIO;
    }

    public void setId_T_LV_TIPOUSUARIO(int id_T_LV_TIPOUSUARIO) {
        this.id_T_LV_TIPOUSUARIO = id_T_LV_TIPOUSUARIO;
    }

    public String getCreadopor() {
        return creadopor;
    }

    public void setCreadopor(String creadopor) {
        this.creadopor = creadopor;
    }

    public Date getCreadoen() {
        return creadoen;
    }

    public void setCreadoen(Date creadoen) {
        this.creadoen = creadoen;
    }

    public String getModificadopor() {
        return modificadopor;
    }

    public void setModificadopor(String modificadopor) {
        this.modificadopor = modificadopor;
    }

    public Date getModificadoEn() {
        return modificadoEn;
    }

    public void setModificadoEn(Date modificadoEn) {
        this.modificadoEn = modificadoEn;
    }
    
    
    
}
