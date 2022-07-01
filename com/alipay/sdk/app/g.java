package com.alipay.sdk.app;

import android.content.Context;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.c;

class g implements Runnable {
  g(PayTask paramPayTask, String paramString, boolean paramBoolean, H5PayCallback paramH5PayCallback) {}
  
  public void run() {
    a a = new a((Context)PayTask.a(this.d), this.a, "payInterceptorWithUrl");
    H5PayResultModel h5PayResultModel = this.d.h5Pay(a, this.a, this.b);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("inc finished: ");
    stringBuilder.append(h5PayResultModel.getResultCode());
    c.b("mspl", stringBuilder.toString());
    this.c.onPayResult(h5PayResultModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */