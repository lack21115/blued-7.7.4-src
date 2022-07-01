package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;

class r extends TimerTask {
  r(p paramp, IXAdPackageUtils paramIXAdPackageUtils, Context paramContext, String paramString, Timer paramTimer) {}
  
  public void run() {
    if (p.e(this.e) >= p.f(this.e))
      if (p.e(this.e) < p.g(this.e)) {
        if (!this.a.isForeground(this.b, this.c)) {
          IXAdPackageUtils iXAdPackageUtils = this.a;
          Context context = this.b;
          if (iXAdPackageUtils.isForeground(context, context.getPackageName())) {
            this.d.cancel();
            this.a.sendDialerIsSuccess(this.b, false, p.e(this.e), this.c);
          } 
        } 
      } else {
        this.d.cancel();
        this.a.sendDialerIsSuccess(this.b, true, 0, this.c);
      }  
    p.h(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */