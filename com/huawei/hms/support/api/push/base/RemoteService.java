package com.huawei.hms.support.api.push.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

public class RemoteService {
  public static final String TAG = "RemoteService";
  
  public Messenger mService = null;
  
  public ServiceConnection serviceConnection;
  
  public boolean startMsgService(final Context applicationContext, final Bundle bundle, Intent paramIntent) {
    applicationContext = applicationContext.getApplicationContext();
    this.serviceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
          HMSLog.i("RemoteService", "remote service onConnected");
          RemoteService.access$002(RemoteService.this, new Messenger(param1IBinder));
          Message message = Message.obtain();
          message.setData(bundle);
          try {
            RemoteService.this.mService.send(message);
          } catch (RemoteException remoteException) {
            HMSLog.i("RemoteService", "remote service message send failed");
          } 
          HMSLog.i("RemoteService", "remote service unbindservice");
          applicationContext.unbindService(RemoteService.this.serviceConnection);
        }
        
        public void onServiceDisconnected(ComponentName param1ComponentName) {
          HMSLog.i("RemoteService", "remote service onDisconnected");
          RemoteService.access$002(RemoteService.this, null);
        }
      };
    HMSLog.i("RemoteService", "remote service bind service start");
    return applicationContext.bindService(paramIntent, this.serviceConnection, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\base\RemoteService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */