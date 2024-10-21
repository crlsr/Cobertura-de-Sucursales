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
 * Clase Grafo
 * Representa un grafo que contiene vértices (estaciones) y sus conexiones (adyacencias).
 * 
 * @author Pedro Sebastiano
 * @version 1.0
 */
public class Grafo {
    /**
     * @param listavertices variable privada de tipo ListaVertices que almacena los vértices (estaciones) del grafo.
     * @param numVertices variable privada de tipo entero que indica el número de vértices en el grafo.
     * @param graph variable privada de tipo Graph que representa la estructura gráfica del grafo.
     * @param t variable privada de tipo entero que representa el radio con el que se cubrirán las estaciones.
     */
    private ListaVertices listavertices;
    private int numVertices;
    private Graph graph;
    private int t;
    
    /**
     * Constructor de la clase Grafo.
     * Inicializa un grafo vacío con 0 vértices y un nuevo objeto Graph.
     * 
     * @author Pedro Sebastiano
     */
    public Grafo() {
        this.numVertices = 0;
        this.listavertices = new ListaVertices();
        this.graph = new MultiGraph("Grafo Metro");
        this.t = 0;
        System.setProperty("org.graphstream.ui", "swing");
    }
    
    /**
     * Elimina todos los vertices del grafo, desconectando y removiendo cada estacion
     * Este procedimiento limpia todo el grafo y establece el numero de vertices a 0 y 
     * apunta al primero de la lista de vertices a null
     * 
     * @author Pedro Sebastiano
     */
    public void destructor(){
        Vertice aux = this.getListavertices().getVfirst();
        while(aux!= null){
            this.eliminarVertice(aux.getTinfo());
            aux = aux.getNext();
        }
        this.setNumVertices(0);
        this.getListavertices().setVfirst(null);
    }
    /**
     * Agrega una nueva estación al grafo.
     * Verifica que el nombre de la estación no esté vacío y que no exista ya en el grafo.
     * Lo anade tanto en la lista de vertices como en graph (visual)
     * 
     * @param tinfo variable de tipo Estacion que se desea agregar al grafo.
     * @author Pedro Sebastiano
     */
    public void agregarVertice(Estacion tinfo){
        if(!"".equals(tinfo.getNombre())){
            Vertice verticeExistente = this.getListavertices().buscarVertice(tinfo);
            if (verticeExistente != null){
                 JOptionPane.showMessageDialog(null,
                        ("Ya existe la estacion: " + tinfo.getNombre() + ". No se puede agregar otro."),
                        "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                int columnas = 10; 
                int x = (getNumVertices() % columnas) * 80; 
                int y = (getNumVertices() / columnas) * 80; 
                this.getListavertices().agregarVertice(tinfo);
                graph.addNode(tinfo.getNombre()).setAttribute("ui.label", tinfo.getNombre());
                this.graph.getNode(tinfo.getNombre()).setAttribute("ui.style", "fill-color: yellow; shape: circle; size: 15px;");
                this.graph.getNode(tinfo.getNombre()).setAttribute("xy", x, y);
                this.setNumVertices(getNumVertices() + 1);
            }
            
        }
    }
    
    /**
     * Elimina una estación del grafo.
     * Verifica que la estación exista antes de eliminarla y desconecta todas las conexiones asociadas.
     * Lo elimina tanto en la lista de vertices como en graph (visual)
     * 
     * @param tinfo variable de tipo Estacion que se desea eliminar del grafo.
     * @author Pedro Sebastiano
     */
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
            }
        }
    }
    
    /**
     * Conecta dos estaciones en el grafo.
     * Verifica que ambas estaciones existan y que no sean la misma.
     * Anade los vertices en la lista de adyacencia del otro, y agrega la conexion en graph (visual).
     * 
     * @param tinfo1 variable de tipo Estacion que representa la primera estación.
     * @param tinfo2 variable de tipo Estacion que representa la segunda estación.
     * @author Pedro Sebastiano
     */
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
    
    /**
     * Desconecta dos estaciones en el grafo.
     * Verifica que ambas estaciones existan antes de eliminar la conexión.
     * Elimina los vertices en la lista de adyacencia del otro, y agrega la conexion en graph (visual).
     * 
     * @param tinfo1 variable de tipo Estacion que representa la primera estación.
     * @param tinfo2 variable de tipo Estacion que representa la segunda estación.
     * @author Pedro Sebastiano
     */
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
    
     /**
     * Muestra el grafo en una ventana de visualización.
     * 
     * @author Pedro Sebastiano
     */
    public void mostrarGrafo() {
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
    }
    
    /**
     * Cambia el color de un vértice en el grafo.
     * 
     * @param tinfo variable de tipo Estacion que representa la estación cuyo color se desea cambiar.
     * @param color variable de tipo String que representa el nuevo color para el vértice.
     * @author Pedro Sebastiano
     */
    public void cambiarColorVertice(Estacion tinfo, String color) {
        if (graph.getNode(tinfo.getNombre()) != null) {
            graph.getNode(tinfo.getNombre()).setAttribute("ui.style", "fill-color: " + color + "; size: 15px; shape: circle;");
        }else{
            JOptionPane.showMessageDialog(null, "La estación " + tinfo.getNombre() + " no existe en el grafo.");
        }
    }
    
    /**
     * Obtiene la lista de vértices del grafo.
     * 
     * @return variable de tipo ListaVertices que contiene todos los vértices del grafo.
     * @author Pedro Sebastiano
     */
    public ListaVertices getListavertices() {
        return listavertices;
    }

    /**
     * Establece una nueva lista de vértices para el grafo.
     * 
     * @param listavertices nueva variable de tipo ListaVertices que reemplaza la lista actual.
     * @author Pedro Sebastiano
     */
    public void setListavertices(ListaVertices listavertices) {
        this.listavertices = listavertices;
    }

    /**
     * Obtiene el número de vértices en el grafo.
     * 
     * @return variable de tipo entero que representa el número de vértices en el grafo.
     * @author Pedro Sebastiano
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * Establece un nuevo número de vértices para el grafo.
     * 
     * @param numVertices nuevo valor entero que representa el número de vértices en el grafo.
     * @author Pedro Sebastiano
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * Obtiene el objeto Graph que representa el grafo.
     * 
     * @return variable de tipo Graph que representa la estructura gráfica del grafo.
     * @author Pedro Sebastiano
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * Establece un nuevo objeto Graph para el grafo.
     * 
     * @param graph nuevo objeto Graph que reemplaza el actual.
     * @author Pedro Sebastiano
     */
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    /**
     * Obtiene el valor del radio utilizado para cubrir las estaciones.
     * 
     * @return variable de tipo entero que representa el radio.
     * @author Pedro Sebastiano
     */
    public int getT() {
        return t;
    }

    /**
     * Establece un nuevo valor para el radio utilizado para cubrir las estaciones.
     * 
     * @param t nuevo valor entero que representa el radio.
     * @author Pedro Sebastiano
     */
    public void setT(int t) {
        this.t = t;
    }
    
}
