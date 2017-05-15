/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.*;
import edu.uniajc.anteproyecto.interfaces.*;

import edu.uniajc.anteproyecto.interfaces.model.*;
import java.util.List;
import javax.ejb.Stateless;
/**
 *
 * @author Leon
 */
@Stateless
public class ListaValorDetalleServices implements IListaValoresDetalle{


    @Override
    public List<ListaValoresDetalle> getListaValorDetallebyID_Lista_Valor(int id_ListaValor) {
         try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD(); 
              ListaValoresDetalleDAO dao = new ListaValoresDetalleDAO(cn.conexion());
                	

                
                List<ListaValoresDetalle> list = dao.getListaValorDetallebyID_Lista_Valor(id_ListaValor);
                 cn.conexion().close();
                
                return list;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
