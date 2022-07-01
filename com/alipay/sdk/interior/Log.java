package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;

public class Log {
  private static long a;
  
  public static boolean forcedLogReport(Context paramContext) {
    try {
      b.a().a(paramContext);
      long l = SystemClock.elapsedRealtime() / 1000L;
      if (l - a < 600L)
        return false; 
      a = l;
      a.a(paramContext);
      return true;
    } catch (Exception exception) {
      c.a(exception);
      return false;
    } 
  }
  
  public static void setupLogCallback(ISdkLogCallback paramISdkLogCallback) {
    c.a(paramISdkLogCallback);
  }
  
  public static interface ISdkLogCallback {
    void onLogLine(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\interior\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */