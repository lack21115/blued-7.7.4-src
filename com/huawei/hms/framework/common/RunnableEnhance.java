package com.huawei.hms.framework.common;

public class RunnableEnhance implements Runnable {
  static final String TRANCELOGO = " -->";
  
  private String parentName = Thread.currentThread().getName();
  
  private Runnable proxy;
  
  RunnableEnhance(Runnable paramRunnable) {
    this.proxy = paramRunnable;
  }
  
  public String getParentName() {
    return this.parentName;
  }
  
  public void run() {
    this.proxy.run();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\RunnableEnhance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */