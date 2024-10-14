/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocoberturasucursales;
import EDD.Grafo;
import Objetos.Estacion;
import JSON.LecturaJSON;
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
        LecturaJSON a = new LecturaJSON("/Users/carlosrodriguez/Documents/GitHub/ProyectoCoberturaSucursales/src/JSON");
        Estacion x = new Estacion("La hoyada");
        Estacion y = new Estacion("Manao");
        Estacion z = new Estacion("Chacaito");
        
        nuevo.agregarVertice(z);
        nuevo.agregarVertice(y);
        nuevo.agregarVertice(x);
        System.out.println(nuevo.getListavertices().print());
        System.out.println(nuevo.getListavertices().print());
        System.out.println(a.getData());
        
        
        
        
        
        
        
        
        
        
    }
    
}
