/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import edu.uniajc.Anteproyecto.util.LeerPropiedades;
import edu.uniajc.anteproyecto.interfaces.ILineamientoDetalle;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.uniajc.anteproyecto.interfaces.model.*;
import edu.uniajc.anteproyecto.logic.services.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Leon
 */
@ManagedBean(name = "lineamientoDetalleBean")
@ViewScoped
public class LineamientoDetalleBean {

    private ILineamientoDetalle servicios;
    private LineamientoDetalle lineamientoDetalle;
    private Lineamiento lineamiento;
    private List<LineamientoDetalle> listalineamientoDetalle;
    private String config = "LineamientoDetalleServices";
    private LeerPropiedades leer = new LeerPropiedades();
    private int v_select_lineamiento;

    //Combos
    private ArrayList<SelectItem> itemsCorte;
    private String v_select_corte;

    private Double porcentajeActual = 0.0;

    //Falta Poner corte como un combo, pero no tenemos modelo de lista valor
    //private ArrayList<SelectItem> itemsCorte;
    //private String v_select_lineamiento;
    public LineamientoDetalleBean() throws NamingException {
        InitialContext ctx = new InitialContext();
        lineamientoDetalle = new LineamientoDetalle();
        servicios = (ILineamientoDetalle) ctx.lookup(leer.leerArchivo(config));
        ejecuteMetodos();
        // listalineamientoDetalle = servicios.getLineamientosDetalle();
        //listalineamientoDetalle = servicios.getLineamientoDetalleByLineamiento(Integer.parseInt(v_select_lineamiento));
    }

    public ArrayList<SelectItem> Consultar_Corte_combo() {
        ListaValorDetalleServices serviciosLine = new ListaValorDetalleServices();

        List<ListaValoresDetalle> lista = serviciosLine.getListaValorDetallebyID_Lista_Valor(1);
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (ListaValoresDetalle obj : (ArrayList<ListaValoresDetalle>) lista) {
            items.add(new SelectItem(obj.getValor(), obj.getDescripcion()));
        }
        return items;
    }

    public void limpiarForma() {
        lineamientoDetalle = new LineamientoDetalle();
        listalineamientoDetalle = servicios.getLineamientoDetalleByLineamiento((v_select_lineamiento));

    }

    public void limpiarCombox() {
        //v_select_lineamiento="";
        v_select_corte = "";
    }
    
    public void cargarLineamiento(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext extContext = facesContext.getExternalContext();
        this.lineamiento = (Lineamiento) extContext.getSessionMap().get(LineamientoBean.KEY);
        extContext.getSessionMap().remove(LineamientoBean.KEY);
        
        
    }

    public void crear() {

        // lineamientoDetalle.setCreadoEn(fechaSQL);
        //lineamientoDetalle.setModificadoEn(fechaSQL);
        lineamientoDetalle.setCreadoPor("Leon");

        //lineamientoDetalle.setModificadoPor("Leon");
        lineamientoDetalle.setIdLineamiento((v_select_lineamiento));
        lineamientoDetalle.setCorte(Integer.parseInt(v_select_corte));

        if (calcularProcentaje() <= 100) {

            if (servicios.createLineamientoDetalle(lineamientoDetalle)) {

                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                limpiarForma();
                llenarlista();
                limpiarCombox();
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realizar la operaciónn");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "El Porcentaje debe ser mayor a 0 y menor que 10");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public Double calcularProcentaje() {
        Double procentaje = 0.0;
        for (int i = 0; i < listalineamientoDetalle.size(); i++) {
            procentaje += listalineamientoDetalle.get(i).getPorcentaje();
        }

        return procentaje + lineamientoDetalle.getPorcentaje();
    }

    public Double calcularProcentajeActual() {
        Double procentaje = 0.0;
        for (int i = 0; i < listalineamientoDetalle.size(); i++) {
            procentaje += listalineamientoDetalle.get(i).getPorcentaje();
        }

        return procentaje;
    }

    public void modificar(RowEditEvent event) {

        Object ob = event.getObject();
        LineamientoDetalle ln = (LineamientoDetalle) ob;

        //ln.setCreadoEn(fechaSQL);
        // ln.setModificadoEn(fechaSQL);
        //ln.setCreadoPor("Leon");
        ln.setModificadoPor("Leon");
        lineamientoDetalle.setIdLineamiento(v_select_lineamiento);

        if (servicios.updateLineamientoDetalle(ln)) {
            llenarlista();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } else {
            llenarlista();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void eliminar(int IdLineamiento) {
        boolean flag = false;
        for (LineamientoDetalle lineamientoEliminar : listalineamientoDetalle) {
            if (lineamientoEliminar.getId() == IdLineamiento) {

                if (servicios.deleteLineamientoDetalle(IdLineamiento)) {
                    flag = true;

                    break;

                }
            }
        }

        if (flag) {
            llenarlista();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "El Lineamiento Fue eliminado con exito.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
public void ejecuteMetodos(){
    
    
    cargarLineamiento();
    itemsCorte = Consultar_Corte_combo();
    this.v_select_lineamiento = lineamiento.getID();
    llenarlista();
  // return  null;
    
    
}
    public void llenarlista() {
        listalineamientoDetalle = servicios.getLineamientoDetalleByLineamiento(v_select_lineamiento);
        porcentajeActual = calcularProcentajeActual();
    }

    public LineamientoDetalleServices getServicios() {
        return null;
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

    public Lineamiento getLineamiento() {
        return lineamiento;
    }

    public void setLineamiento(Lineamiento lineamiento) {
        this.lineamiento = lineamiento;
    }
    
    public void setListalineamientoDetalle(List<LineamientoDetalle> listalineamientoDetalle) {
        this.listalineamientoDetalle = listalineamientoDetalle;
    }

    public int getV_select_lineamiento() {
        return v_select_lineamiento;
    }

    public void setV_select_lineamiento(int v_select_lineamiento) {
        this.v_select_lineamiento = v_select_lineamiento;
    }

    public ArrayList<SelectItem> getItemsCorte() {
        return itemsCorte;
    }

    public void setItemsCorte(ArrayList<SelectItem> itemsCorte) {
        this.itemsCorte = itemsCorte;
    }

    public String getV_select_corte() {
        return v_select_corte;
    }

    public void setV_select_corte(String v_select_corte) {
        this.v_select_corte = v_select_corte;
    }

    public Double getPorcentajeActual() {
        return porcentajeActual;
    }

    public void setPorcentajeActual(Double porcentajeActual) {
        this.porcentajeActual = porcentajeActual;
    }

}
/*public ArrayList<SelectItem> Consultar_Lineamiento_combo() {
         LineamientoServices serviciosLine =new LineamientoServices();
        List<Lineamiento> lista = serviciosLine.getLineamientos();
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (Lineamiento obj : (ArrayList<Lineamiento>) lista) {
            items.add(new SelectItem(obj.getID(), obj.getDescripcion()));
        }
        return items;
    }*/
