package com.alipay.sdk.widget;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class i implements DownloadListener {
  i(h paramh) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
    try {
      Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      intent.setFlags(268435456);
      return;
    } finally {
      paramString1 = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */