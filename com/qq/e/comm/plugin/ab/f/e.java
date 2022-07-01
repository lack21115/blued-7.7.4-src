package com.qq.e.comm.plugin.ab.f;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.a.a;
import com.qq.e.comm.plugin.ab.f.a.b;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  private a a;
  
  private b b;
  
  private a c;
  
  private f d;
  
  public e(a parama, JSONObject paramJSONObject) {
    this.a = parama;
    this.b = new b(paramJSONObject);
    this.c = new a();
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    b b1 = this.c.a(paramString1);
    if (b1 != null) {
      b1.a(this, paramString1, paramString2, paramString3);
      return;
    } 
    a(paramString3, 2, "Unsupported action!", 0);
  }
  
  private void b(String paramString) {
    try {
      JSONArray jSONArray = new JSONArray(paramString);
      int j = jSONArray.length();
      for (int i = 0; i < j; i++) {
        JSONObject jSONObject = jSONArray.getJSONObject(i);
        String str1 = jSONObject.optString("action");
        String str2 = jSONObject.optString("callbackId");
        a(str1, jSONObject.optJSONObject("params").toString(), str2);
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
  
  public f<String> a(String paramString) {
    String str1;
    String str2;
    String str3;
    String str4;
    boolean bool = f.a(Uri.parse(paramString));
    String str5 = "";
    if (bool) {
      this.d = new f(this.a);
      this.d.a();
      d d = this.d.a(paramString);
      if (d != null) {
        ak.a("UnJsBridge-iFrame", d.toString());
        str2 = d.a();
        str3 = d.b();
        if (d.d() != null) {
          paramString = d.d().toString();
        } else {
          paramString = null;
        } 
        str1 = d.e();
        str4 = d.c();
      } else {
        str2 = "";
        str3 = str2;
        paramString = str3;
        str4 = paramString;
        str1 = str5;
      } 
    } else {
      ak.a("UnJsBridge-jsPrompt", paramString);
      try {
        JSONObject jSONObject = new JSONObject(paramString);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      if (jSONException == null) {
        u.a(100292, 3, null, (new d()).a("msg", paramString));
        return new f(-1, "Invalid message");
      } 
      if (!"GDTJsBridge".equals(jSONException.optString("gdtJB"))) {
        u.a(100292, 4, null, (new d()).a("msg", paramString));
        return new f(-1, "Unsupported protocol");
      } 
      str2 = jSONException.optString("service");
      str3 = jSONException.optString("action");
      paramString = jSONException.optString("params");
      str4 = jSONException.optString("callbackId");
      str1 = str5;
    } 
    if ("template".equals(str2)) {
      if ("multiAction".equals(str3)) {
        str2 = str1;
        if (TextUtils.isEmpty(str1))
          str2 = paramString; 
        b(str2);
      } else {
        a(str3, paramString, str4);
      } 
      return new f(null);
    } 
    c c = this.b.a(str2);
    return (c != null) ? c.a(this, this.a.c(), str2, str3, paramString, str4) : new f(1000, "Unsupported service");
  }
  
  public e a(b paramb) {
    if (paramb != null)
      this.c.a(paramb.a(), paramb); 
    return this;
  }
  
  public Set<String> a() {
    return a.a(this.c).keySet();
  }
  
  public void a(com.qq.e.comm.plugin.ab.b.b paramb) {
    if (paramb != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramb) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                GDTLogger.report("Exception while fire JSEvent");
              } 
            }
          }); 
  }
  
  @Deprecated
  public void a(com.qq.e.comm.plugin.ab.b.e parame) {
    if (parame != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, parame) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                GDTLogger.report("Exception while sending JSResponse", exception);
              } 
            }
          }); 
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("callbackid", paramString1);
      jSONObject.put("status", paramInt1);
      jSONObject.put("data", paramString2);
      jSONObject.put("keep", paramInt2);
    } catch (JSONException jSONException) {
      GDTLogger.w("Exception while sendingJSResponse", (Throwable)jSONException);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bridge.callback");
    stringBuilder.append("(");
    stringBuilder.append(jSONObject.toString());
    stringBuilder.append(");");
    String str = stringBuilder.toString();
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, str) {
          public void run() {
            try {
              return;
            } finally {
              Exception exception = null;
              GDTLogger.report("Exception while sending JSResponse", exception);
            } 
          }
        });
  }
  
  public void a(String paramString, c paramc) {
    this.b.a(paramString, paramc);
  }
  
  static class a {
    private Map<String, b> a = new HashMap<String, b>();
    
    private a() {}
    
    b a(String param1String) {
      return TextUtils.isEmpty(param1String) ? null : this.a.get(param1String);
    }
    
    void a(String param1String, b param1b) {
      if (!TextUtils.isEmpty(param1String) && param1b != null)
        this.a.put(param1String, param1b); 
    }
  }
  
  static class b {
    private Map<String, c> a = new HashMap<String, c>();
    
    public b(JSONObject param1JSONObject) {
      a(param1JSONObject);
    }
    
    private void a(JSONObject param1JSONObject) {
      a a = new a(param1JSONObject);
      this.a.put("download", a);
      this.a.put("package", a);
      this.a.put("network", a);
    }
    
    c a(String param1String) {
      return TextUtils.isEmpty(param1String) ? null : this.a.get(param1String);
    }
    
    void a(String param1String, c param1c) {
      if (!TextUtils.isEmpty(param1String) && param1c != null)
        this.a.put(param1String, param1c); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */