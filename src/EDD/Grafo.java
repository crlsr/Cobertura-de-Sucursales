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
        this.graph = new MultiGraph("Prueba 1");
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
                graph.addNode((String) tinfo.getNombre());
                this.graph.getNode((String) tinfo.getNombre()).setAttribute("ui.label", (String) tinfo.getNombre());
                graph.getNode((String) tinfo.getNombre()).setAttribute("ui.style", "fill-color: rgb(" + 178 + "," + 178 + "," + 232 + "); shape: circle; size: 30;");
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
                    break;
                }
                
                this.getListavertices().eliminarVertice(tinfo);
                graph.removeNode((String) tinfo.getNombre());
                this.setNumVertices(getNumVertices()-1);
                JOptionPane.showMessageDialog(null,
                    ((String) tinfo.getNombre() + " eliminado con exito"),
                    "", JOptionPane.INFORMATION_MESSAGE);
                
            }
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
    
    
    
}
