package com.sensetime.stmobile;

import android.content.Context;

public class STMobileAuthentificationNative {
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public static native int checkActiveCode(Context paramContext, String paramString1, String paramString2, int paramInt);
  
  public static native int checkActiveCodeFromBuffer(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2);
  
  public static native String generateActiveCode(Context paramContext, String paramString);
  
  public static native String generateActiveCodeFromBuffer(Context paramContext, String paramString, int paramInt);
  
  public static native String generateActiveCodeFromBufferOnline(Context paramContext, String paramString, int paramInt);
  
  public static native String generateActiveCodeOnline(Context paramContext, String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileAuthentificationNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */