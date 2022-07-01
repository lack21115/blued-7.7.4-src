package com.geetest.onelogin.a;

public class e {
  private String a;
  
  private String b;
  
  private String c;
  
  private int d;
  
  public String a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public String b() {
    return this.b;
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public String c() {
    return this.c;
  }
  
  public void c(String paramString) {
    this.c = paramString;
  }
  
  public int d() {
    return this.d;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("OpBean{appId='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", appKey='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", expireTime=");
    stringBuilder.append(this.d);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */