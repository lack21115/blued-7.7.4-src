package com.blued.android.module.live_china.manager;

import android.util.Log;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;

public class LiveMakeLoverManager {
  private static int a;
  
  public static int a() {
    return a;
  }
  
  public static void a(int paramInt) {
    a = paramInt;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setMode:");
    stringBuilder.append(paramInt);
    Log.i("==makelover", stringBuilder.toString());
    if (a == 1) {
      LiveRefreshUIObserver.a().c(true);
      return;
    } 
    LiveRefreshUIObserver.a().c(false);
  }
  
  public static boolean b() {
    return (a == 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\LiveMakeLoverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */