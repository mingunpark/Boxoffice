package Main;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import View.ViewBoxoffice;
 
public class MainClass {
    

 
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ViewBoxoffice view=new ViewBoxoffice();
            
            view.viewMain();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
}