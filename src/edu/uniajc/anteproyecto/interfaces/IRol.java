/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import edu.uniajc.anteproyecto.interfaces.model.Rol;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author shpreciado
 */
@Local
public interface IRol {
    
    public Rol createRol(String description, String typeRol, String createdBy, Date createdDate);
    
    public ArrayList<Rol> getRoles();

    public List<Rol> getRolesByType(String typeRol);

    public Rol getRolById(int id);
    
}
