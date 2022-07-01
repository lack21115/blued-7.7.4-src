package com.ss.android.socialbase.downloader.k;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.h;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static final h<Integer, a> a = new h(8, 8);
  
  private static final a b = new a(null);
  
  private static JSONObject c;
  
  private static JSONObject d;
  
  private static JSONObject e;
  
  private static Boolean f;
  
  private static boolean g;
  
  private static a h;
  
  private final JSONObject i;
  
  private final JSONObject j;
  
  private final Boolean k;
  
  private int l;
  
  static {
    a();
  }
  
  private a(JSONObject paramJSONObject) {
    JSONObject jSONObject1;
    this.i = paramJSONObject;
    JSONObject jSONObject2 = null;
    if (paramJSONObject != null && !f("bugfix")) {
      JSONObject jSONObject = paramJSONObject.optJSONObject("bugfix");
      paramJSONObject = jSONObject2;
      jSONObject1 = jSONObject;
      if (jSONObject != null) {
        paramJSONObject = jSONObject2;
        jSONObject1 = jSONObject;
        if (jSONObject.has("default")) {
          paramJSONObject = jSONObject2;
          jSONObject1 = jSONObject;
          if (!f("default")) {
            boolean bool1 = false;
            if (jSONObject.optInt("default", 0) == 1)
              bool1 = true; 
            Boolean bool = Boolean.valueOf(bool1);
            jSONObject1 = jSONObject;
          } 
        } 
      } 
    } else {
      jSONObject1 = null;
      paramJSONObject = jSONObject2;
    } 
    this.j = jSONObject1;
    this.k = (Boolean)paramJSONObject;
  }
  
  public static a a(int paramInt) {
    return a(paramInt, (c)null);
  }
  
  private static a a(int paramInt, c paramc) {
    a a1 = h;
    if (a1 != null && a1.l == paramInt)
      return a1; 
    synchronized (a) {
      a a3 = (a)a.get(Integer.valueOf(paramInt));
      a a2 = a3;
      if (a3 == null) {
        h<Integer, a> h1;
        a a4;
        if (paramc == null) {
          null = c(paramInt);
        } else {
          null = b((c)null);
        } 
        synchronized (a) {
          a.put(Integer.valueOf(paramInt), null);
          a4 = null;
        } 
      } 
      a2.l = paramInt;
      h = a2;
      return a2;
    } 
  }
  
  @Deprecated
  public static a a(c paramc) {
    return (paramc == null) ? b : a(paramc.g(), paramc);
  }
  
  public static a a(JSONObject paramJSONObject) {
    if (paramJSONObject == null || paramJSONObject == c || g)
      return b; 
    a a1 = h;
    if (a1 != null && a1.i == paramJSONObject)
      return a1; 
    synchronized (a) {
      for (a a3 : a.values()) {
        if (a3.i == paramJSONObject) {
          h = a3;
          return a3;
        } 
      } 
      a a2 = new a(paramJSONObject);
      h = a2;
      return a2;
    } 
  }
  
  public static void a() {
    JSONObject jSONObject = b.v();
    if (c != jSONObject) {
      boolean bool1;
      Boolean bool;
      c = jSONObject;
      boolean bool2 = false;
      if (jSONObject.optInt("disable_task_setting", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      g = bool1;
      d = jSONObject.optJSONObject("disabled_task_keys");
      JSONObject jSONObject2 = jSONObject.optJSONObject("bugfix");
      JSONObject jSONObject1 = null;
      jSONObject = jSONObject1;
      if (jSONObject2 != null) {
        jSONObject = jSONObject1;
        if (jSONObject2.has("default")) {
          bool1 = bool2;
          if (jSONObject2.optInt("default", 0) == 1)
            bool1 = true; 
          bool = Boolean.valueOf(bool1);
        } 
      } 
      e = jSONObject2;
      f = bool;
    } 
  }
  
  public static void a(int paramInt, JSONObject paramJSONObject) {
    if (paramJSONObject != null && paramJSONObject != c) {
      if (g)
        return; 
      synchronized (a) {
        a a1 = h;
        if (a1 != null && a1.i == paramJSONObject) {
          a1.l = paramInt;
        } else {
          a a2;
          a1 = null;
          Iterator<a> iterator = a.values().iterator();
          while (true) {
            a2 = a1;
            if (iterator.hasNext()) {
              a2 = iterator.next();
              if (a2.i == paramJSONObject) {
                a2.l = paramInt;
                break;
              } 
              continue;
            } 
            break;
          } 
          a1 = a2;
          if (a2 == null) {
            a1 = new a(paramJSONObject);
            a1.l = paramInt;
          } 
          h = a1;
        } 
        a.put(Integer.valueOf(paramInt), a1);
        return;
      } 
    } 
  }
  
  public static void a(String paramString, boolean paramBoolean) {
    try {
      boolean bool;
      if (e == null)
        e = new JSONObject(); 
      JSONObject jSONObject = e;
      if (paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.put(paramString, bool);
      return;
    } catch (JSONException jSONException) {
      return;
    } 
  }
  
  public static a b() {
    return b;
  }
  
  private static a b(c paramc) {
    if (g)
      return b; 
    try {
      String str = paramc.M();
      if (!TextUtils.isEmpty(str))
        return new a(new JSONObject(str)); 
    } finally {
      paramc = null;
    } 
  }
  
  public static void b(int paramInt) {
    a a1 = h;
    if (a1 != null && a1.l == paramInt)
      h = null; 
    synchronized (a) {
      a.remove(Integer.valueOf(paramInt));
      return;
    } 
  }
  
  private static a c(int paramInt) {
    if (g)
      return b; 
    Context context = b.B();
    if (context != null) {
      c c = f.a(context).h(paramInt);
      if (c != null)
        return b(c); 
    } 
    return b;
  }
  
  public static boolean f(String paramString) {
    JSONObject jSONObject = d;
    return (jSONObject != null && jSONObject.optInt(paramString, 0) == 1);
  }
  
  public double a(String paramString, double paramDouble) {
    JSONObject jSONObject = this.i;
    return (jSONObject != null && jSONObject.has(paramString) && !f(paramString)) ? this.i.optDouble(paramString, paramDouble) : c.optDouble(paramString, paramDouble);
  }
  
  public int a(String paramString, int paramInt) {
    JSONObject jSONObject = this.i;
    return (jSONObject != null && jSONObject.has(paramString) && !f(paramString)) ? this.i.optInt(paramString, paramInt) : c.optInt(paramString, paramInt);
  }
  
  public long a(String paramString, long paramLong) {
    JSONObject jSONObject = this.i;
    return (jSONObject != null && jSONObject.has(paramString) && !f(paramString)) ? this.i.optLong(paramString, paramLong) : c.optLong(paramString, paramLong);
  }
  
  public String a(String paramString1, String paramString2) {
    JSONObject jSONObject = this.i;
    return (jSONObject != null && jSONObject.has(paramString1) && !f(paramString1)) ? this.i.optString(paramString1, paramString2) : c.optString(paramString1, paramString2);
  }
  
  public boolean a(String paramString) {
    return b(paramString, false);
  }
  
  public boolean b(String paramString) {
    return c(paramString, false);
  }
  
  public boolean b(String paramString, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String c(String paramString) {
    return a(paramString, "");
  }
  
  public boolean c(String paramString, boolean paramBoolean) {
    JSONObject jSONObject = this.i;
    return (jSONObject != null && jSONObject.has(paramString) && !f(paramString)) ? this.i.optBoolean(paramString, paramBoolean) : c.optBoolean(paramString, paramBoolean);
  }
  
  public JSONObject d(String paramString) {
    JSONObject jSONObject = this.i;
    return (jSONObject != null && jSONObject.has(paramString) && !f(paramString)) ? this.i.optJSONObject(paramString) : c.optJSONObject(paramString);
  }
  
  public JSONArray e(String paramString) {
    JSONObject jSONObject = this.i;
    return (jSONObject != null && jSONObject.has(paramString) && !f(paramString)) ? this.i.optJSONArray(paramString) : c.optJSONArray(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */