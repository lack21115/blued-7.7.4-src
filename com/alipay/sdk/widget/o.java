package com.alipay.sdk.widget;

import android.content.DialogInterface;
import com.alipay.sdk.app.j;
import com.alipay.sdk.app.statistic.a;

class o implements DialogInterface.OnClickListener {
  o(n paramn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    this.a.a.cancel();
    a.a(j.b(this.a.b), "net", "SSLDenied", "2");
    j.a(j.c());
    this.a.b.a.finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */