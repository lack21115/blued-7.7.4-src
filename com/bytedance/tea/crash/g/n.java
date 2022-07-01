package com.bytedance.tea.crash.g;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

public class n {
  public static long a(File paramFile) {
    try {
      StatFs statFs = new StatFs(paramFile.getPath());
      if (Build.VERSION.SDK_INT >= 18)
        return statFs.getTotalBytes(); 
      long l = statFs.getBlockSize();
      return i * l;
    } finally {
      paramFile = null;
    } 
  }
  
  public static JSONObject a(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("inner_app_used", b(paramContext));
      jSONObject.put("inner_free", b());
      jSONObject.put("inner_total", c());
      jSONObject.put("sdcard_app_used", c(paramContext));
      jSONObject.put("sdcard_free", d());
      jSONObject.put("sdcard_total", e());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public static boolean a() {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  private static long b() {
    try {
      return b(Environment.getRootDirectory());
    } catch (Exception exception) {
      return 0L;
    } 
  }
  
  private static long b(Context paramContext) {
    try {
      return c(paramContext.getFilesDir().getParentFile());
    } catch (Exception exception) {
      return 0L;
    } 
  }
  
  public static long b(File paramFile) {
    try {
      StatFs statFs = new StatFs(paramFile.getPath());
      if (Build.VERSION.SDK_INT >= 18)
        return statFs.getFreeBytes(); 
      long l = statFs.getBlockSize();
      return i * l;
    } finally {
      paramFile = null;
    } 
  }
  
  private static long c() {
    try {
      return a(Environment.getRootDirectory());
    } catch (Exception exception) {
      return 0L;
    } 
  }
  
  private static long c(Context paramContext) {
    try {
      if (a()) {
        File file = paramContext.getExternalFilesDir(null);
        if (file != null)
          return c(file.getParentFile()); 
      } 
    } catch (Exception exception) {}
    return 0L;
  }
  
  public static long c(File paramFile) {
    File[] arrayOfFile = paramFile.listFiles();
    long l = 0L;
    if (arrayOfFile == null)
      return 0L; 
    int j = arrayOfFile.length;
    for (int i = 0; i < j; i++) {
      long l1;
      File file = arrayOfFile[i];
      if (file.isDirectory()) {
        l1 = c(file);
      } else {
        l1 = file.length();
      } 
      l += l1;
    } 
    return l;
  }
  
  private static long d() {
    try {
      if (a())
        return Environment.getExternalStorageDirectory().getFreeSpace(); 
    } catch (Exception exception) {}
    return 0L;
  }
  
  private static long e() {
    try {
      if (a())
        return Environment.getExternalStorageDirectory().getTotalSpace(); 
    } catch (Exception exception) {}
    return 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */