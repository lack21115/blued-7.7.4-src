package com.idlefish.flutterboost;

import com.idlefish.flutterboost.log.AndroidLog;
import com.idlefish.flutterboost.log.ILog;

public class Debuger {
  private static final Debuger a = new Debuger();
  
  private static boolean b = false;
  
  private static ILog c = (ILog)new AndroidLog();
  
  public static void a(String paramString) {
    a.c(paramString);
  }
  
  public static void a(Throwable paramThrowable) {
    if (!b()) {
      c.a("FlutterBoost#", "exception", paramThrowable);
      return;
    } 
    throw new RuntimeException(paramThrowable);
  }
  
  public static boolean a() {
    try {
      return FlutterBoost.a().d().b();
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void b(String paramString) {
    if (!b()) {
      c.a("FlutterBoost#", "exception", new RuntimeException(paramString));
      return;
    } 
    throw new RuntimeException(paramString);
  }
  
  private static boolean b() {
    return (a() && !b);
  }
  
  private void c(String paramString) {
    if (a())
      c.a("FlutterBoost#", paramString); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\Debuger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */