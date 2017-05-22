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
//import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IntegrantesDAO {

    private Connection DBConnection = null;

    public IntegrantesDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }
   
 
    public boolean createIntegrantes(Integrantes integrantes) {
      try {
            java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             integrantes.setCreadoen(fechaSQL);
            // lineamiento.setModificadoEn(fechaSQL);

            PreparedStatement ps;

            String SQL ;
            //ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            SQL = "insert into TB_Integrantes(ID_T_Proyecto, ID_T_Usuario , ID_T_LV_TIPOINTEGRANTE , ID_T_LV_ESTADOINTEGRANTE , Observacion , CreadoPor , Creadoen , ModificadoPor , ModificadoEn) values(?,?,?,?,?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            
            ps.setInt(1, integrantes.getID_T_Proyecto());
            ps.setInt(2, integrantes.getID_T_Usuario());
            ps.setInt(3, integrantes.getID_T_LV_TIPOINTEGRANTE());
            ps.setInt(4, integrantes.getID_T_LV_ESTADOINTEGRANTE());
            ps.setString(5, integrantes.getObservacion());
            ps.setString(6, integrantes.getCreadoPor());
            ps.setDate(7, integrantes.getCreadoen());
            ps.setString(8, integrantes.getModificadoPor());
            ps.setDate(9, integrantes.getModificadoEn());
            ps.execute();
            ps.close();
                     
            return true;
        } catch (SQLException e) {
            System.out.println("Error en Integrante DAO" + e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
    
      public boolean deleteIntegrantes(int id) {
     try {
           

            PreparedStatement ps;

            String SQL = "delete from TB_Integrantes where ID =" +id+" ";
               

            ps = this.DBConnection.prepareStatement(SQL);
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en Integrante DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
      
      public boolean deleteIntegrantesbyUserandProyect(int idUser , int idProye) {
     try {
           

            PreparedStatement ps;

            String SQL = "delete from TB_Integrantes where ID_T_USUARIO ="+idUser +" and ID_T_PROYECTO=" + idProye+" ";
               

            ps = this.DBConnection.prepareStatement(SQL);
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en Integrante DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
      
       public boolean deleteIntegrantesByProyecto(int id) {
     try {
           

            PreparedStatement ps;

            String SQL = "delete from TB_Integrantes where ID_T_PROYECTO =" +id+" ";
               

            ps = this.DBConnection.prepareStatement(SQL);
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en Integrante DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
       public boolean updateIntegrantes(Integrantes integrantes) {
       
           try {
             java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             //lineamiento.setCreadoEn(fechaSQL);
             integrantes.setModificadoEn(fechaSQL);
           

            PreparedStatement ps ;
            String SQL = "update TB_Metodologia set ID_T_Proyecto = ?, ID_T_Usuario = ? , ID_T_LV_TIPOINTEGRANTE = ? , ID_T_LV_ESTADOINTEGRANTE = ? , Observacion = ?, CreadoPor = ? , Creadoen = ?, ModificadoPor = ? , ModificadoEn = ? where id = ?";
            ps = this.DBConnection.prepareStatement(SQL);
    
            ps.setInt(1, integrantes.getID_T_Proyecto());
            ps.setInt(2, integrantes.getID_T_Usuario());
            ps.setInt(3, integrantes.getID_T_LV_TIPOINTEGRANTE());
            ps.setInt(4, integrantes.getID_T_LV_ESTADOINTEGRANTE());
            ps.setString(5, integrantes.getObservacion());
            ps.setString(6, integrantes.getCreadoPor());
            ps.setDate(7, integrantes.getCreadoen());
            ps.setString(8, integrantes.getModificadoPor());
            ps.setDate(9, integrantes.getModificadoEn());
            ps.execute();          
            ps.close();
            return true;

                     
             
        } catch (SQLException e) {
            System.out.println("Error en Integrante DAO "+ e.getMessage() );
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }


      public Integrantes getIntegrantesByTipoIntegrante(int ID_T_LV_TIPOINTEGRANTE) {
        
      Integrantes integrante= new Integrantes();
        try {

            PreparedStatement ps ;

            String SQL = "select * from TB_Integrantes where ID =" +ID_T_LV_TIPOINTEGRANTE+"";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
            rs.next();
                
                integrante.setID_T_Proyecto(rs.getInt("ID_T_Proyecto"));
                integrante.setID_T_Usuario(rs.getInt("ID_T_Usuario"));
                integrante.setID_T_LV_TIPOINTEGRANTE(rs.getInt("ID_T_LV_TIPOINTEGRANTE"));
                integrante.setID_T_LV_ESTADOINTEGRANTE(rs.getInt("ID_T_LV_ESTADOINTEGRANTE"));
                integrante.setObservacion(rs.getString("Observacion"));
                integrante.setCreadoPor(rs.getString("CreadoPor"));
                integrante.setCreadoen(rs.getDate("Creadoen"));
                integrante.setModificadoPor(rs.getString("ModificadoPor"));
                integrante.setModificadoEn(rs.getDate("ModificadoEn"));
    
            }
            ps.close();
                       
            return integrante;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     
   public List<Integrantes> getIntegrantesByProyecto(int ID_T_Proyecto){
  
        List<Integrantes> list = new ArrayList<Integrantes>();
       try {

            PreparedStatement ps;

            String SQL = "select * from TB_Integrantes where ID_T_PROYECTO =" +ID_T_Proyecto+" ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
           while (rs.next()) {
            Integrantes integrante = new Integrantes();
        
                integrante.setID_T_Proyecto(rs.getInt("ID_T_Proyecto"));
                integrante.setID_T_Usuario(rs.getInt("ID_T_Usuario"));
                integrante.setID_T_LV_TIPOINTEGRANTE(rs.getInt("ID_T_LV_TIPOINTEGRANTE"));
                integrante.setID_T_LV_ESTADOINTEGRANTE(rs.getInt("ID_T_LV_ESTADOINTEGRANTE"));
                integrante.setObservacion(rs.getString("Observacion"));
                integrante.setCreadoPor(rs.getString("CreadoPor"));
                integrante.setCreadoen(rs.getDate("Creadoen"));
                integrante.setModificadoPor(rs.getString("ModificadoPor"));
                integrante.setModificadoEn(rs.getDate("ModificadoEn"));
                list.add(integrante);
    
            }
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
    

    public ArrayList<Integrantes> getIntegrantesByTipoIntegrantes(int ID_T_LV_TIPOINTEGRANTE )  {
      
        ArrayList<Integrantes> list = new ArrayList<Integrantes>();
        try {

            PreparedStatement ps;

            String SQL = "select * from ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integrantes integrante = new Integrantes();
        
                integrante.setID_T_Proyecto(rs.getInt("ID_T_Proyecto"));
                integrante.setID_T_Usuario(rs.getInt("ID_T_Usuario"));
                integrante.setID_T_LV_TIPOINTEGRANTE(rs.getInt("ID_T_LV_TIPOINTEGRANTE"));
                integrante.setID_T_LV_ESTADOINTEGRANTE(rs.getInt("ID_T_LV_ESTADOINTEGRANTE"));
                integrante.setObservacion(rs.getString("Observacion"));
                integrante.setCreadoPor(rs.getString("CreadoPor"));
                integrante.setCreadoen(rs.getDate("Creadoen"));
                integrante.setModificadoPor(rs.getString("ModificadoPor"));
                integrante.setModificadoEn(rs.getDate("ModificadoEn"));
                list.add(integrante);
            }
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     
 

    
}
