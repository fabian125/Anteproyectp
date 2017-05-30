/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.EntregaDao;
import edu.uniajc.anteproyecto.interfaces.IEntrega;
import edu.uniajc.anteproyecto.interfaces.model.EntregaModel;
import javax.ejb.Stateless;

/**
 *
 * @author jarteaga
 */

@Stateless
public class EntregaServices implements IEntrega{

    @Override
    public boolean createEntrega(EntregaModel entrega) {
         try {

            // validacion de Data
            if (entrega != null)
            {
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD();
                EntregaDao dao = new EntregaDao(cn.conexion());
                	

                
                boolean flag = dao.createEntrega(entrega);
                 cn.conexion().close();
               
                        
                return flag;
            } else {
                System.out.println("Faltan Datos en pantalla");
                return false;
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateEntrega(EntregaModel entrega) {
         try {

                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
               ConexionBD cn = new ConexionBD(); 
               EntregaDao dao = new EntregaDao(cn.conexion());
               dao.updateEntrega(entrega);
               cn.conexion().close();

                
               return true;
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    

    @Override
    public boolean deleteEntrega(int id) {
 try {

                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
                //Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
              ConexionBD cn = new ConexionBD();
              EntregaDao dao = new EntregaDao(cn.conexion());
              dao.deleteEntrega(id);
              cn.conexion().close();

               return true;
    
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
