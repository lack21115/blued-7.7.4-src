package cn.shuzilm.core;

import android.content.Context;

final class g implements Runnable {
  g(Context paramContext) {}
  
  public void run() {
    try {
      System.loadLibrary("du");
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */