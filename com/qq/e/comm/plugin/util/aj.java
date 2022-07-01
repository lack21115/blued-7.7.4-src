package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.f.a;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.Md5Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class aj {
  public static long a(File paramFile) {
    long l1 = 0L;
    long l2 = l1;
    if (paramFile != null) {
      l2 = l1;
      if (paramFile.isDirectory()) {
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (true) {
          l2 = l1;
          if (i < j) {
            File file = arrayOfFile[i];
            if (file.isDirectory()) {
              l2 = a(file);
            } else {
              l2 = file.length();
            } 
            l1 += l2;
            i++;
            continue;
          } 
          break;
        } 
      } 
    } 
    return l2;
  }
  
  public static File a() {
    return GDTADManager.getInstance().getAppContext().getDir("adnet", 0);
  }
  
  public static File a(Context paramContext) {
    File file = new File(paramContext.getApplicationContext().getCacheDir(), "gdtadmobwebcache");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static String a(String paramString) {
    return Md5Util.encode(paramString);
  }
  
  public static void a(File paramFile, String paramString) {
    if (paramFile != null && !TextUtils.isEmpty(paramString))
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
        fileOutputStream.write(paramString.getBytes(a.a));
        fileOutputStream.flush();
        fileOutputStream.close();
        return;
      } catch (IOException iOException) {
        return;
      }  
  }
  
  public static File b(Context paramContext) {
    File file = new File(paramContext.getApplicationContext().getCacheDir(), "gdtadmobwebdatabase");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a().getAbsolutePath());
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    File file = new File(stringBuilder.toString());
    file.mkdirs();
    return file;
  }
  
  public static void b() {
    int i = GDTADManager.getInstance().getSM().getInteger("adnetDirMaxSize", 50);
    if (a(a()) >= (i * 1024) * 1024L) {
      b(a());
      u.a(100032, 0, null);
    } 
  }
  
  public static void b(File paramFile) {
    if (paramFile != null && paramFile.isDirectory()) {
      for (File file : paramFile.listFiles()) {
        if (file.isDirectory()) {
          b(file);
        } else {
          file.delete();
        } 
      } 
      paramFile.delete();
    } 
  }
  
  public static File c() {
    File file = new File(GDTADManager.getInstance().getAppContext().getDir("firstplay", 0).getAbsolutePath());
    file.mkdirs();
    return file;
  }
  
  public static File c(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b(paramString).getAbsolutePath());
    stringBuilder.append(File.separator);
    stringBuilder.append("preload");
    return new File(stringBuilder.toString());
  }
  
  public static String c(File paramFile) {
    byte[] arrayOfByte = null;
    if (paramFile != null && paramFile.exists()) {
      try {
        FileInputStream fileInputStream = new FileInputStream(paramFile);
      } catch (IOException iOException1) {
      
      } finally {
        if (iOException != null)
          try {
            iOException.close();
          } catch (IOException iOException1) {} 
      } 
      if (paramFile != null)
        try {
          paramFile.close();
          return null;
        } catch (IOException iOException1) {
          return null;
        }  
    } 
    return null;
  }
  
  public static File d() {
    File file1 = GDTADManager.getInstance().getAppContext().getApplicationContext().getExternalCacheDir();
    File file2 = GDTADManager.getInstance().getAppContext().getApplicationContext().getCacheDir();
    return (file1 != null) ? file1 : file2;
  }
  
  public static File d(String paramString) {
    File file = f();
    if (file != null) {
      paramString = a(paramString);
      if (!TextUtils.isEmpty(paramString))
        return new File(file, paramString); 
    } 
    return null;
  }
  
  public static File e() {
    File file;
    if (SDKStatus.getSDKVersionCode() < 20) {
      if ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory() != null && Environment.getExternalStorageDirectory().exists()) {
        File file1 = new File(Environment.getExternalStorageDirectory(), "GDTDOWNLOAD");
        file = file1;
        if (!file1.exists()) {
          file1.mkdirs();
          return file1;
        } 
      } else {
        return null;
      } 
    } else {
      File file1 = new File(d(), "com_qq_e_download");
      file = file1;
      if (!file1.exists()) {
        file1.mkdirs();
        return file1;
      } 
    } 
    return file;
  }
  
  public static File e(String paramString) {
    File file = g();
    if (file != null) {
      paramString = a(paramString);
      if (!TextUtils.isEmpty(paramString))
        return new File(file, paramString); 
    } 
    return null;
  }
  
  public static File f() {
    File file = e();
    if (file == null)
      return null; 
    file = new File(file, "video");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File g() {
    File file = new File(a(), "html");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File h() {
    File file = e();
    if (file == null)
      return null; 
    file = new File(file, "apk");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File i() {
    File file = e();
    if (file == null)
      return null; 
    file = new File(file, "icon");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File j() {
    File file = new File(GDTADManager.getInstance().getAppContext().getCacheDir(), "resource");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File k() {
    File file = new File(GDTADManager.getInstance().getAppContext().getCacheDir(), "template");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File l() {
    return new File(GDTADManager.getInstance().getAppContext().getCacheDir(), "GDTDOWNLOAD/image");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */