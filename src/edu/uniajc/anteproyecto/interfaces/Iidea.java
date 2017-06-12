/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.Idea;
import edu.uniajc.anteproyecto.interfaces.model.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leon
 */
@Local
public interface Iidea {
        
    public boolean createIdea(Idea idea);
    public boolean deleteIdea(int ID);
    public boolean updateIdea(Idea idea); 
    public ArrayList<Idea> getIdea();

   
    public List<Idea> getIdeaByUsuario(int usuario);

}
