package com.loc;

import android.text.TextUtils;
import java.util.Map;

public final class ed extends q {
  Map<String, String> a = null;
  
  Map<String, String> b = null;
  
  String f = "";
  
  byte[] g = null;
  
  private String h = null;
  
  public final void a(String paramString) {
    this.f = paramString;
  }
  
  public final void a(Map<String, String> paramMap) {
    this.a = paramMap;
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    this.g = paramArrayOfbyte;
  }
  
  public final Map<String, String> b() {
    return this.a;
  }
  
  public final void b(String paramString) {
    this.h = paramString;
  }
  
  public final void b(Map<String, String> paramMap) {
    this.b = paramMap;
  }
  
  public final Map<String, String> b_() {
    return this.b;
  }
  
  public final String c() {
    return this.f;
  }
  
  public final String d() {
    return !TextUtils.isEmpty(this.h) ? this.h : super.d();
  }
  
  public final byte[] e() {
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */