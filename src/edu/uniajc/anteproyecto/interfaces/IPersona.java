/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.Persona;
import javax.ejb.Local;

/**
 *
 * @author luis.leon
 */
@Local
public interface IPersona {
      public Persona getPersonabyId(int id );
    
}

    
  
    
