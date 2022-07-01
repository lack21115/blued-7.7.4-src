package com.jeremyliao.liveeventbus.utils;

import android.app.Application;

public final class AppUtils {
  private static volatile Application sApplication;
  
  public static Application getApplicationContext() {
    // Byte code:
    //   0: getstatic com/jeremyliao/liveeventbus/utils/AppUtils.sApplication : Landroid/app/Application;
    //   3: ifnonnull -> 65
    //   6: ldc com/jeremyliao/liveeventbus/utils/AppUtils
    //   8: monitorenter
    //   9: getstatic com/jeremyliao/liveeventbus/utils/AppUtils.sApplication : Landroid/app/Application;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull -> 53
    //   17: ldc 'android.app.ActivityThread'
    //   19: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   22: ldc 'currentApplication'
    //   24: iconst_0
    //   25: anewarray java/lang/Class
    //   28: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   31: aconst_null
    //   32: aconst_null
    //   33: checkcast [Ljava/lang/Object;
    //   36: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast android/app/Application
    //   42: putstatic com/jeremyliao/liveeventbus/utils/AppUtils.sApplication : Landroid/app/Application;
    //   45: goto -> 53
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual printStackTrace : ()V
    //   53: ldc com/jeremyliao/liveeventbus/utils/AppUtils
    //   55: monitorexit
    //   56: goto -> 65
    //   59: astore_0
    //   60: ldc com/jeremyliao/liveeventbus/utils/AppUtils
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    //   65: getstatic com/jeremyliao/liveeventbus/utils/AppUtils.sApplication : Landroid/app/Application;
    //   68: areturn
    // Exception table:
    //   from	to	target	type
    //   9	13	59	finally
    //   17	45	48	java/lang/Exception
    //   17	45	59	finally
    //   49	53	59	finally
    //   53	56	59	finally
    //   60	63	59	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbu\\utils\AppUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */