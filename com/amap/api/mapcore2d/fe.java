package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class fe {
  static int a = 1000;
  
  static boolean b = false;
  
  static int c = 20;
  
  private static WeakReference<fa> d;
  
  private static int e = 10;
  
  public static void a(Context paramContext) {
    do.d().submit(new Runnable(paramContext) {
          public void run() {
            try {
              fa fa = fh.a(fe.a());
              fh.a(this.a, fa, dm.i, fe.a, 2097152, "6");
              fa.h = 14400000;
              if (fa.g == null) {
                de de = new de(new dg(new di()));
                fa.g = new fl(new fk(this.a, new fp(), de, new String(dj.a(10)), new Object[] { 
                        cq.f(this.a), cu.v(this.a), cu.m(this.a), cu.h(this.a), cu.a(), Build.MANUFACTURER, Build.DEVICE, cu.x(this.a), cq.c(this.a), Build.MODEL, 
                        cq.d(this.a), cq.b(this.a) }));
              } 
              if (TextUtils.isEmpty(fa.i))
                fa.i = "fKey"; 
              return;
            } finally {
              Exception exception = null;
              do.c(exception, "ofm", "uold");
            } 
          }
        });
  }
  
  public static void a(fd paramfd, Context paramContext) {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/fe
    //   2: monitorenter
    //   3: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
    //   6: new com/amap/api/mapcore2d/fe$1
    //   9: dup
    //   10: aload_1
    //   11: aload_0
    //   12: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/fd;)V
    //   15: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   20: pop
    //   21: ldc com/amap/api/mapcore2d/fe
    //   23: monitorexit
    //   24: return
    //   25: astore_0
    //   26: ldc com/amap/api/mapcore2d/fe
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	25	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */