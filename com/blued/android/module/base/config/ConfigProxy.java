package com.blued.android.module.base.config;

public class ConfigProxy implements IConfig {
  private static ConfigProxy a = new ConfigProxy();
  
  private IConfig b = null;
  
  public static ConfigProxy a() {
    return a;
  }
  
  public void a(IConfig paramIConfig) {
    this.b = paramIConfig;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\config\ConfigProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */