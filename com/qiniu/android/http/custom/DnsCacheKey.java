package com.qiniu.android.http.custom;

import org.json.JSONException;
import org.json.JSONObject;

public class DnsCacheKey {
  public String akScope;
  
  public String currentTime;
  
  public String localIp;
  
  public DnsCacheKey() {}
  
  public DnsCacheKey(String paramString1, String paramString2, String paramString3) {
    this.currentTime = paramString1;
    this.localIp = paramString2;
    this.akScope = paramString3;
  }
  
  public static DnsCacheKey toCacheKey(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      return new DnsCacheKey(jSONObject.getString("currentTime"), jSONObject.getString("localIp"), jSONObject.getString("akScope"));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return null;
    } 
  }
  
  public String getAkScope() {
    return this.akScope;
  }
  
  public String getCurrentTime() {
    return this.currentTime;
  }
  
  public String getLocalIp() {
    return this.localIp;
  }
  
  public void setAkScope(String paramString) {
    this.akScope = paramString;
  }
  
  public void setCurrentTime(String paramString) {
    this.currentTime = paramString;
  }
  
  public void setLocalIp(String paramString) {
    this.localIp = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{\"currentTime\":\"");
    stringBuilder.append(this.currentTime);
    stringBuilder.append("\", \"localIp\":\"");
    stringBuilder.append(this.localIp);
    stringBuilder.append("\", \"akScope\":\"");
    stringBuilder.append(this.akScope);
    stringBuilder.append("\"}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\custom\DnsCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */