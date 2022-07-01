package com.tencent.ams.a.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class d {
  public static String a(Context paramContext, String paramString1, String paramString2) {
    String str2 = "";
    String str1 = str2;
    if (paramContext != null) {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString1)) {
        if (TextUtils.isEmpty(paramString2))
          return ""; 
        str1 = paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, "");
      } 
    } 
    return str1;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong) {
    if (paramContext != null && !TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      SharedPreferences.Editor editor = paramContext.getSharedPreferences(paramString1, 0).edit();
      editor.putLong(paramString2, paramLong);
      editor.commit();
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (paramContext != null && !TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      SharedPreferences.Editor editor = paramContext.getSharedPreferences(paramString1, 0).edit();
      editor.putString(paramString2, paramString3);
      editor.commit();
    } 
  }
  
  public static long b(Context paramContext, String paramString1, String paramString2) {
    long l2 = 0L;
    long l1 = l2;
    if (paramContext != null) {
      l1 = l2;
      if (!TextUtils.isEmpty(paramString1)) {
        if (TextUtils.isEmpty(paramString2))
          return 0L; 
        l1 = paramContext.getSharedPreferences(paramString1, 0).getLong(paramString2, 0L);
      } 
    } 
    return l1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ams\a\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */