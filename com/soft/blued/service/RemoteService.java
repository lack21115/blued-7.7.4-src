package com.soft.blued.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.soft.blued.aidl.IMyAidlInterface;
import com.soft.blued.utils.Logger;

public class RemoteService extends Service {
  private MyConn a;
  
  private MyBinder b;
  
  public IBinder onBind(Intent paramIntent) {
    return (IBinder)this.b;
  }
  
  public void onCreate() {
    super.onCreate();
    Logger.a("RemoteServices", new Object[] { "RemoteService onCreate" });
    this.a = new MyConn(this);
    this.b = new MyBinder(this);
  }
  
  public void onDestroy() {
    super.onDestroy();
    Logger.a("RemoteServices", new Object[] { "RemoteService onDestroy" });
    unbindService(this.a);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    Logger.a("RemoteServices", new Object[] { "RemoteService onStartCommand" });
    bindService(new Intent((Context)this, AutoStartService.class), this.a, 64);
    return 1;
  }
  
  class MyBinder extends IMyAidlInterface.Stub {
    MyBinder(RemoteService this$0) {}
    
    public String a() throws RemoteException {
      return RemoteService.class.getSimpleName();
    }
  }
  
  class MyConn implements ServiceConnection {
    MyConn(RemoteService this$0) {}
    
    public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      Logger.a("RemoteServices", new Object[] { "onServiceConnected" });
    }
    
    public void onServiceDisconnected(ComponentName param1ComponentName) {
      Logger.a("RemoteServices", new Object[] { "restart AutoStrartService onServiceDisconnected" });
      try {
        AutoStartService.a((Context)this.a);
        this.a.bindService(new Intent((Context)this.a, AutoStartService.class), RemoteService.a(this.a), 64);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      Logger.a("RemoteServices", new Object[] { "restart AutoStrartService done" });
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\service\RemoteService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */