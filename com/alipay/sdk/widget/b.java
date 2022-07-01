package com.alipay.sdk.widget;

import android.content.Context;
import com.alipay.sdk.util.c;

class b implements Runnable {
  b(a parama) {}
  
  public void run() {
    if (a.c(this.a) == null) {
      a a1 = this.a;
      a.a(a1, new a.a(a1, (Context)a.a(a1)));
      a.c(this.a).setCancelable(a.d(this.a));
    } 
    try {
      if (!a.c(this.a).isShowing()) {
        a.c(this.a).show();
        a.e(this.a).sendEmptyMessageDelayed(1, 15000L);
        return;
      } 
    } catch (Exception exception) {
      c.a(exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */