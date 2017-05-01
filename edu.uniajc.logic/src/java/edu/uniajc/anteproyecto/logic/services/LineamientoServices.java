/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.*;
import edu.uniajc.anteproyecto.interfaces.ILineamiento;
import edu.uniajc.anteproyecto.interfaces.model.Lineamiento;
import edu.uniajc.anteproyecto.interfaces.model.ListaValor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Leon
 */
@Stateless
public class LineamientoServices implements ILineamiento{

    @Override
    public Boolean createLineamiento(int ID, String descripcion, String dreadoPor, Date creadoEn, String modificadoPor, Date modificadoEn) {
        try {

            // validacion de Data
            if (! String.valueOf(ID).equals("") && !descripcion.equals("") && !dreadoPor.equals("") && (!String.valueOf(creadoEn).equals("")) && !modificadoPor.equals("")&& (!String.valueOf(modificadoEn).equals("")))
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                LineamientoDAO dao = new LineamientoDAO(dbConnection);
                	

                
                Lineamiento lineamiento = dao.createLineamiento(ID, descripcion, dreadoPor, creadoEn, modificadoPor, modificadoEn);
                
               
                        
                return (lineamiento == null ? false :
                        true);
            } else {
                return false;
            }
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Lineamiento> getLineamientos() {
       try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                LineamientoDAO dao = new LineamientoDAO(dbConnection);
                	

                
                ArrayList<Lineamiento> list = dao.getLineamientos();
                
                
                return list;
           
                
            
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Lineamiento> getLineamientoByDirector(String director) {
         try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                LineamientoDAO dao = new LineamientoDAO(dbConnection);
                	

                
                ArrayList<Lineamiento> list = dao.getLineamientoByDirector(director);
                
                
                return list;
           
                
            
        } catch (SQLException | NamingException e) {
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
                Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                LineamientoDAO dao = new LineamientoDAO(dbConnection);
                	

                
                Lineamiento lineamiento = dao.getLineamientoById(id);
                
                
                return lineamiento;
           
                
            
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteLineamiento(int ID) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                LineamientoDAO dao = new LineamientoDAO(dbConnection);
                	

                
               return dao.deleteLineamiento(ID);
                
                
                
           
                
            
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean updateLineamiento(Lineamiento lineamiento) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                LineamientoDAO dao = new LineamientoDAO(dbConnection);
                	

                
               return dao.updateLineamiento(lineamiento);
                
                
                
           
                
            
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}