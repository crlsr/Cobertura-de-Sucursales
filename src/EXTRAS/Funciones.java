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
import EDD.Pila;
import EDD.ListaVertices;
import EXTRAS.Estacion;
/**
 * Clase Funciones
 * Esta clase contiene métodos para gestionar sucursales en el grafo de estaciones.
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Funciones {

    /**
     * Coloca una sucursal en una estación especificada.
     * Verifica si la estación existe y si ya tiene una sucursal.
     * Cambia el atributo sucursal a true de una estacion y el color en el grafo a verde.
     * 
     * @param g el grafo que contiene las estaciones.
     * @param tinfo la estación en la que se desea colocar la sucursal.
     * @author Pedro Sebastiano
     */
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
    
    /**
     * Elimina una sucursal de una estación especificada.
     * Verifica si la estación existe y si tiene una sucursal para eliminar.
     * Cambia el atributo sucursal a false de una estacion y el color en el grafo a amarillo, a menos que esta este cubierta.
     * 
     * @param g el grafo que contiene las estaciones.
     * @param tinfo la estación de la que se desea eliminar la sucursal.
     * @author Pedro Sebastiano
     */
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
    
    
    /**
     * Realiza una búsqueda en anchura (BFS) desde una estación sucursal
     * para determinar la cobertura de las estaciones en el grafo.
     * Utiliza una cola y lista para gestionar los nodos que se van visitando.
     * Llama a la funcion BFS que se encarga de implementar el algoritmo.
     * 
     * @param tinfo la estación desde la cual se inicia la búsqueda.
     * @param t el radio de cobertura que se desea aplicar.
     * @param graph el grafo que contiene las estaciones.
     * @author Pedro Sebastiano
     */
    public void busquedaBFS(Estacion tinfo, int t, Grafo graph){
        Vertice v = graph.getListavertices().buscarVertice(tinfo);
        if (v!= null){
            if (v.getTinfo().getSucursal()){
                Cola colaEstaciones = new Cola();
                ListaVertices visitados = new ListaVertices();
                colaEstaciones.encolar(v);
                visitados.agregarVertice(v.getTinfo());
                BFS(colaEstaciones, visitados, t, graph);
            }else{
                JOptionPane.showMessageDialog(null,
                    ("No existe una sucursal en la parada " + v.getTinfo().getNombre() + ", por lo tanto no se puede revisar su cobertura"),
                        "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    /**
     * Implementa el algoritmo BFS para recorrer las estaciones en el grafo.
     * Este método utiliza una cola y un enfoque recursivo para visitar las estaciones.
     * Cambia el color a azul claro si una estacion se encuentra en el radio t.
     * 
     * @param colaEstaciones la cola que contiene las estaciones a visitar.
     * @param visitados la lista de estaciones que ya han sido visitadas.
     * @param t el radio de cobertura restante.
     * @param graph el grafo que contiene las estaciones.
     * @author Pedro Sebastiano
     */
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

    /**
     * Realiza una búsqueda en profundidad (DFS) desde una estación sucursal
     * para determinar la cobertura de las estaciones en el grafo.
     * Utiliza una pila y lista para gestionar los nodos que se van visitando.
     * Llama a la funcion DFS que se encarga de implementar el algoritmo.
     * 
     * @param tinfo la estación desde la cual se inicia la búsqueda.
     * @param t el radio de cobertura que se desea aplicar.
     * @param graph el grafo que contiene las estaciones.
     * @author Pedro Sebastiano
     */
    public void busquedaDFS(Estacion tinfo, int t, Grafo graph){
        Vertice v = graph.getListavertices().buscarVertice(tinfo);
        if(v!= null){
            if (v.getTinfo().getSucursal()){
                Pila pilaEstaciones = new Pila();
                ListaVertices visitados = new ListaVertices();
                pilaEstaciones.apilar(v);
                visitados.agregarVertice(v.getTinfo());
                DFS(pilaEstaciones, visitados, t, graph);
            }else{
                JOptionPane.showMessageDialog(null,
                    ("No existe una sucursal en la parada " + v.getTinfo().getNombre() + ", por lo tanto no se puede revisar su cobertura"),
                        "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    /**
     * Implementa el algoritmo DFS para recorrer las estaciones en el grafo.
     * Este método utiliza una pila y un enfoque recursivo para visitar las estaciones.
     * Cambia el color a azul claro si una estacion se encuentra en el radio t.
     * 
     * @param pilaEstaciones la pila que contiene las estaciones a visitar.
     * @param visitados la lista de estaciones que ya han sido visitadas.
     * @param t el radio de cobertura restante.
     * @param graph el grafo que contiene las estaciones.
     * @author Pedro Sebastiano
     */
    public void DFS(Pila pilaEstaciones, ListaVertices visitados, int t, Grafo graph){
        if(t>0 && !pilaEstaciones.vacia()){
            Vertice actual = pilaEstaciones.getpCima().getTinfo();
            Nodo aux = actual.getAdyacencia().getPfirst();
            while(aux!= null){
                if(visitados.buscarVertice(aux.getTinfo().getTinfo())== null){
                    pilaEstaciones.apilar(aux.getTinfo());
                    visitados.agregarVertice(aux.getTinfo().getTinfo());
                    aux.getTinfo().getTinfo().setCubierto(true);
                    if (!aux.getTinfo().getTinfo().getSucursal()) {
                        graph.cambiarColorVertice(aux.getTinfo().getTinfo(), "lightblue");
                    }
                    DFS(pilaEstaciones, visitados, t-1, graph);
                }
                aux = aux.getPnext();
            }
            pilaEstaciones.desapilar();
        }
        
    }
    
    
}