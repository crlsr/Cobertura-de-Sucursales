/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import EXTRAS.Estacion;
/**
 * Clase ListaVertices
 * Estructura de Datos de tipo Lista que incluye las primitivas
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class ListaVertices {
    
    /**
     * @param vfirst variable privada de tipo Vertice apunta al primer elemento de la lista
     * @param size variable privada de tipo entero que indica el tamano de la lista
     */
    private Vertice vfirst;
    private int size;

    /**
     * Constructor de la clase ListaVertices
     * Asigna null a vfirst y 0 a size
     * @author Pedro Sebastiano
     */
    public ListaVertices() {
        this.size = 0;
        this.vfirst = null;
    }

    /**
     * Verifica si la lista esta vacia.
     * 
     * @return boolean true si la lista esta vacia y false si en la lista existe
     * al menos un elemento
     * @author Pedro Sebastiano
     */
    public boolean esVacio(){
        return vfirst == null;
    }
    
    /**
     * Busca un nombre de estacion recibida por parametro en la lista de vertices
     * 
     * @param tinfo variable de tipo estacion que se desea buscar
     * @return variable de tipo vertice que en caso de que exista, sino null
     * @author Pedro Sebastiano
     */
    public Vertice buscarVertice(Estacion tinfo){
        Vertice aux = this.getVfirst();
        if(!esVacio()){
            while(aux!= ultimo()){
                if(aux.getTinfo().getNombre().toLowerCase().equals(tinfo.getNombre().toLowerCase())){
                    break;
                }
                aux = aux.getNext();
            }
        }
        return aux;
    }
    
    
    /**
     * Agrega el vertice al principio de la lista sino existe
     * 
     * @param tinfo variable de tipo estacion que se desea agregar
     * @author Pedro Sebastiano
     */
    public void agregarVertice(Estacion tinfo){
        Vertice newVertice = new Vertice(tinfo);
        if(esVacio()){
            vfirst = newVertice;
            this.setSize(getSize() + 1);
        }else{
            newVertice.setNext(this.getVfirst());
            this.setVfirst(newVertice);
            this.setSize(getSize() + 1);
        }
    }
    
    /**
     * Elimina el elemnento recibido como parametro si existe en la lista
     * 
     * @param tinfo variable de tipo estacion que se desea eliminar el vertice que la contiene
     * @author Pedro Sebastiano
     */
    public void eliminarVertice(Estacion tinfo){
        if(!esVacio() && tinfo.getNombre() != null){
            if(this.buscarVertice(tinfo) != null){
                if(this.getVfirst().getTinfo().getNombre().equals(tinfo.getNombre())){
                    Vertice aux = this.getVfirst();
                    this.setVfirst(aux.getNext());
                    aux.setNext(null);
                }else{
                    Vertice aux1 = vfirst.getNext();
                    Vertice aux2 = vfirst;
                    while(aux1!= ultimo()){
                        if(aux1.getTinfo().getNombre().equals(tinfo.getNombre())){
                            aux2.setNext(aux1.getNext());
                            aux1.setNext(null);
                            break;
                        }
                        aux2 = aux1;
                        aux1 = aux1.getNext();
                    }
                }
                this.setSize(getSize() -1);
            }
            
        }
        
        
    }
    
    /**
     * Crea un string con todos los nombres de las estaciones
     * 
     * @return variable de tipo String con todas las estaciones contenidas en la lista
     * @author Pedro Sebastiano
     */
    public String print(){
        String cadena = "";
        if(!esVacio()){
            Vertice aux = vfirst;
            while(aux!= ultimo()){
                cadena += "-->" + aux.getTinfo().getNombre() + "\n";
                aux = aux.getNext();
            }
            
        }
        return cadena;
    }
    
    /**
     * Da el valor despues del ultimo de la lista
     * 
     * @return variable de tipo vertice que es null
     * @author Pedro Sebastiano
     */
    public Vertice ultimo(){
        return null;
    }
    
    /**
     * Obtiene el valor del primer elemento de la lista
     * 
     * @return variable de tipo vertice
     * @author Pedro Sebastiano
     */
    public Vertice getVfirst() {
        return vfirst;
    }

    /**
     * Cambia el valor del primer elemento de la lista por el valor del parametro recibido
     * 
     * @param vfirst variable de tipo vertice por el que se quiere cambiar
     * @author Pedro Sebastiano
     */
    public void setVfirst(Vertice vfirst) {
        this.vfirst = vfirst;
    }

    /**
     * Se obtiene el valor del tamano de la lista
     * 
     * @return size variable de tipo entero
     * @author Pedro Sebastiano
     */
    public int getSize() {
        return size;
    }

    /**
     * Modifica el tamano de la lista
     * @param size nuevo tamano de la lista de tipo entero
     */
    public void setSize(int size) {
        this.size = size;
    }
    
}
