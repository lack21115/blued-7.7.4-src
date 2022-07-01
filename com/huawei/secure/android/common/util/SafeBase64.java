package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;

public class SafeBase64 {
  private static final String a = SafeBase64.class.getSimpleName();
  
  public static String a(byte[] paramArrayOfbyte, int paramInt) {
    try {
      return Base64.encodeToString(paramArrayOfbyte, paramInt);
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(exception.getClass().getSimpleName());
      stringBuilder.append(" , message5 : ");
      stringBuilder.append(exception.getMessage());
      Log.e(str, stringBuilder.toString());
      return "";
    } 
  }
  
  public static byte[] a(String paramString, int paramInt) {
    try {
      return Base64.decode(paramString, paramInt);
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(exception.getClass().getSimpleName());
      stringBuilder.append(" , message2 : ");
      stringBuilder.append(exception.getMessage());
      Log.e(str, stringBuilder.toString());
      return new byte[0];
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\commo\\util\SafeBase64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */