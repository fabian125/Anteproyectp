/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

/**
 *
 * @author jarteaga
 */

    


import edu.uniajc.anteproyecto.interfaces.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shpreciado
 */
public class ListaValoresDAO {
    
    private Connection DBConnection = null;

    public ListaValoresDAO(Connection openConnection) {
        this.DBConnection = openConnection;
    }    

    public ListaValor createListaValor(int id, String agrupacion, String descripcion, String valor) {
        try {
            ListaValor combo = new ListaValor();
            //combo.setCodigo(id);
            combo.setAgrupacion(agrupacion);
            combo.setDescripcion(descripcion);
            combo.setValor(valor);
            
            PreparedStatement ps = null;
            
            String SQL = "select SQ_TB_ROL.nextval ID from dual";
            ps = this.DBConnection.prepareStatement(SQL);
            //ResultSet rs = ps.executeQuery();
            //int codigo = rs.getInt("ID");

            SQL = "insert into TB_LISTAVALORES(id, agrupacion, descripcion, valor) values(?,?,?,?)";
            ps = this.DBConnection.prepareStatement(SQL);
            ps.setInt(1, 1);
            ps.setString(2, combo.getAgrupacion());
            ps.setString(3, combo.getDescripcion());
            ps.setString(4, combo.getValor());
            ps.execute();
            
            combo.setCodigo(id);            
            return combo;
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
    };
}