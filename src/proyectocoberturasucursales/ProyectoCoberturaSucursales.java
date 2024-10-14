/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocoberturasucursales;
import EDD.Grafo;
import JSON.LecturaJSON;
import Objetos.Estacion;
import EDD.ListaAdyacencia;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author pseba
 */
public class ProyectoCoberturaSucursales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Esquema a seguir para implementar añadido del JSON en la Interfaz
        
        /*
        Esquema:
            En este esquema se cumplen los pasos de mostrar ventana para buscar el archivo JSON en cuestión usando un filtrador
            para solo aceptar archivos JSON por parte del usuario aplicando el filtro, luego se recibe la respuesta de la selección
            de archivos la cual puede ser valida o no valida (no se selecciono archivos), luego de ello se procede a obtener el archivo
            crear el objeto para la lectura del JSON y moestra por consola el contenido del JSON para poder percatarnos que la importación de 
            información del JSON es correcta.
        */
        LecturaJSON object;
        JFileChooser finder = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos JSON", "json");
        finder.setFileFilter(filter);
        int response = finder.showOpenDialog(null);
        
        if(response == JFileChooser.APPROVE_OPTION){
            File selected = finder.getSelectedFile();
            object = new LecturaJSON(selected);
            System.out.println(object.getData().toString(2));
        }
        
       //Pruebas Pedro 
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
