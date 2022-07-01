package com.heytap.openid.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.heytap.openid.a;

public class b implements ServiceConnection {
  public b(c paramc) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    this.a.a = a.a.a(paramIBinder);
    synchronized (this.a.d) {
      this.a.d.notify();
      return;
    } 
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    this.a.a = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\heytap\openid\sdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */