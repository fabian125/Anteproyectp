/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
hector prueba
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.model.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shpreciado
 */
public class RolDAO {
    
    private Connection DBConnection = null;

    public RolDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }    

    public Rol createRol(String description, String typeRol, String createdBy, Date createdDate) {
        try {
            Rol rol = new Rol();
            rol.setDescripcion(description);
            rol.setTipo(typeRol);
            rol.setCreadoPor(createdBy);
            rol.setCreadoEn(createdDate);
            
            PreparedStatement ps = null;
            
            String SQL = "select SQ_TB_ROL.nextval ID from dual";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            int id = rs.getInt("ID");

            SQL = "insert into TB_ROL(id, descripcion, tipo, creadoPor, creadoEn) value(?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setString(2, rol.getDescripcion());
            ps.setString(3, rol.getTipo());
            ps.setString(4, rol.getCreadoPor());
            ps.setDate(5, (java.sql.Date) rol.getCreadoEn());
            ps.execute();
            
            rol.setId(id);            
            return rol;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
    };
    
    public ArrayList<Rol> getRoles() {
        ArrayList<Rol> items = new ArrayList<>(0);

        try {
            
            PreparedStatement ps = null;
            
            String SQL = "select * from TB_ROL";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rol rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setTipo(rs.getString("tipo"));
                rol.setCreadoPor(rs.getString("creadopor"));
                rol.setCreadoEn(rs.getDate("creadoen"));
                rol.setModificadoPor(rs.getString("modificadopor"));
                rol.setModificadoEn(rs.getDate("modificadoen"));
                items.add(rol);
            }        

            return items;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
    };
    
}
