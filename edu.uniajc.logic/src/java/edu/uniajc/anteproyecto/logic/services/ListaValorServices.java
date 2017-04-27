/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.*;
import edu.uniajc.anteproyecto.interfaces.IListaValor;
import edu.uniajc.anteproyecto.interfaces.model.ListaValor;
import edu.uniajc.anteproyecto.interfaces.model.Rol;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author jarteaga
 */
@Stateless
public class ListaValorServices  implements IListaValor{

    @Override
    public ListaValor createListaValor(int id, String agrupacion, String descripcion, String valor) {
        try {

            // si el role es igual a Admin se consulta la informacion, de lo contrario se retorna null
            if (!agrupacion.equals("") && !descripcion.equals("") && !valor.equals("") && !String.valueOf(id).equals(""))
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ListaValoresDAO dao = new ListaValoresDAO(dbConnection);
                	

                
                ListaValor listavalor = dao.createListaValor(id, agrupacion, descripcion, valor);
                //consulta las ideas que conincidan con el nombre buscado
                return listavalor;
            } else {
                return null;
            }
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
