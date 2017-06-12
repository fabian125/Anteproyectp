/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *@author Emmanuel Barrera - IRIS
 *12/05/2017
 * Nombre Clase:Iproyecto
 * Descripcion: Tabla que contiene todo el DAS
 */
@Local
public interface IProyecto {
    
    public int createProyecto(Proyecto proyecto);
    public boolean deleteProyecto(int ID);
    public boolean updateProyecto(Proyecto proyecto);
    public ArrayList<Proyecto> getAllProyectos();
    public ArrayList<Proyecto> getAllProyectos2(int codigoUsuario);
    public List<MetodologiaModel> getMetodologia(int id,int corte);
    public List<MetodologiaModel> getMetodologiaCalificacion(int id);
    public int createEntrega(EntregaProyectoEstudiante entregaEstudiante);
    public List<Opciones_menu>getModulos(int idUsuario);
    
    
    //public Proyecto getProyectoById(int id);   
    //public ArrayList<Proyecto> getProyectos();

    
}
