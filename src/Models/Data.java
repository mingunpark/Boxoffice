package Models;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Data {
    public Data() throws Exception{
        
        JSONParser jsonparser = new JSONParser();
        JSONObject jsonobject = (JSONObject)jsonparser.parse(readUrl());
        JSONObject json =  (JSONObject) jsonobject.get("boxOfficeResult");
        JSONArray array = (JSONArray)json.get("dailyBoxOfficeList");
        for(int i = 0 ; i < array.size(); i++){
            
            JSONObject entity = (JSONObject)array.get(i);
            String movieNm = (String) entity.get("movieNm");
            String rank = (String) entity.get("rank");
             
            System.out.println(rank+". "+movieNm);
        }
        
        
   }
   private static String readUrl() throws Exception {
       URL url = new URL("http://ec2-52-26-144-160.us-west-2.compute.amazonaws.com:3000/jiminzzang");
       
       
       // HTTP Connection ���ϱ� 
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       
       // ��û ��� ���� ( GET or POST or .. ������ �������������� GET ��� )
       conn.setRequestMethod("GET"); 
       
       // ���� Ÿ�Ӿƿ� ���� 
       conn.setConnectTimeout(3000); // 3�� 
       // �б� Ÿ�Ӿƿ� ���� 
       conn.setReadTimeout(3000); // 3�� 
       
              
       // ���� ����(BODY) ���ϱ�        
       try (InputStream in = conn.getInputStream();
               ByteArrayOutputStream out = new ByteArrayOutputStream()) {
           
           byte[] buf = new byte[1024 * 8];
           int length = 0;
           while ((length = in.read(buf)) != -1) {
               out.write(buf, 0, length);
           }
           return new String(new String(out.toByteArray(), "UTF-8"));            
       }
       

   }
}
