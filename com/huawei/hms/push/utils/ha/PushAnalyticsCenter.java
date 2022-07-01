package com.huawei.hms.push.utils.ha;

public class PushAnalyticsCenter {
  public PushBaseAnalytics a;
  
  public static PushAnalyticsCenter getInstance() {
    return a.a();
  }
  
  public PushBaseAnalytics getPushAnalytics() {
    return this.a;
  }
  
  public void register(PushBaseAnalytics paramPushBaseAnalytics) {
    this.a = paramPushBaseAnalytics;
  }
  
  public static class a {
    public static PushAnalyticsCenter a = new PushAnalyticsCenter();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\pus\\utils\ha\PushAnalyticsCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */