/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.DAO;

import edu.uniajc.anteproyecto.interfaces.model.ListaValoresDetalle;
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
public class ListaValoresDetalleDAO {

    private Connection DBConnection = null;

    public ListaValoresDetalleDAO (Connection openConnection) {
        this.DBConnection = openConnection;
    }


    public List<ListaValoresDetalle> getListaValorDetallebyID_Lista_Valor(int id_ListaValor) throws SQLException {
        ArrayList<ListaValoresDetalle> list = new ArrayList<ListaValoresDetalle>();
        try {

            PreparedStatement ps = null;

            String SQL = "select * from TB_LISTAVALORESDETALLE where ID_T_LISTAVALORES =" + id_ListaValor + " ";
            ps = this.DBConnection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ListaValoresDetalle listaValorDetalle = new ListaValoresDetalle();

                listaValorDetalle.setId(rs.getInt("ID"));
                listaValorDetalle.setId_T_Listavalores(rs.getInt("ID_T_LISTAVALORES"));
                listaValorDetalle.setDescripcion(rs.getString("DESCRIPCION"));
                listaValorDetalle.setValor(rs.getString("VALOR"));
                listaValorDetalle.setCreadoPor(rs.getString("CREADOPOR"));
                listaValorDetalle.setCreadoEn(rs.getDate("CREADOEN"));
                listaValorDetalle.setModificadoPor(rs.getString("MODIFICADOPOR"));
                listaValorDetalle.setModificadoEn(rs.getDate("MODIFICADOEN"));
 
                list.add(listaValorDetalle);
            }
            ps.close();
            return list;
        } catch (SQLException e) {
            System.out.println("Error en  ListaValoresDetalle DAO "+ e.getMessage());
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return null;
        }

    }
}