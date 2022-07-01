package com.idlefish.flutterboost.log;

import android.util.Log;

public class AndroidLog implements ILog {
  public void a(String paramString1, String paramString2) {
    Log.e(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable) {
    Log.e(paramString1, paramString2, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\log\AndroidLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */