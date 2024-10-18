/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import EDD.Grafo;
import EDD.Vertice;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.JSONTokener;
import EXTRAS.Estacion;
import java.io.FileWriter;
import org.json.JSONArray;

public class LecturaJSON {

    private JSONObject data;
    private String originPath;

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
        try (FileReader reader = new FileReader(endpoint)) {
            this.originPath = endpoint.getAbsolutePath();
            this.data = new JSONObject(new JSONTokener(reader));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al imntentar abrir: " + e.getMessage());
        }

    }

    //Métodos para poder acceder al información de nuestro JSON y listas de retorno de nuestros vertices.
    public JSONObject getData() {
        return data;
    }

    public String getOriginPath() {
        return originPath;
    }

    /*
        Creador de nuestra lista de vertices:
            Esta función tiene como fin acceder a nuestro JSON y a partir de ahí empezar a recorrer sus keywords y values con el 
            fin de poder crear una estación con cada una como un objeto de tipo estación y luego convertirlos en vertices para 
    `       agregarlos a nuestra lisat de vertices. Todo esto accediendo primero a su keyword principal la cual contiene las keyword 
            de las paradas (Ejm: Linea1, Linea2, etc...), y a partir de ahí acceder a los values de las lineas convirtiendolos en un ARREGLO
            usando la libreria JSONArray al igual que como haremos con el contenido de la keyword principal, para así poder recorrerla con mayor 
            facilidad y construirlo con mayor soltura.
            
     */
    public void dataConstructor(Grafo graph) {
        String principalKeyWord = this.getData().names().getString(0); //Obtenemos la keyword principal
        JSONArray principalData = this.getData().getJSONArray(principalKeyWord); //Obtiene el arreglo de JSONs donde se contienen los JSONs individuales para cada linea
        for (int i = 0; i < principalData.length(); i++) {
            JSONObject lineValues = principalData.getJSONObject(i); //Obtenemos el JSON de la linea en la que nos encontremos.
            String lineKey = lineValues.keys().next(); //Obtenemos el key para acceder a los datos del JSON de esta determianda linea.
            JSONArray lineData = lineValues.getJSONArray(lineKey); //Obtenemos los datos del JSON de la linea en la que estemos usando el keyword para su data.
            Estacion prevStation = null;

            for (int j = 0; j < lineData.length(); j++) {
                try {
                    Object station = lineData.getString(j); //Al recorrer la lista de estaciones obtenemos el nombre de la estación posteriormente verificamso si es String o otro JSONObject

                    if (station instanceof String) {
                        String stationName = (String) station; //Con el nombre de la estacion creamos un string con el nombre de la estación
                        Estacion currentStation = findEstacion(graph, stationName, lineKey); //Might be the linekey thing

                        if (currentStation == null) {
                            currentStation = new Estacion(stationName, lineKey);
                            validacionSucursal(currentStation);
                            graph.agregarVertice(currentStation);
                        }

                        if (prevStation != null) {
                            graph.conectarVertices(prevStation, currentStation);
                        }

                        prevStation = currentStation;

                    } else if (station instanceof JSONObject) {
                        JSONObject connection = (JSONObject) station;
                        String fromStationData = connection.keys().next();
                        String toStationData = connection.getString(fromStationData);

                        Estacion fromStation = findEstacion(graph, fromStationData, lineKey);
                        if (fromStationData == null) {
                            fromStation = new Estacion(fromStationData, lineKey);
                            validacionSucursal(fromStation);
                            graph.agregarVertice(fromStation);
                        }

                        Estacion toStation = findEstacion(graph, toStationData, lineKey);
                        if (toStation == null) {
                            toStation = new Estacion(toStationData, lineKey);
                            validacionSucursal(toStation);
                            graph.agregarVertice(toStation);
                        }

                        graph.conectarVertices(fromStation, toStation);

                        if (prevStation != null) {
                            graph.conectarVertices(prevStation, fromStation);
                        }

                        prevStation = fromStation;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /*
        Validación de vertices:
            Esta es una función la cual recorre la lista de bvertices de nuestro grafo con el que estemos trabajando
            con el fin de validar si una estación esta o no esta dentro de dicha lista, esta función es usada en el
            procedimiento dataConstructor() con el fin de no repetir vertices durante el proceso de construcción de datos.
            
     */
    public Estacion findEstacion(Grafo g, String stationName, String lineKey) {
        Vertice aux = g.getListavertices().getVfirst(); //Inicializamos el puntero recorredor
        while (aux != null) {
            if (aux.getTinfo().getNombre().equals(stationName) && aux.getTinfo().getLinea().equals(lineKey)) { //Recorremos validando que se encuentre o no dicho vertice
                return aux.getTinfo(); //Retornamos la estación de ser encontrado
            }
            aux = aux.getNext();
        }
        return null; //Retornamos null de no encontrar dicho vertice
    }

    /*
    
        Validación de Sucursal:
            Esta función valida si la esatción creada tiene o no asignada una sucursal (esto en función
            a si tiene un * en su nombre.
    */
    public void validacionSucursal(Estacion station) {
        if (station.getNombre().indexOf('*') != -1) {
            station.setSucursal(true);
        }
    }

    /*
        Sobreescribir archivo:
            Esta función tiene como fin sobre escribir nuestro JSON original actualizando el JSONArray de Lineas
            del metro y reflejando eso en el archivo original, esto se logra usando la libreria FileWriter la cual
            nos permite poder editar un archivo partiendo de su path en el directorio.
    
            //FIX
     */
    public void addData(String[] data, String stationName) {
        String principalKeyWord = this.getData().names().getString(0); //Obtenemos la keyword principal
        JSONArray principalData = this.getData().getJSONArray(principalKeyWord); // obtenemos arreglo de lineas

        JSONObject newLine = new JSONObject(); //creamos el json de la nueva linea
        JSONArray newStations = new JSONArray(); //creamos el jsonarray para las estaciones de esta nueva linea 

        for (String station : data) {
            newStations.put(station); //agregamos las estaciones a nuestra nueva linea
        }
        newLine.put(stationName, newStations); //agregamos las estaciones a nuestro jsonm de la nueva linea
        principalData.put(newLine); //agregamos al json general la nueva linea.

        try (FileWriter sobreescribir = new FileWriter(this.getOriginPath())) {
            sobreescribir.write(this.getData().toString(4)); //sobre escribimos el archivo
        } catch (IOException e) {
        }
    }
}
