package com.qq.e.comm.plugin.p;

import android.text.TextUtils;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class a {
  private static volatile a a;
  
  private final ExecutorService b = Executors.newFixedThreadPool(5, new ThreadFactory(this) {
        public Thread newThread(Runnable param1Runnable) {
          return new Thread(param1Runnable, "GDT_IMAGE_LOADER_THREAD");
        }
      });
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/p/a.a : Lcom/qq/e/comm/plugin/p/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/p/a
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/p/a.a : Lcom/qq/e/comm/plugin/p/a;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/p/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/p/a.a : Lcom/qq/e/comm/plugin/p/a;
    //   25: ldc com/qq/e/comm/plugin/p/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/p/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/p/a.a : Lcom/qq/e/comm/plugin/p/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(String paramString, ImageView paramImageView, b paramb, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString)) {
      if (paramb != null) {
        paramb.a(paramString, 134217728, new Exception("UrlIsEmpty"));
        return;
      } 
    } else {
      d d = new d(paramString, paramImageView, paramb, paramBoolean);
      this.b.submit(d);
    } 
  }
  
  public void a(String paramString, ImageView paramImageView) {
    a(paramString, paramImageView, null, false);
  }
  
  public void a(String paramString, ImageView paramImageView, b paramb) {
    a(paramString, paramImageView, paramb, false);
  }
  
  public void a(String paramString, b paramb) {
    a(paramString, null, paramb, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\p\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */