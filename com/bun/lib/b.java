package com.bun.lib;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

public class b {
  private static Context a;
  
  public static Context a() {
    try {
      Class<?> clazz = Class.forName("android.app.ActivityThread");
      return (Context)clazz.getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (SecurityException securityException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {
    
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    illegalAccessException.printStackTrace();
    return null;
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/bun/lib/b
    //   2: monitorenter
    //   3: aload_0
    //   4: putstatic com/bun/lib/b.a : Landroid/content/Context;
    //   7: ldc com/bun/lib/b
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/bun/lib/b
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	11	finally
    //   12	15	11	finally
  }
  
  public static Context b() {
    // Byte code:
    //   0: ldc com/bun/lib/b
    //   2: monitorenter
    //   3: getstatic com/bun/lib/b.a : Landroid/content/Context;
    //   6: ifnonnull -> 15
    //   9: invokestatic a : ()Landroid/content/Context;
    //   12: putstatic com/bun/lib/b.a : Landroid/content/Context;
    //   15: getstatic com/bun/lib/b.a : Landroid/content/Context;
    //   18: astore_0
    //   19: ldc com/bun/lib/b
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: astore_0
    //   25: ldc com/bun/lib/b
    //   27: monitorexit
    //   28: aload_0
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	24	finally
    //   15	22	24	finally
    //   25	28	24	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\lib\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */