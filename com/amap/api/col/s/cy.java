package com.amap.api.col.s;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

public abstract class cy {
  int g = 20000;
  
  int h = 20000;
  
  Proxy i = null;
  
  private String a(String paramString) {
    byte[] arrayOfByte = i();
    String str = paramString;
    if (arrayOfByte != null) {
      if (arrayOfByte.length == 0)
        return paramString; 
      Map<String, String> map = e();
      if (map == null)
        return paramString; 
      str = cv.a(map);
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(paramString);
      stringBuffer.append("?");
      stringBuffer.append(str);
      str = stringBuffer.toString();
    } 
    return str;
  }
  
  public final void a(int paramInt) {
    this.g = paramInt;
  }
  
  public String b() {
    return g();
  }
  
  public final void b(int paramInt) {
    this.h = paramInt;
  }
  
  public String c() {
    return "";
  }
  
  public abstract Map<String, String> e();
  
  public abstract Map<String, String> f();
  
  public abstract String g();
  
  public byte[] i() {
    return null;
  }
  
  protected String j() {
    return "";
  }
  
  public boolean k() {
    return false;
  }
  
  final String m() {
    return a(g());
  }
  
  final String n() {
    return a(b());
  }
  
  protected final boolean o() {
    return !TextUtils.isEmpty(j());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */