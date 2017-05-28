/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import edu.uniajc.Anteproyecto.util.LeerPropiedades;
import edu.uniajc.anteproyecto.interfaces.*;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.uniajc.anteproyecto.interfaces.model.*;
import edu.uniajc.anteproyecto.logic.services.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import javax.enterprise.inject.spi.Bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static oracle.sql.NUMBER.e;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Leon
 */
@ManagedBean(name = "IdeaBean")
@ViewScoped
public class IdeaBean {
    
    public static final String KEY = "idea";
    private Iidea servicios;
    private Idea idea;
    private Idea ideaTable;
    private List<Idea> listaidea;
    private String config = "IdeaServices";
    private LeerPropiedades leer = new LeerPropiedades();

    public Idea getIdeaTable() {
        return ideaTable;
    }

    public void setIdeaTable(Idea ideaTable) {
        this.ideaTable = ideaTable;
    }

    
    
    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    public List<Idea> getListaidea() {
        return listaidea;
    }

    public void setListaidea(List<Idea> listaidea) {
        this.listaidea = listaidea;
    }

    public IdeaServices getServicios() {
        return null;
    }

    public void setServicios(IdeaServices servicios) {
        this.servicios = servicios;
    }

    public IdeaBean() throws NamingException {
        InitialContext ctx = new InitialContext();
        idea = new Idea();
        //servicios =  (ILineamiento) ctx.lookup("java:global/edu.uniajc.view/LineamientoServices!edu.uniajc.anteproyecto.interfaces.ILineamiento");
        servicios = (Iidea) ctx.lookup(leer.leerArchivo(config));
        listaidea = servicios.getIdea();
    }

   public String navega() throws NamingException {
        
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put(KEY, ideaTable);
            return "Idea.xhtml";
        
    
}

public void limpiarForma() {
        idea = new Idea();
        listaidea = servicios.getIdea();
    }

    public void crear() {
      
       idea.setID_T_USUARIO(1);
       idea.setCREADOPOR("Fabian");
       idea.setMODIFICADOPOR("Fabian");
       idea.setDESCRIPCION("PRUEBA TAFA");
       idea.setPALABRASCLAVE("Prueba");
       idea.setID_T_LV_IDEAPRIVADA(70);
       idea.setID_T_LV_ESTADOIDEA(71);
       
       
       
       
        

        if (servicios.createIdea(idea)) {

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
        Idea ln = (Idea) ob;
         
        //ln.setCreadoEn(fechaSQL);
       // ln.setModificadoEn(fechaSQL);
       // ln.setCreadoPor("Leon");
        ln.setMODIFICADOPOR("Fabian");

        if (servicios.updateIdea(ln)) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void eliminar(int IDIdea) {
        boolean flag = false;
        for (Idea ideaEliminar : listaidea) {
            if (ideaEliminar.getID() == IDIdea) {
                
                if (servicios.deleteIdea(IDIdea)) {
                    flag = true;
                    break;

                }
            }
        }
        listaidea = servicios.getIdea();
        if (flag) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "El Lineamiento Fue eliminado con exito.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
