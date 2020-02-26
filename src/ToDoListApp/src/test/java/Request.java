import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Request {
     private final String url = "http://localhost:4000/activities/";

     public List<Task> getActivities() throws Exception {
         URL obj = new URL(this.url);

         HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

         conn.setRequestMethod("GET");

         int responseCode = conn.getResponseCode();

         BufferedReader in = new BufferedReader(
                 new InputStreamReader(conn.getInputStream())
         );
         String inputLine;
         StringBuffer response = new StringBuffer();
         List<Task> result = new ArrayList<Task>();
         while((inputLine = in.readLine()) != null){

             JSONArray jsons = new JSONArray(inputLine);
             for(int i = 0; i < jsons.length();i++){
                 JSONObject json = new JSONObject();
                 json = jsons.getJSONObject(i);
                 String name = json.getString("name");
                 String description = json.getString("description");
                 int level =json.getInt("importanceLevel");
                 Task newTask = new Task(name,level,description);
                 result.add(newTask);
             }

             response.append(inputLine);
         }
         in.close();

         return result;
     }
}
