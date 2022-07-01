package com.bytedance.embed_device_register;

import android.util.Log;

interface DrLogWriter {
  void logD(String paramString1, String paramString2, Throwable paramThrowable);
  
  void logE(String paramString1, String paramString2, Throwable paramThrowable);
  
  void logI(String paramString1, String paramString2, Throwable paramThrowable);
  
  void logV(String paramString1, String paramString2, Throwable paramThrowable);
  
  void logW(String paramString1, String paramString2, Throwable paramThrowable);
  
  public static class a implements DrLogWriter {
    public void logD(String param1String1, String param1String2, Throwable param1Throwable) {
      Log.d(param1String1, param1String2, param1Throwable);
    }
    
    public void logE(String param1String1, String param1String2, Throwable param1Throwable) {
      Log.e(param1String1, param1String2, param1Throwable);
    }
    
    public void logI(String param1String1, String param1String2, Throwable param1Throwable) {
      Log.i(param1String1, param1String2, param1Throwable);
    }
    
    public void logV(String param1String1, String param1String2, Throwable param1Throwable) {
      Log.v(param1String1, param1String2, param1Throwable);
    }
    
    public void logW(String param1String1, String param1String2, Throwable param1Throwable) {
      Log.w(param1String1, param1String2, param1Throwable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embed_device_register\DrLogWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */