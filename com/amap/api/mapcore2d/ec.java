package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;

public class ec implements Thread.UncaughtExceptionHandler {
  private static ec a;
  
  private Thread.UncaughtExceptionHandler b;
  
  private Context c;
  
  private da d;
  
  private ec(Context paramContext, da paramda) {
    this.c = paramContext.getApplicationContext();
    this.d = paramda;
    this.b = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  static ec a(Context paramContext, da paramda) {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/ec
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/ec.a : Lcom/amap/api/mapcore2d/ec;
    //   6: ifnonnull -> 21
    //   9: new com/amap/api/mapcore2d/ec
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/da;)V
    //   18: putstatic com/amap/api/mapcore2d/ec.a : Lcom/amap/api/mapcore2d/ec;
    //   21: getstatic com/amap/api/mapcore2d/ec.a : Lcom/amap/api/mapcore2d/ec;
    //   24: astore_0
    //   25: ldc com/amap/api/mapcore2d/ec
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/amap/api/mapcore2d/ec
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  void a(Throwable paramThrowable) {
    String str = db.a(paramThrowable);
    try {
      if (!TextUtils.isEmpty(str))
        if ((str.contains("amapdynamic") || str.contains("admic")) && str.contains("com.amap.api")) {
          dt dt = new dt(this.c, ed.c());
          if (str.contains("loc"))
            eb.a(dt, this.c, "loc"); 
          if (str.contains("navi"))
            eb.a(dt, this.c, "navi"); 
          if (str.contains("sea"))
            eb.a(dt, this.c, "sea"); 
          if (str.contains("2dmap"))
            eb.a(dt, this.c, "2dmap"); 
          if (str.contains("3dmap"))
            return; 
        } else {
          if (str.contains("com.autonavi.aps.amapapi.offline"))
            return; 
          if (str.contains("com.data.carrier_v4"))
            return; 
          if (str.contains("com.autonavi.aps.amapapi.httpdns") || str.contains("com.autonavi.httpdns"))
            return; 
          if (str.contains("com.amap.api.aiunet"))
            return; 
          if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location"))
            return; 
        }  
    } finally {
      str = null;
    } 
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    a(paramThrowable);
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
    if (uncaughtExceptionHandler != null)
      uncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */