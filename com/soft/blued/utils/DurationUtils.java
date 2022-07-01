package com.soft.blued.utils;

import com.blued.android.core.AppInfo;

public class DurationUtils {
  private static long a;
  
  public static void a() {
    a = System.currentTimeMillis();
  }
  
  public static void a(String paramString) {
    if (AppInfo.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("任务耗时：");
      stringBuilder.append(System.currentTimeMillis() - a);
      Logger.c("Timer", new Object[] { stringBuilder.toString() });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\DurationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */