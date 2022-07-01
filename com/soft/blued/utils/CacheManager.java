package com.soft.blued.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import java.io.File;
import java.text.DecimalFormat;

public class CacheManager {
  private static String[] e;
  
  private File a;
  
  private File b;
  
  private File c;
  
  private File d;
  
  public CacheManager() {
    e = AppInfo.d().getResources().getStringArray(2130903050);
    this.b = AppInfo.d().getExternalCacheDir();
    this.a = AppInfo.d().getCacheDir();
    this.c = AppInfo.d().getFilesDir();
    this.d = AppInfo.d().getExternalFilesDir(null);
  }
  
  private static long a(String paramString) {
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = 0L;
    if (bool)
      return 0L; 
    File file = new File(paramString.trim());
    long l1 = l2;
    if (file.exists()) {
      if (file.isDirectory())
        return b(file); 
      l1 = l2;
      if (file.isFile())
        l1 = file.length(); 
    } 
    return l1;
  }
  
  private static String a(long paramLong) {
    StringBuilder stringBuilder2;
    if (paramLong == 0L)
      return "0M"; 
    DecimalFormat decimalFormat1 = new DecimalFormat("#0.00");
    DecimalFormat decimalFormat2 = new DecimalFormat("#0");
    if (paramLong < 10240L)
      return "0M"; 
    double d = paramLong / 1048576.0D;
    if (d < 100.0D) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(decimalFormat1.format(d));
      stringBuilder2.append("M");
      return stringBuilder2.toString();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(stringBuilder2.format(d));
    stringBuilder1.append("M");
    return stringBuilder1.toString();
  }
  
  private static long b(File paramFile) {
    long l3;
    long l1 = 0L;
    if (paramFile != null) {
      long l = l1;
      try {
        if (b(paramFile.getAbsolutePath()))
          return 0L; 
      } catch (OutOfMemoryError outOfMemoryError) {
        outOfMemoryError.printStackTrace();
        return l;
      } 
    } 
    if (outOfMemoryError == null)
      return 0L; 
    long l2 = l1;
    File[] arrayOfFile = outOfMemoryError.listFiles();
    if (arrayOfFile == null)
      return 0L; 
    int i = 0;
    while (true) {
      l3 = l1;
      l2 = l1;
      if (i < arrayOfFile.length) {
        l2 = l1;
        if (arrayOfFile[i].isDirectory()) {
          l2 = l1;
          l3 = b(arrayOfFile[i]);
          l2 = l3;
        } else {
          l2 = l1;
          l3 = arrayOfFile[i].length();
          l2 = l3;
        } 
        l1 += l2;
        i++;
        continue;
      } 
      break;
    } 
    return l3;
  }
  
  private static boolean b(String paramString) {
    if (!StringUtils.e(paramString) && paramString.contains("/")) {
      paramString = paramString.split("/")[(paramString.split("/")).length - 1];
      if (e != null && !StringUtils.e(paramString)) {
        int i = 0;
        while (true) {
          String[] arrayOfString = e;
          if (i < arrayOfString.length) {
            if (paramString.equals(arrayOfString[i]))
              return true; 
            i++;
            continue;
          } 
          break;
        } 
      } 
    } 
    return false;
  }
  
  private static boolean c() {
    boolean bool1;
    boolean bool2;
    String str = Environment.getExternalStorageState();
    boolean bool = "mounted".equals(str);
    boolean bool3 = false;
    if (bool) {
      bool1 = true;
      bool2 = true;
    } else {
      if ("mounted_ro".equals(str)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      bool2 = false;
    } 
    bool = bool3;
    if (bool1) {
      bool = bool3;
      if (bool2)
        bool = true; 
    } 
    return bool;
  }
  
  public String a() {
    long l1;
    long l2;
    if (c() && this.a != null && this.b != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.a.getAbsolutePath());
      stringBuilder1.append("/");
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.b.getAbsolutePath());
      stringBuilder2.append("/");
      String str2 = stringBuilder2.toString();
      l1 = a(str1) + a(str2);
    } else if (this.a != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.getAbsolutePath());
      stringBuilder.append("/");
      l1 = a(stringBuilder.toString());
    } else {
      l1 = 0L;
    } 
    if (c() && this.c != null && this.d != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.c.getAbsolutePath());
      stringBuilder1.append("/");
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.d.getAbsolutePath());
      stringBuilder2.append("/");
      String str2 = stringBuilder2.toString();
      l2 = l1 + a(str1) + a(str2);
    } else {
      l2 = l1;
      if (this.c != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c.getAbsolutePath());
        stringBuilder.append("/");
        l2 = l1 + a(stringBuilder.toString());
      } 
    } 
    return a(l2);
  }
  
  public boolean a(File paramFile) {
    if (paramFile == null)
      return false; 
    try {
      if (paramFile.exists()) {
        if (paramFile.isFile()) {
          paramFile.delete();
          return false;
        } 
        if (paramFile.isDirectory()) {
          if (b(paramFile.getAbsolutePath()))
            return false; 
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile != null)
            for (int i = 0; i < arrayOfFile.length; i++)
              a(arrayOfFile[i]);  
        } 
      } 
      return false;
    } catch (OutOfMemoryError outOfMemoryError) {
      outOfMemoryError.printStackTrace();
      return false;
    } 
  }
  
  public void b() {
    a(this.a);
    a(this.b);
    a(this.c);
    a(this.d);
    if (AppInfo.n() != null)
      AppInfo.n().post(new Runnable(this) {
            public void run() {
              RecyclingImageLoader.d();
              ImageLoader.b();
            }
          }); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\CacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */