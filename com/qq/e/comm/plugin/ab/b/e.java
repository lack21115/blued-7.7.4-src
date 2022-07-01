package com.qq.e.comm.plugin.ab.b;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  private String a;
  
  private String b;
  
  private a c;
  
  private int d = 0;
  
  public e(d paramd, a parama, String paramString) {
    this.a = paramd.c();
    this.c = parama;
    this.b = paramString;
  }
  
  public e(d paramd, a parama, JSONObject paramJSONObject) {
    this(paramd, parama, str);
  }
  
  public e(d paramd, a parama, JSONObject paramJSONObject, int paramInt) {
    this(paramd, parama, str);
    String str;
    this.d = paramInt;
  }
  
  public String a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("callbackid", this.a);
      jSONObject.put("status", this.c.ordinal());
      jSONObject.put("data", this.b);
      jSONObject.put("keep", this.d);
    } catch (JSONException jSONException) {
      GDTLogger.w("Exception while sendingJSResponse", (Throwable)jSONException);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bridge.callback");
    stringBuilder.append("(");
    stringBuilder.append(jSONObject.toString());
    stringBuilder.append(");");
    return stringBuilder.toString();
  }
  
  public enum a {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */