/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.LineamientoDAO;
import edu.uniajc.anteproyecto.interfaces.ILineamiento;
import edu.uniajc.anteproyecto.interfaces.model.Lineamiento;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Leon
 */
@Stateless
public class LineamientoServices implements ILineamiento{

    @Override
    public boolean createLineamiento(Lineamiento lineamiento) {
        try {

            // validacion de Data
            if (lineamiento != null)
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD();
                LineamientoDAO dao = new LineamientoDAO(cn.conexion());
                	

                
                boolean flag = dao.createLineamiento(lineamiento);
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
    public ArrayList<Lineamiento> getLineamientos() {
       try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD();
               LineamientoDAO dao = new LineamientoDAO(cn.conexion());
                	

                
                ArrayList<Lineamiento> list = dao.getLineamientos();
                 cn.conexion().close();
                
                return list;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Lineamiento> getLineamientoByDirector(String director) {
         try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD(); 
               LineamientoDAO dao = new LineamientoDAO(cn.conexion());
                 

                
                ArrayList<Lineamiento> list = dao.getLineamientoByDirector(director);
                cn.conexion().close();	
                
                return list;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Lineamiento> getLineamientoByFacultad(String facultad) {
        return null;
    }

    @Override
    public Lineamiento getLineamientoById(int id) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                LineamientoDAO dao = new LineamientoDAO(cn.conexion());
                	

                
                Lineamiento lineamiento = dao.getLineamientoById(id);
                 cn.conexion().close();
                
                return lineamiento;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteLineamiento(int ID) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                LineamientoDAO dao = new LineamientoDAO(cn.conexion());
              dao.deleteLineamiento(ID);
                         cn.conexion().close();

                
               return true;
                
                
                
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateLineamiento(Lineamiento lineamiento) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD(); 
               LineamientoDAO dao = new LineamientoDAO(cn.conexion());
               dao.updateLineamiento(lineamiento);
                cn.conexion().close();

                
               return true;
                
                
                
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
