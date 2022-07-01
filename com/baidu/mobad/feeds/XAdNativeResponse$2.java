package com.baidu.mobad.feeds;

import android.content.Context;
import android.content.DialogInterface;

class XAdNativeResponse$2 implements DialogInterface.OnClickListener {
  XAdNativeResponse$2(XAdNativeResponse paramXAdNativeResponse, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    paramDialogInterface.dismiss();
    XAdNativeResponse xAdNativeResponse = this.b;
    XAdNativeResponse.a(xAdNativeResponse, this.a, "cancel", 1, XAdNativeResponse.a(xAdNativeResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\feeds\XAdNativeResponse$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */