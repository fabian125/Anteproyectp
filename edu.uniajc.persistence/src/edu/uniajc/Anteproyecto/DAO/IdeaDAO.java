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

/**
 *
 * @author Leon
 */
public class IdeaDAO {

    private Connection DBConnection = null;

    public IdeaDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }
 
    public boolean createIdea(Idea idea) {
        try {
            java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            idea.setCREADOEN(fechaSQL);
            idea.setMODIFICADOEN(fechaSQL);
             
            // lineamiento.setModificadoEn(fechaSQL);

            PreparedStatement ps = null;

            String SQL = "select SQ_TB_ROL.nextval ID from dual";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            SQL = "insert into TB_IDEA(ID,TITULO,DESCRIPCION,PALABRASCLAVE,CREADOPOR,CREADOEN,MODIFICADOPOR,MODIFICADOEN) values(?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            
            ps.setInt(1, idea.getID());
            ps.setString(2, idea.getTITULO());
            ps.setString(3, idea.getDESCRIPCION());
            ps.setString(4, idea.getPALABRASCLAVE());
            ps.setString(5, idea.getCREADOPOR());
            ps.setDate(6, idea.getCREADOEN());
            ps.setString(7, idea.getMODIFICADOPOR());
            ps.setDate(8,idea.getMODIFICADOEN());
            ps.execute();
            ps.close();
            //combo.setCodigo(id);            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en IdeaDao" + e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }


        public ArrayList<Idea> getIdea(){
        ArrayList<Idea> list = new ArrayList<Idea>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_IDEA";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              
                Idea idea = new Idea();
                idea.setID(rs.getInt("ID"));
                idea.setTITULO(rs.getString("TITULO"));
                idea.setDESCRIPCION(rs.getString("DESCRIPCION"));
                idea.setPALABRASCLAVE(rs.getString("PALABRASCLAVE"));
                idea.setCREADOPOR(rs.getString("CREADOPOR"));
                idea.setCREADOEN(rs.getDate("CREADOEN"));
                idea.setMODIFICADOPOR(rs.getString("MODIFICADOPOR"));
                idea.setMODIFICADOEN(rs.getDate("MODIFICADOEN"));
                list.add(idea);
            }
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
 
     
    public boolean deleteIdea(int ID) {
        try {
           

            PreparedStatement ps = null;

            String SQL = "delete from TB_IDEA where ID =" +ID+" ";
           
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            ps = this.DBConnection.prepareStatement(SQL);
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en IdeaDAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
     
    public boolean updateIdea(Idea idea) {
        try {
             java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             //lineamiento.setCreadoEn(fechaSQL);
           idea.setMODIFICADOEN(fechaSQL);
           

            PreparedStatement ps = null;
            String SQL = "update TB_IDEA set descripcion = ?,creadoPor = ?,creadoEn = ?,modificadoPor = ?,modificadoEn = ? where id = ?";
            ps = this.DBConnection.prepareStatement(SQL);
            
            ps.setInt(1, idea.getID());
            ps.setString(2, idea.getTITULO());
            ps.setString(3, idea.getDESCRIPCION());
            ps.setString(4, idea.getPALABRASCLAVE());
            ps.setString(5, idea.getCREADOPOR());
            ps.setDate(6, idea.getCREADOEN());
            ps.setString(7, idea.getMODIFICADOPOR());
            ps.setDate(8,idea.getMODIFICADOEN());
            ps.execute();
            ps.close();
            return true;
    

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en IdeaDAO "+ e.getMessage() );
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }

    
    
        public List<Idea> getIdeaByUsuario(int usuario){
        return null;
    }
    
}
