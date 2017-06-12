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
 *
 * @author Leon
 */
@Local
public interface ILineamiento {
        
    public boolean createLineamiento(Lineamiento lineamiento);
    public boolean deleteLineamiento(int ID);
    public boolean updateLineamiento(Lineamiento lineamiento);
    public Lineamiento getLineamientoById(int id);   
    public ArrayList<Lineamiento> getLineamientos();

    //ESTAS NO VAN
    public List<Lineamiento> getLineamientoByDirector(String director);
    public List<Lineamiento> getLineamientoByFacultad(String facultad);
    
    
    
}
