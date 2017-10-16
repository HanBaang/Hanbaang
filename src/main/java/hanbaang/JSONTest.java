package hanbaang;


import java.io.*;
import org.json.simple.*;
 
public class JSONTest {
       public JSONObject JSONBuilder() {
             //Json 객체 생성.
             JSONObject jobj = new JSONObject();
             jobj.put("name", "wdkang");
             jobj.put("company", "acanet");
             jobj.put("age", "26");
            
             //Json Array 생성.
             JSONArray maglist = new JSONArray();
             maglist.add("JSON test");
             maglist.add("hello JSON");
 
             jobj.put("list", maglist);
 
             try {
 
                    FileWriter file = new FileWriter("c:\\myJson.json");
                    file.write(jobj.toJSONString());
                    file.flush();
                    file.close();
             } catch(IOException e) {
                    e.printStackTrace();
             }
             System.out.println("Create JSON Object : "+jobj);
			return jobj;
       }
}
