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
    
    
    public ListaValor guardarListaValor (){
        
        ListaValorServices valorService = new ListaValorServices();
       try{
        return (valorService.createListaValor(0, listavalor.getAgrupacion(), listavalor.getDescripcion(), listavalor.getValor()));
       }catch(Exception e){
           return null;
       }
    }
    
    
    
    
    
}
