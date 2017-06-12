/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces.model;

import java.sql.Date;

/**
 *
 * @author jarteaga
 */
public class EntregaModel 
{
    
    private int id;
    private int id_proyecto;
    private int id_periodo_entrega;
    private int id_tipo_calificacion;
    private int id_estado_entrega;
    private int estado_aprobacion;
    private String calificacion;
    private Date fecha_entrega;
    private String ruta_proyecto;
    private String observacion;
    private String creadoPor;
    private Date creadoEn;
    private String modificadoPor;
    private Date modificadoEn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getId_periodo_entrega() {
        return id_periodo_entrega;
    }

    public void setId_periodo_entrega(int id_periodo_entrega) {
        this.id_periodo_entrega = id_periodo_entrega;
    }

    public int getId_tipo_calificacion() {
        return id_tipo_calificacion;
    }

    public void setId_tipo_calificacion(int id_tipo_calificacion) {
        this.id_tipo_calificacion = id_tipo_calificacion;
    }

    public int getId_estado_entrega() {
        return id_estado_entrega;
    }

    public void setId_estado_entrega(int id_estado_entrega) {
        this.id_estado_entrega = id_estado_entrega;
    }

    public int getEstado_aprobacion() {
        return estado_aprobacion;
    }

    public void setEstado_aprobacion(int estado_aprobacion) {
        this.estado_aprobacion = estado_aprobacion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }   

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getRuta_proyecto() {
        return ruta_proyecto;
    }

    public void setRuta_proyecto(String ruta_proyecto) {
        this.ruta_proyecto = ruta_proyecto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
