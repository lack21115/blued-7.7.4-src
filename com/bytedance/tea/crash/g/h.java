package com.bytedance.tea.crash.g;

import android.content.Context;
import java.io.File;

public class h {
  public static File a(Context paramContext) {
    return new File(c(paramContext), "CrashLogJava");
  }
  
  public static String a() {
    return String.format("java_%s.npth", new Object[] { String.valueOf(System.nanoTime()) });
  }
  
  public static File b(Context paramContext) {
    return new File(c(paramContext), "crash_history");
  }
  
  public static String b() {
    return String.format("anr_%s.npth", new Object[] { String.valueOf(System.nanoTime()) });
  }
  
  private static String c(Context paramContext) {
    try {
      String str;
      File file;
      if (paramContext.getFilesDir() != null) {
        str = paramContext.getFilesDir().getPath();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/");
        stringBuilder.append(str.getPackageName());
        stringBuilder.append("/files/");
        file = str.getDir(stringBuilder.toString(), 0);
        if (file != null) {
          String str1 = file.getPath();
        } else {
          file = null;
        } 
      } 
      if (file != null)
        return (String)file; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "/sdcard/";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */