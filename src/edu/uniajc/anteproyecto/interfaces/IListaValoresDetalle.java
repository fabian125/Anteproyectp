/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;


import edu.uniajc.anteproyecto.interfaces.model.ListaValoresDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leon
 */
@Local
public interface IListaValoresDetalle {
    

    public List<ListaValoresDetalle> getListaValorDetallebyID_Lista_Valor(int id_ListaValor);
    
  
}
