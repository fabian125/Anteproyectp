/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.ListaValor;
import edu.uniajc.anteproyecto.interfaces.model.Rol;
import java.util.Date;

/**
 *
 * @author jarteaga
 */
public interface IListaValor {
  
    public ListaValor createListaValor(int id, String agrupacion, String descripcion, String valor);
  
}
