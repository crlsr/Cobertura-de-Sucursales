/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocoberturasucursales;
import EDD.Grafo;
import Objetos.Estacion;
import EDD.ListaAdyacencia;
/**
 *
 * @author pseba
 */
public class ProyectoCoberturaSucursales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grafo nuevo = new Grafo();
        Estacion x = new Estacion("La hoyada");
        Estacion y = new Estacion("Manao");
        Estacion z = new Estacion("Chacaito");
        
        nuevo.agregarVertice(z);
        nuevo.agregarVertice(y);
        nuevo.agregarVertice(x);
        nuevo.conectarVertices(z, x);
        nuevo.conectarVertices(x,y);
        nuevo.conectarVertices(z, y);
        nuevo.mostrarGrafo();
        ListaAdyacencia lista = nuevo.getListavertices().getVfirst().getAdyacencia();
        System.out.println(nuevo.getListavertices().getVfirst().getTinfo().getNombre());
        System.out.println(lista.print());
        nuevo.eliminarVertice(x);
        nuevo.desconcectarVertices(y, z);
        lista = nuevo.getListavertices().getVfirst().getAdyacencia();
        System.out.println(nuevo.getListavertices().getVfirst().getTinfo().getNombre());
        System.out.println(lista.print());
        nuevo.mostrarGrafo();

        
        
        
        
        
        
        
        
        
        
        
    }
    
}
