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
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leon
 */
public class LineamientoDAO {

    private Connection DBConnection = null;

    public LineamientoDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }

    public Lineamiento createLineamiento(int ID, String descripcion, String creadoPor, Date creadoEn, String modificadoPor, Date modificadoEn) {
        try {
            Lineamiento lineamiento = new Lineamiento();
            lineamiento.setID(ID);
            lineamiento.setDescripcion(descripcion);
            lineamiento.setCreadoPor(creadoPor);
            lineamiento.setCreadoEn(creadoEn);
            lineamiento.setModificadoPor(modificadoPor);
            lineamiento.setModificadoEn(modificadoEn);

            PreparedStatement ps = null;

            String SQL = "select SQ_TB_ROL.nextval ID from dual";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            SQL = "insert into TB_Lineamiento( ID,descripcion,creadoPor,creadoEn,modificadoPor,modificadoEn) values(?,?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            ps.setInt(1,lineamiento.getID());
            ps.setString(2, lineamiento.getDescripcion());
            ps.setString(3, lineamiento.getCreadoPor());
            ps.setDate(4, lineamiento.getCreadoEn());
            ps.setString(5, lineamiento.getModificadoPor());
            ps.setDate(6, lineamiento.getModificadoEn());
            ps.execute();

            //combo.setCodigo(id);            
            return lineamiento;
        } catch (SQLException e) {
            System.out.println("Error en LineamientoDao" + e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }

    
    
    public ArrayList<Lineamiento> getLineamientos() throws SQLException {
        ArrayList<Lineamiento> list = new ArrayList<Lineamiento>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_Lineamiento";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lineamiento lineamiento = new Lineamiento();
                lineamiento.setID(rs.getInt("ID"));
                lineamiento.setDescripcion(rs.getString("Descripcion"));
                lineamiento.setCreadoPor(rs.getString("CreadoPor"));
                lineamiento.setCreadoEn(rs.getDate("CreadoEn"));
                lineamiento.setModificadoPor(rs.getString("ModificadoPor"));
                lineamiento.setModificadoEn(rs.getDate("ModificadoEn"));
                list.add(lineamiento);
            }

                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
    
    public ArrayList<Lineamiento> getLineamientoByDirector(String director) throws SQLException {
        ArrayList<Lineamiento> list = new ArrayList<Lineamiento>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_Lineamiento where CreadoPor =" +director+" ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lineamiento lineamiento = new Lineamiento();
                lineamiento.setID(rs.getInt("ID"));
                lineamiento.setDescripcion(rs.getString("Descripcion"));
                lineamiento.setCreadoPor(rs.getString("CreadoPor"));
                lineamiento.setCreadoEn(rs.getDate("CreadoEn"));
                lineamiento.setModificadoPor(rs.getString("ModificadoPor"));
                lineamiento.setModificadoEn(rs.getDate("ModificadoEn"));
                list.add(lineamiento);
            }

                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
    
    public Lineamiento getLineamientoById(int id) throws SQLException {
        
        Lineamiento lineamiento = new Lineamiento();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_Lineamiento where ID =" +id+" ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
            rs.first();
                
                lineamiento.setID(rs.getInt("ID"));
                lineamiento.setDescripcion(rs.getString("Descripcion"));
                lineamiento.setCreadoPor(rs.getString("CreadoPor"));
                lineamiento.setCreadoEn(rs.getDate("CreadoEn"));
                lineamiento.setModificadoPor(rs.getString("ModificadoPor"));
                lineamiento.setModificadoEn(rs.getDate("ModificadoEn"));
                
            }

                       
            return lineamiento;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
    
    public Boolean deleteLineamiento(int id) {
        try {
           

            PreparedStatement ps = null;

            String SQL = "delete * from TB_Lineamiento where ID =" +id+" ";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            ps = this.DBConnection.prepareStatement(SQL);

            return ps.execute();

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
    public Boolean updateLineamiento(Lineamiento lineamiento) {
        try {
           

            PreparedStatement ps = null;
            String SQL = "update TB_Lineamiento set descripcion = ?,creadoPor = ?,creadoEn = ?,modificadoPor = ?,modificadoEn = ? where id = ?";
            ps = this.DBConnection.prepareStatement(SQL);
            
            ps.setString(1, lineamiento.getDescripcion());
            ps.setString(2, lineamiento.getCreadoPor());
            ps.setDate(3, lineamiento.getCreadoEn());
            ps.setString(4, lineamiento.getModificadoPor());
            ps.setDate(5, lineamiento.getModificadoEn());
            ps.setInt(6,lineamiento.getID());
            ps.execute();
            
            ps = this.DBConnection.prepareStatement(SQL);

            return ps.execute();

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en Lineamiento DAO "+ e.getMessage() );
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
    
}
