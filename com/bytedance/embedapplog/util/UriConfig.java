package com.bytedance.embedapplog.util;

public class UriConfig {
  public static final int AMERICA = 2;
  
  public static final int DEFAULT = 0;
  
  public static final int SINGAPORE = 1;
  
  private static final String[] a = new String[] { "https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com" };
  
  private static final String[] b = new String[] { "https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com" };
  
  private static final String[] c = new String[] { "https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com" };
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String[] h;
  
  private String i;
  
  private UriConfig() {
    a();
  }
  
  private void a() {
    this.d = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
    this.e = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
    this.f = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
    this.g = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
    this.h = a;
    this.i = "https://success.ctobsnssdk.com";
  }
  
  private void b() {
    this.d = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
    this.e = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
    this.f = "https://toblog.tobsnssdk.com/service/2/log_settings/";
    this.g = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
    this.h = b;
    this.i = "https://success.tobsnssdk.com";
  }
  
  private void c() {
    this.d = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
    this.e = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
    this.f = "https://toblog.itobsnssdk.com/service/2/log_settings/";
    this.g = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
    this.h = c;
    this.i = "https://success.itobsnssdk.com";
  }
  
  public static UriConfig creatUriConfig(int paramInt) {
    UriConfig uriConfig = new UriConfig();
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          uriConfig.a();
          return uriConfig;
        } 
        uriConfig.c();
        return uriConfig;
      } 
      uriConfig.b();
      return uriConfig;
    } 
    uriConfig.a();
    return uriConfig;
  }
  
  public String getABConfigUri() {
    return this.g;
  }
  
  public String getActiveUri() {
    return this.e;
  }
  
  public String getRegisterUri() {
    return this.d;
  }
  
  public String[] getSendHeadersUris() {
    return this.h;
  }
  
  public String getSettingUri() {
    return this.f;
  }
  
  public String getSuccRateUri() {
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\UriConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */