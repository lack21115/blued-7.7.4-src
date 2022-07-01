package com.qiniu.pili.droid.crash;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

public class f {
  private static f a;
  
  private Context b;
  
  private String c = "placeholder";
  
  private String d = ".clean.xcrash";
  
  private String e = ".dirty.xcrash";
  
  private String f = null;
  
  private AtomicInteger g = new AtomicInteger();
  
  public static f a() {
    if (a == null)
      a = new f(); 
    return a;
  }
  
  private File[] f() {
    return d().listFiles();
  }
  
  void a(Context paramContext) {
    this.b = paramContext;
    this.f = d().getAbsolutePath();
  }
  
  void a(File paramFile, i parami) {
    try {
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(paramFile), StandardCharsets.UTF_8);
      try {
        outputStreamWriter.write(parami.c().toString());
        outputStreamWriter.flush();
        return;
      } finally {
        k.a(outputStreamWriter);
      } 
    } catch (Exception exception) {
      return;
    } 
  }
  
  void b() {
    File[] arrayOfFile = e();
    int j = arrayOfFile.length;
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++)
      arrayOfFile[i].delete(); 
    arrayOfFile = f();
    j = arrayOfFile.length;
    for (i = bool; i < j; i++)
      arrayOfFile[i].delete(); 
  }
  
  File c() {
    return this.b.getDir("plcrash_approved", 0);
  }
  
  File d() {
    return this.b.getDir("plcrash_unapproved", 0);
  }
  
  File[] e() {
    return c().listFiles();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */