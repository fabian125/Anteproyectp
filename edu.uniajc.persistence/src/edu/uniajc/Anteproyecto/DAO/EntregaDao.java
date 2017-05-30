/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.model.EntregaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jarteaga
 */
public class EntregaDao 
{
    
     private Connection DBConnection = null;

    public EntregaDao(Connection openConnection) {
        this.DBConnection = openConnection;
    }
    
     public boolean createEntrega(EntregaModel entrega) {
        try {
            java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             entrega.setCreadoEn(fechaSQL);
         

            PreparedStatement ps = null;

//            String SQL = "select SQ_TB_Entrega.nextval ID from dual";
//            ps = this.DBConnection.prepareStatement(SQL);
//            ResultSet rs = ps.executeQuery();
//            int codigo = 0;
//            
//            if(rs.next())
//            {
//                codigo=rs.getInt("ID");
//                entrega.setId(codigo);
//            }

           String SQL = "INSERT INTO TB_ENTREGA(ID_T_PROYECTO,ID_T_LV_PERIODOENTREGA, ID_T_LV_TIPOCALIFICACION, ID_T_LV_ESTADOENTREGA,ESTADOAPROBACION,CALIFICACION, FECHAENTREGA, RUTAPROYECTO,OBSERVACION, CREADOPOR,CREADOEN, MODIFICADOPOR,MODIFICADOEN) values(?,?,?,?,?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            ps.setInt(1,entrega.getId_proyecto());           
            ps.setInt(2, entrega.getId_periodo_entrega());
            ps.setInt(3, entrega.getId_tipo_calificacion());
            ps.setInt(4, entrega.getId_estado_entrega());
            ps.setInt(5, entrega.getEstado_aprobacion());
            ps.setFloat(6, entrega.getCalificacion());
            ps.setDate(7, entrega.getFecha_entrega());
            ps.setString(8, entrega.getRuta_proyecto());
            ps.setString(9, entrega.getObservacion());
            ps.setString(10, entrega.getCreadoPor());
            ps.setDate(11, entrega.getCreadoEn());
            ps.setString(12, entrega.getModificadoPor());
            ps.setDate(13, entrega.getModificadoEn());

            ps.execute();
            //Falta capturar el Id del ultimo registro
            
            ps.close();
           
            //Le asigno el id al objeto proyecto
          //  System.out.println("Codigo de Proyecto"+codigo);
           
            return true;
        } catch (SQLException e) {
            System.out.println("Error en Proyecto DAO" + e.getMessage());
            Logger.getLogger(EntregaDao.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
     
     
      public boolean updateEntrega(EntregaModel entrega) {
        try {
             java.util.Date fecha = new java.util.Date();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
             //lineamiento.setCreadoEn(fechaSQL);
             entrega.setModificadoEn(fechaSQL);
           

            PreparedStatement ps = null;
            String SQL = "UPDATE TB_ENTREGA SET ID_T_PROYECTO = ?,ID_T_LV_PERIODOENTREGA = ?,ID_T_LV_TIPOCALIFICACION = ?,ID_T_LV_ESTADOENTREGA = ?, ESTADOAPROBACION= ?, CALIFICACION= ?, FECHAENTREGA= ?, RUTAPROYECTO= ?, OBSERVACION= ?, CREADOPOR=?, CREADOEN= ?, MODIFICADOPOR= ?, MODIFICADOEN= ? WHERE ID = ?";
            ps = this.DBConnection.prepareStatement(SQL);
            
            ps.setInt(1, entrega.getId_proyecto());
            
            ps.setInt(2, entrega.getId_periodo_entrega());
            ps.setInt(3, entrega.getId_tipo_calificacion());
            ps.setInt(4, entrega.getId_estado_entrega());
            ps.setInt(5, entrega.getEstado_aprobacion());
            ps.setFloat(6, entrega.getCalificacion());
            ps.setDate(7, entrega.getFecha_entrega());
            ps.setString(8, entrega.getRuta_proyecto());
            ps.setString(9, entrega.getObservacion());
            ps.setString(10, entrega.getCreadoPor());
            ps.setDate(11, entrega.getCreadoEn());
            ps.setString(12, entrega.getModificadoPor());
            ps.setDate(13, entrega.getModificadoEn());
            ps.setInt(14, entrega.getId());
            
            
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en ENTREGADAO UPDATE "+ e.getMessage() );
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
      
      public boolean deleteEntrega(int id) {
        try {
           

            PreparedStatement ps = null;

            String SQL = "DELETE FROM TB_ENTREGA WHERE ID =" +id+" ";
           
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            ps = this.DBConnection.prepareStatement(SQL);
            ps.execute();
            ps.close();
            return true;

            //combo.setCodigo(id);            
             
        } catch (SQLException e) {
            System.out.println("Error en Delete EntregaDao "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }

    }
    
    
    
}

