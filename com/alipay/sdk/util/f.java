package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay;
import com.alipay.sdk.app.statistic.a;

class f implements ServiceConnection {
  f(e parame) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    a.a(e.a(this.a), "biz", "srvCon");
    synchronized (e.b(this.a)) {
      e.a(this.a, IAlixPay.Stub.asInterface(paramIBinder));
      e.b(this.a).notify();
      return;
    } 
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    a.a(e.a(this.a), "biz", "srvDis");
    e.a(this.a, (IAlixPay)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */