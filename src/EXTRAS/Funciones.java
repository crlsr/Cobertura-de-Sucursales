/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXTRAS;

import javax.swing.JOptionPane;
import EDD.Grafo;
import EDD.Vertice;
import EXTRAS.Estacion;
/**
 *
 * @author pseba
 */
public class Funciones {
    
    
    public void colocarSucursal(Grafo g, Estacion tinfo){
        Vertice existe= g.getListavertices().buscarVertice(tinfo);
        if(existe != null){
            if(tinfo.getSucursal()){
                JOptionPane.showMessageDialog(null,
                    ("Ya existe una sucursal en " + tinfo.getNombre()),
                            "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                tinfo.setSucursal(true);
                g.cambiarColorVertice(existe.getTinfo(), "green");
            }
        }else{
            JOptionPane.showMessageDialog(null,
               ("No existe la parada " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void eliminarSucursal(Grafo g, Estacion tinfo){
        Vertice existe= g.getListavertices().buscarVertice(tinfo);
        if(existe != null){
        if(!tinfo.getSucursal()){
            JOptionPane.showMessageDialog(null,
               ("No existe una sucursal en " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            tinfo.setSucursal(false);
            g.cambiarColorVertice(existe.getTinfo(), "yellow"); 
        }
        }else{
            JOptionPane.showMessageDialog(null,
               ("No existe la parada " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
    