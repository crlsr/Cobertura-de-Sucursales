/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import javax.swing.JOptionPane;
/**
 *
 * @author pseba
 */
public class Cola {
    
    private Nodo first;
    private Nodo last;
    private int size;
    

    public Cola (){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    

    public boolean esVacia (){
    return first == null;
    }
    

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
    

    public void desencolar (){
        if(!esVacia()){
            first = first.getPnext();
            size --;
        }
    }

    public void imprimir (){
        String cadena = "";
        while (!esVacia()){
            cadena += first.getTinfo().getTinfo().getNombre() + ", ";
            desencolar();
        }
        JOptionPane.showMessageDialog(null, cadena);
    }
    

    public Nodo getFirst() {
        return first;
    }
    

    public void setFirst(Nodo first) {
        this.first = first;
    }
    
    public Nodo getLast() {
        return last;
    }
    
    public void setLast(Nodo last) {
        this.last = last;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
