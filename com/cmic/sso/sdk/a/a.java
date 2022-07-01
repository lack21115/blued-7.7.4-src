package com.cmic.sso.sdk.a;

import android.os.Build;

public class a {
  static int a() {
    return a(b());
  }
  
  private static int a(a parama) {
    int i = null.a[parama.ordinal()];
    return (i != 1) ? ((i != 2) ? -1 : 1) : 0;
  }
  
  private static a b() {
    String str = Build.BRAND;
    return str.equalsIgnoreCase("samsung") ? a.b : (str.equalsIgnoreCase("Huawei") ? a.c : a.a);
  }
  
  public enum a {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */