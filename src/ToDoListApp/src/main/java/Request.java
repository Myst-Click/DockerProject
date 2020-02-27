import org.json.JSONArray;
import org.json.JSONObject;

import java.io.OutputStream;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Request {
    private final String url = "http://localhost:4000/activities/";

    public List<Task> getActivities(int Status) throws Exception {
        String finalurl = "";
        if(Status == 3){
          finalurl = "EndActivities";
        }
        else if(Status == 2){
          finalurl = "workingActivities";
        }
        URL obj = new URL(this.url + finalurl);

        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );
        String inputLine;
        StringBuffer response = new StringBuffer();
        List<Task> result = new ArrayList<>();
        while((inputLine = in.readLine()) != null){

            JSONArray jsons = new JSONArray(inputLine);
            for(int i = 0; i < jsons.length();i++){
                JSONObject json;
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

    public void createTask(String name, String description, int level) throws Exception {
        URL obj = new URL(this.url + "new");

        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        String currentTime = LocalDateTime.now().toString();

        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("description",description);
        json.put("importanceLevel",level);
        json.put("time",currentTime);
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = json.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

    }

    public void endTask(String name) throws Exception {
        URL obj = new URL(this.url + "setEnd");

        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        String currentTime = LocalDateTime.now().toString();

        JSONObject json = new JSONObject();
        json.put("name",name);

        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = json.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

    }
}
