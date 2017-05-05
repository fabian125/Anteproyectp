/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.iAnteproyecto.view;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import edu.uniajc.Anteproyecto.DAO.*;
import edu.uniajc.anteproyecto.interfaces.model.ListaValor;
import edu.uniajc.anteproyecto.logic.services.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author jarteaga
 */
@ManagedBean(name="listaValor")
@RequestScoped
public class ListaValorBean {
    private ListaValor listavalor = new ListaValor();

    public ListaValor getListavalor() {
        return listavalor;
    }

    public void setListavalor(ListaValor listavalor) {
        this.listavalor = listavalor;
    }
    
    
    public void guardarListaValor (){
        
        ListaValorServices valorService = new ListaValorServices();
       try{
         if((valorService.createListaValor(0, listavalor.getAgrupacion(), listavalor.getDescripcion(), listavalor.getValor())) != null){
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Operacion realizado con exito");
        FacesContext.getCurrentInstance().addMessage(null, msg);
         }else{
                  FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "No se pudo realizar la operacion");
        FacesContext.getCurrentInstance().addMessage(null, msg);
         }
       }catch(Exception e){
                     FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Ha ocurrido un error");
        FacesContext.getCurrentInstance().addMessage(null, msg);
           
       }
    }
    
    
    
    
    
}
