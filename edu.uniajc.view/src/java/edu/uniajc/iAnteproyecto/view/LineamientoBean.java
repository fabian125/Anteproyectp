/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import edu.uniajc.Anteproyecto.util.LeerPropiedades;
import edu.uniajc.anteproyecto.interfaces.ILineamiento;
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
@ManagedBean(name = "lineamientoBean")
@ViewScoped
public class LineamientoBean {
    
    public static final String KEY = "lineamiento";
    private ILineamiento servicios;
    private Lineamiento lineamiento;
    private Lineamiento lineamientoTable;
    private List<Lineamiento> listalineamiento;
    private String config = "LineamientoServices";
    private LeerPropiedades leer = new LeerPropiedades();

    public Lineamiento getLineamientoTable() {
        return lineamientoTable;
    }

    public void setLineamientoTable(Lineamiento lineamientoTable) {
        this.lineamientoTable = lineamientoTable;
    }

    
    
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
        return null;
    }

    public void setServicios(LineamientoServices servicios) {
        this.servicios = servicios;
    }

    public LineamientoBean() throws NamingException {
        InitialContext ctx = new InitialContext();
        lineamiento = new Lineamiento();
        //servicios =  (ILineamiento) ctx.lookup("java:global/edu.uniajc.view/LineamientoServices!edu.uniajc.anteproyecto.interfaces.ILineamiento");
        servicios = (ILineamiento) ctx.lookup(leer.leerArchivo(config));
        listalineamiento = servicios.getLineamientos();
    }

   public String navega() throws NamingException {
        
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put(KEY, lineamientoTable);
            return "LineamientosDetalle.xhtml";
        
    
}

public void limpiarForma() {
        lineamiento = new Lineamiento();
        listalineamiento = servicios.getLineamientos();
    }

    public void crear() {
      
       
        lineamiento.setCreadoPor("Leon");
        

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
         
        //ln.setCreadoEn(fechaSQL);
       // ln.setModificadoEn(fechaSQL);
       // ln.setCreadoPor("Leon");
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
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "El Lineamiento Fue eliminado con exito.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
