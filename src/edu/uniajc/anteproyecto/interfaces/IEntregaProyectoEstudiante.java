/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.EntregaProyectoEstudiante;
import edu.uniajc.anteproyecto.interfaces.model.MetodologiaModel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface IEntregaProyectoEstudiante {
    
    public int createEntrega(EntregaProyectoEstudiante entregaEstudiante);
    public List<MetodologiaModel> getMetodologia(int id,int corte);
    
}
