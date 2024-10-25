/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
/**
 * Clase Cola
 * Estructura de Datos de tipo Cola que incluye las primitivas
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Cola {
    /**
     * @param first variable privada de tipo Nodo apunta al primer elemento insertado en la cola
     * @param last variable privada de tipo Nodo apunta al ultimo elemento insertado en la cola
     * @param size variable privada de tipo entero que indica el tamano de la cola
     */
    private Nodo first;
    private Nodo last;
    private int size;
    
    /**
     * Constructor de la clase cola
     * Asigna null a first y last y 0 a size
     * @author Pedro Sebastiano
     */
    public Cola (){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    /**
     * Verifica si la cola esta vacia.
     * 
     * @return boolean true si la cola esta vacia y false si en la cola existe
     * al menos un elemento
     * @author Pedro Sebastiano
     */
    public boolean esVacia (){
        return first == null;
    }
    
    /**
     * Encola en la cola el parametro, le asigna last el nuevo nodo creado
     * 
     * @param X variable de tipo vertice que se desea encolar
     * @author Pedro Sebastiano
     */
    public void encolar (Vertice X){
        Nodo nodo = new Nodo (X);
        if (this.esVacia()){
            this.first = this.last = nodo;
            this.size ++;
        }
        else{
            last.setPnext(nodo);
            last = nodo;
            size ++;
        }
    }
    
    /**
     * Desencola el atributo first de la clase cola
     * 
     * @author Pedro Sebastiano
     */
    public void desencolar (){
        if(!esVacia()){
            first = first.getPnext();
            size --;
        }
    }
    
    /**
     * Obtiene el valor del primer nodo de la cola
     * 
     * @return primer nodo de la cola
     * @author Pedro Sebastiano
     */
    public Nodo getFirst() {
        return first;
    }
    
    /**
     * Cambia el valor del primer nodo de la cola por el recibido
     * 
     * @param first nueva variable de tipo nodo
     * @author Pedro Sebastiano
     */
    public void setFirst(Nodo first) {
        this.first = first;
    }
    
    /**
     * Obtiene el valor del ultimo nodo de la cola
     * 
     * @return ultimo nodo de la cola
     * @author Pedro Sebastiano
     */
    public Nodo getLast() {
        return last;
    }
    
    /**
     * Cambia el valor del ultimo nodo de la cola por el recibido
     * 
     * @param last nueva variable de tipo nodo
     * @author Pedro Sebastiano
     */
    public void setLast(Nodo last) {
        this.last = last;
    }
    
    /**
     * Se obtiene el valor del tamano de la cola
     * @return size variable de tipo entero
     * @author Pedro Sebastiano
     */
    public int getSize() {
        return size;
    }

    /**
     * Modifica el tamano de la cola
     * @param size nuevo tamano de la cola de tipo entero
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
