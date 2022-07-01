package com.ishumei.dfp;

import android.content.Context;

public class SMSDK {
  static {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String v1(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    return (new SMSDK()).w1(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static String v3(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      return (new SMSDK()).w3(paramContext, paramString1, paramString2, paramString3, paramString4);
    } finally {
      paramContext = null;
    } 
  }
  
  private native String w3(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private native String x6(String paramString1, String paramString2);
  
  public static String xx6(String paramString1, String paramString2) {
    try {
      return (new SMSDK()).x6(paramString1, paramString2);
    } finally {
      paramString1 = null;
    } 
  }
  
  public native String w1(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\dfp\SMSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */