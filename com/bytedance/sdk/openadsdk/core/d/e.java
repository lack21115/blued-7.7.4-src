package com.bytedance.sdk.openadsdk.core.d;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.a.c;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
  private final int[] a;
  
  private final int[] b;
  
  private final int[] c;
  
  private final int[] d;
  
  private final int e;
  
  private final int f;
  
  private final int g;
  
  private final int h;
  
  private final long i;
  
  private final long j;
  
  private final int k;
  
  private final int l;
  
  private final int m;
  
  private final int n;
  
  private SparseArray<c.a> o;
  
  private e(a parama) {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.d = a.c(parama);
    this.c = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.i = a.i(parama);
    this.j = a.j(parama);
    this.k = a.k(parama);
    this.l = a.l(parama);
    this.m = a.m(parama);
    this.n = a.n(parama);
    this.o = a.o(parama);
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      int[] arrayOfInt = this.a;
      int i = 0;
      if (arrayOfInt != null && this.a.length == 2)
        jSONObject.putOpt("ad_x", Integer.valueOf(this.a[0])).putOpt("ad_y", Integer.valueOf(this.a[1])); 
      if (this.b != null && this.b.length == 2)
        jSONObject.putOpt("width", Integer.valueOf(this.b[0])).putOpt("height", Integer.valueOf(this.b[1])); 
      if (this.c != null && this.c.length == 2)
        jSONObject.putOpt("button_x", Integer.valueOf(this.c[0])).putOpt("button_y", Integer.valueOf(this.c[1])); 
      if (this.d != null && this.d.length == 2)
        jSONObject.putOpt("button_width", Integer.valueOf(this.d[0])).putOpt("button_height", Integer.valueOf(this.d[1])); 
      JSONObject jSONObject1 = new JSONObject();
      JSONArray jSONArray = new JSONArray();
      if (this.o != null)
        while (true) {
          if (i < this.o.size()) {
            c.a a = (c.a)this.o.valueAt(i);
            if (a != null) {
              JSONObject jSONObject2 = new JSONObject();
              jSONObject2.putOpt("force", Double.valueOf(a.c)).putOpt("mr", Double.valueOf(a.b)).putOpt("phase", Integer.valueOf(a.a)).putOpt("ts", Long.valueOf(a.d));
              jSONArray.put(jSONObject2);
            } 
          } else {
            jSONObject1.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.e)).putOpt("down_y", Integer.valueOf(this.f)).putOpt("up_x", Integer.valueOf(this.g)).putOpt("up_y", Integer.valueOf(this.h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject1);
            return jSONObject;
          } 
          i++;
        }  
      jSONObject1.putOpt("ftc", Integer.valueOf(this.n)).putOpt("info", jSONArray);
      jSONObject.putOpt("down_x", Integer.valueOf(this.e)).putOpt("down_y", Integer.valueOf(this.f)).putOpt("up_x", Integer.valueOf(this.g)).putOpt("up_y", Integer.valueOf(this.h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", jSONObject1);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public static class a {
    private long a;
    
    private long b;
    
    private int c;
    
    private int d;
    
    private int e;
    
    private int f;
    
    private int[] g;
    
    private int[] h;
    
    private int[] i;
    
    private int[] j;
    
    private int k;
    
    private int l;
    
    private int m;
    
    private SparseArray<c.a> n;
    
    private int o;
    
    public a a(int param1Int) {
      this.o = param1Int;
      return this;
    }
    
    public a a(long param1Long) {
      this.a = param1Long;
      return this;
    }
    
    public a a(SparseArray<c.a> param1SparseArray) {
      this.n = param1SparseArray;
      return this;
    }
    
    public a a(int[] param1ArrayOfint) {
      this.g = param1ArrayOfint;
      return this;
    }
    
    public e a() {
      return new e(this);
    }
    
    public a b(int param1Int) {
      this.c = param1Int;
      return this;
    }
    
    public a b(long param1Long) {
      this.b = param1Long;
      return this;
    }
    
    public a b(int[] param1ArrayOfint) {
      this.h = param1ArrayOfint;
      return this;
    }
    
    public a c(int param1Int) {
      this.d = param1Int;
      return this;
    }
    
    public a c(int[] param1ArrayOfint) {
      this.i = param1ArrayOfint;
      return this;
    }
    
    public a d(int param1Int) {
      this.e = param1Int;
      return this;
    }
    
    public a d(int[] param1ArrayOfint) {
      this.j = param1ArrayOfint;
      return this;
    }
    
    public a e(int param1Int) {
      this.f = param1Int;
      return this;
    }
    
    public a f(int param1Int) {
      this.k = param1Int;
      return this;
    }
    
    public a g(int param1Int) {
      this.l = param1Int;
      return this;
    }
    
    public a h(int param1Int) {
      this.m = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */