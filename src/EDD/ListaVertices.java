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
    
    
    public void agregarVertice(Estacion tinfo){
        Vertice newVertice = new Vertice(tinfo);
        if(esVacio()){
            vfirst = newVertice;
            this.setSize(getSize() + 1);
        }else{
            if(this.buscarVertice(tinfo) == null){
                newVertice.setNext(this.getVfirst());
                this.setVfirst(newVertice);
                this.setSize(getSize() + 1);
            }
        }
    }
    
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
    
    public String print(){
        String cadena = "";
        if(!esVacio()){
            Vertice aux = vfirst;
            while(aux!= ultimo()){
                cadena += aux.getTinfo().getNombre();
                aux = aux.getNext();
            }
            
        }
        return cadena;
    }
    
    public Vertice ultimo(){
        return null;
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
