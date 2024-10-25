/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Clase Pila
 * Estructura de Datos de tipo Pila que incluye las primitivas
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Pila {
    /**
     * @param pCima variable privada, apunta al nodo ubicado en el tope de la pila
     * @param size variable privada, indica la cantidad de elementos
     */
    private Nodo pCima;
    private int size;
    
    /**
     * Constructor de la clase pila, no recibe parametros
     * asigna 0 al tamaño de la pila y a pCima null
     * @author Pedro Sebastiano
     */
    public Pila (){
        this.pCima = null;
        this.size = 0;
    }
    
    /**
     * Verifica si la pila esta vacia.
     * 
     * @author Pedro Sebastiano
     * @return boolean true si la pila esta vacia y false si en la pila existe
     * al menos un elemento
     */
    public boolean vacia (){
    return pCima == null;
    }
    
    /**
     * Apila un nuevo elemento en la pila
     * 
     * @param X vertice que indica el elemento que se desea apilar, con el que se crea un nodo
     * @author Pedro Sebastiano
     */
    public void apilar (Vertice X){
        Nodo nodo = new Nodo (X);
        if (this.vacia()){
            this.pCima = nodo;
            this.size ++;
        }else{
            nodo.setPnext(pCima);
            pCima = nodo;
            size ++;
        }
    }
    
    /**
     * Desapila el ultimo elemento en la pila
     * 
     * @author Pedro Sebastiano
     */
    public void desapilar (){
        if(!vacia()){
            pCima = pCima.getPnext();
            size --;
        }
    }

    /**
     * Metodo que vacia la pila, le asigna cero a la variable size y pCima apunte a null
     * @author Pedro Sebastiano
     */
    public void VaciarPila(){
        pCima = null;
        size = 0;
    }
    
    /**
     * Se obtiene el valor de pCima
     * @return Nodo el ultimo elemento agregado a la pila
     * @author Pedro Sebastiano
     */
    public Nodo getpCima() {
        return pCima;
    }

    /**
     * Modifica el primer elemento de la pila
     * @param first nueva variable de tipo nodo
     * @author Pedro Sebastiano
     */
    public void setpCima(Nodo first) {
        this.pCima = first;
    }

    /**
     * Se obtiene el valor del tamano de la pila
     * @return size variable de tipo entero
     * @author Pedro Sebastiano
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Modifica el tamano de la pila
     * @param size nuevo tamano de la pila de tipo entero
     */
    public void setSize(int size) {
        this.size = size;
    }
}
