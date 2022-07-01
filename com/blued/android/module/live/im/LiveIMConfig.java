package com.blued.android.module.live.im;

import com.blued.android.statistics.util.Logger;

public class LiveIMConfig {
  private static boolean a = false;
  
  private static Logger b = new Logger("blued-grpc-live-im");
  
  public static Logger a() {
    return b;
  }
  
  public static String a(String paramString) {
    if (paramString != null && paramString.trim().length() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("blued-grpc-live-im");
      stringBuilder.append("-");
      stringBuilder.append(paramString);
      return stringBuilder.toString();
    } 
    return "blued-grpc-live-im";
  }
  
  protected static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static boolean b() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\im\LiveIMConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */