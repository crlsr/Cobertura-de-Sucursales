/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXTRAS;

/**
 *
 * @author pseba
 */
public class Estacion {
    
    private String nombre;
    private String linea;
    private boolean sucursal;

    public Estacion(String nombre, String linea) {
        this.nombre = nombre;
        this.linea = linea;
        this.sucursal = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public boolean getSucursal() {
        return sucursal;
    }

    public void setSucursal(boolean sucursal) {
        this.sucursal = sucursal;
    }
    
}
