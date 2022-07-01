package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;

class q extends TimerTask {
  q(p paramp, IXAdPackageUtils paramIXAdPackageUtils, Context paramContext, String paramString1, Timer paramTimer, String paramString2) {}
  
  public void run() {
    if (p.a(this.f) >= p.b(this.f))
      if (p.a(this.f) < p.c(this.f)) {
        if (!this.a.isForeground(this.b, this.c)) {
          this.d.cancel();
          this.a.sendAPOIsSuccess(this.b, false, p.a(this.f), this.e, this.c);
        } 
      } else {
        this.d.cancel();
        this.a.sendAPOIsSuccess(this.b, true, 0, this.e, this.c);
      }  
    p.d(this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */