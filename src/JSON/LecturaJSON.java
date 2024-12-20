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
import EXTRAS.Estacion;
import EDD.Grafo;
import EDD.Vertice;
import EXTRAS.Funciones;
import java.io.FileWriter;
import org.json.JSONArray;

public class LecturaJSON {

    private JSONObject data;
    private String originPath;
    private Funciones funtions = new Funciones();

    /**
     * Constructor de LecturaJSON:
            Recibe como parametro un archivo al cual llamaremos endpoint para poder acceder al archivo JSON
            Luego hacemos un try-with-resourses pasandole como resourse el archivo con el JSON (así en caso de que haya un
                error en la lectura del archivo, maneje mejor la excepción y lo cierre al terminar de extraer sus datos).
            Posteriormente definimos nuestra data la cual será el archivo JSON convertido en un Objeto del tipo JSONObject operable denteo de Jsva
            Por ultimo validamos cualquier error mostrando que hibieron errores al internar abrir el archivo en cuestión.
    
            NOTA: Se le pasa al JSONObject un JSONTokener para poder acceder a la informacion del archivo como string y pasarlo aformato JSONObject.
     * @param endpoint 
     * @author Carlos Rodríguez
     */
    
    public LecturaJSON(File endpoint) {
        this.originPath = endpoint.getAbsolutePath();
        try (FileReader reader = new FileReader(endpoint)) {
            this.data = new JSONObject(new JSONTokener(reader));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir: " + e.getMessage());
        }

    }

    //Métodos para poder acceder al información de nuestro JSON y listas de retorno de nuestros vertices.
    
    /**
     * Getter del JSONObject de LecturaJSON
     * @return data: JSONObject general del objeto 
     * @author Carlos Rodríguez
     */
    public JSONObject getData() {
        return data;
    }
    
    /**
     * Getter del path del archivo del archivo con el que se comunica el LecturaJSON
     * @return originPath
     * @author Carlos Rodríguez
     */
    public String getOriginPath() {
        return originPath;
    }

    //Métodos para cambiar atributos:
    
    /**
     * Setter del JSONObject contenido dentro de un LecturaJSON
     * @param data
     * @author Carlos Rodríguez
     */
    public void setData(JSONObject data) {
        this.data = data;
    }

    /**
     * Setter del path del archivo con el que se comunica un LecturaJSON
     * @param originPath 
     * @author Carlos Rodríguez
     */
    public void setOriginPath(String originPath) {
        this.originPath = originPath;
    }
    
    
    //Métodos para el manejo edición del JSON:
    
    /**
     * 
    Creador de nuestra lista de vertices:
        Esta función tiene como fin acceder a nuestro JSON y a partir de ahí empezar a recorrer sus keywords y values con el
        fin de poder crear una estación con cada una como un objeto de tipo estación y luego convertirlos en vertices para
        agregarlos a nuestra lisat de vertices. Todo esto accediendo primero a su keyword principal la cual contiene las keyword
        de las paradas (Ejm: Linea1, Linea2, etc...), y a partir de ahí acceder a los values de las lineas convirtiendolos en un ARREGLO
        usando la libreria JSONArray al igual que como haremos con el contenido de la keyword principal, para así poder recorrerla con mayor
        facilidad y construirlo con mayor soltura.
     * @param g : parametro de tipo Grafo
     * @author Carlos Rodríguez
     */
    public void dataConstructor(Grafo g) {
        String principalKeyWord = this.getData().names().getString(0);
        JSONArray principalData = this.getData().getJSONArray(principalKeyWord);

        for (int i = 0; i < principalData.length(); i++) {
            JSONObject lineValues = principalData.getJSONObject(i);
            String lineKey = lineValues.keys().next();
            JSONArray lineData = lineValues.getJSONArray(lineKey);
            Estacion previousStation = null;

            for (int j = 0; j < lineData.length(); j++) {
                try {
                    Object station = lineData.get(j);
                    if (station instanceof String) {
                        Estacion currentStation = new Estacion((String) station, lineKey);

                        if (g.getListavertices().buscarVertice(currentStation) == null) {
                            if (currentStation.getNombre().contains("*")) {
                                currentStation.setNombre(currentStation.getNombre().replace("*", ""));
                                g.agregarVertice(currentStation);
                                currentStation.setSucursal(true);
                                g.cambiarColorVertice(currentStation, "green");
                            } else {
                                g.agregarVertice(currentStation);
                            }

                        }

                        if (previousStation != null) {

                            if (g.getListavertices().buscarVertice(previousStation).getAdyacencia().buscarNodo(g.getListavertices().buscarVertice(currentStation)) == null) {
                                g.conectarVertices(previousStation, currentStation);
                            }
                        }

                        previousStation = currentStation;

                    } else if (station instanceof JSONObject) {
                        JSONObject connection = (JSONObject) station;

                        String fromStation = connection.keys().next();
                        String toStation = connection.getString(fromStation);

                        Estacion fromEstacion = new Estacion(fromStation, lineKey);

                        Estacion toEstacion = new Estacion(toStation, "Transferencia");

                        if (g.getListavertices().buscarVertice(fromEstacion) == null) {
                            if (fromEstacion.getNombre().contains("*")) {
                                fromEstacion.setNombre(fromEstacion.getNombre().replace("*", ""));
                                if (g.getListavertices().buscarVertice(toEstacion) == null) {
                                    g.agregarVertice(fromEstacion);
                                    fromEstacion.setSucursal(true);
                                    g.cambiarColorVertice(fromEstacion, "green");
                                }

                            } else {
                                g.agregarVertice(fromEstacion);
                            }

                        }

                        if (g.getListavertices().buscarVertice(toEstacion) == null) {
                            if (toEstacion.getNombre().contains("*")) {
                                toEstacion.setNombre(toEstacion.getNombre().replace("*", ""));
                                if (g.getListavertices().buscarVertice(toEstacion) == null) {
                                    toEstacion.setSucursal(true);
                                    g.agregarVertice(toEstacion);
                                    g.cambiarColorVertice(toEstacion, "green");
                                }
                            } else {
                                g.agregarVertice(toEstacion);
                            }

                        }

                        if (g.getListavertices().buscarVertice(fromEstacion)
                                .getAdyacencia().buscarNodo(g.getListavertices().buscarVertice(toEstacion)) == null) {
                            g.conectarVertices(fromEstacion, toEstacion);
                        }

                        if (previousStation != null) {

                            if (g.getListavertices().buscarVertice(previousStation)
                                    .getAdyacencia().buscarNodo(g.getListavertices().buscarVertice(fromEstacion)) == null) {
                                g.conectarVertices(previousStation, fromEstacion);
                            }
                        }

                        previousStation = fromEstacion;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            ("Error inesperado"),
                            "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }


    /**
     Sobreescribir archivo:
        Esta función tiene como fin sobre escribir nuestro JSON original actualizando el JSONArray de Lineas
        del metro y reflejando eso en el archivo original, esto se logra usando la libreria FileWriter la cual
        nos permite poder editar un archivo partiendo de su path en el directorio.
     * @param data: Parametro de tipo String[]
     * @param lineName: Parametro de tipo String
     * @param graph: Parametro de tipo Grafo
     * @author Carlos Rodríguez
     */
    public void addData(String[] data, String lineName, Grafo graph) {
        String principalKeyWord = this.getData().names().getString(0); //Obtenemos la keyword principal
        JSONArray principalData = this.getData().getJSONArray(principalKeyWord); // obtenemos arreglo de lineas

        JSONObject newLine = new JSONObject(); //creamos el json de la nueva linea
        JSONArray newStations = new JSONArray(); //creamos el jsonarray para las estaciones de esta nueva linea 

        for (String station : data) {
            if (station.contains("-")) {
                String[] substation = station.split("-");

                if (substation.length >= 2) {
                    String fromStation = funtions.formatearTitulo(substation[0]);
                    String toStation = funtions.formatearTitulo(substation[1]);
                    JSONObject pathStations = new JSONObject();
                    pathStations.put(fromStation, toStation);
                    newStations.put(pathStations);
                }

            } else {
                Estacion tempStation = new Estacion(funtions.formatearTitulo(station), lineName);
                Vertice stationState = graph.getListavertices().buscarVertice(tempStation);
                if (stationState == null) {
                    newStations.put(tempStation.getNombre()); //agregamos las estaciones a nuestra nueva linea
                }
            }
        }

        newLine.put(lineName, newStations); //agregamos las estaciones a nuestro jsonm de la nueva linea
        principalData.put(newLine); //agregamos al json general la nueva linea.
        updateData();
    }
    
    /**
    Actualizar Archivo:
       Esta función tiene como fin recibir los datos del JSONOBject presentes dentro del LecturaJSON
       para actualizar el JSON con el que se comunica la clase (esto se hace usando el path).
     * @author Carlos Rodríguez
     */
    public void updateData() {
        try (FileWriter sobreescribir = new FileWriter(this.getOriginPath())) {
            sobreescribir.write(this.getData().toString(4)); //sobre escribimos el archivo
        } catch (IOException e) {
        }
    }
    
    /**
    Función para cambair el JSON:
         Esta función lo que hace es recibir los nuevos parametros del nuevo JSON y llama a los setters
         del objeto para redefinir sus atributos 
     * @param newEndpoint: Parametrp de tipo File
     * @param g: Parametro de tipo Grafo
     * @author Carlos Rodríguez
     * 
     */
    public void changeJSON(File newEndpoint, Grafo g) {
        updateData();
        g.destructor();
        String newPath = newEndpoint.getAbsolutePath();
        this.setOriginPath(newPath);

        try (FileReader reader = new FileReader(newEndpoint)) {
            JSONObject newData = new JSONObject(new JSONTokener(reader));
            this.setData(newData);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al imntentar abrir: " + e.getMessage());
        }

        dataConstructor(g);
    }
    
    /**
    Función Validar Sucursal:
         Esta función tiene como fin recibir la estación a la que se le agregue la sucursal y marcar dentro del JSON
         dicha sucursal con un * para que la proxima vez que se llame, tenga la sucursal ya predefinida. Al finalizar dicho proceso
         actualiza el JSON con los nuevis datos usando la función updateData().
        
     * @param station: Parametro de tipo Estación
     * @param graph: Parametro de tipo Grafo
     * @author Carlos Rodríguez
     */
    public void checkSucursal(Estacion station, Grafo graph) {
        String principalKeyWord = this.getData().names().getString(0);
        JSONArray principalData = this.getData().getJSONArray(principalKeyWord);
        for (int i = 0; i < principalData.length(); i++) {
            JSONObject lineValues = principalData.getJSONObject(i);
            String lineKey = lineValues.keys().next();
            JSONArray lineData = lineValues.getJSONArray(lineKey);

            for (int j = 0; j < lineData.length(); j++) {
                Object line = lineData.get(j);
                if (line instanceof String) {
                    if (station.getNombre().toLowerCase().equals(((String) line).toLowerCase())) {
                        lineData.put(j, (String) line + "*");
                    }
                } else if (line instanceof JSONObject) {
                    JSONObject transitionData = (JSONObject) line;
                    String fromStation = transitionData.keys().next();
                    String toStation = transitionData.getString(fromStation);
                    if (station.getNombre().toLowerCase().equals(fromStation.toLowerCase())) {
                        transitionData.put(fromStation + "*", toStation);
                        transitionData.remove(fromStation);
                        lineData.put(j, transitionData);
                    } else if (station.getNombre().toLowerCase().equals(toStation.toLowerCase())) {
                        transitionData.put(fromStation, toStation + "*");
                        lineData.put(j, transitionData);
                    }
                }
            }
        }
        updateData();
    }
    
    
    /**
     Función Eliminar Sucursal:
         Esta función tiene como fin recibir la estación que se desea eliminar y se le elimina
         el * dentro del JSON para que la proxima vez que se construyan los datos esta estación
         no se cree con sucursal.
          * 
     * @param station: Parametro de tipo Estación
     * @param graph: Parametro de tipo Grafo
     * @author Carlos Rodríguez
     */
    public void deleteSucursal(Estacion station, Grafo graph) {
        String principalKeyWord = this.getData().names().getString(0);
        JSONArray principalData = this.getData().getJSONArray(principalKeyWord);

        for (int i = 0; i < principalData.length(); i++) {
            JSONObject lineValues = principalData.getJSONObject(i);
            String lineKey = lineValues.keys().next();
            JSONArray lineData = lineValues.getJSONArray(lineKey);

            for (int j = 0; j < lineData.length(); j++) {
                Object line = lineData.get(j);
                if (line instanceof String) {
                    if (station.getNombre().toLowerCase().equals(((String) line).toLowerCase().replace("*", ""))) {
                        lineData.put(j, ((String) line).replace("*", ""));
                    }
                } else if (line instanceof JSONObject) {
                    JSONObject transitionData = (JSONObject) line;
                    String fromStation = transitionData.keys().next();
                    String toStation = transitionData.getString(fromStation);
                    if (station.getNombre().toLowerCase().equals(fromStation.toLowerCase().replace("*", ""))) {
                        transitionData.put(fromStation.replace("*", ""), toStation);
                        transitionData.remove(fromStation);
                        lineData.put(j, transitionData);
                    } else if (station.getNombre().toLowerCase().equals(toStation.toLowerCase().replace("*", ""))) {
                        transitionData.put(fromStation, toStation.replace("*", ""));
                        lineData.put(j, transitionData);
                    }
                }
            }
        }
        updateData();
    }
}
