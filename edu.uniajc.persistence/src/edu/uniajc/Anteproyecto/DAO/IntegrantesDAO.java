/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IntegrantesDAO {

    private Connection DBConnection = null;

    public IntegrantesDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }
 
    public boolean createIntegrantes(Integrantes integrantes) {
       
            return false;
        }
    
      public boolean deleteIntegrantes(int id) {
       
            return false;
        
    }
       public boolean updateIntegrantes(Integrantes integrantes) {
        
            return false;
        

    }


      public Integrantes getIntegrantesByTipoIntegrante(int ID_T_LV_TIPOINTEGRANTE) {
        
      
            return null;
        

    }

      
   public Integrantes getIntegrantesByProyecto(int ID_T_Proyecto){
       
       return null;
   }
      
      
      
    

    public ArrayList<Integrantes> getIntegrantesByTipoIntegrantes(int ID_T_LV_TIPOINTEGRANTE )  {
       
            return null;
        

    }

    
}
