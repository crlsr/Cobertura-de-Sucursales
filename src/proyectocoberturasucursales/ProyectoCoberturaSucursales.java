/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocoberturasucursales;
import EDD.Grafo;
import JSON.LecturaJSON;
import EXTRAS.Estacion;
import EDD.ListaVertices;
import EDD.Vertice;
import EXTRAS.Funciones;
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
            Grafo nuevo = new Grafo();
            object.dataConstructor(nuevo);
            Estacion x = new Estacion("La hoyada", "Linea 1");
            Estacion y = new Estacion("CAPitolio", "Linea 1");
            Estacion m = new Estacion("las adjuntas", "linea1");
            Funciones funciones = new Funciones();
            funciones.colocarSucursal(nuevo, y);
            funciones.colocarSucursal(nuevo, x);
            funciones.colocarSucursal(nuevo, m);
            funciones.busquedaDFS(m, 5, nuevo);
            //funciones.busquedaDFS(y, 5, nuevo);
            nuevo.mostrarGrafo();
        }
        
    }
    
}
