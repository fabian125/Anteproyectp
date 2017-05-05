/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.uniajc.anteproyecto.interfaces.model.*;
import edu.uniajc.anteproyecto.logic.services.*;
import java.sql.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Leon
 */
@ManagedBean(name = "lineamientoBean")
@RequestScoped
public class LineamientoBean {

    private LineamientoServices servicios;
    private Lineamiento lineamiento;
    private List<Lineamiento> listalineamiento;

    public Lineamiento getLineamiento() {
        return lineamiento;
    }

    public void setLineamiento(Lineamiento lineamiento) {
        this.lineamiento = lineamiento;
    }

    public List<Lineamiento> getListalineamiento() {
        return listalineamiento;
    }

    public void setListalineamiento(List<Lineamiento> listalineamiento) {
        this.listalineamiento = listalineamiento;
    }

    public LineamientoServices getServicios() {
        return servicios;
    }

    public void setServicios(LineamientoServices servicios) {
        this.servicios = servicios;
    }

    public LineamientoBean() {
        lineamiento = new Lineamiento();
        servicios = new LineamientoServices();
        listalineamiento = servicios.getLineamientos();
    }

    public void limpiarForma() {
        lineamiento = new Lineamiento();
        listalineamiento = servicios.getLineamientos();
    }

    public void crear() {
        Date date = new Date(2017, 4, 4);
        lineamiento.setCreadoEn(date);
        lineamiento.setModificadoEn(date);
        lineamiento.setCreadoPor("Leon");
        lineamiento.setModificadoPor("Leon");

        if (servicios.createLineamiento(lineamiento)) {

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
        Lineamiento ln = (Lineamiento) ob;
        Date date = new Date(2017, 4, 4);
        ln.setCreadoEn(date);
        ln.setModificadoEn(date);
        ln.setCreadoPor("Leon");
        ln.setModificadoPor("Leon");

        if (servicios.updateLineamiento(ln)) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void eliminar(int IdLineamiento) {
        boolean flag = false;
        for (Lineamiento lineamientoEliminar : listalineamiento) {
            if (lineamientoEliminar.getID() == IdLineamiento) {
                if (servicios.deleteLineamiento(IdLineamiento)) {
                    flag = true;
                    break;

                }
            }
        }
        listalineamiento = servicios.getLineamientos();
        if (flag) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "El proyecto Fue eliminado con exito.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
