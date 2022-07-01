package com.baidu.mobad.feeds;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

class XAdNativeResponse$1 implements DialogInterface.OnClickListener {
  XAdNativeResponse$1(XAdNativeResponse paramXAdNativeResponse, Context paramContext, View paramView, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    paramDialogInterface.dismiss();
    XAdNativeResponse.a(this.d, this.a);
    XAdNativeResponse.c(this.d).handleClick(this.b, XAdNativeResponse.a(this.d), this.c, XAdNativeResponse.b(this.d));
    XAdNativeResponse xAdNativeResponse = this.d;
    XAdNativeResponse.a(xAdNativeResponse, this.a, "confirmed", 0, XAdNativeResponse.a(xAdNativeResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\feeds\XAdNativeResponse$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */