package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class DUConnection implements ServiceConnection {
  public static IDUService duService;
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    try {
      duService = IDUService$Stub.asInterface(paramIBinder);
      if (duService != null) {
        Main.mLock.unlock();
        return;
      } 
    } catch (Exception exception) {
      duService = null;
    } 
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    duService = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\DUConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */