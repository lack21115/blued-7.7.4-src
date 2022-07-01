package com.bun.miitmdid.c;

import android.text.TextUtils;

public enum a {
  b(-1, "unsupport"),
  c(0, "HUAWEI"),
  d(1, "Xiaomi"),
  e(2, "vivo"),
  f(3, "oppo"),
  g(4, "motorola"),
  h(5, "lenovo"),
  i(6, "asus"),
  j(7, "samsung"),
  k(8, "meizu"),
  l(10, "nubia"),
  m(11, "ZTE"),
  n(12, "OnePlus"),
  o(13, "blackshark"),
  p(30, "freemeos"),
  q(31, "ssui");
  
  private String a;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  a(int paramInt1, String paramString1) {
    this.a = paramString1;
  }
  
  public static a a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return b; 
    a[] arrayOfA = values();
    int j = arrayOfA.length;
    int i = 0;
    while (i < j) {
      a a2 = arrayOfA[i];
      a a1 = a2;
      if (!a2.a.equalsIgnoreCase(paramString)) {
        i++;
        continue;
      } 
      return a1;
    } 
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */