package com.ss.android.socialbase.downloader.m;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.ss.android.socialbase.downloader.downloader.b;

public final class a {
  private static a a(PackageManager paramPackageManager, PackageInfo paramPackageInfo) {
    boolean bool;
    if (paramPackageInfo == null)
      return null; 
    ApplicationInfo applicationInfo = paramPackageInfo.applicationInfo;
    String str1 = paramPackageInfo.packageName;
    String str2 = applicationInfo.loadLabel(paramPackageManager).toString();
    Drawable drawable = applicationInfo.loadIcon(paramPackageManager);
    String str3 = applicationInfo.sourceDir;
    String str4 = paramPackageInfo.versionName;
    int i = paramPackageInfo.versionCode;
    if ((applicationInfo.flags & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return new a(str1, str2, drawable, str3, str4, i, bool);
  }
  
  public static a a(String paramString) {
    try {
      PackageManager packageManager = b.B().getPackageManager();
      return (packageManager == null) ? null : a(packageManager, packageManager.getPackageInfo(paramString, 0));
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      return null;
    } 
  }
  
  public static class a {
    private String a;
    
    private String b;
    
    private Drawable c;
    
    private String d;
    
    private String e;
    
    private int f;
    
    private boolean g;
    
    public a(String param1String1, String param1String2, Drawable param1Drawable, String param1String3, String param1String4, int param1Int, boolean param1Boolean) {
      b(param1String2);
      a(param1Drawable);
      a(param1String1);
      c(param1String3);
      d(param1String4);
      a(param1Int);
      a(param1Boolean);
    }
    
    public Drawable a() {
      return this.c;
    }
    
    public void a(int param1Int) {
      this.f = param1Int;
    }
    
    public void a(Drawable param1Drawable) {
      this.c = param1Drawable;
    }
    
    public void a(String param1String) {
      this.a = param1String;
    }
    
    public void a(boolean param1Boolean) {
      this.g = param1Boolean;
    }
    
    public void b(String param1String) {
      this.b = param1String;
    }
    
    public boolean b() {
      return this.g;
    }
    
    public String c() {
      return this.a;
    }
    
    public void c(String param1String) {
      this.d = param1String;
    }
    
    public String d() {
      return this.b;
    }
    
    public void d(String param1String) {
      this.e = param1String;
    }
    
    public String e() {
      return this.d;
    }
    
    public int f() {
      return this.f;
    }
    
    public String g() {
      return this.e;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("{\n  pkg name: ");
      stringBuilder.append(c());
      stringBuilder.append("\n  app icon: ");
      stringBuilder.append(a());
      stringBuilder.append("\n  app name: ");
      stringBuilder.append(d());
      stringBuilder.append("\n  app path: ");
      stringBuilder.append(e());
      stringBuilder.append("\n  app v name: ");
      stringBuilder.append(g());
      stringBuilder.append("\n  app v code: ");
      stringBuilder.append(f());
      stringBuilder.append("\n  is system: ");
      stringBuilder.append(b());
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */