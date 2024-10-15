/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import EXTRAS.Estacion;
/**
 *
 * @author pseba
 */
public class Grafo {
    private ListaVertices listavertices;
    private int numVertices;
    private Graph graph;
    private int t;

    public Grafo() {
        this.numVertices = 0;
        this.listavertices = new ListaVertices();
        this.graph = new MultiGraph("Grafo Metro");
        this.t = 0;
        System.setProperty("org.graphstream.ui", "swing");
        //verificar si estas 3 lineas son necesarias
        /*
        graph.setAttribute("ui.stylesheet", "node { fill-color: blue; } edge { fill-color: gray; }");
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        */
    }
    
    public void agregarVertice(Estacion tinfo){
        if(!"".equals(tinfo.getNombre())){
            Vertice verticeExistente = this.getListavertices().buscarVertice(tinfo);
            if (verticeExistente != null){
                 JOptionPane.showMessageDialog(null,
                        ("Ya existe la estacion: " + tinfo.getNombre() + ". No se puede agregar otro."),
                        "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                this.getListavertices().agregarVertice(tinfo);
                graph.addNode(tinfo.getNombre()).setAttribute("ui.label", tinfo.getNombre());
                this.graph.getNode(tinfo.getNombre()).setAttribute("ui.style", "fill-color: red; shape: circle; size: 30px;");
                this.setNumVertices(getNumVertices() + 1);
            }
            
        }
    }
    
    public void eliminarVertice(Estacion tinfo){
        if(!"".equals(tinfo.getNombre())){
            Vertice verticeEliminar = this.getListavertices().buscarVertice(tinfo);
            if(verticeEliminar == null){
                JOptionPane.showMessageDialog(null,
                        ("La estacion: " + (String) tinfo.getNombre() + " no existe en el grafo"),
                        "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Vertice aux = this.getListavertices().getVfirst();
                while(aux != null){
                    this.desconcectarVertices(aux.getTinfo(), tinfo);
                    aux = aux.getNext();  
                }
                this.getListavertices().eliminarVertice(tinfo);
                graph.removeNode(tinfo.getNombre());
                this.setNumVertices(getNumVertices()-1);
                JOptionPane.showMessageDialog(null,
                    ((String) tinfo.getNombre() + " eliminado con exito"),
                    "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void conectarVertices(Estacion tinfo1, Estacion tinfo2){
        if(!"".equals(tinfo1.getNombre()) && !"".equals(tinfo2.getNombre())){
            if(tinfo1.getNombre().equals(tinfo2.getNombre())){
                JOptionPane.showMessageDialog(null,
                        ("La estacion " + tinfo1.getNombre() + " no se puede conectar a sí mismo"),
                        "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Vertice vertice1= this.getListavertices().buscarVertice(tinfo1);
                Vertice vertice2= this.getListavertices().buscarVertice(tinfo2);
                if(vertice1 == null || vertice2 == null){
                    JOptionPane.showMessageDialog(null,
                        "Uno o ambas estaciones no existen en el grafo",
                        "", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    Nodo encontrado = vertice1.getAdyacencia().buscarNodo(vertice2);
                    if(encontrado != null){
                        JOptionPane.showMessageDialog(null,
                        ("Las estaciones " + (String) tinfo1.getNombre() + " y " + (String) tinfo2.getNombre() + " ya están conectados"),
                        "", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        vertice1.getAdyacencia().agregarNodo(vertice2);
                        vertice2.getAdyacencia().agregarNodo(vertice1); 
                        graph.addEdge(tinfo1.getNombre() + "-" + tinfo2.getNombre(), tinfo1.getNombre(), tinfo2.getNombre());
                    }
                }
            }
        }
    }
    
    public void desconcectarVertices(Estacion tinfo1, Estacion tinfo2){
         if(!"".equals(tinfo1.getNombre()) && !"".equals(tinfo2.getNombre())){
            Vertice vertice1= this.getListavertices().buscarVertice(tinfo1);
            Vertice vertice2= this.getListavertices().buscarVertice(tinfo2);
            if(vertice1 == null || vertice2 == null){
                JOptionPane.showMessageDialog(null,
                    "Uno o ambas estaciones no existen en el grafo",
                    "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Nodo nodoAdyacente = vertice1.getAdyacencia().buscarNodo(vertice2);
                if(nodoAdyacente!= null){
                    Vertice adyacente = vertice1.getAdyacencia().buscarNodo(vertice2).getTinfo();
                    if(adyacente!= null){
                        vertice1.getAdyacencia().eliminarNodo(vertice2);
                        vertice2.getAdyacencia().eliminarNodo(vertice1);
                        try{
                            graph.removeEdge(tinfo1.getNombre() + "-" + tinfo2.getNombre());
                        }catch(Exception e){
                            graph.removeEdge(tinfo2.getNombre() + "-" + tinfo1.getNombre());
                        }
                    }
                }
            }
         }
    }
    
     
    public void mostrarGrafo() {
        
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.EXIT); 
    }
    
    public void cambiarColorVertice(Estacion tinfo, String color) {
    if (graph.getNode(tinfo.getNombre()) != null) {
        graph.getNode(tinfo.getNombre()).setAttribute("ui.style", "fill-color: " + color + "; size: 30px; shape: circle;");
    }else{
        JOptionPane.showMessageDialog(null, "La estación " + tinfo.getNombre() + " no existe en el grafo.");
    }
    }
    
    public void colocarSucursal(Estacion tinfo){
        if(tinfo.getSucursal()){
            JOptionPane.showMessageDialog(null,
               ("Ya existe una sucursal en " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            tinfo.setSucursal(true);
            cambiarColorVertice(tinfo, "green");
        }
    }
    
    public void eliminarSucursal(Estacion tinfo){
        if(!tinfo.getSucursal()){
            JOptionPane.showMessageDialog(null,
               ("No existe una sucursal en " + tinfo.getNombre()),
                        "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            tinfo.setSucursal(false);
            cambiarColorVertice(tinfo, "red"); 
        }
    }

    public ListaVertices getListavertices() {
        return listavertices;
    }

    public void setListavertices(ListaVertices listavertices) {
        this.listavertices = listavertices;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
    
}
