package com.blued.android.module.external_sense_library.utils;

import android.util.Log;
import com.blued.android.core.AppInfo;
import java.util.regex.Pattern;

public class LogUtils {
  private static final Pattern a = Pattern.compile("GMT([-+]\\d{4})$");
  
  private static Boolean b = null;
  
  private static boolean c = true;
  
  public static int a(String paramString1, String paramString2, Object... paramVarArgs) {
    return a(paramString1, 2) ? Log.v(paramString1, String.format(paramString2, paramVarArgs)) : 0;
  }
  
  public static int a(String paramString, Object... paramVarArgs) {
    return a("stSticker", 4) ? Log.i("stSticker", String.format(paramString, paramVarArgs)) : 0;
  }
  
  public static boolean a(String paramString, int paramInt) {
    return AppInfo.m();
  }
  
  public static int b(String paramString1, String paramString2, Object... paramVarArgs) {
    return a(paramString1, 3) ? Log.d(paramString1, String.format(paramString2, paramVarArgs)) : 0;
  }
  
  public static int c(String paramString1, String paramString2, Object... paramVarArgs) {
    return a(paramString1, 4) ? Log.i(paramString1, String.format(paramString2, paramVarArgs)) : 0;
  }
  
  public static int d(String paramString1, String paramString2, Object... paramVarArgs) {
    return a(paramString1, 6) ? Log.e(paramString1, String.format(paramString2, paramVarArgs)) : 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\LogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */