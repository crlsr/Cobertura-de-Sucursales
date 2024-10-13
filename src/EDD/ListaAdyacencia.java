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
    
    public Nodo buscarNodo(Nodo obj){
        Nodo aux = this.getPfirst();
        if(!esVacio()){
            while(aux!= null){
                if(aux == obj){
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
            if(this.buscarNodo(newNodo) == null){
                newNodo.setPnext(this.getPfirst());
                this.setPfirst(newNodo);
                this.setSize(getSize() + 1);
            }
        }
    }
    
    public void eliminarNodo(Nodo obj){
        if(!esVacio() && obj != null){
            if(this.buscarNodo(obj) != null){
                if(obj == this.getPfirst()){
                    this.setPfirst(obj.getPnext());
                    obj.setPnext(null);
                }else{
                    Nodo aux1 = pfirst.getPnext();
                    Nodo aux2 = pfirst;
                    while(aux1!= null){
                        if(obj == aux1){
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
