package com.qiniu.pili.droid.shortvideo.f;

import android.os.Build;

public class a {
  public static final String[] a = new String[] { "GT-I9260" };
  
  public static final String[] b = new String[] { "GT-I9260" };
  
  private b c = b.a;
  
  private b d = b.a;
  
  private a() {
    e e = e.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Build.MODEL:");
    stringBuilder.append(Build.MODEL);
    e.c("CompatibleManager", stringBuilder.toString());
  }
  
  public static a a() {
    return a.a;
  }
  
  private b d() {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equalsIgnoreCase(Build.MODEL))
        return b.b; 
    } 
    return b.c;
  }
  
  private b e() {
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equalsIgnoreCase(Build.MODEL))
        return b.c; 
    } 
    return b.b;
  }
  
  public boolean b() {
    if (this.c == b.a)
      this.c = d(); 
    return (this.c == b.b);
  }
  
  public boolean c() {
    if (this.d == b.a)
      this.d = e(); 
    return (this.d == b.b);
  }
  
  static class a {
    public static final a a = new a();
  }
  
  enum b {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */