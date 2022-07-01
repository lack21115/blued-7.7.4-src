package com.alipay.sdk.app;

import android.content.DialogInterface;
import com.alipay.sdk.app.statistic.a;

class d implements DialogInterface.OnClickListener {
  d(c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    this.a.b.cancel();
    a.a(b.a(this.a.c), "net", "SSLDenied", "1");
    j.a(j.c());
    this.a.a.finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */