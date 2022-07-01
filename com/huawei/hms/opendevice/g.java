package com.huawei.hms.opendevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

public class g implements ServiceConnection {
  public g(h paramh, Bundle paramBundle, Context paramContext) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    HMSLog.i("RemoteService", "remote service onConnected");
    h.a(this.c, new Messenger(paramIBinder));
    Message message = Message.obtain();
    message.setData(this.a);
    try {
      h.a(this.c).send(message);
    } catch (RemoteException remoteException) {
      HMSLog.i("RemoteService", "remote service message send failed");
    } 
    HMSLog.i("RemoteService", "remote service unbindservice");
    this.b.unbindService(h.b(this.c));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    HMSLog.i("RemoteService", "remote service onDisconnected");
    h.a(this.c, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */