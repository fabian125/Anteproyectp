/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.model.Persona;
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
 * @author luis.leon
 */
public class PersonaDAO {
    
    private Connection DBConnection = null;

    public PersonaDAO (Connection openConnection) {
        this.DBConnection = openConnection;
    }
    
    public Persona getPersonabyId(int numero ) throws SQLException {
       
        try {
  Persona persona = new Persona();
            PreparedStatement ps;

            String SQL = "select * from TB_PERSONA where ID =" + numero + " ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
          if(rs != null){
            rs.next();
              

                persona.setId(rs.getInt("ID"));
                persona.setId_T_LV_TIPOIDENTIFICACION(rs.getInt("ID_T_LV_TIPOIDENTIFICACION"));
                persona.setNumeroidentificacion(rs.getInt("NUMIDENTIFICACION"));
                persona.setNombres(rs.getString("NOMBRES"));
               persona.setPrimerapellido(rs.getString("PRIMERAPELLIDO"));
               persona.setSegundoapellido(rs.getString("SEGUNDOAPELLIDO"));
               persona.setTelefonofijo(rs.getString("TELEFONOFIJO"));
               persona.setTelefonocelular(rs.getString("TELEFONOCELULAR"));
               persona.setEmail(rs.getString("EMAIL"));
               persona.setId_T_LV_TIPOUSUARIO(rs.getInt("ID_T_LV_TIPOUSUARIO"));
               persona.setCreadopor(rs.getString("CREADOPOR"));
               persona.setCreadoen(rs.getDate("CREADOEN"));
               persona.setModificadopor(rs.getString("MODIFICADOPOR"));
               persona.setModificadoEn(rs.getDate("MODIFICADOEN"));
               
                ps.close();
               
            }
           return persona;
            
        } catch (SQLException e) {
            System.out.println("Error en  ListaValoresDetalle DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
    
    
    
}
