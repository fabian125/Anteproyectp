/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.ILineamiento;
import edu.uniajc.anteproyecto.interfaces.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leon
 */
public class LineamientoDAO implements ILineamiento{

    private Connection DBConnection = null;

    public LineamientoDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }
 @Override
    public boolean createLineamiento(Lineamiento lineamiento) {
        try {
           

            PreparedStatement ps = null;

            String SQL = "select SQ_TB_ROL.nextval ID from dual";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            SQL = "insert into TB_Metodologia( ID,descripcion,creadoPor,creadoEn,modificadoPor,modificadoEn) values(?,?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            ps.setInt(1,lineamiento.getID());
            ps.setString(2, lineamiento.getDescripcion());
            ps.setString(3, lineamiento.getCreadoPor());
            ps.setDate(4, lineamiento.getCreadoEn());
            ps.setString(5, lineamiento.getModificadoPor());
            ps.setDate(6, lineamiento.getModificadoEn());
            ps.execute();
            ps.close();
            //combo.setCodigo(id);            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en LineamientoDao" + e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }

    
     @Override
    public ArrayList<Lineamiento> getLineamientos() {
        ArrayList<Lineamiento> list = new ArrayList<Lineamiento>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_Metodologia";
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
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     @Override
    public ArrayList<Lineamiento> getLineamientoByDirector(String director)  {
        ArrayList<Lineamiento> list = new ArrayList<Lineamiento>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_Metodologia where CreadoPor =" +director+" ";
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
            ps.close();
                       
            return list;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     @Override
    public Lineamiento getLineamientoById(int id) {
        
        Lineamiento lineamiento = new Lineamiento();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_Metodologia where ID =" +id+" ";
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
            ps.close();
                       
            return lineamiento;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     @Override
    public boolean deleteLineamiento(int id) {
        try {
           

            PreparedStatement ps = null;

            String SQL = "delete from TB_Metodologia where ID =" +id+" ";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            ps = this.DBConnection.prepareStatement(SQL);
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en LineamientoDao "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
     @Override
    public boolean updateLineamiento(Lineamiento lineamiento) {
        try {
           

            PreparedStatement ps = null;
            String SQL = "update TB_Metodologia set descripcion = ?,creadoPor = ?,creadoEn = ?,modificadoPor = ?,modificadoEn = ? where id = ?";
            ps = this.DBConnection.prepareStatement(SQL);
            
            ps.setString(1, lineamiento.getDescripcion());
            ps.setString(2, lineamiento.getCreadoPor());
            ps.setDate(3, lineamiento.getCreadoEn());
            ps.setString(4, lineamiento.getModificadoPor());
            ps.setDate(5, lineamiento.getModificadoEn());
            ps.setInt(6,lineamiento.getID());
            ps.execute();
            
            ps = this.DBConnection.prepareStatement(SQL);
           ps.execute();
                     ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en Lineamiento DAO "+ e.getMessage() );
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }

    @Override
    public List<Lineamiento> getLineamientoByFacultad(String facultad) {
        return null;
    }
    
}
