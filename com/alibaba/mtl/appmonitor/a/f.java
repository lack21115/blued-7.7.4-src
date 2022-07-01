package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.log.e.i;

public enum f {
  a(65501, 30, "alarmData", 5000),
  b(65502, 30, "counterData", 5000),
  c(65133, 30, "counterData", 5000),
  d(65503, 30, "statData", 5000);
  
  static String TAG;
  
  private int e;
  
  private int h;
  
  private int i = 25;
  
  private int j = 180;
  
  private int k;
  
  private boolean m;
  
  private String t;
  
  static {
    a = new f[] { (f)a, b, c, d };
    TAG = "EventType";
  }
  
  f(int paramInt1, int paramInt2, String paramString1, int paramInt3) {
    this.e = paramInt1;
    this.h = paramInt2;
    this.m = true;
    this.t = paramString1;
    this.k = paramInt3;
  }
  
  public static f a(int paramInt) {
    f[] arrayOfF = a();
    for (int i = 0; i < arrayOfF.length; i++) {
      f f1 = arrayOfF[i];
      if (f1 != null && f1.a() == paramInt)
        return f1; 
    } 
    return null;
  }
  
  public static f[] a() {
    return (f[])a.clone();
  }
  
  public int a() {
    return this.e;
  }
  
  public String a() {
    return this.t;
  }
  
  public int b() {
    return this.h;
  }
  
  public void b(int paramInt) {
    String str1 = TAG;
    String str2 = this.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    i.a(str1, new Object[] { "[setTriggerCount]", str2, stringBuilder.toString() });
    this.h = paramInt;
  }
  
  public void b(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public int c() {
    return this.i;
  }
  
  public void c(int paramInt) {
    this.k = paramInt;
  }
  
  public int d() {
    return this.j;
  }
  
  public int e() {
    return this.k;
  }
  
  public boolean isOpen() {
    return this.m;
  }
  
  public void setStatisticsInterval(int paramInt) {
    this.i = paramInt;
    this.j = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */