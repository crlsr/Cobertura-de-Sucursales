/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author pseba
 */
public class Nodo {
    private Vertice tinfo;
    private Nodo pnext;

    public Nodo(Vertice tinfo) {
        this.tinfo = tinfo;
        this.pnext = null;
    }

    public Vertice getTinfo() {
        return tinfo;
    }

    public void setTinfo(Vertice tinfo) {
        this.tinfo = tinfo;
    }

    public Nodo getPnext() {
        return pnext;
    }

    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }
    
    
    
    
    
    
    
    
}
