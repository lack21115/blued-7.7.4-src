package com.wrapper.proxyapplication;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

public abstract class WrapperProxyApplication extends Application {
  static Context baseContext;
  
  static String className = "com.soft.blued.app.BluedApplication";
  
  static ClassLoader mLoader;
  
  static Application shellApp;
  
  static String tinkerApp = "tinker support";
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public WrapperProxyApplication() {
    throw new VerifyError("bad dex opcode");
  }
  
  private boolean Fixappname() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/wrapper/proxyapplication/WrapperProxyApplication.className : Ljava/lang/String;
    //   5: astore_1
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	16	finally
  }
  
  public static void fixAndroid(Context paramContext, Application paramApplication) {
    if (Build.VERSION.SDK_INT == 28)
      try {
        throw new VerifyError("bad dex opcode");
      } finally {
        paramContext = null;
      }  
    throw new VerifyError("bad dex opcode");
  }
  
  private static String getVersionCode(Context paramContext) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  static Context getWrapperProxyAppBaseContext() {
    return baseContext;
  }
  
  native void Ooo0ooO0oO();
  
  protected void attachBaseContext(Context paramContext) {
    super.attachBaseContext(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  protected abstract void initProxyApplication(Context paramContext);
  
  public void onCreate() {
    super.onCreate();
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\wrapper\proxyapplication\WrapperProxyApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */