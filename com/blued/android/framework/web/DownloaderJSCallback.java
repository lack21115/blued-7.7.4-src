package com.blued.android.framework.web;

import androidx.collection.ArrayMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloaderJSCallback {
  private Map<String, String> a = (Map<String, String>)new ArrayMap();
  
  private JSExecutor b;
  
  public DownloaderJSCallback(JSExecutor paramJSExecutor) {
    this.b = paramJSExecutor;
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("option", paramString2);
      jSONObject.put("code", paramString1);
      jSONObject.put("progress", paramInt2);
      for (String paramString2 : this.a.keySet()) {
        String str = this.a.get(paramString2);
        JSExecutor jSExecutor = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(str);
        stringBuilder.append("('");
        stringBuilder.append(paramInt1);
        stringBuilder.append("',");
        stringBuilder.append(jSONObject.toString());
        stringBuilder.append(")");
        jSExecutor.a(paramString2, stringBuilder.toString());
      } 
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  public void a(String paramString1, String paramString2) {
    this.a.put(paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\DownloaderJSCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */