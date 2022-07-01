package com.loc;

import java.util.List;

public final class bw extends bt {
  private static bw b = new bw();
  
  private bw() {
    super(5120);
  }
  
  private static String a(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public static bw b() {
    return b;
  }
  
  public final byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, List<? extends ca> paramList) {
    if (paramList == null)
      return null; 
    try {
      int i = paramList.size();
    } finally {
      paramArrayOfbyte1 = null;
    } 
    return null;
  }
  
  public final byte[] c() {
    a();
    try {
      int i = this.a.a(de.f());
      int j = this.a.a(de.c());
      int k = this.a.a(de.i());
      int m = this.a.a(de.h());
      int n = this.a.a(a(de.g()));
      int i1 = this.a.a(a(de.j()));
      long l = dd.a(de.n());
      int i2 = this.a.a(de.l());
      int i3 = this.a.a(de.k());
      int i4 = this.a.a(de.d());
      int i5 = this.a.a(de.e());
      i = df.a(this.a, de.a(), i, j, (byte)de.m(), k, m, n, i1, l, i2, i3, i4, i5);
      this.a.c(i);
      return this.a.c();
    } catch (Exception exception) {
      dg.a(exception);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */