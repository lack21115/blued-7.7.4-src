package com.huawei.hms.base.ui;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

public class a {
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
    Log.e(paramString1, a(paramString2, false));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString2))
      return; 
    Log.e(paramString1, a(paramString2, paramBoolean));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\bas\\ui\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */