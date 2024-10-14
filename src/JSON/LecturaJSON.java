/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author pseba
 */
public class LecturaJSON {
    
    public JSONObject data;
    public String endpoint;
    public LecturaJSON(String filePath){
        try {
            this.endpoint = filePath;
            Object JSON = new JSONParser().parse(new FileReader(endpoint));
            this.data = (JSONObject) JSON;
            
        } catch (IOException | ParseException e) {
            System.out.println("File not found");
        }
    }

    public JSONObject getData() {
        return data;
    } 

}
