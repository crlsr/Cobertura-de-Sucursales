/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author pseba
 */
public class Pila {

    private Nodo pCima;
    private int size;
    

    public Pila (){
        this.pCima = null;
        this.size = 0;
    }
    

    public boolean vacia (){
    return pCima == null;
    }
    

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
    
    public void desapilar (){
        if(!vacia()){
            pCima = pCima.getPnext();
            size --;
        }
    }

    public void VaciarPila(){
        pCima = null;
        size = 0;
    }
    

    public String imprimir (){
        String cadena = "";
        while (!vacia()){
            cadena += pCima.getTinfo().getTinfo().getNombre()+"; ";
            desapilar();
        }
        return cadena;
    }

    public Nodo getpCima() {
        return pCima;
    }


    public void setpCima(Nodo first) {
        this.pCima = first;
    }


    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
