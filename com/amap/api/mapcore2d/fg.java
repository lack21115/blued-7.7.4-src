package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;

public class fg {
  private static WeakReference<fa> a;
  
  public static void a(Context paramContext) {
    do.d().submit(new Runnable(paramContext) {
          public void run() {
            try {
              fa fa = fh.a(fg.a());
              fh.a(this.a, fa, dm.h, 1000, 307200, "2");
              if (fa.g == null)
                fa.g = new fi(new fm(this.a, new fj(new fn(new fp())))); 
              fa.h = 3600000;
              if (TextUtils.isEmpty(fa.i))
                fa.i = "cKey"; 
              return;
            } finally {
              Exception exception = null;
              do.c(exception, "stm", "usd");
            } 
          }
        });
  }
  
  public static void a(ff paramff, Context paramContext) {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/fg
    //   2: monitorenter
    //   3: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
    //   6: new com/amap/api/mapcore2d/fg$1
    //   9: dup
    //   10: aload_1
    //   11: aload_0
    //   12: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/ff;)V
    //   15: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   20: pop
    //   21: ldc com/amap/api/mapcore2d/fg
    //   23: monitorexit
    //   24: return
    //   25: astore_0
    //   26: ldc com/amap/api/mapcore2d/fg
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	25	finally
  }
  
  private static void b(Context paramContext, byte[] paramArrayOfbyte) throws IOException {
    fa fa = fh.a(a);
    fh.a(paramContext, fa, dm.h, 1000, 307200, "2");
    if (fa.e == null)
      fa.e = new dh(); 
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Integer.toString(random.nextInt(100)));
    stringBuilder.append(Long.toString(System.nanoTime()));
    String str = stringBuilder.toString();
    try {
      return;
    } finally {
      str = null;
      do.c((Throwable)str, "stm", "wts");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */