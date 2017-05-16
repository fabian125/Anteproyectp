/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import edu.uniajc.Anteproyecto.util.LeerPropiedades;
import edu.uniajc.anteproyecto.interfaces.IProyecto;
import edu.uniajc.anteproyecto.interfaces.model.Lineamiento;
import edu.uniajc.anteproyecto.interfaces.model.ListaValoresDetalle;
import edu.uniajc.anteproyecto.interfaces.model.Proyecto;
import edu.uniajc.anteproyecto.logic.services.LineamientoServices;
import edu.uniajc.anteproyecto.logic.services.ListaValorDetalleServices;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author luis.leon
 */
@ManagedBean(name = "proyectoBean")
@ViewScoped
public class ProyectoBean {
    
     private IProyecto servicios;
    private Proyecto proyecto;
    //private Lineamiento lineamiento;
    private List<String> listaIntegrantes;
    private String config = "ProyectoServices";
    int idProyectoCreado;
    private LeerPropiedades leer = new LeerPropiedades();
    

    //Combos
    private ArrayList<SelectItem> itemsEstado;
    private ArrayList<SelectItem> itemsLineamiento;
    private String v_select_estado;
    private String  v_select_lineamiento;

    public ProyectoBean() throws NamingException {
        InitialContext ctx = new InitialContext();
        proyecto = new Proyecto();
        servicios = (IProyecto) ctx.lookup(leer.leerArchivo(config));
        ejecuteMetodos();
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
     
    public void crearProyecto() {

       
        proyecto.setCreadoPor("Leon");
        proyecto.setId_T_Metodologia(Integer.parseInt(this.v_select_lineamiento));
        proyecto.setId_T_LV_estadoProyecto(Integer.parseInt(this.v_select_estado));
        idProyectoCreado = servicios.createProyecto(proyecto); 
        //Metodo para crear integrantes      
        limpiarForma();
        limpiarCombox();
    } 
    
    public void limpiarForma(){
        
        proyecto = new Proyecto();
        //Hay que limpiar listaIntegrantes
    }
      public void limpiarCombox() {
        //v_select_lineamiento="";
        v_select_lineamiento = "";
        v_select_estado="";
    }
      
      
      
     public void ejecuteMetodos(){
    
    this.itemsEstado = Consultar_Estado_combo();
    this.itemsLineamiento= Consultar_Lineamiento_combo();
   
    //llenarlista();
  // return  null;
    
    
}
     public void eliminarIntegrante(int id){
         
     }

    public IProyecto getServicios() {
        return servicios;
    }

    public void setServicios(IProyecto servicios) {
        this.servicios = servicios;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public LeerPropiedades getLeer() {
        return leer;
    }

    public void setLeer(LeerPropiedades leer) {
        this.leer = leer;
    }

    public ArrayList<SelectItem> getItemsEstado() {
        return itemsEstado;
    }

    public void setItemsEstado(ArrayList<SelectItem> itemsEstado) {
        this.itemsEstado = itemsEstado;
    }

    public ArrayList<SelectItem> getItemsLineamiento() {
        return itemsLineamiento;
    }

    public void setItemsLineamiento(ArrayList<SelectItem> itemsLineamiento) {
        this.itemsLineamiento = itemsLineamiento;
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
    
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
}
