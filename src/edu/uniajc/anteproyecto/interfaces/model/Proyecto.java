/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces.model;

import java.sql.Date;

/**
 *@author Emmanuel Barrera - IRIS
 *12/05/2017
 * Nombre Clase:Proyecto.java
 * Descripcion: Tabla que contiene los SET y GET de la tabla Proyecto
 */

public class Proyecto {
   private int ID;
   private int id_T_Metodologia;
   private int id_T_Idea;
   private String tituloProyecto;
   private String resumenProyecto;
   private int id_T_LV_estadoProyecto;
   private String rutaProyecto;
   private String creadoPor;
   private Date creadoEn;
   private String modificadoPor;
   private Date modificadoEn;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId_T_Metodologia() {
        return id_T_Metodologia;
    }

    public void setId_T_Metodologia(int id_T_Metodologia) {
        this.id_T_Metodologia = id_T_Metodologia;
    }

    public int getId_T_Idea() {
        return id_T_Idea;
    }

    public void setId_T_Idea(int id_T_Idea) {
        this.id_T_Idea = id_T_Idea;
    }

    public String getTituloProyecto() {
        return tituloProyecto;
    }

    public void setTituloProyecto(String tituloProyecto) {
        this.tituloProyecto = tituloProyecto;
    }

    public String getResumenProyecto() {
        return resumenProyecto;
    }

    public void setResumenProyecto(String resumenProyecto) {
        this.resumenProyecto = resumenProyecto;
    }

    public int getId_T_LV_estadoProyecto() {
        return id_T_LV_estadoProyecto;
    }

    public void setId_T_LV_estadoProyecto(int id_T_LV_estadoProyecto) {
        this.id_T_LV_estadoProyecto = id_T_LV_estadoProyecto;
    }

    public String getRutaProyecto() {
        return rutaProyecto;
    }

    public void setRutaProyecto(String rutaProyecto) {
        this.rutaProyecto = rutaProyecto;
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
