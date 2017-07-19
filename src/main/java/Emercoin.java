import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Аглиуллины on 19.07.2017.
 */
public class Emercoin {

JSONWorker jsonWorker = new JSONWorker();

private final  String url = "http://Ratmir:KP15CY88@127.0.0.1:6662";

public void setDataInChain(String name, String value){
    HttpClient client = HttpClientBuilder.create().build();

    HttpPost post = new HttpPost(url);
    JSONObject data = new JSONObject();
    data.put("method", "name_new");
    JSONArray ar = new JSONArray();
    ar.add(name);
    ar.add(value);
    ar.add(30);
    data.put("params",ar);
    StringEntity input = null;
    try {
        input = new StringEntity(data.toJSONString());
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

    post.setEntity(input);

    HttpResponse response = null;
    try {
        response = client.execute(post);
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(name+" have done!");
}



    public String getDataFromChain(String name){


        HttpClient client = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost(url);
        JSONObject data = new JSONObject();
        data.put("method", "name_show");
        JSONArray ar = new JSONArray();
        ar.add(name);
        data.put("params",ar);

        post.setHeader("Content-type", "application/json"); // add header


        StringEntity input = null;
        try {
            input = new StringEntity(data.toJSONString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        post.setEntity(input);

        HttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer result = new StringBuffer();

        String line = "";


        try {
            while ((line = rd.readLine()) != null) {
                result.append(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

String res = jsonWorker.getValueFormJSON(result);
        System.out.println(res);
return res;
    }

}
