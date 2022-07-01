package com.alipay.security.mobile.module.c;

import android.os.Environment;
import java.io.File;

public final class c {
  public static String a(String paramString) {
    try {
      if (a()) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), paramString);
        if (file.exists()) {
          file.delete();
          return "";
        } 
      } 
    } catch (Exception exception) {}
    return null;
  }
  
  public static boolean a() {
    String str = Environment.getExternalStorageState();
    return (str != null && str.length() > 0 && (str.equals("mounted") || str.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */