/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.model.LineamientoDetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leon
 */
public class LineamientoDetalleDAO {

    private Connection DBConnection = null;

    public LineamientoDetalleDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }
     
    public boolean createLineamientoDetalle(LineamientoDetalle lineamientoDetalle) {
        try {
              java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             lineamientoDetalle.setCreadoEn(fechaSQL);
            // lineamiento.setModificadoEn(fechaSQL);

            PreparedStatement ps = null;

            String SQL = "select SQ_TB_ROL.nextval ID from dual";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            SQL = "insert into TB_MetodologiaDetalle( ID_T_Metodologia,descripcion,porcentaje,corte,creadoPor,creadoEn,modificadoPor,modificadoEn) values(?,?,?,?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
           //ps.setInt(1, lineamientoDetalle.getId());
            ps.setInt(1, lineamientoDetalle.getIdLineamiento());
            ps.setString(2, lineamientoDetalle.getDescripcion());
            ps.setDouble(3, lineamientoDetalle.getPorcentaje());
            ps.setInt(4, lineamientoDetalle.getCorte());
            ps.setString(5, lineamientoDetalle.getCreadoPor());
            ps.setDate(6, lineamientoDetalle.getCreadoEn());
            ps.setString(7, lineamientoDetalle.getModificadoPor());
            ps.setDate(8, lineamientoDetalle.getModificadoEn());
            ps.execute();
            ps.close();

            //combo.setCodigo(id);  
            
            return true ;
        } catch (SQLException e) {
            System.out.println("Error en  Lineamiento Detalle DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
     
    public List<LineamientoDetalle> getLineamientoDetalleByLineamiento(int lineamiento)  {
        ArrayList<LineamientoDetalle> list = new ArrayList<LineamientoDetalle>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_MetodologiaDetalle where ID_T_Metodologia =" + lineamiento + " ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LineamientoDetalle lineamientoDetalle = new LineamientoDetalle();

                lineamientoDetalle.setId(rs.getInt("ID"));
                lineamientoDetalle.setIdLineamiento(rs.getInt("ID_T_Metodologia"));
                lineamientoDetalle.setDescripcion(rs.getString("descripcion"));
                lineamientoDetalle.setPorcentaje(rs.getDouble("porcentaje"));
                lineamientoDetalle.setCorte(rs.getInt("corte"));
                lineamientoDetalle.setCreadoPor(rs.getString("creadoPor"));
                lineamientoDetalle.setCreadoEn(rs.getDate("creadoEn"));
                lineamientoDetalle.setModificadoPor(rs.getString("modificadoPor"));
                lineamientoDetalle.setModificadoEn(rs.getDate("modificadoEn"));

                list.add(lineamientoDetalle);
            }
            ps.close();
            return list;
        } catch (SQLException e) {
            System.out.println("Error en  Lineamiento Detalle DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     
    public LineamientoDetalle getLineamientoDetalleById(int id)  {

        LineamientoDetalle lineamientoDetalle = new LineamientoDetalle();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_MetodologiaDetalle where ID =" + id + " ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
               rs.next();

                lineamientoDetalle.setId(rs.getInt("ID"));
                lineamientoDetalle.setIdLineamiento(rs.getInt("ID_T_Metodologia"));
                lineamientoDetalle.setDescripcion(rs.getString("descripcion"));
                lineamientoDetalle.setPorcentaje(rs.getDouble("porcentaje"));
                lineamientoDetalle.setCorte(rs.getInt("corte"));
                lineamientoDetalle.setCreadoPor(rs.getString("creadoPor"));
                lineamientoDetalle.setCreadoEn(rs.getDate("creadoEn"));
                lineamientoDetalle.setModificadoPor(rs.getString("modificadoPor"));
                lineamientoDetalle.setModificadoEn(rs.getDate("modificadoEn"));

            }
            ps.close();
            return lineamientoDetalle;
        } catch (SQLException e) {
            System.out.println("Error en  Lineamiento Detalle DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
    
    public ArrayList<LineamientoDetalle> getLineamientosDetalle() {

        ArrayList<LineamientoDetalle> list = new ArrayList<LineamientoDetalle>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_MetodologiaDetalle";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LineamientoDetalle lineamientoDetalle = new LineamientoDetalle();
                lineamientoDetalle.setId(rs.getInt("ID"));
                lineamientoDetalle.setIdLineamiento(rs.getInt("ID_T_Metodologia"));
                lineamientoDetalle.setDescripcion(rs.getString("descripcion"));
                lineamientoDetalle.setPorcentaje(rs.getDouble("porcentaje"));
                lineamientoDetalle.setCorte(rs.getInt("corte"));
                lineamientoDetalle.setCreadoPor(rs.getString("creadoPor"));
                lineamientoDetalle.setCreadoEn(rs.getDate("creadoEn"));
                lineamientoDetalle.setModificadoPor(rs.getString("modificadoPor"));
                lineamientoDetalle.setModificadoEn(rs.getDate("modificadoEn"));
                list.add(lineamientoDetalle);
            }
            ps.close();
            return list;
        } catch (SQLException e) {
            System.out.println("Error en  Lineamiento Detalle DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
     
    public boolean deleteLineamientoDetalle(int ID){
         try {
           

            PreparedStatement ps = null;

            String SQL = "delete from TB_MetodologiaDetalle where ID =" +ID+" ";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            ps = this.DBConnection.prepareStatement(SQL);

            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en  Lineamiento Detalle DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }
    }
     
    public boolean updateLineamientoDetalle(LineamientoDetalle lineamientoDetalle){
        try {
            java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             //lineamientoDetalle.setCreadoEn(fechaSQL);
             lineamientoDetalle.setModificadoEn(fechaSQL);

            PreparedStatement ps = null;
            
            String SQL = "update TB_MetodologiaDetalle set  ID_T_Metodologia = ?,descripcion=?,porcentaje=?,corte =?,creadoPor =?,creadoEn =?,modificadoPor=?,modificadoEn=? where ID = ?";
            ps = this.DBConnection.prepareStatement(SQL);
          
            ps.setInt(1, lineamientoDetalle.getIdLineamiento());
            ps.setString(2, lineamientoDetalle.getDescripcion());
            ps.setDouble(3, lineamientoDetalle.getPorcentaje());
            ps.setInt(4, lineamientoDetalle.getCorte());
            ps.setString(5, lineamientoDetalle.getCreadoPor());
            ps.setDate(6, lineamientoDetalle.getCreadoEn());
            ps.setString(7, lineamientoDetalle.getModificadoPor());
            ps.setDate(8, lineamientoDetalle.getModificadoEn());
            ps.setInt(9, lineamientoDetalle.getId());
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en  Lineamiento Detalle DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
}
