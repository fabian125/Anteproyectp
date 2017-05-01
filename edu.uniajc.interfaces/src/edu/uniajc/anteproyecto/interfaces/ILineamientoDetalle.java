/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.Lineamiento;
import edu.uniajc.anteproyecto.interfaces.model.LineamientoDetalle;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Leon
 */
public interface ILineamientoDetalle {
    
    public LineamientoDetalle createLineamientoDetalle(int id,    int idLineamiento,    String descripcion,    Double porcentaje,    int corte,    String dreadoPor,    Date creadoEn,    String modificadoPor,    Date modificadoEn);
    
    public List<LineamientoDetalle> getLineamientoByLineamiento(int lineamiento);
   
    public LineamientoDetalle getLineamientoDetalleById(int id);
}
