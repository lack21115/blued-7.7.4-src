package com.qq.e.comm.plugin.splash;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.plugin.util.av;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class l {
  private static final Object a = new Object();
  
  private static volatile long b = 0L;
  
  public static String a() {
    return (new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())).format(new Date());
  }
  
  public static void a(String paramString) {
    synchronized (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("splashPlayround");
      stringBuilder.append(paramString);
      int i = av.b(stringBuilder.toString(), 0);
      stringBuilder = new StringBuilder();
      stringBuilder.append("splashPlayround");
      stringBuilder.append(paramString);
      av.a(stringBuilder.toString(), i + 1);
      return;
    } 
  }
  
  public static boolean a(Context paramContext) {
    return (GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue() > 0 && ad.a(paramContext));
  }
  
  public static int b(String paramString) {
    synchronized (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("splashPlayround");
      stringBuilder.append(paramString);
      return av.b(stringBuilder.toString(), 0);
    } 
  }
  
  public static boolean b() {
    if (GDTADManager.getInstance().getSM().getInteger("SplashAvoidMultiClick", 1) == 1) {
      long l1 = System.currentTimeMillis();
      if (b != 0L && l1 - b < 5000L) {
        b = l1;
        return true;
      } 
      b = l1;
    } 
    return false;
  }
  
  public static void c() {
    // Byte code:
    //   0: ldc com/qq/e/comm/plugin/splash/l
    //   2: monitorenter
    //   3: lconst_0
    //   4: putstatic com/qq/e/comm/plugin/splash/l.b : J
    //   7: ldc com/qq/e/comm/plugin/splash/l
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/qq/e/comm/plugin/splash/l
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */