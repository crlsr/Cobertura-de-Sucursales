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

    /**
     * Realiza la cobertura total de las estaciones en el grafo, iniciando
     * una búsqueda en anchura (BFS) desde cada estación que tenga una sucursal.
     * 
     * @param t el radio de cobertura que se desea aplicar.
     * @param graph el grafo que contiene las estaciones.
     * @author Pedro Sebastiano
     */
    public void coberturaTotal(int t, Grafo graph){
        ListaVertices estaciones = graph.getListavertices();
        Vertice aux = estaciones.getVfirst();
        while(aux!= null){
            if(aux.getTinfo().getSucursal()){
                this.busquedaBFS(aux.getTinfo(), t, graph);
            }
            aux = aux.getNext();
        }
    }
    
    /**
     * Elimina la cobertura de las estaciones cubiertas por otras sucursales y las coloca en
     * amarillo en el grafo.
     * 
     * @param graph el grafo que contiene las estaciones.
     * @author Pedro Sebastiano
     */
    public void eliminarCobertura(Grafo graph){
        ListaVertices estaciones = graph.getListavertices();
        Vertice aux = estaciones.getVfirst();
        while(aux!= null){
            if(aux.getTinfo().getCubierto() && !aux.getTinfo().getSucursal()){
                aux.getTinfo().setCubierto(false);
                graph.cambiarColorVertice(aux.getTinfo(), "yellow");                
            }
            aux = aux.getNext();
        }
    }
    
    /**
     * Revisa la cobertura total de las estaciones en el grafo, ejecutando
     * la búsqueda de cobertura total y luego verificando si hay estaciones
     * que no están cubiertas. Si se encuentran estaciones no cubiertas,
     * llama a la funcion sugerirSucursal.
     * 
     * @param graph el grafo que contiene las estaciones.
     * @param t el radio de cobertura que se desea aplicar.
     * @author Pedro Sebastiano
     */
    public void revisarCobertura(Grafo graph, int t){
        coberturaTotal(t, graph);
        ListaVertices estaciones = graph.getListavertices();
        Vertice aux = estaciones.getVfirst();
        ListaVertices noCubiertas = new ListaVertices();
        while(aux!= null){
            if(!aux.getTinfo().getCubierto() && !aux.getTinfo().getSucursal()){
                noCubiertas.agregarVertice(aux.getTinfo());
            }
            aux = aux.getNext();
        }
        
        if(noCubiertas.esVacio()){
            JOptionPane.showMessageDialog(null, "La ciudad está completamente cubierta.");
        }
        else{
            if(graph.getNumVertices()> noCubiertas.getSize()){
                sugerirSucursal(noCubiertas, graph, t);
            }else{
                JOptionPane.showMessageDialog(null, "No se ha colocado ninguna sucursal, por ende no se puede sugerir alguna.");
            }
        }
    }
    
    /**
     * Sugiere una nueva sucursal para cubrir el mayor número de estaciones
     * que no están cubiertas, llamando a la funcion calcularCobertura para 
     * conocer la cobertura de cada estación en la lista de estaciones no cubiertas.
     * 
     * @param noCubiertas la lista de estaciones que no están cubiertas.
     * @param graph el grafo que contiene las estaciones.
     * @param t el radio de cobertura que se desea aplicar.
     * @author Pedro Sebastiano
     */
    public void sugerirSucursal(ListaVertices noCubiertas, Grafo graph, int t){
        Vertice mejorEstacion = null;
        int mayorCobertura = 0;
        Vertice aux = noCubiertas.getVfirst();
        while(aux != null){
            int cobertura = calcularCobertura(aux, graph, t);
            if(cobertura > mayorCobertura){
                mayorCobertura = cobertura;
                mejorEstacion = aux;
            }
            aux = aux.getNext();
        }
        JOptionPane.showMessageDialog(null, "Se sugiere colocar una sucursal en " + 
            mejorEstacion.getTinfo().getNombre() + " para cubrir " + mayorCobertura + " estaciones.");
        
    }
    
    /**
     * Calcula cuántas estaciones puede cubrir una estación dada
     * en función de su radio de cobertura. Utiliza una cola para
     * realizar la búsqueda y contabilizar las estaciones cubiertas.
     * 
     * @param v el vértice (estación) desde el cual se calcula la cobertura.
     * @param graph el grafo que contiene las estaciones.
     * @param t el radio de cobertura que se desea aplicar.
     * @return el número de estaciones cubiertas por la estación dada.
     * @author Pedro Sebastiano
     */
    public int calcularCobertura(Vertice v, Grafo graph, int t){
        ListaVertices visitados = new ListaVertices();
        Cola colaEstaciones = new Cola();
        colaEstaciones.encolar(v);
        visitados.agregarVertice(v.getTinfo());
        int estacionesCubiertas = 1; 
        while (!colaEstaciones.esVacia() && t > 0) { 
        int t2 = colaEstaciones.getSize(); 
        while (t2 > 0) { 
            Vertice actual = graph.getListavertices().buscarVertice(colaEstaciones.getFirst().getTinfo().getTinfo());
            colaEstaciones.desencolar(); 
            Nodo aux = actual.getAdyacencia().getPfirst(); 
            while (aux != null) {
                Vertice adyacente = aux.getTinfo();
                if(!adyacente.getTinfo().getCubierto() && !adyacente.getTinfo().getSucursal()){
                    if (visitados.buscarVertice(adyacente.getTinfo()) == null) {
                        colaEstaciones.encolar(adyacente); 
                        visitados.agregarVertice(adyacente.getTinfo()); 
                        estacionesCubiertas++; 
                    }
                }
                aux = aux.getPnext(); 
                
            }
            t2--; 
        }
        t--; 
        }
        return estacionesCubiertas;
    }
    
    
    /**
    * Agrega una nueva línea de estaciones al grafo. Verifica que exista al menos una estacion de transferencia 
    * dentro de la linea, y sino no la agrega. Verifica si hay estaciones repetidas dentro del grafo que no
    * sean de transferencia. Crea nuevos vertices y sus conexiones.
    *
    * @param estacionesNuevas un arreglo de Strings que representa los nombres de las 
    * estaciones a añadir a la línea.
    * @param linea el nombre de la línea que se está añadiendo.
    * @param graph el grafo que contiene las estaciones y conexiones.
    */
    public void agregarLinea(String[] estacionesNuevas, String linea, Grafo graph) {
        if (!linea.isBlank()) {
            if (estacionesNuevas.length > 0) {
                String estacionTransferencia;
                String estacionExistente;
                linea = formatearTitulo(linea);
                boolean existeTransferencia = false;

                for (String estacion : estacionesNuevas) {
                    String estacionNombre = formatearTitulo(estacion.trim());
                    if (estacionNombre.contains("-")) {
                        String[] partes = estacionNombre.split("-");
                        estacionTransferencia = formatearTitulo(partes[0].trim());
                        estacionExistente = formatearTitulo(partes[1].trim());
                        Vertice verticeExistente = graph.getListavertices().buscarVertice(new Estacion(estacionExistente, linea));
                        if (verticeExistente == null) {
                            JOptionPane.showMessageDialog(null, "La estación de transferencia " + estacionExistente + " no existe en el grafo.");
                            return;
                        }else{
                            existeTransferencia = true;
                            verticeExistente.getTinfo().setLinea("Transferencia");
                            Estacion transferencia = new Estacion(estacionTransferencia, "Transferencia");
                            graph.agregarVertice(transferencia);
                            graph.conectarVertices(transferencia, verticeExistente.getTinfo());
                        }
                    }
                }
                if (!existeTransferencia) {
                    JOptionPane.showMessageDialog(null, "No se ha especificado una estación de transferencia.");
                    return;
                }
                Vertice anterior = null;
                for (String estacion : estacionesNuevas) {
                    String estacionNombre = formatearTitulo(estacion.trim());
                    if (estacionNombre.contains("-")) {
                        String[] partes = estacionNombre.split("-");
                        Estacion conexionGrafo = new Estacion(formatearTitulo(partes[0].trim()), "Transferencia");
                        if (anterior != null) {
                            graph.conectarVertices(conexionGrafo, anterior.getTinfo());
                        }
                        anterior = graph.getListavertices().buscarVertice(conexionGrafo);
                    }else{
                        Estacion nuevaEstacion = new Estacion(estacionNombre, linea);
                        Vertice nuevoVertice = graph.getListavertices().buscarVertice(nuevaEstacion);
                        if (nuevoVertice == null) {
                            graph.agregarVertice(nuevaEstacion);
                            if (anterior != null) {
                                graph.conectarVertices(nuevaEstacion, anterior.getTinfo());
                            }
                            anterior = graph.getListavertices().buscarVertice(nuevaEstacion);
                        }else{
                            JOptionPane.showMessageDialog(null, "No se puede conectar la estacion con " + nuevoVertice.getTinfo().getNombre() +
                                    " porque ya existe en el grafo y no es una estación de transferencia");
                            continue;
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se han proporcionado estaciones.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se ha proporcionado el nombre de la linea.");
        }
    }

    /**
    * Formatea un texto para que tenga un formato de título (Ej. la hOYAda -> La Hoyada). Convierte el texto a 
    * minúsculas, elimina espacios en blanco al inicio y al final, y capitaliza la 
    * primera letra de cada palabra. 
    *
    * @param texto la cadena de texto que se desea formatear.
    * @return una cadena formateada donde cada palabra comienza con una letra mayúscula.
    */
    public String formatearTitulo(String texto) {
        texto = texto.trim().toLowerCase();
        String[] palabras = texto.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                sb.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1)).append(" ");
        }
        }
        return sb.toString().trim();
    }
    
    
    
    
}