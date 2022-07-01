package com.huawei.hms.update.manager;

public class HMSPublishStateHolder {
  public static final int NOT_CHECKED = 0;
  
  public static final int NOT_PUBLISHED_YET = 2;
  
  public static final int PUBLISHED = 1;
  
  private static int a;
  
  private static final Object b = new Object();
  
  public static int getPublishState() {
    synchronized (b) {
      return a;
    } 
  }
  
  public static void setPublishState(int paramInt) {
    synchronized (b) {
      a = paramInt;
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\manager\HMSPublishStateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */