/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import EXTRAS.Estacion;
/**
 *
 * @author pseba
 */
public class Arista {
    
    private Estacion destino;
    private int dato;
    private Arista next;

    public Arista(Estacion Destino) {
        this.destino = Destino;
        this.next = null;
    }

    public Arista(Estacion destino, int dato) {
        this.destino = destino;
        this.dato = dato;
        this.next= null;
    }

    public Estacion getDestino() {
        return destino;
    }

    public void setDestino(Estacion destino) {
        this.destino = destino;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Arista getNext() {
        return next;
    }

    public void setNext(Arista next) {
        this.next = next;
    }
    
    
    
    
    
    
}
