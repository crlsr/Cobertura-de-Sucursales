/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
/**
 * Clase ListaAdyacencia
 * Estructura de Datos de tipo Lista que incluye las primitivas
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class ListaAdyacencia {

    /**
     * @param pfirst variable privada de tipo Nodo apunta al primer elemento de la lista
     * @param size variable privada de tipo entero que indica el tamano de la lista
     */
    private Nodo pfirst;
    private int size;

    /**
     * Constructor de la clase ListaAdyacencia
     * Asigna null a vfirst y 0 a size
     * @author Pedro Sebastiano
     */
    public ListaAdyacencia() {
        this.pfirst = null;
        this.size = 0;
    }

    
    /**
     * Verifica si la lista esta vacia.
     * 
     * @return boolean true si la lista esta vacia y false si en la lista existe
     * al menos un elemento
     * @author Pedro Sebastiano
     */
    public boolean esVacio(){
        return pfirst == null;
    }
    
    /**
     * Busca un nombre de estacion recibida por parametro en la lista de vertices
     * 
     * @param tinfo variable de tipo Vertice que se desea buscar
     * @return variable de tipo Nodo que en caso de que exista, sino null
     * @author Pedro Sebastiano
     */
    public Nodo buscarNodo(Vertice tinfo){
        Nodo aux = this.getPfirst();
        if(!esVacio()){
            while(aux!= ultimo()){
                if(aux.getTinfo().getTinfo().getNombre().toLowerCase().equals(tinfo.getTinfo().getNombre().toLowerCase())){
                    break;
                }
                aux = aux.getPnext();
            }
        }
        return aux;
    }
    
    /**
     * Agrega el Nodo al principio de la lista 
     * 
     * @param v variable de tipo Vertice que se desea agregar
     * @author Pedro Sebastiano
     */
    public void agregarNodo(Vertice v){
        Nodo newNodo = new Nodo(v);
        if(esVacio()){
            pfirst = newNodo;
            this.setSize(getSize() + 1);
        }else{
            newNodo.setPnext(this.getPfirst());
            this.setPfirst(newNodo);
            this.setSize(getSize() + 1);
        }
    }
    
    /**
     * Elimina el elemnento recibido como parametro 
     * 
     * @param v variable de tipo Vertice que se desea eliminar el vertice que la contiene
     * @author Pedro Sebastiano
     */
    public void eliminarNodo(Vertice v){
        if(!esVacio() && v != null){
            if(this.buscarNodo(v) != null){
                if(v.getTinfo().getNombre().equals(this.getPfirst().getTinfo().getTinfo().getNombre())){
                    Nodo aux = this.getPfirst();
                    this.setPfirst(aux.getPnext());
                    aux.setPnext(null);
                }else{
                    Nodo aux1 = pfirst.getPnext();
                    Nodo aux2 = pfirst;
                    while(aux1!= ultimo()){
                        if(aux1.getTinfo().getTinfo().getNombre().equals(v.getTinfo().getNombre())){
                            aux2.setPnext(aux1.getPnext());
                            aux1.setPnext(null);
                            break;
                        }
                        aux2 = aux1;
                        aux1 = aux1.getPnext();
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
            Nodo aux = pfirst;
            while(aux!= ultimo()){
                cadena += aux.getTinfo().getTinfo().getNombre() + "\n";
                aux = aux.getPnext();
            }
            
        }
        return cadena;
    }

    /**
     * Da el valor despues del ultimo de la lista
     * 
     * @return variable de tipo nodo que es null
     * @author Pedro Sebastiano
     */
    public Nodo ultimo(){
        return null;
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
    
    /**
     * Obtiene el valor del primer elemento de la lista
     * 
     * @return variable de tipo Nodo
     * @author Pedro Sebastiano
     */
    public Nodo getPfirst() {
        return pfirst;
    }

    /**
     * Cambia el valor del primer elemento de la lista por el valor del parametro recibido
     * 
     * @param pfirst variable de tipo Nodo por el que se quiere cambiar
     * @author Pedro Sebastiano
     */
    public void setPfirst(Nodo pfirst) {
        this.pfirst = pfirst;
    }

    
}
