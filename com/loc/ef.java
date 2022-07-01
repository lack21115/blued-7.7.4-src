package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

public final class ef extends ar {
  Map<String, String> f = null;
  
  String g = "";
  
  String h = "";
  
  byte[] i = null;
  
  byte[] j = null;
  
  boolean k = false;
  
  String l = null;
  
  Map<String, String> m = null;
  
  boolean n = false;
  
  private String o = "";
  
  public ef(Context paramContext, t paramt) {
    super(paramContext, paramt);
  }
  
  public final void a(String paramString) {
    this.g = paramString;
  }
  
  public final byte[] a_() {
    return this.i;
  }
  
  public final Map<String, String> b() {
    return this.f;
  }
  
  public final void b(String paramString) {
    this.h = paramString;
  }
  
  public final Map<String, String> b_() {
    return this.m;
  }
  
  public final String c() {
    return this.g;
  }
  
  public final void c(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      this.o = paramString;
      return;
    } 
    this.o = "";
  }
  
  public final String d() {
    return this.h;
  }
  
  public final byte[] f() {
    return this.j;
  }
  
  public final String h() {
    return this.o;
  }
  
  public final boolean j() {
    return this.k;
  }
  
  public final String k() {
    return this.l;
  }
  
  protected final boolean l() {
    return this.n;
  }
  
  public final String p() {
    return "loc";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */