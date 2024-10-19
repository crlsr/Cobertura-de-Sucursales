/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXTRAS;

/**
 * Clase Estacion
 * Representa una estación de tren o metro que pertenece a una línea.
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Estacion {
    
    /**
     * @param nombre variable privada de tipo string que contiene el nombre de la estación.
     * @param linea variable privada de tipo string que contiene la línea a la que pertenece la estación.
     * @param sucursal variable privada booleana que indica si la estación tiene una sucursal.
     * @param cubierto variable privada booleana que indica si la estacion esta cubierta por el radio t de otra estacion.
     */
    private String nombre;
    private String linea;
    private boolean sucursal;
    private boolean cubierto;

    /**
     * Constructor de la clase Estacion.
     * Crea una estación con nombre y línea, con los valores sucursal y cubierto en false.
     * 
     * @param nombre variable String con el nombre de la estación.
     * @param linea variable String con el nombre de la línea a la que pertenece la estación.
     * @author Pedro Sebastiano
     */
    public Estacion(String nombre, String linea) {
        this.nombre = nombre;
        this.linea = linea;
        this.sucursal = false;
        this.cubierto = false;
    }

    /**
     * Obtiene el nombre de la estación.
     * 
     * @return variable de tipo string con el nombre de la estación.
     * @author Pedro Sebastiano
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre de la estación.
     * 
     * @param nombre variable de tipo String con el nuevo nombre de la estación.
     * @author Pedro Sebastiano
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la línea a la que pertenece la estación.
     * 
     * @return variable de tipo String con el nombre de la línea a la que pertenece la estación.
     * @author Pedro Sebastiano
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Cambia la línea a la que pertenece la estación.
     * 
     * @param linea variable de tipo String con la nueva línea a la que pertenece la estación.
     * @author Pedro Sebastiano
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene si la estación es una sucursal.
     * 
     * @return true si la estación tiene una sucursal, false en caso contrario.
     * @author Pedro Sebastiano
     */
    public boolean getSucursal() {
        return sucursal;
    }

    /**
     * Cambia el atributo sucursal de la clase Estacion.
     * 
     * @param sucursal variable de tipo booleana con el nuevo valor booleano que indica si la estación tiene una sucursal.
     * @author Pedro Sebastiano
     */
    public void setSucursal(boolean sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * Obtiene el valor de cubierto, para saber si la estacion esta cubierta por otra sucursal.
     * 
     * @return true si la estación está cubierta, false en caso contrario.
     * @author Pedro Sebastiano
     */
    public boolean getCubierto() {
        return cubierto;
    }

    /**
     * Cambia el atributo Cubierto de la clase sucursal.
     * 
     * @param cubierto variable de tipo booleana con el nuevo valor booleano que indica si la estación está cubierta.
     * @author Pedro Sebastiano
     */
    public void setCubierto(boolean cubierto) {
        this.cubierto = cubierto;
    }
    
}
