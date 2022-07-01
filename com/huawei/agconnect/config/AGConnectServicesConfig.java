package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.a.a;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class AGConnectServicesConfig {
  private static final Map<String, AGConnectServicesConfig> a = new HashMap<String, AGConnectServicesConfig>();
  
  private static final Object b = new Object();
  
  public static AGConnectServicesConfig a(Context paramContext) {
    Context context = paramContext.getApplicationContext();
    if (context != null)
      paramContext = context; 
    return a(paramContext, paramContext.getPackageName());
  }
  
  public static AGConnectServicesConfig a(Context paramContext, String paramString) {
    synchronized (b) {
      a a;
      AGConnectServicesConfig aGConnectServicesConfig2 = a.get(paramString);
      AGConnectServicesConfig aGConnectServicesConfig1 = aGConnectServicesConfig2;
      if (aGConnectServicesConfig2 == null) {
        a = new a(paramContext, paramString);
        a.put(paramString, a);
      } 
      return (AGConnectServicesConfig)a;
    } 
  }
  
  public abstract String a(String paramString);
  
  public abstract void a(InputStream paramInputStream);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\AGConnectServicesConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */