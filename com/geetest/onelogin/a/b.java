package com.geetest.onelogin.a;

import android.text.TextUtils;

public class b {
  private int a;
  
  private int b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private int g;
  
  private long h;
  
  public String a() {
    return this.c;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(long paramLong) {
    this.h = paramLong;
  }
  
  public void a(String paramString) {
    this.c = paramString;
  }
  
  public long b() {
    return this.h;
  }
  
  public void b(int paramInt) {
    this.b = paramInt;
  }
  
  public void b(String paramString) {
    this.d = paramString;
  }
  
  public void c(int paramInt) {
    this.g = paramInt;
  }
  
  public void c(String paramString) {
    this.e = paramString;
  }
  
  public void d(String paramString) {
    this.f = paramString;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject != null && paramObject instanceof b) {
      paramObject = paramObject;
      return TextUtils.isEmpty(this.f) ? this.e.equals(((b)paramObject).e) : ((this.e.equals(((b)paramObject).e) && this.f.equals(((b)paramObject).f)));
    } 
    return super.equals(paramObject);
  }
  
  public int hashCode() {
    if (TextUtils.isEmpty(this.f))
      return this.e.hashCode(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append(this.f);
    return stringBuilder.toString().hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{id=");
    stringBuilder.append(this.a);
    stringBuilder.append(", simId=");
    stringBuilder.append(this.b);
    stringBuilder.append(", simOperator='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", simState='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", simInfo='");
    stringBuilder.append(this.e);
    stringBuilder.append('\'');
    stringBuilder.append(", simSN='");
    stringBuilder.append(this.f);
    stringBuilder.append('\'');
    stringBuilder.append(", phoneCnt=");
    stringBuilder.append(this.g);
    stringBuilder.append(", updateTime=");
    stringBuilder.append(this.h);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */