package com.alipay.security.mobile.module.c;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public final class e {
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
  }
  
  public static void a(Context paramContext, String paramString, Map<String, String> paramMap) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences(paramString, 0).edit();
    if (editor != null) {
      for (String str : paramMap.keySet())
        editor.putString(str, paramMap.get(str)); 
      editor.commit();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */