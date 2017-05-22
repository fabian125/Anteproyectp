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
 *16/05/2017
 * Nombre Clase:IntegrantesServices
 * Descripcion: Logica de la clase Integrantes
 */
@Stateless
public class IntegrantesServices implements IIntegrantes{

    @Override
   public boolean createintegrantes(Integrantes integrantes) {
        try {

            // validacion de Data
            if (integrantes!=null)
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                IntegrantesDAO dao = new IntegrantesDAO(cn.conexion());
                	

                
               boolean flag = dao.createIntegrantes(integrantes);
                cn.conexion().close();
               
                        
                return flag;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean deleteIntegrantes(int ID) {
        try {

                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                IntegrantesDAO dao = new IntegrantesDAO(cn.conexion());
                boolean flag=dao.deleteIntegrantes(ID);
                        cn.conexion().close();

                
               return flag;

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateIntegrantes(Integrantes integrantes) {
         try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
               ConexionBD cn = new ConexionBD(); 
               IntegrantesDAO dao = new IntegrantesDAO(cn.conexion());
               boolean flag=dao.updateIntegrantes(integrantes);
               cn.conexion().close();
           return flag;

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @Override
  public Integrantes getIntegrantesByTipoIntegrante(int ID_T_LV_TIPOINTEGRANTE) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                IntegrantesDAO dao = new IntegrantesDAO(cn.conexion());
                	

                
                Integrantes integrantes = dao.getIntegrantesByTipoIntegrante(ID_T_LV_TIPOINTEGRANTE);
                 cn.conexion().close();
                
                return integrantes;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
  
     @Override
  public List<Integrantes> getIntegrantesByProyecto(int ID_T_Proyecto) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                IntegrantesDAO dao = new IntegrantesDAO(cn.conexion());
                	

                
                List <Integrantes> list = dao.getIntegrantesByProyecto(ID_T_Proyecto);
                 cn.conexion().close();
                
                return list;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
  
  @Override
    public ArrayList<Integrantes> getIntegrantesByTipoIntegrantes(int ID_T_LV_TIPOINTEGRANTE ) {
       try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD();
               IntegrantesDAO dao = new IntegrantesDAO(cn.conexion());
                	

                
                ArrayList<Integrantes> list = dao.getIntegrantesByTipoIntegrantes( ID_T_LV_TIPOINTEGRANTE );
                 cn.conexion().close();
                
                return list;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteIntegrantesByProyecto(int id) {
        try {

                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                IntegrantesDAO dao = new IntegrantesDAO(cn.conexion());
                boolean flag=dao.deleteIntegrantesByProyecto(id);
                        cn.conexion().close();

                
               return flag;

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteIntegrantesbyUserandProyect(int iduser, int idProy) {
        try {

                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                IntegrantesDAO dao = new IntegrantesDAO(cn.conexion());
                boolean flag=dao.deleteIntegrantesbyUserandProyect(iduser , idProy);
                        cn.conexion().close();

                
               return flag;

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
   
}
