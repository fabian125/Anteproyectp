/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;

import edu.uniajc.Anteproyecto.util.LeerPropiedades;
import edu.uniajc.anteproyecto.interfaces.IEntrega;
import edu.uniajc.anteproyecto.interfaces.ILineamiento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.uniajc.anteproyecto.interfaces.model.*;
import edu.uniajc.anteproyecto.logic.services.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jarteaga
 */
@ManagedBean(name = "entregaBean")
@ViewScoped
public class EntregaBean {
    
    public static final String KEY = "entrega";
    private IEntrega iEntrega;
    private EntregaModel entrega;
     private String destination="D:\\tmp\\";
   
    private String config = "EntregaServices";
    private LeerPropiedades leer = new LeerPropiedades();

    public IEntrega getiEntrega() {
        return iEntrega;
    }

    public void setiEntrega(IEntrega iEntrega) {
        this.iEntrega = iEntrega;
    }

    public EntregaModel getEntrega() {
        return entrega;
    }

    public void setEntrega(EntregaModel entrega) {
        this.entrega = entrega;
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


    public EntregaBean() throws NamingException {
        InitialContext ctx = new InitialContext();
        entrega = new EntregaModel();
        //servicios =  (ILineamiento) ctx.lookup("java:global/edu.uniajc.view/LineamientoServices!edu.uniajc.anteproyecto.interfaces.ILineamiento");
        iEntrega = (IEntrega) ctx.lookup(leer.leerArchivo(config));
    }





    public void crear() {
      
       
        entrega.setCreadoPor("JA");
        

        if (iEntrega.createEntrega(entrega)) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realizar la operaciónn");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }

    }

    public void modificar(RowEditEvent event) {

        Object ob = event.getObject();
        EntregaModel ent = (EntregaModel) ob;
         
    
        ent.setModificadoPor("JA");

        if (iEntrega.updateEntrega(ent)) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realziar la operación");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
      
 
    public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Exito! ", event.getFile().getFileName() + " Se ha subido al servidor.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            entrega.setRuta_proyecto(destination+event.getFile().getFileName());
        
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }  
 
    public void copyFile(String fileName, InputStream in) {
           try {
              
              
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }

 

}
