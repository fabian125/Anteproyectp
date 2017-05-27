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

    //Integrantes
    private Integrantes integrante;
    private IIntegrantes servicioIntegrante;
    private List<Integrantes> listaIntegrantes;
    private String configIntegrante = "IntegrantesServices";
    private ArrayList<SelectItem> itemsTipoIntegrante;
    private ArrayList<SelectItem> itemsEstadoIntegrante;
    private String v_select_Tipointegrante;
    private String v_select_Estadointegrante;

    //USUARIO 
    private Usuario user;
    private IUsuario servicioUsuario;
    private String configUsuario = "UsuarioServices";
    private String usernamePantalla;

    //PERSONA
   private Persona persona;
    private IPersona servicioPersona;
    private String configPersona = "PersonaServices";
    private List<Persona> listaPersona;
    
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

    public ProyectoGestionBean() throws NamingException {
        InitialContext ctx = new InitialContext();

        //proyecto
        servicios = (IProyecto) ctx.lookup(leer.leerArchivo(configProyecto));
        this.cargarProyecto();
        v_select_lineamiento = String.valueOf(proyecto.getId_T_Metodologia());
        v_select_estado = String.valueOf(proyecto.getId_T_LV_estadoProyecto());
        //integrante   
        this.integrante = new Integrantes();
        servicioIntegrante = (IIntegrantes) ctx.lookup(leer.leerArchivo(configIntegrante));
        listaIntegrantes = servicioIntegrante.getIntegrantesByProyecto(proyecto.getID());
        //usuario
        servicioUsuario = (IUsuario) ctx.lookup(leer.leerArchivo(configUsuario));

        //Persona
        this.persona = new Persona();
        servicioPersona = (IPersona) ctx.lookup(leer.leerArchivo(configPersona));
        listaPersona = new ArrayList<Persona>();
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

    public void limpiarCombox() {
        //v_select_lineamiento="";
        v_select_lineamiento = "";
        v_select_estado = "";

    }

    public void limpiarComboxIntegrante() {
        //v_select_lineamiento="";
        v_select_Tipointegrante = "";
        v_select_Estadointegrante = "";
    }

    public void ejecuteMetodos() {

        this.itemsEstadoProyecto = Consultar_Estado_combo();
        this.itemsLineamiento = Consultar_Lineamiento_combo();
        this.itemsEstadoIntegrante = Consultar_EstadoInt_combo();
        this.itemsTipoIntegrante = Consultar_TipoInt_combo();
        cargarPersonas();
        cargarLineamientosCorte();

        // return  null;
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

    public void anadirIntegrantePantalla() {
        this.user = consultarUsuario(usernamePantalla);
        if (this.user != null) {
            construirIntegrantesBD();
            persona = servicioPersona.getPersonabyId(user.getId_t_Persona());
            listaPersona.add(persona);
            limpiarComboxIntegrante();
            this.user = new Usuario();
            usernamePantalla = "";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "El usuario no existe");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void updateProyecto() {

        boolean flag;
        if (listaIntegrantes != null && listaIntegrantes.size() > 0) {
            proyecto.setCreadoPor("Leon");
            proyecto.setId_T_Metodologia(Integer.parseInt(this.v_select_lineamiento));
            proyecto.setId_T_LV_estadoProyecto(Integer.parseInt(this.v_select_estado));
            servicios.updateProyecto(proyecto);
            servicioIntegrante.deleteIntegrantesByProyecto(proyecto.getID());

            //Metodo para crear integrantes  
            for (int i = 0; i < listaIntegrantes.size(); i++) {
                listaIntegrantes.get(i).setID_T_Proyecto(proyecto.getID());
                servicioIntegrante.createintegrantes(listaIntegrantes.get(i));

            }

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo crear el proyecto, debe tener minimo un integrante");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void construirIntegrantesBD() {

        this.integrante.setID_T_Usuario(this.user.getId());
        this.integrante.setID_T_LV_TIPOINTEGRANTE(Integer.parseInt(v_select_Tipointegrante));
        this.integrante.setID_T_LV_ESTADOINTEGRANTE(Integer.parseInt(v_select_Estadointegrante));
        this.integrante.setCreadoPor("Leon");
        this.listaIntegrantes.add(integrante);
        this.integrante = new Integrantes();

    }

    public void cargarPersonas() {
        for (int i = 0; i < this.listaIntegrantes.size(); i++) {
            Usuario usu = servicioUsuario.getUsuarioById(listaIntegrantes.get(i).getID_T_Usuario());
            Persona per = servicioPersona.getPersonabyId(usu.getId_t_Persona());
            listaPersona.add(per);
        }

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

    public void limpiarLista() {

        listaIntegrantes.clear();
        listaPersona.clear();
    }

    public void eliminarIntegrante(int idPersona) {

        int idUser = servicioUsuario.getUsuariobyidPersona(idPersona);

        for (int i = 0; i < listaIntegrantes.size(); i++) {
            if (listaIntegrantes.get(i).getID_T_Usuario() == idUser) {
                listaIntegrantes.remove(i);
            }
        }
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getId() == idPersona) {
                listaPersona.remove(i);
            }
        }
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

    public Integrantes getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrantes integrante) {
        this.integrante = integrante;
    }

    public IIntegrantes getServicioIntegrante() {
        return servicioIntegrante;
    }

    public void setServicioIntegrante(IIntegrantes servicioIntegrante) {
        this.servicioIntegrante = servicioIntegrante;
    }

    public List<Integrantes> getListaIntegrantes() {
        return listaIntegrantes;
    }

    public void setListaIntegrantes(List<Integrantes> listaIntegrantes) {
        this.listaIntegrantes = listaIntegrantes;
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

    public String getV_select_Tipointegrante() {
        return v_select_Tipointegrante;
    }

    public void setV_select_Tipointegrante(String v_select_Tipointegrante) {
        this.v_select_Tipointegrante = v_select_Tipointegrante;
    }

    public String getV_select_Estadointegrante() {
        return v_select_Estadointegrante;
    }

    public void setV_select_Estadointegrante(String v_select_Estadointegrante) {
        this.v_select_Estadointegrante = v_select_Estadointegrante;
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

    public ArrayList<SelectItem> getItemsTipoIntegrante() {
        return itemsTipoIntegrante;
    }

    public void setItemsTipoIntegrante(ArrayList<SelectItem> itemsTipoIntegrante) {
        this.itemsTipoIntegrante = itemsTipoIntegrante;
    }

    public ArrayList<SelectItem> getItemsEstadoIntegrante() {
        return itemsEstadoIntegrante;
    }

    public void setItemsEstadoIntegrante(ArrayList<SelectItem> itemsEstadoIntegrante) {
        this.itemsEstadoIntegrante = itemsEstadoIntegrante;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public IPersona getServicioPersona() {
        return servicioPersona;
    }

    public void setServicioPersona(IPersona servicioPersona) {
        this.servicioPersona = servicioPersona;
    }

    public String getConfigPersona() {
        return configPersona;
    }

    public void setConfigPersona(String configPersona) {
        this.configPersona = configPersona;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
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
