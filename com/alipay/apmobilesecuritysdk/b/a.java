package com.alipay.apmobilesecuritysdk.b;

import com.alipay.security.mobile.module.http.d;

public final class a {
  private static a b = new a();
  
  private int a = 0;
  
  public static a a() {
    return b;
  }
  
  public final void a(int paramInt) {
    this.a = paramInt;
  }
  
  public final int b() {
    return this.a;
  }
  
  public final String c() {
    String str = d.a();
    if (com.alipay.security.mobile.module.a.a.b(str))
      return str; 
    int i = this.a;
    return (i != 1) ? ((i != 2) ? ((i != 3) ? ((i != 4) ? "https://mobilegw.alipay.com/mgw.htm" : "http://mobilegw.aaa.alipay.net/mgw.htm") : "http://mobilegw-1-64.test.alipay.net/mgw.htm") : "https://mobilegw.alipay.com/mgw.htm") : "http://mobilegw.stable.alipay.net/mgw.htm";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */