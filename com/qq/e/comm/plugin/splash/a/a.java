package com.qq.e.comm.plugin.splash.a;

import android.text.TextUtils;
import com.qq.e.comm.util.Md5Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  static String a = "uoid";
  
  static String b = "date";
  
  static String c = "exposureUrl";
  
  static String d = "customUrls";
  
  static String e = "c2sSdkUrls";
  
  public String f;
  
  public String g;
  
  public String h;
  
  public List<String> i;
  
  public List<String> j;
  
  public a() {}
  
  public a(String paramString) {
    a(paramString);
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      this.f = jSONObject.optString(a, "");
      this.g = jSONObject.optString(b, "");
      this.h = jSONObject.optString(c, "");
      JSONArray jSONArray2 = jSONObject.getJSONArray(d);
      byte b = 0;
      if (jSONArray2 != null && jSONArray2.length() > 0) {
        this.i = new ArrayList<String>();
        for (int i = 0; i < jSONArray2.length(); i++) {
          String str = jSONArray2.getString(i);
          this.i.add(str);
        } 
      } 
      JSONArray jSONArray1 = jSONObject.getJSONArray(e);
      if (jSONArray1 != null && jSONArray1.length() > 0) {
        this.j = new ArrayList<String>();
        for (int i = b; i < jSONArray1.length(); i++) {
          String str = jSONArray1.getString(i);
          this.j.add(str);
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public String a() {
    if (TextUtils.isEmpty(this.f))
      return ""; 
    try {
      JSONObject jSONObject = new JSONObject();
      if (!TextUtils.isEmpty(this.f))
        jSONObject.put(a, this.f); 
      if (!TextUtils.isEmpty(this.g))
        jSONObject.put(b, this.g); 
      if (!TextUtils.isEmpty(this.h))
        jSONObject.put(c, this.h); 
      if (this.i != null && this.i.size() > 0)
        jSONObject.put(d, new JSONArray(this.i)); 
      if (this.j != null && this.j.size() > 0)
        jSONObject.put(e, new JSONArray(this.j)); 
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return "";
    } 
  }
  
  public String b() {
    if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.f);
    stringBuilder.append("_");
    stringBuilder.append(this.g);
    return Md5Util.encode(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */