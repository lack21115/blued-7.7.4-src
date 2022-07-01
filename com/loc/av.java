package com.loc;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

public abstract class av {
  int c = 20000;
  
  int d = 20000;
  
  Proxy e = null;
  
  private String a(String paramString) {
    byte[] arrayOfByte = e();
    String str = paramString;
    if (arrayOfByte != null) {
      if (arrayOfByte.length == 0)
        return paramString; 
      Map<String, String> map = b_();
      if (map == null)
        return paramString; 
      str = at.a(map);
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(paramString);
      stringBuffer.append("?");
      stringBuffer.append(str);
      str = stringBuffer.toString();
    } 
    return str;
  }
  
  public final void a(int paramInt) {
    this.c = paramInt;
  }
  
  public final void a(Proxy paramProxy) {
    this.e = paramProxy;
  }
  
  public abstract Map<String, String> b();
  
  public final void b(int paramInt) {
    this.d = paramInt;
  }
  
  public abstract Map<String, String> b_();
  
  public abstract String c();
  
  public String d() {
    return c();
  }
  
  public byte[] e() {
    return null;
  }
  
  protected String h() {
    return "";
  }
  
  public boolean i() {
    return false;
  }
  
  final String m() {
    return a(c());
  }
  
  final String n() {
    return a(d());
  }
  
  protected final boolean o() {
    return !TextUtils.isEmpty(h());
  }
  
  public String p() {
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */