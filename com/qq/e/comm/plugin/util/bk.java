package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.y.u;
import java.lang.reflect.Method;

public class bk {
  private static int a;
  
  private static Class<?> b;
  
  private static Method c;
  
  private static volatile boolean d;
  
  private static Boolean e;
  
  private static void a(boolean paramBoolean) {
    if (au.b(GDTADManager.getInstance().getSM().getInteger("webViewTypeEventRate", 10), 10000)) {
      int i;
      if (paramBoolean) {
        i = 90102;
      } else {
        i = 90112;
      } 
      u.a(i, 0, null);
    } 
  }
  
  public static boolean a() {
    if (GDTADManager.getInstance().getSM().getInteger("x5Switch", 1) != 0) {
      int i = a;
      if (i != 0) {
        if (i != 1)
          ak.a("gdt_tag_x5", "isTbsCoreInited = false"); 
        ak.a("gdt_tag_x5", "isTbsCoreInited = true");
        a(true);
        return true;
      } 
      try {
        if (b == null)
          b = Class.forName("com.tencent.smtt.sdk.QbSdk"); 
        if (c == null)
          c = b.getDeclaredMethod("isTbsCoreInited", new Class[0]); 
        Object object = c.invoke(b, new Object[0]);
        if (object instanceof Boolean) {
          if (((Boolean)object).booleanValue()) {
            a = 1;
            ak.a("gdt_tag_x5", "isTbsCoreInited = true");
            a(true);
            return true;
          } 
          c();
        } else {
          a = 2;
        } 
        ak.a("gdt_tag_x5", "isTbsCoreInited = false");
      } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException classNotFoundException) {}
    } 
    a(false);
    return false;
  }
  
  public static boolean b() {
    // Byte code:
    //   0: ldc com/qq/e/comm/plugin/util/bk
    //   2: monitorenter
    //   3: getstatic com/qq/e/comm/plugin/util/bk.e : Ljava/lang/Boolean;
    //   6: ifnonnull -> 51
    //   9: getstatic com/qq/e/comm/plugin/util/bk.b : Ljava/lang/Class;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull -> 33
    //   17: ldc 'com.tencent.smtt.sdk.QbSdk'
    //   19: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   22: putstatic com/qq/e/comm/plugin/util/bk.b : Ljava/lang/Class;
    //   25: goto -> 33
    //   28: ldc 'no QbSdk Environment'
    //   30: invokestatic i : (Ljava/lang/String;)V
    //   33: getstatic com/qq/e/comm/plugin/util/bk.b : Ljava/lang/Class;
    //   36: ifnull -> 73
    //   39: iconst_1
    //   40: istore_0
    //   41: goto -> 44
    //   44: iload_0
    //   45: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   48: putstatic com/qq/e/comm/plugin/util/bk.e : Ljava/lang/Boolean;
    //   51: getstatic com/qq/e/comm/plugin/util/bk.e : Ljava/lang/Boolean;
    //   54: invokevirtual booleanValue : ()Z
    //   57: istore_0
    //   58: ldc com/qq/e/comm/plugin/util/bk
    //   60: monitorexit
    //   61: iload_0
    //   62: ireturn
    //   63: astore_1
    //   64: ldc com/qq/e/comm/plugin/util/bk
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: goto -> 28
    //   73: iconst_0
    //   74: istore_0
    //   75: goto -> 44
    // Exception table:
    //   from	to	target	type
    //   3	13	63	finally
    //   17	25	69	java/lang/ClassNotFoundException
    //   17	25	63	finally
    //   28	33	63	finally
    //   33	39	63	finally
    //   44	51	63	finally
    //   51	58	63	finally
  }
  
  private static void c() {
    if (!d) {
      d = true;
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */