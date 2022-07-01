package com.bytedance.sdk.openadsdk.core.d;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class o {
  private String a;
  
  private String b;
  
  private String c;
  
  private List<a> d;
  
  public static o a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    try {
      o o1 = new o();
    } finally {
      paramJSONObject = null;
    } 
  }
  
  public static o d(String paramString) {
    if (paramString == null)
      return null; 
    try {
      return a(new JSONObject(paramString));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(List<a> paramList) {
    List<a> list = paramList;
    if (paramList == null)
      list = new ArrayList<a>(); 
    this.d = list;
  }
  
  public String b() {
    return this.b;
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public String c() {
    return this.c;
  }
  
  public void c(String paramString) {
    this.c = paramString;
  }
  
  public List<a> d() {
    if (this.d == null)
      this.d = new ArrayList<a>(); 
    return this.d;
  }
  
  public boolean e() {
    return (c() != null && b() != null && a() != null);
  }
  
  public String f() {
    if (e())
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("name", a());
        jSONObject.putOpt("version", b());
        jSONObject.putOpt("main", c());
        JSONArray jSONArray = new JSONArray();
        if (d() != null)
          for (a a : d()) {
            JSONObject jSONObject1 = new JSONObject();
            jSONObject1.putOpt("url", a.a());
            jSONObject1.putOpt("md5", a.b());
            jSONObject1.putOpt("level", Integer.valueOf(a.c()));
            jSONArray.put(jSONObject1);
          }  
        jSONObject.putOpt("resources", jSONArray);
        return jSONObject.toString();
      } finally {
        Exception exception;
      }  
    return null;
  }
  
  public static class a {
    private String a;
    
    private String b;
    
    private int c;
    
    public String a() {
      return this.a;
    }
    
    public void a(int param1Int) {
      this.c = param1Int;
    }
    
    public void a(String param1String) {
      this.a = param1String;
    }
    
    public String b() {
      return this.b;
    }
    
    public void b(String param1String) {
      this.b = param1String;
    }
    
    public int c() {
      return this.c;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof a) {
        String str = this.a;
        return (str != null && str.equals(((a)param1Object).a()));
      } 
      return super.equals(param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */