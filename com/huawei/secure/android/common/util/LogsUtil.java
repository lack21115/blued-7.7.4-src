package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

public class LogsUtil {
  private static final Pattern a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
  
  private static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    int k = paramString.length();
    int j = 1;
    if (1 == k)
      return String.valueOf('*'); 
    StringBuilder stringBuilder = new StringBuilder(k);
    int i = 0;
    while (i < k) {
      char c = paramString.charAt(i);
      int m = j;
      char c1 = c;
      if (a.matcher(String.valueOf(c)).matches()) {
        if (j % 2 == 0)
          c = '*'; 
        m = j + 1;
        c1 = c;
      } 
      stringBuilder.append(c1);
      i++;
      j = m;
    } 
    return stringBuilder.toString();
  }
  
  private static String a(String paramString, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder(512);
    if (!TextUtils.isEmpty(paramString))
      if (paramBoolean) {
        stringBuilder.append(a(paramString));
      } else {
        stringBuilder.append(paramString);
      }  
    return stringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString2))
      return; 
    Log.i(paramString1, a(paramString2, false));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString2) && TextUtils.isEmpty(paramString3))
      return; 
    Log.e(paramString1, c(paramString2, paramString3));
  }
  
  public static void b(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString2))
      return; 
    Log.e(paramString1, a(paramString2, false));
  }
  
  private static String c(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder(512);
    if (!TextUtils.isEmpty(paramString1))
      stringBuilder.append(paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      stringBuilder.append(a(paramString2)); 
    return stringBuilder.toString();
  }
  
  static class a extends Throwable {
    private String a;
    
    private Throwable b;
    
    private Throwable c;
    
    public Throwable getCause() {
      Throwable throwable2 = this.b;
      Throwable throwable1 = throwable2;
      if (throwable2 == this)
        throwable1 = null; 
      return throwable1;
    }
    
    public String getMessage() {
      return this.a;
    }
    
    public String toString() {
      Throwable throwable = this.c;
      if (throwable == null)
        return ""; 
      String str2 = throwable.getClass().getName();
      String str1 = str2;
      if (this.a != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(": ");
        str1 = stringBuilder1.toString();
        if (this.a.startsWith(str1))
          return this.a; 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str1);
        stringBuilder2.append(this.a);
        str1 = stringBuilder2.toString();
      } 
      return str1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\commo\\util\LogsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */