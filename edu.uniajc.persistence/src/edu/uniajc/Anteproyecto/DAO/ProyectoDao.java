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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *@author Jonathan Arteaga - IRIS
 *12/05/2017
 * Nombre Clase: ProyectoDao
 * Descripcion: Tabla que contiene el CRUD de la tabla proyecto
 */
public class ProyectoDao {

    private Connection DBConnection = null;

    public ProyectoDao(Connection openConnection) {
        this.DBConnection = openConnection;
    }
    
     public int createProyecto(Proyecto proyecto) {
        try {
            java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             proyecto.setCreadoEn(fechaSQL);
         

            PreparedStatement ps = null;

            String SQL = "select SQ_TB_Proyecto.nextval ID from dual";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            int codigo = 0;
            
            if(rs.next())
            {
                codigo=rs.getInt("ID");
                proyecto.setID(codigo);
            }

          SQL = "INSERT INTO TB_PROYECTO(ID,ID_T_METODOLOGIA,TituloProyecto, ResumenProyecto, ID_T_LV_EstadoProyecto, RutaProyecto, CreadoPor, CreadoEn) values(?,?,?,?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            ps.setInt(1,proyecto.getID());
            ps.setInt(2,proyecto.getId_T_Metodologia());           
            ps.setString(3, proyecto.getTituloProyecto());
            ps.setString(4, proyecto.getResumenProyecto());
            ps.setInt(5, proyecto.getId_T_LV_estadoProyecto());
            ps.setString(6, proyecto.getRutaProyecto());
            ps.setString(7, proyecto.getCreadoPor());
            ps.setDate(8, proyecto.getCreadoEn());
            ps.execute();
            //Falta capturar el Id del ultimo registro
            
            ps.close();
           
            //Le asigno el id al objeto proyecto
            System.out.println("Codigo de Proyecto"+codigo);
           
            return codigo;
        } catch (SQLException e) {
            System.out.println("Error en Proyecto DAO" + e.getMessage());
            Logger.getLogger(ProyectoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return 0;
        }

    }
 /*
    public int createProyecto(Proyecto proyecto) {
        try {
            java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             proyecto.setCreadoEn(fechaSQL);
            // lineamiento.setModificadoEn(fechaSQL);

            PreparedStatement ps = null;

          //  String SQL = "select SQ_TB_ROL.nextval ID from dual";
          //  ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

          String SQL = "INSERT INTO TB_PROYECTO(ID_T_METODOLOGIA,ID_T_Idea,TituloProyecto,ResumenProyecto,ID_T_LV_EstadoProyecto,RutaProyecto,CreadoPor,CreadoEn,ModificadoPor,ModificadoEn) values(?,?,?,?,?,?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            ps.setInt(1,proyecto.getId_T_Metodologia());
            ps.setInt(2, proyecto.getId_T_Idea());
            ps.setString(3, proyecto.getTituloProyecto());
            ps.setString(4, proyecto.getResumenProyecto());
            ps.setInt(5, proyecto.getId_T_LV_estadoProyecto());
            ps.setString(6, proyecto.getRutaProyecto());
            ps.setString(7, proyecto.getCreadoPor());
            ps.setDate(8, proyecto.getCreadoEn());
            ResultSet rs =ps.executeQuery();
            //Falta capturar el Id del ultimo registro
            
            ps.close();
            //combo.setCodigo(id);            
            return proyecto.getID();
        } catch (SQLException e) {
            System.out.println("Error en Proyecto DAO" + e.getMessage());
            Logger.getLogger(ProyectoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return 0;
        }

    }*/

    
    
    public ArrayList<ProyectoRequest> getProyectos() {
        ArrayList<ProyectoRequest> list = new ArrayList<>(0);
        try {

            PreparedStatement ps = null;

           final String SQL = "SELECT p.ID,m.Descripcion, i.Titulo, p.TituloProyecto,p.ResumenProyecto, ld.valor,p.RutaProyecto, p.CreadoPor , p.CreadoEn,p.ModificadoPor,p.ModificadoEn FROM "
                    + " TB_Proyecto p JOIN TB_Metodologia m ON p.ID_T_METODOLOGIA=m.ID  "
                   + " LEFT JOIN TB_Idea i ON i.ID=p.ID_T_Idea "
                   + " JOIN TB_ListaValoresDetalle ld ON ld.ID=p.ID_T_LV_EstadoProyecto ORDER BY p.ID";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoRequest proyecto = new ProyectoRequest();
                proyecto.setId(rs.getInt("p.ID"));
                proyecto.setDescripcionMetodologia(rs.getString("m.Descripcion"));
                proyecto.setTitulo_idea(rs.getString("i.Titulo"));
                proyecto.setTitulo_proyecto(rs.getString("p.TituloProyecto"));
                proyecto.setResumen(rs.getString("p.ResumenProyecto"));
                proyecto.setValor(rs.getString("ld.valor"));
                proyecto.setRuta_proyecto(rs.getString("p.RutaProyecto"));
                proyecto.setCreadorPor(rs.getString("p.CreadoPor"));
                proyecto.setCreadoEn(rs.getDate("p.CreadoEn"));
                proyecto.setModificadoPor(rs.getString("p.ModificadoPor"));
                proyecto.setModificadoEn(rs.getDate("p.ModificadoEn"));

                list.add(proyecto);
            }
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(ProyectoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     
    public ArrayList<ProyectoRequest> getProyectoByTitulo(String titulo)  {
         ArrayList<ProyectoRequest> list = new ArrayList<>(0);
        try {

            PreparedStatement ps = null;

           final String SQL = "SELECT p.ID,m.Descripcion, i.Titulo, p.TituloProyecto,p.ResumenProyecto, ld.valor,p.RutaProyecto, p.CreadoPor , p.CreadoEn,p.ModificadoPor,p.ModificadoEn FROM "
                    + " TB_Proyecto p JOIN TB_Metodologia m ON p.ID_T_METODOLOGIA=m.ID  "
                   + " LEFT JOIN TB_Idea i ON i.ID=p.ID_T_Idea "
                   + " JOIN TB_ListaValoresDetalle ld ON ld.ID=p.ID_T_LV_EstadoProyecto WHERE p.TituloProyecto like '%"+titulo+"_' ORDER BY p.ID";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoRequest proyecto = new ProyectoRequest();
                proyecto.setId(rs.getInt("p.ID"));
                proyecto.setDescripcionMetodologia(rs.getString("m.Descripcion"));
                proyecto.setTitulo_idea(rs.getString("i.Titulo"));
                proyecto.setTitulo_proyecto(rs.getString("p.TituloProyecto"));
                proyecto.setResumen(rs.getString("p.ResumenProyecto"));
                proyecto.setValor(rs.getString("ld.valor"));
                proyecto.setRuta_proyecto(rs.getString("p.RutaProyecto"));
                proyecto.setCreadorPor(rs.getString("p.CreadoPor"));
                proyecto.setCreadoEn(rs.getDate("p.CreadoEn"));
                proyecto.setModificadoPor(rs.getString("p.ModificadoPor"));
                proyecto.setModificadoEn(rs.getDate("p.ModificadoEn"));

                list.add(proyecto);
            }
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(ProyectoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     
    public ProyectoRequest getProyectoById(int id) {
        
        
        try {
            
            ProyectoRequest proyecto = new ProyectoRequest();


            PreparedStatement ps = null;

           final String SQL = "SELECT p.ID,m.Descripcion, i.Titulo, p.TituloProyecto,p.ResumenProyecto, ld.valor,p.RutaProyecto, p.CreadoPor , p.CreadoEn,p.ModificadoPor,p.ModificadoEn FROM "
                    + " TB_Proyecto p JOIN TB_Metodologia m ON p.ID_T_METODOLOGIA=m.ID  "
                   + " LEFT JOIN TB_Idea i ON i.ID=p.ID_T_Idea "
                   + " JOIN TB_ListaValoresDetalle ld ON ld.ID=p.ID_T_LV_EstadoProyecto WHERE p.ID= "+id+" ORDER BY p.ID";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
             if (rs != null) {
                rs.next();
                proyecto.setId(rs.getInt("p.ID"));
                proyecto.setDescripcionMetodologia(rs.getString("m.Descripcion"));
                proyecto.setTitulo_idea(rs.getString("i.Titulo"));
                proyecto.setTitulo_proyecto(rs.getString("p.TituloProyecto"));
                proyecto.setResumen(rs.getString("p.ResumenProyecto"));
                proyecto.setValor(rs.getString("ld.valor"));
                proyecto.setRuta_proyecto(rs.getString("p.RutaProyecto"));
                proyecto.setCreadorPor(rs.getString("p.CreadoPor"));
                proyecto.setCreadoEn(rs.getDate("p.CreadoEn"));
                proyecto.setModificadoPor(rs.getString("p.ModificadoPor"));
                proyecto.setModificadoEn(rs.getDate("p.ModificadoEn"));

                
            }
            ps.close();
                       
            return proyecto;
        } catch (SQLException e) {
            Logger.getLogger(ProyectoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     
    public boolean deleteProyecto(int id) {
        try {
           

        

            String SQL = "DELETE FROM TB_Proyecto WHERE ID =" +id+" ";
            
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

                PreparedStatement ps = this.DBConnection.prepareStatement(SQL);
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en Proyecto DAO Delete "+ e.getMessage());
            Logger.getLogger(ProyectoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
     
    public boolean updateProyecto(Proyecto proyecto) {
        try {
             java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             //lineamiento.setCreadoEn(fechaSQL);
             proyecto.setModificadoEn(fechaSQL);
           

            PreparedStatement ps = null;
            String SQL = "UPDATE TB_Proyecto SET ID_T_METODOLOGIA = ?,TituloProyecto = ?,ResumenProyecto = ?,ID_T_LV_EstadoProyecto = ?, RutaProyecto= ?, CreadoPor= ?, CreadoEn= ?, ModificadoPor= ?, ModificadoEn= ? where ID = ?";
            ps = this.DBConnection.prepareStatement(SQL);
            
            ps.setInt(1, proyecto.getId_T_Metodologia());
            
            ps.setString(2, proyecto.getTituloProyecto());
            ps.setString(3, proyecto.getResumenProyecto());
            ps.setInt(4, proyecto.getId_T_LV_estadoProyecto());
            ps.setString(5, proyecto.getRutaProyecto());
            ps.setString(6, proyecto.getCreadoPor());
            ps.setDate(7, proyecto.getCreadoEn());
            ps.setString(8, proyecto.getModificadoPor());
            ps.setDate(9, proyecto.getModificadoEn());
            ps.setInt(10, proyecto.getID());
            
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en Proyecto DAO UPDATE "+ e.getMessage() );
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
    
     public ArrayList<ProyectoRequest> getProyectoByIdea(String idea)  {
         ArrayList<ProyectoRequest> list = new ArrayList<>(0);
        try {

            PreparedStatement ps = null;

           final String SQL = "SELECT p.ID,m.Descripcion, i.Titulo, p.TituloProyecto,p.ResumenProyecto, ld.valor,p.RutaProyecto, p.CreadoPor , p.CreadoEn,p.ModificadoPor,p.ModificadoEn FROM "
                    + " TB_Proyecto p JOIN TB_Metodologia m ON p.ID_T_METODOLOGIA=m.ID  "
                   + " LEFT JOIN TB_Idea i ON i.ID=p.ID_T_Idea "
                   + " JOIN TB_ListaValoresDetalle ld ON ld.ID=p.ID_T_LV_EstadoProyecto WHERE i.Titulo like '%"+idea+"%' ORDER BY p.ID";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoRequest proyecto = new ProyectoRequest();
                proyecto.setId(rs.getInt("p.ID"));
                proyecto.setDescripcionMetodologia(rs.getString("m.Descripcion"));
                proyecto.setTitulo_idea(rs.getString("i.Titulo"));
                proyecto.setTitulo_proyecto(rs.getString("p.TituloProyecto"));
                proyecto.setResumen(rs.getString("p.ResumenProyecto"));
                proyecto.setValor(rs.getString("ld.valor"));
                proyecto.setRuta_proyecto(rs.getString("p.RutaProyecto"));
                proyecto.setCreadorPor(rs.getString("p.CreadoPor"));
                proyecto.setCreadoEn(rs.getDate("p.CreadoEn"));
                proyecto.setModificadoPor(rs.getString("p.ModificadoPor"));
                proyecto.setModificadoEn(rs.getDate("p.ModificadoEn"));

                list.add(proyecto);
            }
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(ProyectoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }

    public ArrayList<Proyecto> getAllProyectos() {
        ArrayList<Proyecto> list = new ArrayList<>(0);
        try {

            PreparedStatement ps = null;

           final String SQL = "SELECT * from TB_PROYECTO";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proyecto proyecto = new Proyecto();
                proyecto.setID(rs.getInt("ID"));
                proyecto.setId_T_Metodologia(rs.getInt("ID_T_METODOLOGIA"));
                proyecto.setId_T_Idea(rs.getInt("ID_T_IDEA"));
                proyecto.setTituloProyecto(rs.getString("TITULOPROYECTO"));
                proyecto.setResumenProyecto(rs.getString("RESUMENPROYECTO"));
                proyecto.setId_T_LV_estadoProyecto(rs.getInt("ID_T_LV_ESTADOPROYECTO"));
                proyecto.setRutaProyecto(rs.getString("RUTAPROYECTO"));
                proyecto.setCreadoPor(rs.getString("CREADOPOR"));
                proyecto.setModificadoPor(rs.getString("MODIFICADOPOR"));
                proyecto.setCreadoEn(rs.getDate("CREADOEN"));
                proyecto.setModificadoEn(rs.getDate("MODIFICADOEN"));
                

                list.add(proyecto);
            }
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(ProyectoDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
 
    
}
