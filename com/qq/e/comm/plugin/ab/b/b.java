package com.qq.e.comm.plugin.ab.b;

import org.json.JSONObject;

public class b {
  private String a;
  
  private JSONObject b;
  
  public b(String paramString, JSONObject paramJSONObject) {
    this.a = paramString;
    this.b = paramJSONObject;
  }
  
  public String a() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("try {");
    stringBuilder.append("bridge.dispatch");
    stringBuilder.append("({'type':'");
    stringBuilder.append(this.a);
    stringBuilder.append("','param':");
    JSONObject jSONObject = this.b;
    if (jSONObject == null) {
      str = "null";
    } else {
      str = JSONObject.quote(str.toString());
    } 
    stringBuilder.append(str);
    stringBuilder.append("})");
    stringBuilder.append("} catch(e) { console.log(e) }");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */