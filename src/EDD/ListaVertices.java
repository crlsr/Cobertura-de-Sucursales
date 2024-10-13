/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Objetos.Estacion;
/**
 *
 * @author pseba
 */
public class ListaVertices {
    private Vertice vfirst;
    private int size;

    public ListaVertices() {
        this.size = 0;
        this.vfirst = null;
    }

    
    
    public boolean esVacio(){
        return vfirst == null;
    }
    
    public Vertice buscarVertice(Vertice v){
        Vertice aux = this.getVfirst();
        if(!esVacio()){
            while(aux!= null){
                if(aux == v){
                    break;
                }
                aux = aux.getNext();
            }
        }
        return aux;
    }
    
    
    public void agregarVertice(Estacion tinfo){
        Vertice newVertice = new Vertice(tinfo);
        if(esVacio()){
            vfirst = newVertice;
            this.setSize(getSize() + 1);
        }else{
            if(this.buscarVertice(newVertice) == null){
                newVertice.setNext(this.getVfirst());
                this.setVfirst(newVertice);
                this.setSize(getSize() + 1);
            }
        }
    }
    
    public void eliminarVertice(Vertice v){
        if(!esVacio() && v != null){
            if(this.buscarVertice(v) != null){
                if(v == this.getVfirst()){
                    this.setVfirst(v.getNext());
                    v.setNext(null);
                }else{
                    Vertice aux1 = vfirst.getNext();
                    Vertice aux2 = vfirst;
                    while(aux1!= null){
                        if(v == aux1){
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
    
    
    public Vertice getVfirst() {
        return vfirst;
    }

    public void setVfirst(Vertice vfirst) {
        this.vfirst = vfirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
           
    
    
    
}
