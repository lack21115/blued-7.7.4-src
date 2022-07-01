package com.baidu.mobads.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class q implements Thread.UncaughtExceptionHandler {
  public static String a = "";
  
  private static Thread.UncaughtExceptionHandler b;
  
  private static volatile q c;
  
  private Context d;
  
  private a e;
  
  private q(Context paramContext) {
    this.d = paramContext.getApplicationContext();
    b = Thread.getDefaultUncaughtExceptionHandler();
    (new Thread(new r(this))).start();
  }
  
  public static q a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/baidu/mobads/f/q.c : Lcom/baidu/mobads/f/q;
    //   3: ifnonnull -> 38
    //   6: ldc com/baidu/mobads/f/q
    //   8: monitorenter
    //   9: getstatic com/baidu/mobads/f/q.c : Lcom/baidu/mobads/f/q;
    //   12: ifnonnull -> 26
    //   15: new com/baidu/mobads/f/q
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/baidu/mobads/f/q.c : Lcom/baidu/mobads/f/q;
    //   26: ldc com/baidu/mobads/f/q
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/baidu/mobads/f/q
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/baidu/mobads/f/q.c : Lcom/baidu/mobads/f/q;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private String a(String paramString) {
    return c().getString(paramString, "");
  }
  
  private String a(Throwable paramThrowable) {
    Throwable throwable = paramThrowable.getCause();
    if (throwable != null)
      paramThrowable = throwable; 
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length > 0)
      for (int i = 0; i < arrayOfStackTraceElement.length; i++) {
        String str = arrayOfStackTraceElement[i].getClassName();
        if (str.startsWith("junit.framework"))
          return null; 
        if (str.startsWith("com.baidu.mobads.container"))
          return "remote"; 
        if (str.startsWith("com.baidu.mobads.loader"))
          return "loader"; 
        if (str.startsWith("com.baidu.mobads_vr"))
          return "vr"; 
        if (str.startsWith("com.baidu.mobads"))
          return "proxy"; 
      }  
    return null;
  }
  
  private SharedPreferences c() {
    return this.d.getSharedPreferences("baidu_mobads_crash", 0);
  }
  
  private SharedPreferences.Editor d() {
    return c().edit();
  }
  
  private void e() {
    SharedPreferences.Editor editor = d();
    editor.clear();
    if (Build.VERSION.SDK_INT >= 9) {
      editor.apply();
      return;
    } 
    editor.commit();
  }
  
  public void a() {
    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof q))
      Thread.setDefaultUncaughtExceptionHandler(this); 
  }
  
  public void a(a parama) {
    this.e = parama;
  }
  
  public void a(String paramString1, String paramString2) {
    SharedPreferences.Editor editor = d();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("crashtime:");
    stringBuilder2.append(System.currentTimeMillis());
    stringBuilder2.append(" ");
    String str = stringBuilder2.toString();
    editor.putString("key_crash_source", paramString1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str);
    stringBuilder1.append(paramString2);
    editor.putString("key_crash_trace", stringBuilder1.toString());
    editor.putString("key_crash_ad", a);
    if (Build.VERSION.SDK_INT >= 9) {
      editor.apply();
      return;
    } 
    editor.commit();
  }
  
  public void b() {
    this.e = null;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    try {
      String str = a(paramThrowable);
      if (str != null) {
        a(str, Log.getStackTraceString(paramThrowable));
        if (this.e != null)
          this.e.a(str); 
      } 
      if (b != null) {
        b.uncaughtException(paramThread, paramThrowable);
        return;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(exception);
    } 
  }
  
  static interface a {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */