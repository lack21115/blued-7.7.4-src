package com.baidu.mobads;

import android.content.Context;
import android.os.Looper;

public class CpuInfoManager {
  private static void a(Runnable paramRunnable) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      (new Thread(new l(paramRunnable))).start();
      return;
    } 
    paramRunnable.run();
  }
  
  public static void getCpuInfoUrl(Context paramContext, String paramString, int paramInt, UrlListener paramUrlListener) {
    a(new j(paramContext, paramInt, paramString, paramUrlListener));
  }
  
  public static interface UrlListener {
    void onUrl(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\CpuInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */