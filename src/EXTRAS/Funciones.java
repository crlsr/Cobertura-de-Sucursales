/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXTRAS;

import javax.swing.JOptionPane;

/**
 *
 * @author pseba
 */
public class Funciones {
    
    
    public void colocarSucursal(Estacion tinfo){
        if(tinfo.getSucursal()){
            JOptionPane.showMessageDialog(null,
               ("Ya existe una sucursal en " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            tinfo.setSucursal(true);
        }
    }
    
    public void eliminarSucursal(Estacion tinfo){
        if(!tinfo.getSucursal()){
            JOptionPane.showMessageDialog(null,
               ("No existe una sucursal en " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            tinfo.setSucursal(false);
        }
    }
    
    
}
