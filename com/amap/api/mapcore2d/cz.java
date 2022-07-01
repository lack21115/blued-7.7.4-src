package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Map;

@Deprecated
public class cz extends Thread implements et.a {
  protected static boolean g = false;
  
  private static String i = "sodownload";
  
  private static String j = "sofail";
  
  protected a a;
  
  protected RandomAccessFile b;
  
  protected String c;
  
  protected String d;
  
  protected String e;
  
  protected Context f;
  
  private et h;
  
  public cz(Context paramContext, String paramString1, String paramString2, String paramString3) {
    this.f = paramContext;
    this.e = paramString3;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("temp.so");
    this.c = a(paramContext, stringBuilder.toString());
    this.d = a(paramContext, "libwgs2gcj.so");
    this.a = new a(paramString2);
    this.h = new et(this.a);
  }
  
  public static String a(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    stringBuilder.append(File.separator);
    stringBuilder.append("libso");
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private static String b(Context paramContext, String paramString) {
    return a(paramContext, paramString);
  }
  
  public void a() {
    a a1 = this.a;
    if (a1 != null && !TextUtils.isEmpty(a1.h()) && this.a.h().contains("libJni_wgs2gcj.so")) {
      if (!this.a.h().contains(db.a(this.f)))
        return; 
      if ((new File(this.d)).exists())
        return; 
      start();
    } 
  }
  
  public void a(Throwable paramThrowable) {
    try {
      if (this.b != null)
        this.b.close(); 
      d();
      File file = new File(b(this.f, "tempfile"));
      boolean bool = file.exists();
    } finally {
      paramThrowable = null;
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, long paramLong) {
    try {
      if (this.b == null) {
        File file1 = new File(this.c);
        File file2 = file1.getParentFile();
        if (!file2.exists())
          file2.mkdirs(); 
        try {
          this.b = new RandomAccessFile(file1, "rw");
        } catch (FileNotFoundException fileNotFoundException) {
          do.c(fileNotFoundException, "sdl", "oDd");
          d();
        } 
      } 
    } finally {
      paramArrayOfbyte = null;
      d();
      do.c((Throwable)paramArrayOfbyte, "sdl", "oDd");
    } 
  }
  
  public void b() {
    d();
  }
  
  public void c() {
    try {
      return;
    } finally {
      Exception exception = null;
      d();
      File file = new File(this.d);
      if (file.exists())
        file.delete(); 
      do.c(exception, "sdl", "ofs");
    } 
  }
  
  protected void d() {
    File file = new File(this.c);
    if (file.exists())
      file.delete(); 
  }
  
  public void run() {
    try {
      return;
    } finally {
      Exception exception = null;
      do.c(exception, "sdl", "run");
      d();
    } 
  }
  
  public static class a extends ew {
    private String a;
    
    a(String param1String) {
      this.a = param1String;
    }
    
    public Map<String, String> f() {
      return null;
    }
    
    public Map<String, String> g() {
      return null;
    }
    
    public String h() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */