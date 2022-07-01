package com.alipay.sdk.util;

public enum d {
  a(0, "WIFI"),
  b(1, "unicom2G"),
  c(2, "mobile2G"),
  d(4, "telecom2G"),
  e(5, "telecom3G"),
  f(6, "telecom3G"),
  g(12, "telecom3G"),
  h(8, "unicom3G"),
  i(3, "unicom3G"),
  j(13, "LTE"),
  k(11, "IDEN"),
  l(9, "HSUPA"),
  m(10, "HSPA"),
  n(15, "HSPAP"),
  o(-1, "none");
  
  private int p;
  
  private String q;
  
  d(int paramInt1, String paramString1) {
    this.p = paramInt1;
    this.q = paramString1;
  }
  
  public static d a(int paramInt) {
    for (d d1 : values()) {
      if (d1.a() == paramInt)
        return d1; 
    } 
    return o;
  }
  
  public final int a() {
    return this.p;
  }
  
  public final String b() {
    return this.q;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */