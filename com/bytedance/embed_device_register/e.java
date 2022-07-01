package com.bytedance.embed_device_register;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.embed_bdtracker.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

final class e {
  private static final String a;
  
  private static volatile e b;
  
  private a c;
  
  private g.b d;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e.class.getSimpleName());
    stringBuilder.append("#");
    a = stringBuilder.toString();
  }
  
  private e(Context paramContext, SharedPreferences paramSharedPreferences) {
    if (paramContext != null && a(paramContext.getApplicationContext())) {
      Context context = paramContext.getApplicationContext();
      d.a("TrackerDr-query-hms", new Runnable(this, paramSharedPreferences, new h(), context, paramContext) {
            private void a(h<e.a.a> param1h) {
              if (param1h.a != null)
                d.a("TrackerDr-update", new Runnable(this, param1h) {
                      public void run() {
                        e.a(this.b.e, ((e.a.a)this.a.a).a());
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(e.b());
                        stringBuilder.append("update: ");
                        stringBuilder.append(e.a(this.b.e).b());
                        c.a("TrackerDr", stringBuilder.toString());
                        if (e.b(this.b.e) != null)
                          e.b(this.b.e).a(e.a(this.b.e)); 
                      }
                    }); 
            }
            
            public void run() {
              String str2 = this.a.getString("oaid_req_id", "");
              String str1 = str2;
              if (TextUtils.isEmpty(str2)) {
                str1 = UUID.randomUUID().toString();
                this.a.edit().putString("oaid_req_id", str1).apply();
              } 
              int i = this.a.getInt("oaid_query_hms_times", 0);
              e.a.a a = e.a.a.a(this.a.getString("oaid_last_success_query_oaid", ""));
              if (a.b()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(e.b());
                stringBuilder.append("fromJson.isOaidValid()=true, oaid=");
                stringBuilder.append(a.a().b());
                c.a("TrackerDr", stringBuilder.toString());
                h<e.a.a> h1 = this.b;
                h1.a = (T)a;
                a(h1);
              } 
              a = e.a(this.e, this.c);
              a.c(str1).a(i);
              this.a.edit().putInt("oaid_query_hms_times", i + 1).apply();
              if (!TextUtils.isEmpty(e.a.a.a(a))) {
                a.b(System.currentTimeMillis());
                a.c(e.b(this.e, this.d));
                this.a.edit().putString("oaid_last_success_query_oaid", a.a().b()).apply();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(e.b());
                stringBuilder.append("saveOaid=");
                stringBuilder.append(a.a().b());
                c.a("TrackerDr", stringBuilder.toString());
                this.b.a = (T)a;
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
  
  static boolean a(Context paramContext) {
    return d.a(paramContext, "com.huawei.hwid");
  }
  
  private long b(Context paramContext) {
    byte b1;
    byte b2 = -1;
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
      b1 = b2;
      if (packageInfo != null)
        b1 = packageInfo.versionCode; 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      b1 = b2;
    } 
    return b1;
  }
  
  static e b(Context paramContext, SharedPreferences paramSharedPreferences) {
    // Byte code:
    //   0: getstatic com/bytedance/embed_device_register/e.b : Lcom/bytedance/embed_device_register/e;
    //   3: ifnonnull -> 39
    //   6: ldc com/bytedance/embed_device_register/e
    //   8: monitorenter
    //   9: getstatic com/bytedance/embed_device_register/e.b : Lcom/bytedance/embed_device_register/e;
    //   12: ifnonnull -> 27
    //   15: new com/bytedance/embed_device_register/e
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial <init> : (Landroid/content/Context;Landroid/content/SharedPreferences;)V
    //   24: putstatic com/bytedance/embed_device_register/e.b : Lcom/bytedance/embed_device_register/e;
    //   27: ldc com/bytedance/embed_device_register/e
    //   29: monitorexit
    //   30: goto -> 39
    //   33: astore_0
    //   34: ldc com/bytedance/embed_device_register/e
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: getstatic com/bytedance/embed_device_register/e.b : Lcom/bytedance/embed_device_register/e;
    //   42: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	33	finally
    //   27	30	33	finally
    //   34	37	33	finally
  }
  
  private a.a c(Context paramContext) {
    a.a a1 = new a.a();
  }
  
  a a() {
    return this.c;
  }
  
  void a(g.b paramb) {
    this.d = paramb;
  }
  
  static final class a {
    final String a;
    
    final String b;
    
    final boolean c;
    
    final long d;
    
    final long e;
    
    private final List<String> f;
    
    private final int g;
    
    private final long h;
    
    a(String param1String1, String param1String2, boolean param1Boolean, long param1Long1, long param1Long2, List<String> param1List, int param1Int, long param1Long3) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1Boolean;
      this.d = param1Long1;
      this.e = param1Long2;
      this.f = Collections.unmodifiableList(new ArrayList<String>(param1List));
      this.g = param1Int;
      this.h = param1Long3;
    }
    
    Map<String, String> a() {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      d.a(hashMap, "id", this.a);
      d.a(hashMap, "is_track_limited", String.valueOf(this.c));
      d.a(hashMap, "take_ms", String.valueOf(this.d));
      d.a(hashMap, "req_id", this.b);
      d.a(hashMap, "hw_id_version_code", String.valueOf(this.h));
      return (Map)hashMap;
    }
    
    String b() {
      return (new JSONObject(a())).toString();
    }
    
    static class a {
      private String a;
      
      private String b;
      
      private boolean c;
      
      private long d;
      
      private long e;
      
      private List<String> f = new CopyOnWriteArrayList<String>();
      
      private int g;
      
      private long h;
      
      a() {}
      
      a(a param2a) {
        this.a = param2a.a;
        this.b = param2a.b;
        this.c = param2a.c;
        this.d = param2a.d;
        this.e = param2a.e;
        this.f = new CopyOnWriteArrayList<String>(param2a.f);
        this.g = param2a.g;
        this.h = param2a.h;
      }
      
      static a a(String param2String) {
        a a1 = new a();
        if (TextUtils.isEmpty(param2String))
          return a1; 
        try {
          JSONObject jSONObject = new JSONObject(param2String);
          param2String = jSONObject.optString("id");
          String str1 = jSONObject.optString("is_track_limited");
          String str2 = jSONObject.optString("take_ms");
          String str3 = jSONObject.optString("time");
          String str4 = jSONObject.optString("req_id");
          String str5 = jSONObject.optString("query_times");
          String str6 = jSONObject.optString("hw_id_version_code");
          return (new a()).b(param2String).a(Boolean.valueOf(str1).booleanValue()).a(d.a(str2, -1L)).b(d.a(str3, -1L)).c(str4).a(d.a(str5, -1)).c(d.a(str6, -1L));
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
          return a1;
        } 
      }
      
      a a(int param2Int) {
        this.g = param2Int;
        return this;
      }
      
      a a(long param2Long) {
        this.d = param2Long;
        return this;
      }
      
      a a(boolean param2Boolean) {
        this.c = param2Boolean;
        return this;
      }
      
      e.a a() {
        return new e.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      }
      
      a b(long param2Long) {
        this.e = param2Long;
        return this;
      }
      
      a b(String param2String) {
        this.a = param2String;
        return this;
      }
      
      boolean b() {
        return TextUtils.isEmpty(this.a) ^ true;
      }
      
      a c(long param2Long) {
        this.h = param2Long;
        return this;
      }
      
      a c(String param2String) {
        this.b = param2String;
        return this;
      }
      
      a d(String param2String) {
        this.f.add(param2String);
        return this;
      }
    }
  }
  
  static class a {
    private String a;
    
    private String b;
    
    private boolean c;
    
    private long d;
    
    private long e;
    
    private List<String> f = new CopyOnWriteArrayList<String>();
    
    private int g;
    
    private long h;
    
    a() {}
    
    a(a param1a) {
      this.a = param1a.a;
      this.b = param1a.b;
      this.c = param1a.c;
      this.d = param1a.d;
      this.e = param1a.e;
      this.f = new CopyOnWriteArrayList<String>(param1a.f);
      this.g = param1a.g;
      this.h = param1a.h;
    }
    
    static a a(String param1String) {
      a a1 = new a();
      if (TextUtils.isEmpty(param1String))
        return a1; 
      try {
        JSONObject jSONObject = new JSONObject(param1String);
        param1String = jSONObject.optString("id");
        String str1 = jSONObject.optString("is_track_limited");
        String str2 = jSONObject.optString("take_ms");
        String str3 = jSONObject.optString("time");
        String str4 = jSONObject.optString("req_id");
        String str5 = jSONObject.optString("query_times");
        String str6 = jSONObject.optString("hw_id_version_code");
        return (new a()).b(param1String).a(Boolean.valueOf(str1).booleanValue()).a(d.a(str2, -1L)).b(d.a(str3, -1L)).c(str4).a(d.a(str5, -1)).c(d.a(str6, -1L));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        return a1;
      } 
    }
    
    a a(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    a a(long param1Long) {
      this.d = param1Long;
      return this;
    }
    
    a a(boolean param1Boolean) {
      this.c = param1Boolean;
      return this;
    }
    
    e.a a() {
      return new e.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
    
    a b(long param1Long) {
      this.e = param1Long;
      return this;
    }
    
    a b(String param1String) {
      this.a = param1String;
      return this;
    }
    
    boolean b() {
      return TextUtils.isEmpty(this.a) ^ true;
    }
    
    a c(long param1Long) {
      this.h = param1Long;
      return this;
    }
    
    a c(String param1String) {
      this.b = param1String;
      return this;
    }
    
    a d(String param1String) {
      this.f.add(param1String);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embed_device_register\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */