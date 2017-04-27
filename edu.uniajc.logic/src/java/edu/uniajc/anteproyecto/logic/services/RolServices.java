/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.RolDAO;
import javax.ejb.Stateless;
import edu.uniajc.anteproyecto.interfaces.IRol;
import edu.uniajc.anteproyecto.interfaces.model.Rol;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author shpreciado
 */
@Stateless
public class RolServices implements IRol{

    @Override
    public Rol createRol(String description, String typeRol, String createdBy, Date createdDate) {
        try {

            // si el role es igual a Admin se consulta la informacion, de lo contrario se retorna null
            if (!description.equals("") && !typeRol.equals("") && !createdBy.equals(""))
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/iris")).getConnection();
                RolDAO dao = new RolDAO(dbConnection);
                
                Date date = (createdDate == null)? new Date():createdDate;
                        
                Rol rol = dao.createRol(description, typeRol, createdBy, date);
                //consulta las ideas que conincidan con el nombre buscado
                return rol;
            } else {
                return null;
            }
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Rol> getRoles() {      
        try {
            Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/iris")).getConnection();
            RolDAO dao = new RolDAO(dbConnection);
            //consulta las ideas que conincidan con el nombre buscado
            ArrayList<Rol> list = dao.getRoles();
            return list;
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Rol> getRolesByType(String typeRol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol getRolById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
