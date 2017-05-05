/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.uniajc.anteproyecto.interfaces.model.*;
import edu.uniajc.anteproyecto.logic.services.*;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Leon
 */
@ManagedBean(name = "lineamientoDetalleBean")
@ViewScoped
public class LineamientoDetalleBean {

    private LineamientoDetalleServices servicios;
    private LineamientoDetalle lineamientoDetalle;
    private List<LineamientoDetalle> listalineamientoDetalle;
    
     //Combos
    private ArrayList<SelectItem> itemsLineamiento;
    private String v_select_lineamiento;
    
    //Falta Poner corte como un combo, pero no tenemos modelo de lista valor
     //private ArrayList<SelectItem> itemsCorte;
     //private String v_select_lineamiento;
    

    public LineamientoDetalleBean() {
        lineamientoDetalle = new LineamientoDetalle();
        servicios = new LineamientoDetalleServices();
        itemsLineamiento = Consultar_Lineamiento_combo();
       // listalineamientoDetalle = servicios.getLineamientosDetalle();
       //listalineamientoDetalle = servicios.getLineamientoDetalleByLineamiento(Integer.parseInt(v_select_lineamiento));
    }
    public ArrayList<SelectItem> Consultar_Lineamiento_combo() {
         LineamientoServices serviciosLine =new LineamientoServices();
        
        List<Lineamiento> lista = serviciosLine.getLineamientos();
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (Lineamiento obj : (ArrayList<Lineamiento>) lista) {
            items.add(new SelectItem(obj.getID(), obj.getDescripcion()));
        }
        return items;
    }
    public void limpiarForma() {
        lineamientoDetalle = new LineamientoDetalle();
        listalineamientoDetalle = servicios.getLineamientoDetalleByLineamiento(Integer.parseInt(v_select_lineamiento));
        //v_select_lineamiento="";
    }

    public void crear() {
       Date fecha = new Date();
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        lineamientoDetalle.setCreadoEn(fechaSQL);
        lineamientoDetalle.setModificadoEn(fechaSQL);
        lineamientoDetalle.setCreadoPor("Leon");
        lineamientoDetalle.setModificadoPor("Leon");
        lineamientoDetalle.setIdLineamiento(Integer.parseInt(v_select_lineamiento));

        if (servicios.createLineamientoDetalle(lineamientoDetalle)) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpiarForma();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realizar la operaciónn");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }

    }

    public void modificar(RowEditEvent event) {

        Object ob = event.getObject();
        LineamientoDetalle ln = (LineamientoDetalle) ob;
         Date fecha = new Date();
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        //ln.setCreadoEn(fechaSQL);
        ln.setModificadoEn(fechaSQL);
        ln.setCreadoPor("Leon");
        ln.setModificadoPor("Leon");

        if (servicios.updateLineamientoDetalle(ln)) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void eliminar(int IdLineamiento) {
        boolean flag = false;
        for (LineamientoDetalle lineamientoEliminar : listalineamientoDetalle) {
            if (lineamientoEliminar.getId()== IdLineamiento) {
                
                if (servicios.deleteLineamientoDetalle(IdLineamiento)) {
                    flag = true;
                    break;

                }
            }
        }
        listalineamientoDetalle =  servicios.getLineamientoDetalleByLineamiento(Integer.parseInt(v_select_lineamiento));
        if (flag) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "El Lineamiento Fue eliminado con exito.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void llenarlista (){
        listalineamientoDetalle = servicios.getLineamientoDetalleByLineamiento(Integer.parseInt(v_select_lineamiento));
    }

    public LineamientoDetalleServices getServicios() {
        return servicios;
    }

    public void setServicios(LineamientoDetalleServices servicios) {
        this.servicios = servicios;
    }

    public LineamientoDetalle getLineamientoDetalle() {
        return lineamientoDetalle;
    }

    public void setLineamientoDetalle(LineamientoDetalle lineamientoDetalle) {
        this.lineamientoDetalle = lineamientoDetalle;
    }

    public List<LineamientoDetalle> getListalineamientoDetalle() {
        return listalineamientoDetalle;
    }

    public void setListalineamientoDetalle(List<LineamientoDetalle> listalineamientoDetalle) {
        this.listalineamientoDetalle = listalineamientoDetalle;
    }

    public ArrayList<SelectItem> getItemsLineamiento() {
        return itemsLineamiento;
    }

    public void setItemsLineamiento(ArrayList<SelectItem> itemsLineamiento) {
        this.itemsLineamiento = itemsLineamiento;
    }

    public String getV_select_lineamiento() {
        return v_select_lineamiento;
    }

    public void setV_select_lineamiento(String v_select_lineamiento) {
        this.v_select_lineamiento = v_select_lineamiento;
    }

}
