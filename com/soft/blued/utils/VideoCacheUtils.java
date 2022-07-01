package com.soft.blued.utils;

import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Md5;
import java.io.File;

public class VideoCacheUtils {
  private static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    String str = AppMethods.b("video");
    paramString = Md5.a(paramString.toLowerCase());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2) {
    paramString1 = a(paramString1);
    return TextUtils.isEmpty(paramString1) ? paramString2 : (AppMethods.a(paramString2, paramString1, false) ? paramString1 : paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\VideoCacheUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */