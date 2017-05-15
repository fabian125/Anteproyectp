/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces.model;

import java.util.Date;

/**
 *@author Jonathan Arteaga - IRIS
 *12/05/2017
 * Nombre Clase:  ProyectoRequest
 * Descripcion: Pojo de tabla Proyecto, idea, metodologia y lista valor para realizar consultas.
 */
public class ProyectoRequest 
{
    private int id;
    private String descripcionMetodologia;
    private String titulo_idea;
    private String titulo_proyecto;
    private String resumen;
    private String valor;
    private String ruta_proyecto;
    private String creadorPor;
    private Date CreadoEn;
    private String ModificadoPor;
    private Date ModificadoEn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionMetodologia() {
        return descripcionMetodologia;
    }

    public void setDescripcionMetodologia(String descripcionMetodologia) {
        this.descripcionMetodologia = descripcionMetodologia;
    }

    public String getTitulo_idea() {
        return titulo_idea;
    }

    public void setTitulo_idea(String titulo_idea) {
        this.titulo_idea = titulo_idea;
    }

    public String getTitulo_proyecto() {
        return titulo_proyecto;
    }

    public void setTitulo_proyecto(String titulo_proyecto) {
        this.titulo_proyecto = titulo_proyecto;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getRuta_proyecto() {
        return ruta_proyecto;
    }

    public void setRuta_proyecto(String ruta_proyecto) {
        this.ruta_proyecto = ruta_proyecto;
    }

    public String getCreadorPor() {
        return creadorPor;
    }

    public void setCreadorPor(String creadorPor) {
        this.creadorPor = creadorPor;
    }

    public Date getCreadoEn() {
        return CreadoEn;
    }

    public void setCreadoEn(Date CreadoEn) {
        this.CreadoEn = CreadoEn;
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

    @Override
    public String toString() {
        return "ProyectoRequest{" + "id=" + id + ", descripcionMetodologia=" + descripcionMetodologia + ", titulo_idea=" + titulo_idea + ", titulo_proyecto=" + titulo_proyecto + ", resumen=" + resumen + ", valor=" + valor + ", ruta_proyecto=" + ruta_proyecto + ", creadorPor=" + creadorPor + ", CreadoEn=" + CreadoEn + ", ModificadoPor=" + ModificadoPor + ", ModificadoEn=" + ModificadoEn + '}';
    }
    
    
    
}
