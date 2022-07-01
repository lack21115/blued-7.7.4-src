package com.huawei.agconnect.config.a;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

class d implements b {
  private final JSONObject a;
  
  d(InputStream paramInputStream) {
    this.a = a(paramInputStream);
  }
  
  private JSONObject a(InputStream paramInputStream) {
    if (paramInputStream != null) {
      String str;
      try {
        return new JSONObject(h.a(paramInputStream, "UTF-8"));
      } catch (IOException iOException) {
        str = "IOException when reading the 'Config' from InputStream.";
      } catch (JSONException jSONException) {
        str = "JSONException when reading the 'Config' from InputStream.";
      } 
      Log.e("InputStreamReader", str);
    } 
    return new JSONObject();
  }
  
  public String a(String paramString1, String paramString2) {
    if (paramString1.endsWith("/"))
      return paramString2; 
    String[] arrayOfString = paramString1.split("/");
    try {
      JSONObject jSONObject = this.a;
      for (int i = 1; i < arrayOfString.length; i++) {
        if (i == arrayOfString.length - 1)
          return jSONObject.get(arrayOfString[i]).toString(); 
        jSONObject = jSONObject.getJSONObject(arrayOfString[i]);
      } 
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("JSONException when reading 'path': ");
      stringBuilder.append(paramString1);
      Log.w("InputStreamReader", stringBuilder.toString());
    } 
    return paramString2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */