package com.ss.android.a.a.c;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class d {
  private String a;
  
  private final String b;
  
  private final String c;
  
  private final boolean d;
  
  private final long e;
  
  private final String f;
  
  private final long g;
  
  private final JSONObject h;
  
  private final List<String> i;
  
  private final int j;
  
  private final Object k;
  
  private final String l;
  
  private final boolean m;
  
  private final String n;
  
  private final JSONObject o;
  
  d(a parama) {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.i = a.i(parama);
    this.j = a.j(parama);
    this.k = a.k(parama);
    this.m = a.l(parama);
    this.n = a.m(parama);
    this.o = a.n(parama);
    this.l = a.o(parama);
  }
  
  public String a() {
    return this.b;
  }
  
  public String b() {
    return this.c;
  }
  
  public boolean c() {
    return this.d;
  }
  
  public JSONObject d() {
    return this.h;
  }
  
  public boolean e() {
    return this.m;
  }
  
  public String toString() {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("category: ");
    stringBuilder.append(this.a);
    stringBuilder.append("\ttag: ");
    stringBuilder.append(this.b);
    stringBuilder.append("\tlabel: ");
    stringBuilder.append(this.c);
    stringBuilder.append("\nisAd: ");
    stringBuilder.append(this.d);
    stringBuilder.append("\tadId: ");
    stringBuilder.append(this.e);
    stringBuilder.append("\tlogExtra: ");
    stringBuilder.append(this.f);
    stringBuilder.append("\textValue: ");
    stringBuilder.append(this.g);
    stringBuilder.append("\nextJson: ");
    stringBuilder.append(this.h);
    stringBuilder.append("\nclickTrackUrl: ");
    List<String> list = this.i;
    String str2 = "";
    if (list != null) {
      str1 = list.toString();
    } else {
      str1 = "";
    } 
    stringBuilder.append(str1);
    stringBuilder.append("\teventSource: ");
    stringBuilder.append(this.j);
    stringBuilder.append("\textraObject: ");
    Object object = this.k;
    if (object != null) {
      object = object.toString();
    } else {
      object = "";
    } 
    stringBuilder.append((String)object);
    stringBuilder.append("\nisV3: ");
    stringBuilder.append(this.m);
    stringBuilder.append("\tV3EventName: ");
    stringBuilder.append(this.n);
    stringBuilder.append("\tV3EventParams: ");
    JSONObject jSONObject = this.o;
    object = str2;
    if (jSONObject != null)
      object = jSONObject.toString(); 
    stringBuilder.append((String)object);
    return stringBuilder.toString();
  }
  
  public static class a {
    private String a;
    
    private String b;
    
    private String c;
    
    private boolean d = false;
    
    private long e;
    
    private String f;
    
    private long g;
    
    private JSONObject h;
    
    private Map<String, Object> i;
    
    private List<String> j;
    
    private int k;
    
    private Object l;
    
    private String m;
    
    private boolean n = false;
    
    private String o;
    
    private JSONObject p;
    
    public a a(int param1Int) {
      this.k = param1Int;
      return this;
    }
    
    public a a(long param1Long) {
      this.e = param1Long;
      return this;
    }
    
    public a a(Object param1Object) {
      this.l = param1Object;
      return this;
    }
    
    public a a(String param1String) {
      this.b = param1String;
      return this;
    }
    
    public a a(List<String> param1List) {
      this.j = param1List;
      return this;
    }
    
    public a a(JSONObject param1JSONObject) {
      this.h = param1JSONObject;
      return this;
    }
    
    public a a(boolean param1Boolean) {
      this.n = param1Boolean;
      return this;
    }
    
    public d a() {
      if (TextUtils.isEmpty(this.a))
        this.a = "umeng"; 
      JSONObject jSONObject = new JSONObject();
      if (this.h == null)
        this.h = new JSONObject(); 
      try {
        if (this.i != null && !this.i.isEmpty())
          for (Map.Entry<String, Object> entry : this.i.entrySet()) {
            if (!this.h.has((String)entry.getKey()))
              this.h.putOpt((String)entry.getKey(), entry.getValue()); 
          }  
        boolean bool = this.n;
        if (bool) {
          this.o = this.c;
          this.p = new JSONObject();
          Iterator<String> iterator = this.h.keys();
          while (iterator.hasNext()) {
            String str = iterator.next();
            this.p.put(str, this.h.get(str));
          } 
          this.p.put("category", this.a);
          this.p.put("tag", this.b);
          this.p.put("value", this.e);
          this.p.put("ext_value", this.g);
          if (!TextUtils.isEmpty(this.m))
            this.p.put("refer", this.m); 
          if (this.d) {
            if (!this.p.has("log_extra") && !TextUtils.isEmpty(this.f))
              this.p.put("log_extra", this.f); 
            this.p.put("is_ad_event", "1");
          } 
        } 
        if (this.d) {
          jSONObject.put("ad_extra_data", this.h.toString());
          if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f))
            jSONObject.put("log_extra", this.f); 
          jSONObject.put("is_ad_event", "1");
        } else {
          jSONObject.put("extra", this.h);
        } 
        if (!TextUtils.isEmpty(this.m))
          jSONObject.putOpt("refer", this.m); 
        this.h = jSONObject;
      } catch (Exception exception) {}
      return new d(this);
    }
    
    public a b(long param1Long) {
      this.g = param1Long;
      return this;
    }
    
    public a b(String param1String) {
      this.c = param1String;
      return this;
    }
    
    public a b(boolean param1Boolean) {
      this.d = param1Boolean;
      return this;
    }
    
    public a c(String param1String) {
      this.f = param1String;
      return this;
    }
    
    public a d(String param1String) {
      this.m = param1String;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\a\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */