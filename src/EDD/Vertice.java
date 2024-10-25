/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import EXTRAS.Estacion;
/**
 * Clase Vertice
 * Representa un vértice en un grafo, que contiene una estación, una lista de adyacencia y una referencia al siguiente vértice.
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Vertice {
    
    /**
     * @param tinfo variable privada de tipo Estacion que contiene la información del vértice.
     * @param Adyacencia variable privada de tipo ListaAdyacencia que almacena las conexiones (adyacencias) de este vértice.
     * @param next variable privada de tipo Vertice que apunta al siguiente vértice en la estructura.
     */
    private Estacion tinfo;
    private ListaAdyacencia Adyacencia;
    private Vertice next;

    /**
     * Constructor de la clase Vertice.
     * Crea un vértice con la información de una estación, inicializa una lista de adyacencia vacía y asigna null al siguiente vértice.
     * 
     * @param tinfo variable de tipo Estacion que contiene la información del vértice.
     * @author Pedro Sebastiano
     */
    public Vertice(Estacion tinfo) {
        this.tinfo = tinfo;
        this.Adyacencia = new ListaAdyacencia();
        this.next = null;
    }

    /**
     * Obtiene la información del vértice (estación).
     * 
     * @return variable de tipo Estacion con la información del vértice.
     * @author Pedro Sebastiano
     */
    public Estacion getTinfo() {
        return tinfo;
    }

    /**
     * Cambia la información del vértice (estación).
     * 
     * @param tinfo variable de tipo Estacion con la nueva información del vértice.
     * @author Pedro Sebastiano
     */
    public void setTinfo(Estacion tinfo) {
        this.tinfo = tinfo;
    }

    /**
     * Obtiene la lista de adyacencia del vértice.
     * 
     * @return variable de tipo ListaAdyacencia que contiene las conexiones del vértice.
     * @author Pedro Sebastiano
     */
    public ListaAdyacencia getAdyacencia() {
        return Adyacencia;
    }

    /**
     * Cambia la lista de adyacencia del vértice.
     * 
     * @param Adyacencia variable de tipo ListaAdyacencia con la nueva lista de adyacencia del vértice.
     * @author Pedro Sebastiano
     */
    public void setAdyacencia(ListaAdyacencia Adyacencia) {
        this.Adyacencia = Adyacencia;
    }

    /**
     * Obtiene el siguiente vértice en la estructura.
     * 
     * @return variable de tipo Vertice que apunta al siguiente vértice.
     * @author Pedro Sebastiano
     */
    public Vertice getNext() {
        return next;
    }

    /**
     * Cambia el vértice al que apunta el atributo next.
     * 
     * @param next variable de tipo Vertice que contiene el nuevo vértice al que se desea apuntar.
     * @author Pedro Sebastiano
     */
    public void setNext(Vertice next) {
        this.next = next;
    }
    
}
