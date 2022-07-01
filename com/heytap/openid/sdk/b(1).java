package com.heytap.openid.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class b implements ServiceConnection {
  public b(c paramc) {}
  
  public native void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  public native void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\openid\sdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */