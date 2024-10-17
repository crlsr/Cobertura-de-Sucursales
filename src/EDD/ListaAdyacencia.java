/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
/**
 *
 * @author pseba
 */
public class ListaAdyacencia {

    private int size;
    private Nodo pfirst;

    public ListaAdyacencia() {
        this.pfirst = null;
        this.size = 0;
    }

    public boolean esVacio(){
        return pfirst == null;
    }
    
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
    
    
    public void agregarNodo(Vertice v){
        Nodo newNodo = new Nodo(v);
        if(esVacio()){
            pfirst = newNodo;
            this.setSize(getSize() + 1);
        }else{
            if(this.buscarNodo(v) == null){
                newNodo.setPnext(this.getPfirst());
                this.setPfirst(newNodo);
                this.setSize(getSize() + 1);
            }
        }
    }
    
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
     public String print(){
        String cadena = "";
        if(!esVacio()){
            Nodo aux = pfirst;
            while(aux!= ultimo()){
                cadena += aux.getTinfo().getTinfo().getNombre();
                aux = aux.getPnext();
            }
            
        }
        return cadena;
    }

     
    public Nodo ultimo(){
        return null;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Nodo getPfirst() {
        return pfirst;
    }

    public void setPfirst(Nodo pfirst) {
        this.pfirst = pfirst;
    }

    
}
