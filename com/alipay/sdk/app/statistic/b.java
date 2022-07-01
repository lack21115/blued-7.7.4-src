package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;

final class b implements Runnable {
  b(String paramString, Context paramContext) {}
  
  public void run() {
    if (!TextUtils.isEmpty(this.a) && !a.b.a(this.b, this.a))
      return; 
    for (int i = 0; i < 4; i++) {
      String str = a.a.a(this.b);
      if (TextUtils.isEmpty(str))
        return; 
      if (!a.b.a(this.b, str))
        return; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\statistic\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */