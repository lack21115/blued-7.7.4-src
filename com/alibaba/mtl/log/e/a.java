package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public static a a(String paramString) {
    a a1 = new a();
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (jSONObject.has("success")) {
        String str = jSONObject.getString("success");
        if (!TextUtils.isEmpty(str) && str.equals("success"))
          a1.G = true; 
      } 
      if (jSONObject.has("ret")) {
        a1.ad = jSONObject.getString("ret");
        return a1;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return a1;
  }
  
  public static class a {
    public static a a = new a();
    
    public boolean G = false;
    
    public String ad = null;
    
    public boolean i() {
      return "E0102".equalsIgnoreCase(this.ad);
    }
    
    public boolean j() {
      return ("E0111".equalsIgnoreCase(this.ad) || "E0112".equalsIgnoreCase(this.ad));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */