package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

public class MultiProcessFlag {
  private static boolean a;
  
  private static boolean b;
  
  public static boolean isMultiProcess() {
    return a;
  }
  
  public static void setMultiProcess(boolean paramBoolean) {
    if (!b) {
      b = true;
      a = paramBoolean;
      return;
    } 
    GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\cfg\MultiProcessFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */