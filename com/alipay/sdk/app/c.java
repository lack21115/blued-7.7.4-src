package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.webkit.SslErrorHandler;
import com.alipay.sdk.widget.e;

class c implements Runnable {
  c(b paramb, Activity paramActivity, SslErrorHandler paramSslErrorHandler) {}
  
  public void run() {
    e.a((Context)this.a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new d(this), null, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */