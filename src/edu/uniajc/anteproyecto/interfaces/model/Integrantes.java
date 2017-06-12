/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces.model;

import java.sql.Date;

/**
 *@author Fabian Castro - IRIS
 *12/05/2017
 * Nombre Clase:Integrantes
 * Descripcion: Clase Integrantes, Mapeo de la Entidad Integrantes
 */
public class Integrantes {
    
   private int ID;
   private int ID_T_Proyecto;
   private int ID_T_Usuario;
   private int ID_T_LV_TIPOINTEGRANTE;
   private int ID_T_LV_ESTADOINTEGRANTE;
   private String  Observacion;
   private String CreadoPor;
   private Date Creadoen;
   private String ModificadoPor;
   private Date ModificadoEn;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_T_Proyecto() {
        return ID_T_Proyecto;
    }

    public void setID_T_Proyecto(int ID_T_Proyecto) {
        this.ID_T_Proyecto = ID_T_Proyecto;
    }

    public int getID_T_Usuario() {
        return ID_T_Usuario;
    }

    public void setID_T_Usuario(int ID_T_Usuario) {
        this.ID_T_Usuario = ID_T_Usuario;
    }

    public int getID_T_LV_TIPOINTEGRANTE() {
        return ID_T_LV_TIPOINTEGRANTE;
    }

    public void setID_T_LV_TIPOINTEGRANTE(int ID_T_LV_TIPOINTEGRANTE) {
        this.ID_T_LV_TIPOINTEGRANTE = ID_T_LV_TIPOINTEGRANTE;
    }

    public int getID_T_LV_ESTADOINTEGRANTE() {
        return ID_T_LV_ESTADOINTEGRANTE;
    }

    public void setID_T_LV_ESTADOINTEGRANTE(int ID_T_LV_ESTADOINTEGRANTE) {
        this.ID_T_LV_ESTADOINTEGRANTE = ID_T_LV_ESTADOINTEGRANTE;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public String getCreadoPor() {
        return CreadoPor;
    }

    public void setCreadoPor(String CreadoPor) {
        this.CreadoPor = CreadoPor;
    }

    public Date getCreadoen() {
        return Creadoen;
    }

    public void setCreadoen(Date Creadoen) {
        this.Creadoen = Creadoen;
    }

    public String getModificadoPor() {
        return ModificadoPor;
    }

    public void setModificadoPor(String ModificadoPor) {
        this.ModificadoPor = ModificadoPor;
    }

    public Date getModificadoEn() {
        return ModificadoEn;
    }

    public void setModificadoEn(Date ModificadoEn) {
        this.ModificadoEn = ModificadoEn;
    }

}
