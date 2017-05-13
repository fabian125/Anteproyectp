/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *@author Emmanuel Barrera - IRIS
 *12/05/2017
 * Nombre Clase:Iproyecto
 * Descripcion: Tabla que contiene todo el DAS
 */

public interface IProyecto {
        
    public boolean createProyecto(Proyecto proyecto);
    public boolean deleteProyecto(int ID);
    public boolean updateProyecto(Proyecto proyecto);
    public Proyecto getProyectoById(int id);   
    public ArrayList<Proyecto> getProyectos();

    
}
