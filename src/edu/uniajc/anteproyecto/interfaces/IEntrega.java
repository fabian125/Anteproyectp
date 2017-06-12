/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.EntregaModel;
import javax.ejb.Local;

/**
 *
 * @author jarteaga
 */
@Local
public interface IEntrega {
        public boolean createEntrega(EntregaModel entrega);
                public boolean updateEntrega(EntregaModel entrega);
                public boolean deleteEntrega(int id);


    
}
