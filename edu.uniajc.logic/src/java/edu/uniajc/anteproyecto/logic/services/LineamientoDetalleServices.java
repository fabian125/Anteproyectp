/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;
import edu.uniajc.Anteproyecto.DAO.LineamientoDetalleDAO;
import edu.uniajc.anteproyecto.interfaces.ILineamientoDetalle;
import edu.uniajc.anteproyecto.interfaces.model.LineamientoDetalle;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
/**
 *
 * @author Leon
 */
@Stateless
public class LineamientoDetalleServices implements ILineamientoDetalle{

    @Override
    public boolean createLineamientoDetalle(LineamientoDetalle lineamientoDetalle) {
        try {

            // validacion de Data
            if (lineamientoDetalle!=null)
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                LineamientoDetalleDAO dao = new LineamientoDetalleDAO(cn.conexion());
                	

                
               boolean flag = dao.createLineamientoDetalle(lineamientoDetalle);
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
    public boolean deleteLineamientoDetalle(int ID) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                LineamientoDetalleDAO dao = new LineamientoDetalleDAO(cn.conexion());
                boolean flag=dao.deleteLineamientoDetalle(ID);
                        cn.conexion().close();

                
               return flag;
                
                
                
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateLineamientoDetalle(LineamientoDetalle lineamientoDetalle) {
         try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
               ConexionBD cn = new ConexionBD(); 
               LineamientoDetalleDAO dao = new LineamientoDetalleDAO(cn.conexion());
               boolean flag=dao.updateLineamientoDetalle(lineamientoDetalle);
               cn.conexion().close();

                
               return flag;
                
                
                
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<LineamientoDetalle> getLineamientoDetalleByLineamiento(int lineamiento) {
         try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD(); 
               LineamientoDetalleDAO dao = new LineamientoDetalleDAO(cn.conexion());
                	

                
                List<LineamientoDetalle> list = dao.getLineamientoDetalleByLineamiento(lineamiento);
                 cn.conexion().close();
                
                return list;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public LineamientoDetalle getLineamientoDetalleById(int id) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                 ConexionBD cn = new ConexionBD();
                LineamientoDetalleDAO dao = new LineamientoDetalleDAO(cn.conexion());
                	

                
                LineamientoDetalle lineamientoDetalle = dao.getLineamientoDetalleById(id);
                 cn.conexion().close();
                
                return lineamientoDetalle;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<LineamientoDetalle> getLineamientosDetalle() {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD();
                LineamientoDetalleDAO dao = new LineamientoDetalleDAO(cn.conexion());
                	

                
                ArrayList<LineamientoDetalle> list = dao.getLineamientosDetalle();
                 cn.conexion().close();
                
                return list;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
