package com.bytedance.sdk.openadsdk.core.h;

import com.bytedance.sdk.openadsdk.utils.ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
  String a;
  
  int b;
  
  JSONArray c;
  
  List<String> d = new ArrayList<String>();
  
  long e;
  
  volatile boolean f;
  
  public static d a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    try {
      d d1 = new d();
      d1.a(paramJSONObject.optString("host"));
      d1.a(paramJSONObject.optInt("ttl", 60));
      d1.a(paramJSONObject.optJSONArray("ips"));
      d1.a(paramJSONObject.optBoolean(" statsdnstime", false));
      long l = paramJSONObject.optLong("starttime", 0L);
      if (l > 0L) {
        d1.a(l);
        return d1;
      } 
      d1.a(System.currentTimeMillis());
      return d1;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public void a(long paramLong) {
    this.e = paramLong;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(JSONArray paramJSONArray) {
    if (paramJSONArray == null)
      return; 
    this.c = paramJSONArray;
    int i = 0;
    while (true) {
      if (i < paramJSONArray.length()) {
        try {
          String str = paramJSONArray.get(i).toString();
          if (ah.l(str))
            this.d.add(str); 
        } catch (Exception exception) {}
        i++;
        continue;
      } 
      return;
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public int b() {
    return this.b;
  }
  
  public JSONArray c() {
    return this.c;
  }
  
  public boolean d() {
    return (System.currentTimeMillis() - f() > (b() * 1000));
  }
  
  public String e() {
    List<String> list = this.d;
    if (list == null || list.size() == 0)
      return null; 
    int i = this.d.size();
    int j = (int)(Math.random() * i + 0.5D) - 1;
    i = j;
    if (j < 0)
      i = 0; 
    return this.d.get(i);
  }
  
  public long f() {
    return this.e;
  }
  
  public boolean g() {
    return this.f;
  }
  
  public JSONObject h() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("host", a());
      jSONObject.put("ttl", b());
      jSONObject.put("ips", c());
      jSONObject.put("starttime", f());
      jSONObject.put("statsdnstime", g());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */