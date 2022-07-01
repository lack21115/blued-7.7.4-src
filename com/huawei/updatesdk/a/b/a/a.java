package com.huawei.updatesdk.a.b.a;

import android.content.Context;

public class a {
  private static final Object b = new Object();
  
  private static a c;
  
  private Context a;
  
  public a(Context paramContext) {
    this.a = paramContext.getApplicationContext();
  }
  
  public static void a(Context paramContext) {
    synchronized (b) {
      if (c == null)
        c = new a(paramContext); 
      return;
    } 
  }
  
  public static a c() {
    synchronized (b) {
      return c;
    } 
  }
  
  public Context a() {
    return this.a;
  }
  
  public String b() {
    Context context = this.a;
    return (context == null || context.getFilesDir() == null) ? "" : this.a.getFilesDir().getAbsolutePath();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */