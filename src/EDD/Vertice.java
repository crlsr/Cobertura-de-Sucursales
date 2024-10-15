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
public class Vertice {
    
    
    private Estacion tinfo;
    private ListaAdyacencia Adyacencia;
    private Vertice next;

    public Vertice(Estacion tinfo) {
        this.tinfo = tinfo;
        this.Adyacencia = new ListaAdyacencia();
        this.next = null;
    }

    public Estacion getTinfo() {
        return tinfo;
    }

    public void setTinfo(Estacion tinfo) {
        this.tinfo = tinfo;
    }

    public ListaAdyacencia getAdyacencia() {
        return Adyacencia;
    }

    public void setAdyacencia(ListaAdyacencia Adyacencia) {
        this.Adyacencia = Adyacencia;
    }

    public Vertice getNext() {
        return next;
    }

    public void setNext(Vertice next) {
        this.next = next;
    }
    
    
    
    
}
