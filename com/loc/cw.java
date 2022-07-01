package com.loc;

public abstract class cw {
  public String a = "";
  
  public String b = "";
  
  public int c = 99;
  
  public int d = Integer.MAX_VALUE;
  
  public long e = 0L;
  
  public long f = 0L;
  
  public int g = 0;
  
  public boolean h;
  
  public boolean i = true;
  
  public cw(boolean paramBoolean1, boolean paramBoolean2) {
    this.h = paramBoolean1;
    this.i = paramBoolean2;
  }
  
  private static int a(String paramString) {
    try {
      return Integer.parseInt(paramString);
    } catch (Exception exception) {
      dg.a(exception);
      return 0;
    } 
  }
  
  public abstract cw a();
  
  public final void a(cw paramcw) {
    if (paramcw != null) {
      this.a = paramcw.a;
      this.b = paramcw.b;
      this.c = paramcw.c;
      this.d = paramcw.d;
      this.e = paramcw.e;
      this.f = paramcw.f;
      this.g = paramcw.g;
      this.h = paramcw.h;
      this.i = paramcw.i;
    } 
  }
  
  public final int b() {
    return a(this.a);
  }
  
  public final int c() {
    return a(this.b);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("AmapCell{mcc=");
    stringBuilder.append(this.a);
    stringBuilder.append(", mnc=");
    stringBuilder.append(this.b);
    stringBuilder.append(", signalStrength=");
    stringBuilder.append(this.c);
    stringBuilder.append(", asulevel=");
    stringBuilder.append(this.d);
    stringBuilder.append(", lastUpdateSystemMills=");
    stringBuilder.append(this.e);
    stringBuilder.append(", lastUpdateUtcMills=");
    stringBuilder.append(this.f);
    stringBuilder.append(", age=");
    stringBuilder.append(this.g);
    stringBuilder.append(", main=");
    stringBuilder.append(this.h);
    stringBuilder.append(", newapi=");
    stringBuilder.append(this.i);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */