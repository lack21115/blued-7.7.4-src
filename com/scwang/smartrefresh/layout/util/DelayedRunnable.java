package com.scwang.smartrefresh.layout.util;

public class DelayedRunnable implements Runnable {
  public long a;
  
  private Runnable b = null;
  
  public DelayedRunnable(Runnable paramRunnable, long paramLong) {
    this.b = paramRunnable;
    this.a = paramLong;
  }
  
  public void run() {
    try {
      if (this.b != null) {
        this.b.run();
        return;
      } 
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layou\\util\DelayedRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */