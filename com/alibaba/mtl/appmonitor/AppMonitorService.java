package com.alibaba.mtl.appmonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AppMonitorService extends Service {
  IMonitor a = null;
  
  public IBinder onBind(Intent paramIntent) {
    if (this.a == null)
      this.a = new Monitor(getApplication()); 
    return (IBinder)this.a;
  }
  
  public void onDestroy() {
    IMonitor iMonitor = this.a;
    if (iMonitor != null)
      try {
        iMonitor.triggerUpload();
      } catch (RemoteException remoteException) {} 
    super.onDestroy();
  }
  
  public void onLowMemory() {
    IMonitor iMonitor = this.a;
    if (iMonitor != null)
      try {
        iMonitor.triggerUpload();
      } catch (RemoteException remoteException) {} 
    super.onLowMemory();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */