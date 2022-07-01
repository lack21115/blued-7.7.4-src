package com.baidu.mobads.openad.e;

import android.util.Log;

class j extends Thread {
  j(e.e parame, Runnable paramRunnable, String paramString) {
    super(paramRunnable, paramString);
  }
  
  public void run() {
    try {
      return;
    } finally {
      Exception exception = null;
      Log.e("ThreadUtils", "Request threw uncaught throwable", exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */