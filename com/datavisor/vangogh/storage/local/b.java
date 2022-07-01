package com.datavisor.vangogh.storage.local;

import android.os.Environment;
import com.datavisor.vangogh.f.c;
import com.datavisor.vangogh.f.d;
import java.io.File;

public class b {
  public static String a(String paramString) {
    try {
      String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      if (a() && (new File(str, paramString)).exists())
        return c.b(str, paramString); 
    } finally {
      paramString = null;
    } 
  }
  
  public static String a(String paramString1, String paramString2) {
    if (paramString2 == null)
      return null; 
    try {
      if (a()) {
        File file = new File(Environment.getExternalStorageDirectory(), paramString1);
        if (!file.exists())
          file.getParentFile().mkdirs(); 
        return paramString2;
      } 
    } finally {
      paramString1 = null;
    } 
  }
  
  public static boolean a() {
    String str = Environment.getExternalStorageState();
    return (str != null && str.length() > 0 && (str.equals("mounted") || str.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null);
  }
  
  public static String b(String paramString) {
    File file = null;
    try {
      String str2 = a(paramString);
      return str1;
    } finally {
      paramString = null;
      d.a((Throwable)paramString);
    } 
  }
  
  public static void b(String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramString1 = null;
      d.a((Throwable)paramString1);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\storage\local\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */