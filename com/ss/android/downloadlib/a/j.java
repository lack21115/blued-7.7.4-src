package com.ss.android.downloadlib.a;

import android.content.Context;
import android.os.Environment;
import com.ss.android.a.a.a.a;
import com.ss.android.a.a.a.b;
import com.ss.android.a.a.a.c;
import com.ss.android.a.a.a.d;
import com.ss.android.a.a.a.e;
import com.ss.android.a.a.a.f;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.h;
import com.ss.android.a.a.a.i;
import com.ss.android.a.a.a.k;
import com.ss.android.a.a.a.l;
import com.ss.android.a.a.b.a;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.a;
import com.ss.android.downloadlib.b.a;
import com.ss.android.downloadlib.b.b;
import com.ss.android.downloadlib.e.a;
import com.ss.android.downloadlib.e.g;
import com.ss.android.socialbase.appdownloader.c.h;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import java.io.File;
import org.json.JSONObject;

public class j {
  private static Context a;
  
  private static e b;
  
  private static b c;
  
  private static com.ss.android.a.a.a.j d;
  
  private static f e;
  
  private static g f;
  
  private static h g;
  
  private static a h;
  
  private static a i;
  
  private static h j;
  
  private static c k;
  
  private static d l;
  
  private static l m;
  
  private static i n;
  
  private static k o;
  
  public static Context a() {
    Context context = a;
    if (context != null)
      return context; 
    throw new IllegalArgumentException("Context is null");
  }
  
  public static void a(Context paramContext) {
    if (paramContext != null && paramContext.getApplicationContext() != null) {
      a = paramContext.getApplicationContext();
      return;
    } 
    throw new IllegalArgumentException("Context is null");
  }
  
  public static void a(a parama) {
    i = parama;
  }
  
  public static void a(e parame) {
    b = parame;
  }
  
  public static void a(f paramf) {
    e = paramf;
  }
  
  public static void a(g paramg) {
    f = paramg;
  }
  
  public static void a(h paramh) {
    g = paramh;
    try {
      if (paramh.a().optInt("hook", 0) == 1)
        a.a(); 
      d.h().b(v());
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void a(com.ss.android.a.a.a.j paramj) {
    d = paramj;
  }
  
  public static void a(a parama) {
    h = parama;
  }
  
  public static void a(String paramString) {
    d.h().a(paramString);
  }
  
  public static e b() {
    return b;
  }
  
  public static void b(Context paramContext) {
    if (a == null && paramContext != null && paramContext.getApplicationContext() != null)
      a = paramContext.getApplicationContext(); 
  }
  
  public static b c() {
    if (c == null)
      c = new b() {
          public void a(Context param1Context, c param1c, a param1a, b param1b) {}
          
          public void a(Context param1Context, c param1c, a param1a, b param1b, String param1String) {}
        }; 
    return c;
  }
  
  public static com.ss.android.a.a.a.j d() {
    if (d == null)
      d = (com.ss.android.a.a.a.j)new a(); 
    return d;
  }
  
  public static f e() {
    return e;
  }
  
  public static g f() {
    if (f == null)
      f = (g)new b(); 
    return f;
  }
  
  public static h g() {
    if (j == null)
      j = new h() {
          public void a(c param1c, a param1a, int param1Int) {}
        }; 
    return j;
  }
  
  public static l h() {
    return m;
  }
  
  public static JSONObject i() {
    if (g == null)
      g = new h() {
          public JSONObject a() {
            return new JSONObject();
          }
        }; 
    return (JSONObject)g.a((Object[])new JSONObject[] { g.a(), new JSONObject() });
  }
  
  public static a j() {
    if (h == null)
      h = (new a.a()).a(); 
    return h;
  }
  
  public static a k() {
    return i;
  }
  
  public static k l() {
    return o;
  }
  
  public static String m() {
    return "1.9.5.1";
  }
  
  public static c n() {
    return k;
  }
  
  public static d o() {
    return l;
  }
  
  public static i p() {
    return n;
  }
  
  public static boolean q() {
    int m = i().optInt("is_enable_start_install_again");
    boolean bool = true;
    if (m != 1) {
      if (r())
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public static boolean r() {
    return false;
  }
  
  public static double s() {
    return i().optDouble("min_install_size", 0.0D);
  }
  
  public static long t() {
    long l2 = i().optLong("start_install_interval");
    long l1 = l2;
    if (l2 == 0L)
      l1 = 300000L; 
    return l1;
  }
  
  public static long u() {
    long l2 = i().optLong("next_install_min_interval");
    long l1 = l2;
    if (l2 == 0L)
      l1 = 10000L; 
    return l1;
  }
  
  public static String v() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      stringBuilder.append(File.separator);
      stringBuilder.append("ByteDownload");
      return i().optString("default_save_dir_name", null);
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */