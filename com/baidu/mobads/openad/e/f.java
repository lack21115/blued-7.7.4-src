package com.baidu.mobads.openad.e;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class f implements Executor {
  private final Handler a = new Handler(Looper.getMainLooper());
  
  public void execute(Runnable paramRunnable) {
    this.a.post(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */