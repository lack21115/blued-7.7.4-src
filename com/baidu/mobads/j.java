package com.baidu.mobads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.production.b.c;

final class j implements Runnable {
  j(Context paramContext, int paramInt, String paramString, CpuInfoManager.UrlListener paramUrlListener) {}
  
  public void run() {
    String str = (new c(this.a.getApplicationContext(), this.b, this.c)).a();
    if (this.d != null)
      (new Handler(Looper.getMainLooper())).post(new k(this, str)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */