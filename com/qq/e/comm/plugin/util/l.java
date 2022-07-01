package com.qq.e.comm.plugin.util;

import android.content.SharedPreferences;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;

public class l {
  private static volatile l a;
  
  private static final String b;
  
  private static int c = GDTADManager.getInstance().getSM().getInteger("buglyRate", 0);
  
  private boolean d;
  
  private l(String paramString) {
    b(paramString);
  }
  
  public static l a(String paramString) {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/util/l.a : Lcom/qq/e/comm/plugin/util/l;
    //   3: ifnonnull -> 38
    //   6: ldc com/qq/e/comm/plugin/util/l
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/util/l.a : Lcom/qq/e/comm/plugin/util/l;
    //   12: ifnonnull -> 26
    //   15: new com/qq/e/comm/plugin/util/l
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: putstatic com/qq/e/comm/plugin/util/l.a : Lcom/qq/e/comm/plugin/util/l;
    //   26: ldc com/qq/e/comm/plugin/util/l
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/qq/e/comm/plugin/util/l
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/qq/e/comm/plugin/util/l.a : Lcom/qq/e/comm/plugin/util/l;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void b() {
    SharedPreferences.Editor editor = GDTADManager.getInstance().getAppContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
    editor.remove("2c39b77689");
    editor.apply();
  }
  
  private void b(String paramString) {
    try {
      if (!m.a(paramString) && Math.abs(paramString.hashCode() % 100) < c) {
        c();
        this.d = true;
        return;
      } 
      b();
      this.d = false;
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Bugly Init encounter exception: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
      return;
    } 
  }
  
  private void c() {
    SharedPreferences.Editor editor = GDTADManager.getInstance().getAppContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
    editor.putString("2c39b77689", b);
    editor.apply();
  }
  
  public boolean a() {
    return this.d;
  }
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(SDKStatus.getSDKVersion());
    stringBuilder.append(".");
    stringBuilder.append(GDTADManager.getInstance().getPM().getPluginVersion());
    b = stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */