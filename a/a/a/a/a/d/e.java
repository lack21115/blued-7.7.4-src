package a.a.a.a.a.d;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  public static String a() throws JSONException {
    JSONObject jSONObject1 = new JSONObject(f.a().c());
    for (Map.Entry<String, ?> entry : f.a().b().entrySet())
      jSONObject1.put((String)entry.getKey(), entry.getValue()); 
    jSONObject1.put("data_type", "method");
    JSONArray jSONArray = new JSONArray();
    JSONObject jSONObject2 = new JSONObject();
    jSONObject2.put("raw", jSONObject1.toString());
    jSONArray.put(jSONObject2);
    return jSONArray.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */