package com.blued.android.module.shortvideo.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.io.File;

public class StvConfig {
  public static final String a;
  
  private static String b;
  
  private static String c;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory());
    stringBuilder.append("/ShortVideo/img/");
    a = stringBuilder.toString();
  }
  
  public static String a() {
    if (TextUtils.isEmpty(b)) {
      File file = AppInfo.d().getExternalCacheDir();
      if (file != null && file.exists()) {
        file.mkdirs();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getAbsolutePath());
        stringBuilder.append("/ShortVideo/");
        b = stringBuilder.toString();
        StvTools.c(b);
      } 
    } 
    return b;
  }
  
  public static String b() {
    if (TextUtils.isEmpty(c)) {
      File file = AppInfo.d().getExternalCacheDir();
      if (file != null && file.exists()) {
        file.mkdirs();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getAbsolutePath());
        stringBuilder.append("/AutnVideo/");
        c = stringBuilder.toString();
        StvTools.c(c);
        StvTools.c(a);
      } 
    } 
    return c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */