/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.*;
import edu.uniajc.anteproyecto.interfaces.*;
import edu.uniajc.anteproyecto.interfaces.model.*;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Fabian
 */
@Stateless
public class IdeaServices implements Iidea{
    
    
    

    @Override
   public boolean createIdea(Idea idea) {
        try {

            // validacion de Data
            if (idea != null)
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD();
                IdeaDAO dao = new IdeaDAO(cn.conexion());
                	

                
                boolean flag = dao.createIdea(idea);
                 cn.conexion().close();
               
                        
                return flag;
            } else {
                System.out.println("Faltan Datos en pantalla");
                return false;
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
   

    @Override
    public ArrayList<Idea> getIdea() {
       try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD();
              IdeaDAO dao = new IdeaDAO(cn.conexion());
                	

                
                ArrayList<Idea> list = dao.getIdea();
                 cn.conexion().close();
                
                return list;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
 

    @Override
      public List<Idea> getIdeaByUsuario(int usuario){ {
        return null;
    }

      }
      
      
    @Override
    
    public boolean deleteIdea(int ID) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                IdeaDAO dao = new IdeaDAO(cn.conexion());
              dao.deleteIdea(ID);
                         cn.conexion().close();

                
               return true;
                
                
                
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateIdea(Idea idea) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD(); 
               IdeaDAO dao = new IdeaDAO(cn.conexion());
               dao.updateIdea(idea);
                cn.conexion().close();

                
               return true;
                
     
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
