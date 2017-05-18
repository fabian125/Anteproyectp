/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import edu.uniajc.Anteproyecto.util.LeerPropiedades;
import edu.uniajc.anteproyecto.interfaces.IIntegrantes;
import edu.uniajc.anteproyecto.interfaces.IProyecto;
import java.util.List;
import javax.faces.bean.ManagedBean;

import edu.uniajc.anteproyecto.interfaces.model.*;
import edu.uniajc.anteproyecto.logic.services.*;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Leon
 */
@ManagedBean(name = "listadoProyectoBean")
@ViewScoped
public class ListadoProBean {

    public static final String KEY = "lineamiento";
    private IProyecto servicios;
    private String config = "ProyectoServices";
    private List<Proyecto> listaProyectos;
    //private Proyecto proyecto;
    private Proyecto proyectoTable;
    private IIntegrantes servicioIntegrante;
    private String configIntegrante = "IntegrantesServices";
    private String v_select_estado;
    private String v_select_lineamiento;
    private ArrayList<SelectItem> itemsEstadoProyecto;
    private ArrayList<SelectItem> itemsLineamiento;

    private LeerPropiedades leer = new LeerPropiedades();

    public ListadoProBean() throws NamingException {
        InitialContext ctx = new InitialContext();
        servicios = (IProyecto) ctx.lookup(leer.leerArchivo(config));
        servicioIntegrante = (IIntegrantes) ctx.lookup(leer.leerArchivo(configIntegrante));
        listaProyectos = servicios.getAllProyectos();
        this.itemsEstadoProyecto = Consultar_Estado_combo();
        this.itemsLineamiento = Consultar_Lineamiento_combo();
    }

    public String navega() throws NamingException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put(KEY, proyectoTable);
        return "DetalleProyecto.xhtml";

    }

    public ArrayList<SelectItem> Consultar_Estado_combo() {
        ListaValorDetalleServices serviciosLine = new ListaValorDetalleServices();

        List<ListaValoresDetalle> lista = serviciosLine.getListaValorDetallebyID_Lista_Valor(21);
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (ListaValoresDetalle obj : (ArrayList<ListaValoresDetalle>) lista) {
            items.add(new SelectItem(obj.getValor(), obj.getDescripcion()));
        }
        return items;
    }

    public ArrayList<SelectItem> Consultar_Lineamiento_combo() {
        LineamientoServices serviciosLine = new LineamientoServices();

        List<Lineamiento> lista = serviciosLine.getLineamientos();
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (Lineamiento obj : (ArrayList<Lineamiento>) lista) {
            items.add(new SelectItem(obj.getID(), obj.getDescripcion()));
        }
        return items;
    }

    public void modificar(RowEditEvent event) {

        Object ob = event.getObject();
        Proyecto ln = (Proyecto) ob;

        ln.setModificadoPor("Leon");

        if (servicios.updateProyecto(ln)) {
            listaProyectos = servicios.getAllProyectos();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void eliminar(int IdProyecto) {
        boolean flag = false;
        for (Proyecto proyectoEliminar : listaProyectos) {
            if (proyectoEliminar.getID() == IdProyecto) {

                if (servicios.deleteProyecto(IdProyecto)) {
                    flag = true;
                    break;

                }
            }
        }
        boolean flag2 = servicioIntegrante.deleteIntegrantesByProyecto(IdProyecto);

        listaProyectos = servicios.getAllProyectos();
        if (flag && flag2) {
            listaProyectos = servicios.getAllProyectos();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "El Proyecto Fue eliminado con sus integrantes.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public IProyecto getServicios() {
        return servicios;
    }

    public void setServicios(IProyecto servicios) {
        this.servicios = servicios;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public List<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(List<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public Proyecto getProyectoTable() {
        return proyectoTable;
    }

    public void setProyectoTable(Proyecto proyectoTable) {
        this.proyectoTable = proyectoTable;
    }

    public IIntegrantes getServicioIntegrante() {
        return servicioIntegrante;
    }

    public void setServicioIntegrante(IIntegrantes servicioIntegrante) {
        this.servicioIntegrante = servicioIntegrante;
    }

    public String getConfigIntegrante() {
        return configIntegrante;
    }

    public void setConfigIntegrante(String configIntegrante) {
        this.configIntegrante = configIntegrante;
    }

    public LeerPropiedades getLeer() {
        return leer;
    }

    public void setLeer(LeerPropiedades leer) {
        this.leer = leer;
    }

    public String getV_select_estado() {
        return v_select_estado;
    }

    public void setV_select_estado(String v_select_estado) {
        this.v_select_estado = v_select_estado;
    }

    public String getV_select_lineamiento() {
        return v_select_lineamiento;
    }

    public void setV_select_lineamiento(String v_select_lineamiento) {
        this.v_select_lineamiento = v_select_lineamiento;
    }

    public ArrayList<SelectItem> getItemsEstadoProyecto() {
        return itemsEstadoProyecto;
    }

    public void setItemsEstadoProyecto(ArrayList<SelectItem> itemsEstadoProyecto) {
        this.itemsEstadoProyecto = itemsEstadoProyecto;
    }

    public ArrayList<SelectItem> getItemsLineamiento() {
        return itemsLineamiento;
    }

    public void setItemsLineamiento(ArrayList<SelectItem> itemsLineamiento) {
        this.itemsLineamiento = itemsLineamiento;
    }
    
   
}
    
    
    
    


