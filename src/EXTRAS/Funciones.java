/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXTRAS;

import javax.swing.JOptionPane;
import EDD.Grafo;
import EDD.Vertice;
import EDD.Nodo;
import EDD.Cola;
import EDD.ListaVertices;
import EXTRAS.Estacion;
/**
 *
 * @author pseba
 */
public class Funciones {
    
    
    public void colocarSucursal(Grafo g, Estacion tinfo){
        Vertice existe= g.getListavertices().buscarVertice(tinfo);
        if(existe != null){
            if(existe.getTinfo().getSucursal()){
                JOptionPane.showMessageDialog(null,
                    ("Ya existe una sucursal en " + tinfo.getNombre()),
                            "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                existe.getTinfo().setSucursal(true);
                g.cambiarColorVertice(existe.getTinfo(), "green");
            }
        }else{
            JOptionPane.showMessageDialog(null,
               ("No existe la parada " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void eliminarSucursal(Grafo g, Estacion tinfo){
        Vertice existe= g.getListavertices().buscarVertice(tinfo);
        if(existe != null){
        if(!existe.getTinfo().getSucursal()){
            JOptionPane.showMessageDialog(null,
               ("No existe una sucursal en " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            existe.getTinfo().setSucursal(false);
            //Verificar el cubierto
            g.cambiarColorVertice(existe.getTinfo(), "yellow"); 
        }
        }else{
            JOptionPane.showMessageDialog(null,
               ("No existe la parada " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    
    public void busquedaBFS(Estacion tinfo, int t, Grafo graph){
        Vertice v = graph.getListavertices().buscarVertice(tinfo);
        Cola colaEstaciones = new Cola();
        ListaVertices visitados = new ListaVertices();
        colaEstaciones.encolar(v);
        visitados.agregarVertice(v.getTinfo());
        if (v.getTinfo().getSucursal()){
            BFS(colaEstaciones, visitados, t, graph);
        }
    }
    
    
    public void BFS(Cola colaEstaciones, ListaVertices visitados, int t, Grafo graph) {
    if (t > 0 && !colaEstaciones.esVacia()) {
        int nivelActual = colaEstaciones.getSize(); 
        while (nivelActual > 0) { 
            Vertice actual = colaEstaciones.getFirst().getTinfo();
            colaEstaciones.desencolar();
            Nodo aux = actual.getAdyacencia().getPfirst(); 
            while (aux != null) {
                Vertice adyacente = aux.getTinfo();
                if (visitados.buscarVertice(adyacente.getTinfo()) == null) {
                    colaEstaciones.encolar(adyacente);
                    visitados.agregarVertice(adyacente.getTinfo());
                    adyacente.getTinfo().setCubierto(true);
                    if (!adyacente.getTinfo().getSucursal()) {
                        graph.cambiarColorVertice(adyacente.getTinfo(), "lightblue");
                    }
                }
                aux = aux.getPnext();
            }

            nivelActual--;
        }
        BFS(colaEstaciones, visitados, t - 1, graph);
    }
}

}
    