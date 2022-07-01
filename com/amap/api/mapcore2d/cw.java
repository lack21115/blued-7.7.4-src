package com.amap.api.mapcore2d;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

public class cw {
  private volatile b a = new b();
  
  private el b = new el("HttpsDecisionUtil");
  
  public static cw a() {
    return a.a;
  }
  
  public static String a(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("https"))
        return paramString; 
      try {
        Uri.Builder builder = Uri.parse(paramString).buildUpon();
        return builder.build().toString();
      } finally {
        str = null;
      } 
    } 
    return str;
  }
  
  private void b(Context paramContext, boolean paramBoolean) {
    this.b.a(paramContext, "isTargetRequired", paramBoolean);
  }
  
  public static boolean c() {
    return (Build.VERSION.SDK_INT == 19);
  }
  
  private boolean c(Context paramContext) {
    return this.b.b(paramContext, "isTargetRequired", true);
  }
  
  private void d(Context paramContext) {
    this.b.a(paramContext, "isTargetRequired", true);
  }
  
  public void a(Context paramContext) {
    if (this.a == null)
      this.a = new b(); 
    this.a.a(c(paramContext));
    this.a.a(paramContext);
  }
  
  void a(Context paramContext, boolean paramBoolean) {
    if (this.a == null)
      this.a = new b(); 
    b(paramContext, paramBoolean);
    this.a.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean) {
    if (this.a == null)
      this.a = new b(); 
    this.a.b(paramBoolean);
  }
  
  public void b(Context paramContext) {
    d(paramContext);
  }
  
  public boolean b() {
    if (this.a == null)
      this.a = new b(); 
    return this.a.a();
  }
  
  public boolean b(boolean paramBoolean) {
    boolean bool1 = c();
    boolean bool = false;
    if (bool1)
      return false; 
    if (!paramBoolean) {
      paramBoolean = bool;
      return b() ? true : paramBoolean;
    } 
    return true;
  }
  
  static class a {
    static cw a = new cw();
  }
  
  static class b {
    protected boolean a = true;
    
    private int b = 0;
    
    private final boolean c = true;
    
    private boolean d = false;
    
    private b() {}
    
    private int b() {
      int j = this.b;
      int i = j;
      if (j <= 0)
        i = 28; 
      return i;
    }
    
    private boolean c() {
      return (b() >= 28);
    }
    
    private boolean d() {
      return (Build.VERSION.SDK_INT >= 28);
    }
    
    private boolean e() {
      boolean bool1;
      boolean bool4 = d();
      boolean bool2 = this.a;
      boolean bool3 = false;
      if (!bool2 || c()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      bool2 = bool3;
      if (bool4) {
        bool2 = bool3;
        if (bool1)
          bool2 = true; 
      } 
      return bool2;
    }
    
    public void a(Context param1Context) {
      if (param1Context == null)
        return; 
      if (this.b <= 0 && Build.VERSION.SDK_INT >= 4)
        this.b = (param1Context.getApplicationContext().getApplicationInfo()).targetSdkVersion; 
    }
    
    public void a(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public boolean a() {
      return (this.d || e());
    }
    
    public void b(boolean param1Boolean) {
      this.d = param1Boolean;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */