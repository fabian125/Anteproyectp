/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniajc.Anteproyecto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author luis.leon
 */
public class LeerPropiedades {

    public String leerArchivo(String leer) {
        try {

            /**
             * Creamos un Objeto de tipo Properties
             */
            Properties propiedades = new Properties();

            /**
             * Cargamos el archivo desde la ruta especificada
             */
            
                    
            
            propiedades.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/edu/uniajc/Anteproyecto/util/Configuracion.properties"));
            
            /**
             * Obtenemos los parametros definidos en el archivo
             */
            String nombre = propiedades.getProperty(leer);

            /**
             * Imprimimos los valores
             */
            System.out.println("Nombre: " + nombre);

            return nombre;

        } catch (FileNotFoundException e) {
            System.out.println("Error, El archivo no exite");
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            System.out.println("Error, No se puede leer el archivo");
            return "";
        }

    }
}
