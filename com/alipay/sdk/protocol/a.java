package com.alipay.sdk.protocol;

import android.text.TextUtils;

public enum a {
  a("none"),
  b("js://wappay"),
  c("js://update"),
  d("loc:openweb"),
  e("loc:setResult"),
  f("loc:exit");
  
  private String g;
  
  a(String paramString1) {
    this.g = paramString1;
  }
  
  public static a a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return a; 
    a a1 = a;
    for (a a2 : values()) {
      if (paramString.startsWith(a2.g))
        return a2; 
    } 
    return a1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\protocol\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */