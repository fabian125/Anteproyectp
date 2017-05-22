/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.anteproyecto.interfaces;

import edu.uniajc.anteproyecto.interfaces.model.Usuario;

/**
 *
 * @author luis.leon
 */
public interface IUsuario {
    public Usuario getUsuariobyUsername(String usuario);
    public int getUsuariobyidPersona(int idPersona);
    public Usuario getUsuarioById(int id);
}
