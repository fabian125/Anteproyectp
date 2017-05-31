/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import edu.uniajc.Anteproyecto.util.LeerPropiedades;
import edu.uniajc.anteproyecto.interfaces.IIntegrantes;
import edu.uniajc.anteproyecto.interfaces.ILineamiento;
import edu.uniajc.anteproyecto.interfaces.ILineamientoDetalle;
import edu.uniajc.anteproyecto.interfaces.IPersona;
import edu.uniajc.anteproyecto.interfaces.IProyecto;
import edu.uniajc.anteproyecto.interfaces.IUsuario;
import edu.uniajc.anteproyecto.interfaces.model.Integrantes;
import edu.uniajc.anteproyecto.interfaces.model.Lineamiento;
import edu.uniajc.anteproyecto.interfaces.model.LineamientoDetalle;
import edu.uniajc.anteproyecto.interfaces.model.ListaValoresDetalle;
import edu.uniajc.anteproyecto.interfaces.model.Persona;
import edu.uniajc.anteproyecto.interfaces.model.Proyecto;
import edu.uniajc.anteproyecto.interfaces.model.Usuario;
import edu.uniajc.anteproyecto.logic.services.LineamientoDetalleServices;
import edu.uniajc.anteproyecto.logic.services.LineamientoServices;
import edu.uniajc.anteproyecto.logic.services.ListaValorDetalleServices;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author luis.leon
 */
@ManagedBean(name = "proyectoGestionBean")
@ViewScoped
public class ProyectoGestionBean {

    private IProyecto servicios;
    private Proyecto proyecto;
    private String configProyecto = "ProyectoServices";
    // int idProyectoCreado;
    private LeerPropiedades leer = new LeerPropiedades();

    //Combos
    private ArrayList<SelectItem> itemsEstadoProyecto;
    private ArrayList<SelectItem> itemsLineamiento;
    private String v_select_estado;
    private String v_select_lineamiento;

    

    //USUARIO 
    private Usuario user;
    private IUsuario servicioUsuario;
    private String configUsuario = "UsuarioServices";
    private String usernamePantalla;

      
    //Lineamientos
    private Lineamiento lineamiento;
    private List<LineamientoDetalle> lineamientoDetalle;
    private List<LineamientoDetalle> lineamientoDetalleCort1;
    private List<LineamientoDetalle> lineamientoDetalleCort2;
    private List<LineamientoDetalle> lineamientoDetalleCort3;
    private ILineamiento lineamientoService;
    private ILineamientoDetalle linDetalleServi;
    private String lin = "LineamientoServices";
    private String linDet = "LineamientoDetalleServices";
    //combos
    private ArrayList<SelectItem> itemsCorte;
    private String v_select_corte;

    public ProyectoGestionBean() throws NamingException {
        InitialContext ctx = new InitialContext();

        //proyecto
        servicios = (IProyecto) ctx.lookup(leer.leerArchivo(configProyecto));
        this.cargarProyecto();
        v_select_lineamiento = String.valueOf(proyecto.getId_T_Metodologia());
        v_select_estado = String.valueOf(proyecto.getId_T_LV_estadoProyecto());
        //integrante   
       
        //usuario
        servicioUsuario = (IUsuario) ctx.lookup(leer.leerArchivo(configUsuario));

       
        //Lineamientos
        lineamientoService=(ILineamiento) ctx.lookup(leer.leerArchivo(lin));
        linDetalleServi=(ILineamientoDetalle) ctx.lookup(leer.leerArchivo(linDet));
        lineamiento=lineamientoService.getLineamientoById(proyecto.getId_T_Metodologia());
        lineamientoDetalle=linDetalleServi.getLineamientoDetalleByLineamiento(lineamiento.getID());
        ejecuteMetodos();
        
       
    }

    public void cargarProyecto() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext extContext = facesContext.getExternalContext();
        this.proyecto = (Proyecto) extContext.getSessionMap().get(ListadoProBean.KEY);
        extContext.getSessionMap().remove(ListadoProBean.KEY);

    }

 

  

    public void limpiarCombox() {
        //v_select_lineamiento="";
        v_select_lineamiento = "";
        v_select_estado = "";

    }


    public void ejecuteMetodos() {

        
       
        itemsCorte=Consultar_Corte_combo();
        v_select_corte="";
        
        
        cargarLineamientosCorte();

        // return  null;
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
    public void cargarLineamientosCorte(){
        lineamientoDetalleCort1=new ArrayList<LineamientoDetalle>();
                lineamientoDetalleCort2=new ArrayList<LineamientoDetalle>();
                lineamientoDetalleCort3=new ArrayList<LineamientoDetalle>();
                
        for(int i=0 ; i< lineamientoDetalle.size(); i++){
            if(lineamientoDetalle.get(i).getCorte() == 1){
                lineamientoDetalleCort1.add(lineamientoDetalle.get(i));
            }
            if(lineamientoDetalle.get(i).getCorte() == 2){
                lineamientoDetalleCort2.add(lineamientoDetalle.get(i));
            }
            if(lineamientoDetalle.get(i).getCorte() == 3){
                lineamientoDetalleCort3.add(lineamientoDetalle.get(i));
            }
        }
    }

    public Usuario consultarUsuario(String username) {
        Usuario usuario = servicioUsuario.getUsuariobyUsername(username);
        return usuario;

    }

 

   

 

   

    public ArrayList<SelectItem> Consultar_EstadoInt_combo() {
        ListaValorDetalleServices serviciosLine = new ListaValorDetalleServices();

        List<ListaValoresDetalle> lista = serviciosLine.getListaValorDetallebyID_Lista_Valor(22);
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (ListaValoresDetalle obj : (ArrayList<ListaValoresDetalle>) lista) {
            items.add(new SelectItem(obj.getValor(), obj.getDescripcion()));
        }
        return items;
    }

    public ArrayList<SelectItem> Consultar_TipoInt_combo() {
        ListaValorDetalleServices serviciosLine = new ListaValorDetalleServices();

        List<ListaValoresDetalle> lista = serviciosLine.getListaValorDetallebyID_Lista_Valor(23);
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (ListaValoresDetalle obj : (ArrayList<ListaValoresDetalle>) lista) {
            items.add(new SelectItem(obj.getValor(), obj.getDescripcion()));
        }
        return items;
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

    public String getConfigProyecto() {
        return configProyecto;
    }

    public void setConfigProyecto(String configProyecto) {
        this.configProyecto = configProyecto;
    }

    

    public LeerPropiedades getLeer() {
        return leer;
    }

    public void setLeer(LeerPropiedades leer) {
        this.leer = leer;
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

  

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public IUsuario getServicioUsuario() {
        return servicioUsuario;
    }

    public void setServicioUsuario(IUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    public String getConfigUsuario() {
        return configUsuario;
    }

    public void setConfigUsuario(String configUsuario) {
        this.configUsuario = configUsuario;
    }

    public String getUsernamePantalla() {
        return usernamePantalla;
    }

    public void setUsernamePantalla(String usernamePantalla) {
        this.usernamePantalla = usernamePantalla;
    }

   
    public Lineamiento getLineamiento() {
        return lineamiento;
    }

    public void setLineamiento(Lineamiento lineamiento) {
        this.lineamiento = lineamiento;
    }

    public List<LineamientoDetalle> getLineamientoDetalle() {
        return lineamientoDetalle;
    }

    public void setLineamientoDetalle(List<LineamientoDetalle> lineamientoDetalle) {
        this.lineamientoDetalle = lineamientoDetalle;
    }

    public List<LineamientoDetalle> getLineamientoDetalleCort1() {
        return lineamientoDetalleCort1;
    }

    public void setLineamientoDetalleCort1(List<LineamientoDetalle> lineamientoDetalleCort1) {
        this.lineamientoDetalleCort1 = lineamientoDetalleCort1;
    }

    public List<LineamientoDetalle> getLineamientoDetalleCort2() {
        return lineamientoDetalleCort2;
    }

    public void setLineamientoDetalleCort2(List<LineamientoDetalle> lineamientoDetalleCort2) {
        this.lineamientoDetalleCort2 = lineamientoDetalleCort2;
    }

    public List<LineamientoDetalle> getLineamientoDetalleCort3() {
        return lineamientoDetalleCort3;
    }

    public void setLineamientoDetalleCort3(List<LineamientoDetalle> lineamientoDetalleCort3) {
        this.lineamientoDetalleCort3 = lineamientoDetalleCort3;
    }

    public ILineamiento getLineamientoService() {
        return lineamientoService;
    }

    public void setLineamientoService(ILineamiento lineamientoService) {
        this.lineamientoService = lineamientoService;
    }

    public ILineamientoDetalle getLinDetalleServi() {
        return linDetalleServi;
    }

    public void setLinDetalleServi(ILineamientoDetalle linDetalleServi) {
        this.linDetalleServi = linDetalleServi;
    }

    public String getLin() {
        return lin;
    }

    public void setLin(String lin) {
        this.lin = lin;
    }

    public String getLinDet() {
        return linDet;
    }

    public void setLinDet(String linDet) {
        this.linDet = linDet;
    }
    

}
