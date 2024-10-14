/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import Objetos.Estacion;
/**
 *
 * @author pseba
 */
public class Grafo {
    private ListaVertices listavertices;
    private int numVertices;
    private Graph graph;

    public Grafo() {
        this.numVertices = 0;
        this.listavertices = new ListaVertices();
        this.graph = new MultiGraph("Grafo Metro");
        System.setProperty("org.graphstream.ui", "swing"); // Utiliza el renderer Swing
        graph.setAttribute("ui.stylesheet", "node { fill-color: blue; } edge { fill-color: gray; }");
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
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
                this.graph.getNode(tinfo.getNombre()).setAttribute("ui.style", "fill-color: rgb(178, 178, 232); shape: circle; size: 30px;");
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
                       graph.removeEdge(tinfo1.getNombre() + "-" + tinfo2.getNombre());
                    }
                }
            }
         }
    }
    
     
    public void mostrarGrafo() {
        
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.EXIT); 
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
    
    
    
}
