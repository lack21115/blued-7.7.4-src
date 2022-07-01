package com.amap.api.col.s;

import com.amap.api.services.core.ServiceSettings;

public final class h {
  public static final String[] a = new String[] { "com.amap.api.services", "com.amap.api.search.admic" };
  
  public static br a(boolean paramBoolean) {
    try {
      return (new br.a("sea", "7.7.0", "AMAP SDK Android Search 7.7.0")).a(a).a(paramBoolean).a("7.7.0").a();
    } catch (bh bh) {
      i.a(bh, "ConfigableConst", "getSDKInfo");
      return null;
    } 
  }
  
  public static String a() {
    return (ServiceSettings.getInstance().getProtocol() == 1) ? "http://restsdk.amap.com/v3" : "https://restsdk.amap.com/v3";
  }
  
  public static String b() {
    return (ServiceSettings.getInstance().getProtocol() == 1) ? "http://restsdk.amap.com/v4" : "https://restsdk.amap.com/v4";
  }
  
  public static String c() {
    return (ServiceSettings.getInstance().getProtocol() == 1) ? "http://yuntuapi.amap.com" : "https://yuntuapi.amap.com";
  }
  
  public static String d() {
    return (ServiceSettings.getInstance().getProtocol() == 1) ? "http://restsdk.amap.com/rest/me/cpoint" : "https://restsdk.amap.com/rest/me/cpoint";
  }
  
  public static String e() {
    return (ServiceSettings.getInstance().getProtocol() == 1) ? "http://m5.amap.com/ws/mapapi/shortaddress/transform" : "https://m5.amap.com/ws/mapapi/shortaddress/transform";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */