package com.alipay.sdk.util;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    int i;
    int j;
    JSONObject[] arrayOfJSONObject;
    JSONObject jSONObject = new JSONObject();
    try {
      arrayOfJSONObject = new JSONObject[2];
      i = 0;
      arrayOfJSONObject[0] = paramJSONObject1;
      arrayOfJSONObject[1] = paramJSONObject2;
      j = arrayOfJSONObject.length;
    } catch (JSONException jSONException) {
      c.a((Throwable)jSONException);
      return jSONObject;
    } 
    while (true) {
      if (i < j) {
        JSONObject jSONObject1 = arrayOfJSONObject[i];
        if (jSONObject1 != null) {
          Iterator<String> iterator = jSONObject1.keys();
          while (iterator.hasNext()) {
            String str = iterator.next();
            jSONObject.put(str, jSONObject1.get(str));
          } 
        } 
        i++;
        continue;
      } 
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */