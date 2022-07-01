package com.amap.api.mapcore2d;

public class ea {
  protected String a;
  
  String b;
  
  String c;
  
  String d;
  
  String e;
  
  int f;
  
  int g;
  
  private String h;
  
  private boolean i = false;
  
  private boolean j = false;
  
  private boolean k = true;
  
  public ea(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    this(paramString1, paramString2, paramString3, false, paramBoolean);
  }
  
  public ea(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2) {
    this.a = paramString1;
    this.h = paramString2;
    this.i = paramBoolean1;
    this.k = paramBoolean2;
    try {
      String[] arrayOfString = paramString1.split("/");
      int i = arrayOfString.length;
      if (i <= 1)
        return; 
      this.b = arrayOfString[i - 1];
      arrayOfString = this.b.split("_");
      this.c = arrayOfString[0];
      this.d = arrayOfString[2];
      this.e = arrayOfString[1];
      return;
    } finally {
      paramString1 = null;
      eh.a((Throwable)paramString1, "DexDownloadItem", "DexDownloadItem");
    } 
  }
  
  String a() {
    return this.a;
  }
  
  public void a(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public String b() {
    return this.h;
  }
  
  String c() {
    return this.d;
  }
  
  public boolean d() {
    return this.i;
  }
  
  public boolean e() {
    return this.j;
  }
  
  public boolean f() {
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */