/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Clase Nodo
 * Representa un nodo de una estructura de datos, que contiene un vértice y una referencia al siguiente nodo.
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Nodo {
    /**
     * @param tinfo variable privada de tipo Vertice que contiene la información del nodo.
     * @param pnext variable privada de tipo Nodo que apunta al siguiente nodo en la estructura.
     */
    private Vertice tinfo;
    private Nodo pnext;

    /**
     * Constructor de la clase Nodo.
     * Crea un nodo con la información de tipo Vertice y asigna null al siguiente nodo.
     * 
     * @param tinfo variable de tipo Vertice que contiene la información del nodo.
     * @author Pedro Sebastiano
     */
    public Nodo(Vertice tinfo) {
        this.tinfo = tinfo;
        this.pnext = null;
    }

    /**
     * Obtiene la información del nodo.
     * 
     * @return variable de tipo Vertice con la información del nodo.
     * @author Pedro Sebastiano
     */
    public Vertice getTinfo() {
        return tinfo;
    }

    /**
     * Cambia la información del nodo.
     * 
     * @param tinfo variable de tipo Vertice con la nueva información del nodo.
     * @author Pedro Sebastiano
     */
    public void setTinfo(Vertice tinfo) {
        this.tinfo = tinfo;
    }

    /**
     * Obtiene el siguiente nodo en la estructura.
     * 
     * @return variable de tipo Nodo que apunta al siguiente nodo.
     * @author Pedro Sebastiano
     */
    public Nodo getPnext() {
        return pnext;
    }

    /**
     * Cambia el nodo al que apunta el atributo pnext.
     * 
     * @param pnext variable de tipo Nodo que contiene el nuevo nodo al que se desea apuntar.
     * @author Pedro Sebastiano
     */
    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }

}
