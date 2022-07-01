package com.alipay.apmobilesecuritysdk.face;

import com.alipay.apmobilesecuritysdk.a.a;
import java.util.Map;

class TMNTokenClient$1 implements Runnable {
  TMNTokenClient$1(TMNTokenClient paramTMNTokenClient, Map paramMap, TMNTokenClient.InitResultListener paramInitResultListener, String paramString) {}
  
  public void run() {
    String str;
    int i = (new a(TMNTokenClient.a(this.d))).a(this.a);
    TMNTokenClient.InitResultListener initResultListener = this.b;
    if (initResultListener == null)
      return; 
    if (i == 0) {
      str = a.a(TMNTokenClient.a(this.d), this.c);
      this.b.onResult(str, 0);
      return;
    } 
    str.onResult("", i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\TMNTokenClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */