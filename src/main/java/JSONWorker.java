import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Аглиуллины on 19.07.2017.
 */
public class JSONWorker {
    FileConverter fileConverter = new FileConverter();



    public JSONObject FileToJSON(){
        JSONObject resultJson = new JSONObject();
        for (File file:fileConverter.getListFiles()
                ) {
            resultJson.put(file.getName(),fileConverter.getStringFromFile(file));
        }

        System.out.println(resultJson.toJSONString());
        return resultJson;
    }

    public void JSONToString(){
        for (File file:fileConverter.getListFiles()
                ) {JSONObject filename = new JSONObject();
            filename.put("filename: ",file.getName());
            Object str = FileToJSON().get(filename);
            System.out.println(str.toString());
        }
    }

    public void ConvertJSONInFile(){
        HashMap<String,Object> block =
                null;
        try {
            block = new ObjectMapper().readValue(String.valueOf(FileToJSON()), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry entry:block.entrySet()
                ) {
            fileConverter.writeInFile(entry.getKey().toString(),entry.getValue().toString());
            System.out.println("File "+entry.getKey().toString()+" value "+entry.getValue().toString());

        }
    }

    public String getValueFormJSON( StringBuffer result){

        String json = result.toString();
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObj = (JSONObject) obj;
        Object objValue = jsonObj.get("result");
        JSONObject jsonValue = (JSONObject) objValue;
        return jsonValue.get("value").toString();
    }

}
