/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXTRAS;

import javax.swing.JOptionPane;
import EDD.Grafo;
/**
 *
 * @author pseba
 */
public class Funciones {
    
    
    public void colocarSucursal(Grafo G, Estacion tinfo){
        if(tinfo.getSucursal()){
            JOptionPane.showMessageDialog(null,
               ("Ya existe una sucursal en " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            tinfo.setSucursal(true);
            G.cambiarColorVertice(tinfo, "green");
        }
    }
    
    public void eliminarSucursal(Grafo G, Estacion tinfo){
        if(!tinfo.getSucursal()){
            JOptionPane.showMessageDialog(null,
               ("No existe una sucursal en " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            tinfo.setSucursal(false);
            G.cambiarColorVertice(tinfo, "rgb(178, 178, 232)"); // Este es el color original de los nodos
        }
    }
}
    