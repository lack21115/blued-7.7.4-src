package com.qq.e.comm.plugin.aa.a;

import android.text.TextUtils;
import com.qq.e.comm.plugin.j.b;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class a implements c.a {
  private static volatile a a;
  
  private final Map<String, c> b = new ConcurrentHashMap<String, c>();
  
  private final b c;
  
  private a() {
    ExecutorService executorService = Executors.newFixedThreadPool(15, new ThreadFactory(this) {
          public Thread newThread(Runnable param1Runnable) {
            return new Thread(param1Runnable, "GDT_DOWNLOAD_THREAD");
          }
        });
    this.c = (new b.a()).a(executorService).b(10000).a(10000).a();
  }
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/aa/a/a.a : Lcom/qq/e/comm/plugin/aa/a/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/aa/a/a
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/aa/a/a.a : Lcom/qq/e/comm/plugin/aa/a/a;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/aa/a/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/aa/a/a.a : Lcom/qq/e/comm/plugin/aa/a/a;
    //   25: ldc com/qq/e/comm/plugin/aa/a/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/aa/a/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/aa/a/a.a : Lcom/qq/e/comm/plugin/aa/a/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private String b(String paramString) {
    if (paramString != null)
      return String.valueOf(paramString.hashCode()); 
    throw new NullPointerException("Tag can't be null!");
  }
  
  public void a(b paramb, String paramString, com.qq.e.comm.plugin.j.a parama) {
    if (TextUtils.isEmpty(paramb.c())) {
      if (parama != null) {
        parama.a(new c(134217728, "UrlIsEmpty"));
        return;
      } 
    } else {
      paramString = b(paramString);
      c c2 = this.b.get(paramString);
      if (c2 != null) {
        if (c2.a()) {
          c2.a(parama);
          GDTLogger.w("Task has been started!", null);
          return;
        } 
        GDTLogger.e("Downloader instance with same tag has not been destroyed!");
        return;
      } 
      c c1 = new c(paramString, paramb, parama, this.c);
      c1.a(this);
      this.b.put(paramString, c1);
      t.a.submit(c1);
    } 
  }
  
  public void a(String paramString) {
    this.b.remove(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\aa\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */