package com.geetest.onelogin.a;

public class g {
  private int a;
  
  private int b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  public g(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.h = paramString6;
  }
  
  public int a() {
    return this.a;
  }
  
  public int b() {
    return this.b;
  }
  
  public String c() {
    return this.c;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{id='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", simId='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", iccId='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", carrierName='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", displayName='");
    stringBuilder.append(this.e);
    stringBuilder.append('\'');
    stringBuilder.append(", number='");
    stringBuilder.append(this.f);
    stringBuilder.append('\'');
    stringBuilder.append(", mcc='");
    stringBuilder.append(this.g);
    stringBuilder.append('\'');
    stringBuilder.append(", mnc='");
    stringBuilder.append(this.h);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */