/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces.model;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class EntregaProyectoEstudiante {
    private int id;
    private int idProyecto;
    private int idPeriodoEntrega;
    private Date fechaEntrega;
    private String rutaProyecto;
    private String creadoPor;
    private Date creadoEn;
    private String calificacion; 
    private String observacion; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }
    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdPeriodoEntrega() {
        return idPeriodoEntrega;
    }

    public void setIdPeriodoEntrega(int idPeriodoEntrega) {
        this.idPeriodoEntrega = idPeriodoEntrega;
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

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
    
    
    
    
    
}
