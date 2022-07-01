package com.blued.android.module.shortvideo.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;

public class StvLogUtils {
  public static void a(int paramInt) {
    try {
      AppMethods.a(AppInfo.d().getResources().getString(paramInt), false);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void a(String paramString) {
    try {
      if (!TextUtils.isEmpty(paramString)) {
        AppMethods.a(paramString, false);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(String paramString, Object... paramVarArgs) {}
  
  public static void b(String paramString, Object... paramVarArgs) {}
  
  public static void c(String paramString, Object... paramVarArgs) {}
  
  public static void d(String paramString, Object... paramVarArgs) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvLogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */