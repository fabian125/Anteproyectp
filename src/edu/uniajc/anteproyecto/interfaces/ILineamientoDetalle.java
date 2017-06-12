/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;


import edu.uniajc.anteproyecto.interfaces.model.LineamientoDetalle;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leon
 */
@Local
public interface ILineamientoDetalle {
    
    public boolean createLineamientoDetalle(LineamientoDetalle lineamientoDetalle);
    public boolean deleteLineamientoDetalle(int ID);

    public boolean updateLineamientoDetalle(LineamientoDetalle lineamientoDetalle);
    public List<LineamientoDetalle> getLineamientoDetalleByLineamiento(int lineamiento);
    public LineamientoDetalle getLineamientoDetalleById(int id);
    public ArrayList<LineamientoDetalle> getLineamientosDetalle();
    
    
}
