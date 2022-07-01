package com.amap.api.mapcore2d;

public abstract class fx implements Runnable {
  a d;
  
  public abstract void a();
  
  public final void run() {
    try {
      if (this.d != null)
        this.d.a(this); 
      if (Thread.interrupted())
        return; 
      a();
    } finally {
      Exception exception = null;
      do.c(exception, "ThreadTask", "run");
    } 
  }
  
  static interface a {
    void a(fx param1fx);
    
    void b(fx param1fx);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */