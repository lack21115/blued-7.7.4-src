package com.alipay.sdk.widget;

import android.content.Context;
import android.webkit.SslErrorHandler;

class n implements Runnable {
  n(j paramj, SslErrorHandler paramSslErrorHandler) {}
  
  public void run() {
    e.a((Context)this.b.a, "安全警告", "安全連接證書校驗無效，將無法保證訪問資料的安全性，請安裝支付寶 Alipay 後重試。", "確定", new o(this), null, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */