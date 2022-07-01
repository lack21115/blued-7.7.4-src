package com.huawei.android.hms.pps.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

public final class a implements ServiceConnection {
  public boolean a = false;
  
  public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<IBinder>(1);
  
  public final native void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  public final native void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\pps\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */