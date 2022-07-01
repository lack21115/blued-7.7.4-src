package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.app.j;
import java.util.concurrent.CountDownLatch;

class g implements AlipayResultActivity.a {
  g(e parame, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {
    e.a(this.b, j.a(paramInt, paramString1, paramString2));
    this.a.countDown();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */