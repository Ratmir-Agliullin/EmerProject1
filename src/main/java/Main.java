import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by Аглиуллины on 17.07.2017.
 */
public class Main {


    public static void main(String[] args) {

//JSONWorker jsonWorker = new JSONWorker();
//jsonWorker.ConvertJSONInFile();
        FileConverter fileConverter=new FileConverter();
Emercoin emercoin = new Emercoin();
  //  String value=    emercoin.getDataFromChain("soufee:C:\\1\\1.txt");
//fileConverter.writeInFile("1.txt",value);
        for (File file : fileConverter.getListFiles()
             ) { String name = "Ratmir_Agl_"+file.getName();
            emercoin.setDataInChain(name,fileConverter.getStringFromFile(file));
        }
    }
}
