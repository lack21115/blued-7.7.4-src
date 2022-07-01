package com.amap.api.mapcore2d;

class bq {
  private Thread[] a;
  
  public bq(int paramInt, Runnable paramRunnable1, Runnable paramRunnable2) {
    this.a = new Thread[paramInt];
    int i;
    for (i = 0; i < paramInt; i++) {
      if (i == 0 && paramInt > 1) {
        this.a[i] = new Thread(paramRunnable1);
      } else {
        this.a[i] = new Thread(paramRunnable2);
      } 
    } 
  }
  
  public void a() {
    try {
    
    } finally {
      Exception exception = null;
    } 
  }
  
  public void b() {
    Thread[] arrayOfThread = this.a;
    if (arrayOfThread == null)
      return; 
    int j = arrayOfThread.length;
    for (int i = 0; i < j; i++) {
      this.a[i].interrupt();
      this.a[i] = null;
    } 
    this.a = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */