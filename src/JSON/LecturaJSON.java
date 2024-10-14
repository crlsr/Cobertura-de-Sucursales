/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.JSONTokener;

public class LecturaJSON { 
    private JSONObject data;

    /*
        Constructor de LecturaJSON:
            Recibe como parametro un archivo al cual llamaremos endpoint para poder acceder al archivo JSON
            Luego hacemos un try-with-resourses pasandole como resourse el archivo con el JSON (así en caso de que haya un
                error en la lectura del archivo, maneje mejor la excepción y lo cierre al terminar de extraer sus datos).
            Posteriormente definimos nuestra data la cual será el archivo JSON convertido en un Objeto del tipo JSONObject operable denteo de Jsva
            Por ultimo validamos cualquier error mostrando que hibieron errores al internar abrir el archivo en cuestión.
    
            NOTA: Se le pasa al JSONObject un JSONTokener para poder acceder a la informacion del archivo como string y pasarlo aformato JSONObject.
    */
    public LecturaJSON(File endpoint) {
        try(FileReader reader = new FileReader(endpoint)){
            this.data = new JSONObject(new JSONTokener(reader));
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al imntentar abrir: " + e.getMessage());
        }
        
    }
    
    //Método para poder acceder al información de nuestro JSON
    public JSONObject getData() {
        return data;
    }
}
