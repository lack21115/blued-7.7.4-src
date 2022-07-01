package com.alipay.security.mobile.module.d;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class a {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
  }
  
  public final String toString() {
    StringBuffer stringBuffer = new StringBuffer((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(Calendar.getInstance().getTime()));
    StringBuilder stringBuilder = new StringBuilder(",");
    stringBuilder.append(this.a);
    stringBuffer.append(stringBuilder.toString());
    stringBuilder = new StringBuilder(",");
    stringBuilder.append(this.b);
    stringBuffer.append(stringBuilder.toString());
    stringBuilder = new StringBuilder(",");
    stringBuilder.append(this.c);
    stringBuffer.append(stringBuilder.toString());
    stringBuilder = new StringBuilder(",");
    stringBuilder.append(this.d);
    stringBuffer.append(stringBuilder.toString());
    if (com.alipay.security.mobile.module.a.a.a(this.e) || this.e.length() < 20) {
      stringBuilder = new StringBuilder(",");
      str = this.e;
    } else {
      stringBuilder = new StringBuilder(",");
      str = this.e.substring(0, 20);
    } 
    stringBuilder.append(str);
    stringBuffer.append(stringBuilder.toString());
    if (com.alipay.security.mobile.module.a.a.a(this.f) || this.f.length() < 20) {
      stringBuilder = new StringBuilder(",");
      str = this.f;
    } else {
      stringBuilder = new StringBuilder(",");
      str = this.f.substring(0, 20);
    } 
    stringBuilder.append(str);
    stringBuffer.append(stringBuilder.toString());
    if (com.alipay.security.mobile.module.a.a.a(this.g) || this.g.length() < 20) {
      stringBuilder = new StringBuilder(",");
      str = this.g;
      stringBuilder.append(str);
      stringBuffer.append(stringBuilder.toString());
      return stringBuffer.toString();
    } 
    stringBuilder = new StringBuilder(",");
    String str = this.g.substring(0, 20);
    stringBuilder.append(str);
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */