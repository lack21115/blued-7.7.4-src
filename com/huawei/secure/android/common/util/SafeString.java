package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeString {
  private static final String a = SafeString.class.getSimpleName();
  
  public static String a(String paramString, int paramInt) {
    if (paramString != null && paramString.length() >= paramInt) {
      if (paramInt < 0)
        return ""; 
      try {
        return paramString.substring(paramInt);
      } catch (Exception exception) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("substring exception: ");
        stringBuilder.append(exception.getMessage());
        Log.e(str, stringBuilder.toString());
      } 
    } 
    return "";
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2) {
    if (paramString != null && paramInt1 >= 0 && paramInt2 <= paramString.length()) {
      if (paramInt2 < paramInt1)
        return ""; 
      try {
        return paramString.substring(paramInt1, paramInt2);
      } catch (Exception exception) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("substring: ");
        stringBuilder.append(exception.getMessage());
        Log.e(str, stringBuilder.toString());
      } 
    } 
    return "";
  }
  
  public static String a(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    if (paramString != null && paramCharSequence1 != null) {
      if (paramCharSequence2 == null)
        return paramString; 
      try {
        return paramString.replace(paramCharSequence1, paramCharSequence2);
      } catch (Exception exception) {
        paramCharSequence2 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("replace: ");
        stringBuilder.append(exception.getMessage());
        Log.e((String)paramCharSequence2, stringBuilder.toString());
      } 
    } 
    return paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\commo\\util\SafeString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */