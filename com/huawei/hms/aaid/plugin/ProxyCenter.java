package com.huawei.hms.aaid.plugin;

public class ProxyCenter {
  public PushProxy proxy;
  
  public static ProxyCenter getInstance() {
    return a.a();
  }
  
  public static PushProxy getProxy() {
    return (getInstance()).proxy;
  }
  
  public static void register(PushProxy paramPushProxy) {
    (getInstance()).proxy = paramPushProxy;
  }
  
  public static class a {
    public static ProxyCenter a = new ProxyCenter();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\plugin\ProxyCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */