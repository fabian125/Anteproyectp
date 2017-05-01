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
 *
 * @author Leon
 */
public interface ILineamiento {
        
    public boolean createLineamiento(int ID,   String descripcion,   String dreadoPor,   Date creadoEn,   String modificadoPor,   Date modificadoEn);
    public boolean deleteLineamiento(int ID);
    public boolean updateLineamiento(Lineamiento lineamiento);
    
    public ArrayList<Lineamiento> getLineamientos();

    public List<Lineamiento> getLineamientoByDirector(String director);
    public List<Lineamiento> getLineamientoByFacultad(String facultad);
    public Lineamiento getLineamientoById(int id);
    
    
}
