/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.logic.services;

import edu.uniajc.Anteproyecto.DAO.PersonaDAO;
import edu.uniajc.anteproyecto.interfaces.IPersona;
import edu.uniajc.anteproyecto.interfaces.model.Persona;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author luis.leon
 */
@Stateless
public class PersonaServices implements IPersona{

    @Override
    public Persona getPersonabyId(int numero) {
         try {

           
                // se adquiere la conexion a base de datos desde el servidor de aplicaciones
               // Connection dbConnection = ((DataSource) new InitialContext().lookup("jdbc/sample")).getConnection();
                ConexionBD cn = new ConexionBD(); 
              PersonaDAO dao = new PersonaDAO(cn.conexion());
                	

                
               Persona persona = dao.getPersonabyId(numero);
                 cn.conexion().close();
                
                return persona;
           
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
