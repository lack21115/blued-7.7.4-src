package com.bytedance.tea.crash;

import android.content.Context;
import com.bytedance.tea.crash.e.a;
import com.bytedance.tea.crash.e.b;
import com.bytedance.tea.crash.e.j;
import java.util.concurrent.ConcurrentHashMap;

public final class h {
  private static Context a;
  
  private static long b = 0L;
  
  private static String c = "default";
  
  private static boolean d = false;
  
  private static a e;
  
  private static b f = new b();
  
  private static b g = new b();
  
  private static volatile ConcurrentHashMap<Integer, String> h;
  
  private static j i = null;
  
  private static volatile int j;
  
  private static volatile String k;
  
  public static a a() {
    return e;
  }
  
  static void a(Context paramContext, d paramd) {
    b = System.currentTimeMillis();
    a = paramContext;
    e = new a(a, paramd);
  }
  
  public static b b() {
    return g;
  }
  
  public static j c() {
    // Byte code:
    //   0: getstatic com/bytedance/tea/crash/h.i : Lcom/bytedance/tea/crash/e/j;
    //   3: ifnonnull -> 34
    //   6: ldc com/bytedance/tea/crash/h
    //   8: monitorenter
    //   9: new com/bytedance/tea/crash/e/j
    //   12: dup
    //   13: getstatic com/bytedance/tea/crash/h.a : Landroid/content/Context;
    //   16: invokespecial <init> : (Landroid/content/Context;)V
    //   19: putstatic com/bytedance/tea/crash/h.i : Lcom/bytedance/tea/crash/e/j;
    //   22: ldc com/bytedance/tea/crash/h
    //   24: monitorexit
    //   25: goto -> 34
    //   28: astore_0
    //   29: ldc com/bytedance/tea/crash/h
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    //   34: getstatic com/bytedance/tea/crash/h.i : Lcom/bytedance/tea/crash/e/j;
    //   37: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	28	finally
    //   29	32	28	finally
  }
  
  public static Context d() {
    return a;
  }
  
  public static b e() {
    return f;
  }
  
  public static long f() {
    return b;
  }
  
  public static String g() {
    return c;
  }
  
  public static boolean h() {
    return d;
  }
  
  public static ConcurrentHashMap<Integer, String> i() {
    return h;
  }
  
  public static int j() {
    return j;
  }
  
  public static String k() {
    return k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */