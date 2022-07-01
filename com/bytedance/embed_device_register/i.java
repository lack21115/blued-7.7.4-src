package com.bytedance.embed_device_register;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

final class i {
  private static final String a;
  
  private static volatile i b;
  
  private b c;
  
  private g.b d;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i.class.getSimpleName());
    stringBuilder.append("#");
    a = stringBuilder.toString();
  }
  
  private i(Context paramContext, SharedPreferences paramSharedPreferences) {
    if (paramContext != null && a.a()) {
      paramContext = paramContext.getApplicationContext();
      d.a(new Runnable(this, paramSharedPreferences, new h(), paramContext) {
            private void a(h<i.b> param1h) {
              if (param1h.a != null)
                d.a(new Runnable(this, param1h) {
                      public void run() {
                        i.a(this.b.d, (i.b)this.a.a);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(i.b());
                        stringBuilder.append("update: ");
                        stringBuilder.append(i.a(this.b.d).a());
                        c.a("TrackerDr", stringBuilder.toString());
                        if (i.b(this.b.d) != null)
                          i.b(this.b.d).a(i.a(this.b.d)); 
                      }
                    }); 
            }
            
            public void run() {
              String str2 = this.a.getString("oaid_xiaomi_reqId", "");
              String str1 = str2;
              if (TextUtils.isEmpty(str2)) {
                str1 = UUID.randomUUID().toString();
                this.a.edit().putString("oaid_xiaomi_reqId", str1).apply();
              } 
              int j = this.a.getInt("oaid_xiaomi_queryXiaomiTimes", 0);
              i.b b = i.b.a(this.a.getString("oaid_xiaomi_lastSuccessQueryOaid", ""));
              if (b != null && b.c()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i.b());
                stringBuilder.append("fromJson.isOaidValid()=true, oaid=");
                stringBuilder.append(b.a());
                c.a("TrackerDr", stringBuilder.toString());
                h<i.b> h1 = this.b;
                h1.a = (T)b;
                a(h1);
              } 
              long l1 = SystemClock.elapsedRealtime();
              i.a a = new i.a(this.c);
              long l2 = SystemClock.elapsedRealtime();
              this.a.edit().putInt("oaid_xiaomi_queryXiaomiTimes", j + 1).apply();
              if (!TextUtils.isEmpty(a.b)) {
                long l = System.currentTimeMillis();
                i.b b1 = new i.b(a.a, a.b, a.c, a.d, str1, l, l2 - l1);
                this.a.edit().putString("oaid_xiaomi_lastSuccessQueryOaid", b1.a()).apply();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i.b());
                stringBuilder.append("saveOaid=");
                stringBuilder.append(b1.a());
                c.a("TrackerDr", stringBuilder.toString());
                this.b.a = (T)b1;
              } 
              a(this.b);
            }
          });
    } 
  }
  
  public static void a(Context paramContext, SharedPreferences paramSharedPreferences) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("init: ");
    c.a("TrackerDr", stringBuilder.toString());
    b(paramContext, paramSharedPreferences);
  }
  
  static i b(Context paramContext, SharedPreferences paramSharedPreferences) {
    // Byte code:
    //   0: getstatic com/bytedance/embed_device_register/i.b : Lcom/bytedance/embed_device_register/i;
    //   3: ifnonnull -> 39
    //   6: ldc com/bytedance/embed_device_register/i
    //   8: monitorenter
    //   9: getstatic com/bytedance/embed_device_register/i.b : Lcom/bytedance/embed_device_register/i;
    //   12: ifnonnull -> 27
    //   15: new com/bytedance/embed_device_register/i
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial <init> : (Landroid/content/Context;Landroid/content/SharedPreferences;)V
    //   24: putstatic com/bytedance/embed_device_register/i.b : Lcom/bytedance/embed_device_register/i;
    //   27: ldc com/bytedance/embed_device_register/i
    //   29: monitorexit
    //   30: goto -> 39
    //   33: astore_0
    //   34: ldc com/bytedance/embed_device_register/i
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: getstatic com/bytedance/embed_device_register/i.b : Lcom/bytedance/embed_device_register/i;
    //   42: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	33	finally
    //   27	30	33	finally
    //   34	37	33	finally
  }
  
  b a() {
    return this.c;
  }
  
  void a(g.b paramb) {
    this.d = paramb;
  }
  
  static final class a {
    private static Object e;
    
    private static Class<?> f;
    
    private static Method g;
    
    private static Method h;
    
    private static Method i;
    
    private static Method j;
    
    final String a;
    
    final String b;
    
    final String c;
    
    final String d;
    
    static {
      try {
        f = Class.forName("com.android.id.impl.IdProviderImpl");
        e = f.newInstance();
        g = f.getMethod("getUDID", new Class[] { Context.class });
        h = f.getMethod("getOAID", new Class[] { Context.class });
        i = f.getMethod("getVAID", new Class[] { Context.class });
        j = f.getMethod("getAAID", new Class[] { Context.class });
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.b());
        stringBuilder.append("oaid=");
        stringBuilder.append(h);
        stringBuilder.append(" udid=");
        stringBuilder.append(g);
        c.a("TrackerDr", stringBuilder.toString());
        return;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.b());
        stringBuilder.append("IdentifierManager");
        c.b(stringBuilder.toString(), "reflect exception!", exception);
        return;
      } 
    }
    
    a(Context param1Context) {
      this.a = a(param1Context, g);
      this.b = a(param1Context, h);
      this.c = a(param1Context, i);
      this.d = a(param1Context, j);
    }
    
    private static String a(Context param1Context, Method param1Method) {
      Object object = e;
      if (object != null && param1Method != null)
        try {
          Object object1 = param1Method.invoke(object, new Object[] { param1Context });
          if (object1 != null)
            return (String)object1; 
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i.b());
          stringBuilder.append("IdentifierManager");
          c.b(stringBuilder.toString(), "invoke exception!", exception);
        }  
      return null;
    }
    
    static boolean a() {
      return (f != null && e != null);
    }
  }
  
  static final class b {
    final String a;
    
    final String b;
    
    final String c;
    
    final String d;
    
    final String e;
    
    final long f;
    
    private final long g;
    
    b(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, long param1Long1, long param1Long2) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1String3;
      this.d = param1String4;
      this.e = param1String5;
      this.f = param1Long1;
      this.g = param1Long2;
    }
    
    static b a(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return null; 
      try {
        JSONObject jSONObject = new JSONObject(param1String);
        return new b(jSONObject.optString("udid", ""), jSONObject.optString("oaid", ""), jSONObject.optString("vaid", ""), jSONObject.optString("aaid", ""), jSONObject.optString("req_id", ""), jSONObject.optLong("last_success_query_oaid_time", -1L), jSONObject.optLong("take_ms", -1L));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        return null;
      } 
    }
    
    String a() {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("udid", this.a);
        jSONObject.put("oaid", this.b);
        jSONObject.put("vaid", this.c);
        jSONObject.put("aaid", this.d);
        jSONObject.put("req_id", this.e);
        jSONObject.put("last_success_query_oaid_time", this.f);
        jSONObject.put("take_ms", this.g);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      return jSONObject.toString();
    }
    
    Map<String, String> b() {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      d.a(hashMap, "id", this.b);
      d.a(hashMap, "udid", this.a);
      d.a(hashMap, "take_ms", String.valueOf(this.g));
      d.a(hashMap, "req_id", this.e);
      return (Map)hashMap;
    }
    
    boolean c() {
      return TextUtils.isEmpty(this.b) ^ true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embed_device_register\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */