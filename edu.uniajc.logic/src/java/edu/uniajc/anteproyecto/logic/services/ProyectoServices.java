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
 *@author Fabian Castro - IRIS
 *15/05/2017
 * Nombre Clase:ProyectoServices
 * Descripcion: logica de la clase proyecto
 */

@Stateless
public class ProyectoServices implements IProyecto
{

    @Override
    public boolean createProyecto(Proyecto proyecto) {
        try {

            // validacion de Data
            if (proyecto != null)
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD();
                ProyectoDao dao = new ProyectoDao(cn.conexion());
                	

                
                boolean flag = dao.createProyecto(proyecto);
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
    public boolean deleteProyecto(int ID) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                ProyectoDao dao = new ProyectoDao(cn.conexion());
              dao.deleteProyecto(ID);
                         cn.conexion().close();
   
               return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateProyecto(Proyecto proyecto) {
        try {

                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD(); 
               ProyectoDao dao = new ProyectoDao(cn.conexion());
               dao.updateProyecto(proyecto);
                cn.conexion().close();

                
               return true;
                
                
                
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
