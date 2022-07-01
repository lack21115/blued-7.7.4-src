package com.ss.android.downloadlib.a;

import android.text.TextUtils;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.b;
import com.ss.android.downloadlib.a.a.a;
import com.ss.android.downloadlib.a.b.a;
import com.ss.android.downloadlib.e.d;
import java.util.HashMap;
import java.util.Map;

public class a {
  private static a a;
  
  private Map<String, b> b = new HashMap<String, b>();
  
  private Map<String, a> c;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/a/a.a : Lcom/ss/android/downloadlib/a/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/downloadlib/a/a
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/a/a.a : Lcom/ss/android/downloadlib/a/a;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/downloadlib/a/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/downloadlib/a/a.a : Lcom/ss/android/downloadlib/a/a;
    //   25: ldc com/ss/android/downloadlib/a/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/downloadlib/a/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/downloadlib/a/a.a : Lcom/ss/android/downloadlib/a/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private boolean b(String paramString) {
    return this.b.containsKey(paramString);
  }
  
  private b c(String paramString) {
    b b = this.b.get(paramString);
    if (b != null)
      this.b.remove(paramString); 
    return b;
  }
  
  public void a(c paramc) {
    if (paramc != null) {
      if (TextUtils.isEmpty(paramc.t()))
        return; 
      if (this.c == null)
        this.c = new HashMap<String, a>(); 
      this.c.put(paramc.t(), new a(0L, paramc.d(), paramc.e(), paramc.t(), paramc.f(), paramc.s(), ""));
    } 
  }
  
  public void a(b paramb) {
    if (paramb == null)
      return; 
    if (!TextUtils.isEmpty(paramb.a())) {
      this.b.put(paramb.b(), paramb);
      return;
    } 
    this.b.remove(paramb.b());
  }
  
  public void a(String paramString) {
    if (this.c != null) {
      if (TextUtils.isEmpty(paramString))
        return; 
      if (this.c.containsKey(paramString)) {
        a a1 = this.c.remove(paramString);
        a1.a();
        a.a().a(a1);
        this.c.remove(paramString);
      } 
    } 
  }
  
  public boolean a(String paramString, com.ss.android.downloadad.a.b.a parama) {
    if (b(paramString)) {
      b b = c(paramString);
      if (b == null)
        return false; 
      com.ss.android.downloadlib.d.a.a().a("deeplink_url_app", parama);
      int i = d.a(b.a()).a();
      if (i != 1 && i != 3) {
        com.ss.android.downloadlib.d.a.a().a("deeplink_open_fail", parama);
        return false;
      } 
      com.ss.android.downloadlib.d.a.a().a("deeplink_open_success", parama);
      j.c().a(j.a(), (c)parama.s(), null, null, paramString);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */