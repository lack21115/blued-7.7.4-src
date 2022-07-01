package com.bun.miitmdid.a;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.a.c.a;
import com.bun.miitmdid.a.c.b;
import com.bun.miitmdid.a.c.c;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class a implements b {
  public a a = new a(this);
  
  public static a a(Context paramContext) {
    String str = com.bun.miitmdid.d.a.a(paramContext, "supplierconfig.json");
    if (!TextUtils.isEmpty(str)) {
      boolean bool;
      a a1 = new a();
      JSONTokener jSONTokener = new JSONTokener(str);
      try {
        JSONObject jSONObject = (JSONObject)jSONTokener.nextValue();
        if (jSONObject != null) {
          jSONObject = jSONObject.optJSONObject("supplier");
          if (jSONObject != null) {
            boolean bool1 = a(a1, jSONObject);
            boolean bool2 = c(a1, jSONObject);
            boolean bool3 = b(a1, jSONObject);
            if (bool1 && bool2 && bool3) {
              bool = true;
            } else {
              bool = false;
            } 
          } else {
            return null;
          } 
        } else {
          return null;
        } 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        bool = false;
      } 
      if (!bool)
        a1 = null; 
      return a1;
    } 
    return null;
  }
  
  private static boolean a(a parama, JSONObject paramJSONObject) {
    if (paramJSONObject != null && parama != null) {
      if (paramJSONObject.optJSONObject("huawei") != null)
        parama.a.a = new a(); 
      if (parama.a.a != null)
        return true; 
    } 
    return false;
  }
  
  private static boolean b(a parama, JSONObject paramJSONObject) {
    if (paramJSONObject != null && parama != null) {
      paramJSONObject = paramJSONObject.optJSONObject("vivo");
      b b1 = new b();
      if (paramJSONObject != null) {
        b1.a = paramJSONObject.optString("appid");
        parama.a.b = b1;
      } 
      if (parama.a.b != null)
        return true; 
    } 
    return false;
  }
  
  private static boolean c(a parama, JSONObject paramJSONObject) {
    if (paramJSONObject != null && parama != null) {
      if (paramJSONObject.optJSONObject("xiaomi") != null)
        parama.a.c = new c(); 
      if (parama.a.c != null)
        return true; 
    } 
    return false;
  }
  
  public String a() {
    a a1 = this.a;
    if (a1 == null)
      return ""; 
    b b1 = a1.b;
    if (b1 == null)
      return ""; 
    String str2 = b1.a;
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public class a {
    public a a;
    
    public b b;
    
    public c c;
    
    public a(a this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */