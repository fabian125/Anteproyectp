/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *@author Fabian Castro - IRIS
 *16/05/2017
 * Nombre Clase:IIntegrantes
 * Descripcion: interface de la clase Integrantes
 */
@Local
public interface IIntegrantes {
        
    public boolean createintegrantes(Integrantes integrantes);
    public boolean deleteIntegrantes(int ID);
    public boolean deleteIntegrantesByProyecto(int id);
    public boolean updateIntegrantes(Integrantes integrantes);
    public Integrantes getIntegrantesByTipoIntegrante(int ID_T_LV_TIPOINTEGRANTE);   
    public List<Integrantes> getIntegrantesByProyecto(int ID_T_Proyecto);
    public boolean deleteIntegrantesbyUserandProyect(int iduser, int idProy);
    public ArrayList<Integrantes> getIntegrantesByTipoIntegrantes(int ID_T_LV_TIPOINTEGRANTE );
    
   

}
