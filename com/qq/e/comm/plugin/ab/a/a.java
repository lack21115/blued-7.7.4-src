package com.qq.e.comm.plugin.ab.a;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

public class a {
  private final c a;
  
  private final JSONObject b;
  
  public a(c paramc, JSONObject paramJSONObject) {
    this.a = paramc;
    this.b = paramJSONObject;
  }
  
  public static a a(String paramString, JSONObject paramJSONObject) {
    StringBuilder stringBuilder;
    c c1 = c.a(paramString);
    if (c1 == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Unknown ADEvent Type:");
      stringBuilder.append(paramString);
      GDTLogger.e(stringBuilder.toString());
      return null;
    } 
    return new a(c1, (JSONObject)stringBuilder);
  }
  
  public c a() {
    return this.a;
  }
  
  public JSONObject b() {
    return this.b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("event<");
    stringBuilder.append(this.a);
    stringBuilder.append(",");
    stringBuilder.append(this.b);
    stringBuilder.append(">");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */