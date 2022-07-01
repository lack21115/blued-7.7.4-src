package com.huawei.android.hms.pps.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;

public final class a implements ServiceConnection {
  public boolean a = false;
  
  public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<IBinder>(1);
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    try {
      Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
      this.b.put(paramIBinder);
      return;
    } catch (InterruptedException interruptedException) {
      Log.w("PPSSerivceConnection", "onServiceConnected InterruptedException " + System.currentTimeMillis());
      return;
    } 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\huawei\android\hms\pps\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */