package com.blued.android.module.im;

import com.blued.android.statistics.util.Logger;

public class IMConfig {
  private static boolean a = false;
  
  private static Logger b = new Logger("blued-grpc-im");
  
  public static Logger a() {
    return b;
  }
  
  protected static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static boolean b() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\IMConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */