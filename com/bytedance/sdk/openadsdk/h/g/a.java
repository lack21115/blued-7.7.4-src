package com.bytedance.sdk.openadsdk.h.g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class a {
  static Context a;
  
  @Deprecated
  public static File a() {
    return b(a);
  }
  
  public static File a(File paramFile, String paramString) {
    if (!c() || !d() || TextUtils.isEmpty(paramString))
      return null; 
    File file = paramFile;
    if (paramFile == null)
      file = a(); 
    paramFile = new File(file, paramString);
    a(paramFile);
    return paramFile;
  }
  
  public static void a(Context paramContext) {
    if (paramContext != null) {
      a = paramContext;
      return;
    } 
    throw new NullPointerException();
  }
  
  public static void a(File paramFile) {
    if (!paramFile.exists())
      paramFile.mkdirs(); 
  }
  
  public static File b() {
    if (!c() || !d())
      return null; 
    File file = new File(a(), "video");
    a(file);
    return file;
  }
  
  public static File b(Context paramContext) {
    File file2 = paramContext.getExternalCacheDir();
    File file1 = file2;
    if (file2 == null)
      file1 = paramContext.getCacheDir(); 
    return file1;
  }
  
  public static boolean c() {
    try {
      String str = Environment.getExternalStorageState();
      if (!"mounted".equals(str)) {
        boolean bool = "mounted_ro".equals(str);
        if (!bool)
          return false; 
      } 
      return true;
    } catch (Exception exception) {
      return c.a().b();
    } 
  }
  
  public static boolean d() {
    try {
      return "mounted".equals(Environment.getExternalStorageState());
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */