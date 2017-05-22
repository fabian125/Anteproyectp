/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.UsuarioDAO;
import edu.uniajc.anteproyecto.interfaces.IUsuario;
import edu.uniajc.anteproyecto.interfaces.model.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author luis.leon
 */
@Stateless
public class UsuarioServices implements IUsuario{

    @Override
    public Usuario getUsuariobyUsername(String username) {
         try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
              ConexionBD cn = new ConexionBD(); 
              UsuarioDAO dao = new UsuarioDAO(cn.conexion());
                	

                
               Usuario usuario = dao.getUsuariobyUsername(username);
                 cn.conexion().close();
                
                return usuario;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int getUsuariobyidPersona(int idPersona) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
              ConexionBD cn = new ConexionBD(); 
              UsuarioDAO dao = new UsuarioDAO(cn.conexion());
                	

                
               int resultado= dao.getUsuariobyidPersona(idPersona);
                 cn.conexion().close();
                
                return resultado;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
     @Override
    public Usuario getUsuarioById(int id) {
        try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
              ConexionBD cn = new ConexionBD(); 
              UsuarioDAO dao = new UsuarioDAO(cn.conexion());
                	

                
               Usuario resultado= dao.getUsuarioById(id);
                 cn.conexion().close();
                
                return resultado;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
