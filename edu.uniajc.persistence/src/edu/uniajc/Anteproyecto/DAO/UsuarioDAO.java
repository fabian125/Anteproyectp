/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis.leon
 */
public class UsuarioDAO {
    
    private Connection DBConnection = null;

    public UsuarioDAO (Connection openConnection) {
        this.DBConnection = openConnection;
    }
    
    
    
      public Usuario getUsuariobyUsername(String valor) throws SQLException {
       
        try {
            Usuario usuario=null;
           

            String SQL = "select * from TB_USUARIO where USUARIO  ='" + valor + "' ";
            //System.out.println(SQL);
             PreparedStatement ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
          if(rs != null){
                usuario=new Usuario();
                rs.next();
                usuario.setId(rs.getInt("ID"));
                usuario.setId_t_Persona(rs.getInt("ID_T_PERSONA"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setContrasena(rs.getString("CONTRASENA"));
                usuario.setId_t_lv_estadousuario(rs.getInt("ID_T_LV_ESTADOUSUARIO"));
                usuario.setCreadoPor(rs.getString("CREADOPOR"));
                usuario.setModificadoPor(rs.getString("MODIFICADOPOR"));
                usuario.setCreadoEn(rs.getDate("CREADOEN"));
                usuario.setModificadoEn(rs.getDate("MODIFICADOEN"));
               
                
               
               
               
            }
           ps.close();
           return usuario;
            
        } catch (SQLException e) {
            System.out.println("Error en  UsuarioDAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
      
     
      
      
      
      public int getUsuariobyidPersona(int id){
           try {
            Usuario usuario = new Usuario();
           

            String SQL = "select * from TB_USUARIO where ID_T_PERSONA  =" + id + " ";
            System.out.println(SQL);
             PreparedStatement ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
          if(rs != null){
                rs.next();
                usuario.setId(rs.getInt("ID"));
                usuario.setId_t_Persona(rs.getInt("ID_T_PERSONA"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setContrasena(rs.getString("CONTRASENA"));
                usuario.setId_t_lv_estadousuario(rs.getInt("ID_T_LV_ESTADOUSUARIO"));
                usuario.setCreadoPor(rs.getString("CREADOPOR"));
                usuario.setModificadoPor(rs.getString("MODIFICADOPOR"));
                usuario.setCreadoEn(rs.getDate("CREADOEN"));
                usuario.setModificadoEn(rs.getDate("MODIFICADOEN"));
               
                
               
               
               
            }
           ps.close();
           return usuario.getId();
            
        } catch (SQLException e) {
            System.out.println("Error en  UsuarioDAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return 0;
        }
      }
      
       public Usuario getUsuarioById(int id){
           try {
            Usuario usuario = new Usuario();
           

            String SQL = "select * from TB_USUARIO where ID  =" + id + " ";
            System.out.println(SQL);
             PreparedStatement ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
          if(rs != null){
                rs.next();
                usuario.setId(rs.getInt("ID"));
                usuario.setId_t_Persona(rs.getInt("ID_T_PERSONA"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setContrasena(rs.getString("CONTRASENA"));
                usuario.setId_t_lv_estadousuario(rs.getInt("ID_T_LV_ESTADOUSUARIO"));
                usuario.setCreadoPor(rs.getString("CREADOPOR"));
                usuario.setModificadoPor(rs.getString("MODIFICADOPOR"));
                usuario.setCreadoEn(rs.getDate("CREADOEN"));
                usuario.setModificadoEn(rs.getDate("MODIFICADOEN"));
               
                
               
               
               
            }
           ps.close();
           return usuario;
            
        } catch (SQLException e) {
            System.out.println("Error en  UsuarioDAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }
      }
    
}
