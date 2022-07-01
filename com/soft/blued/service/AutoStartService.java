package com.soft.blued.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.blued.android.core.AppInfo;
import com.soft.blued.aidl.IMyAidlInterface;
import com.soft.blued.app.InitTaskUtil;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ServiceUtils;

public class AutoStartService extends Service {
  private MyBinder a;
  
  private MyConn b;
  
  private IBinder c;
  
  private void a() {
    Intent intent = new Intent();
    intent.setAction("com.soft.blued.android.ACTION_AUTOSTARTER");
    PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)this, 0, intent, 0);
    ((AlarmManager)AppInfo.d().getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + 300000L, pendingIntent);
  }
  
  public static void a(Context paramContext) {
    if (InitTaskUtil.getStartAutoStartService()) {
      ServiceUtils.a(paramContext, AutoStartService.class, null);
      ServiceUtils.a(paramContext, RemoteService.class, null);
    } 
  }
  
  public static void b(Context paramContext) {
    try {
      paramContext.stopService(new Intent(paramContext, AutoStartService.class));
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public IBinder onBind(Intent paramIntent) {
    return (IBinder)this.a;
  }
  
  public void onCreate() {
    super.onCreate();
    Logger.a("AutoStartService", new Object[] { "AutoStartService.onCreate()" });
    this.a = new MyBinder(this);
    this.b = new MyConn(this);
    InitTaskUtil.setStartAutoStartService(false);
  }
  
  public void onDestroy() {
    super.onDestroy();
    Logger.a("AutoStartService", new Object[] { "AutoStartService.onDestroy()" });
    if (this.c != null) {
      Logger.a("AutoStartService", new Object[] { "unbind remote service" });
      unbindService(this.b);
      this.c = null;
    } 
    if (UserInfo.a().j())
      a(); 
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    Logger.a("AutoStartService", new Object[] { "AutoStartService onStartCommand" });
    bindService(new Intent((Context)this, RemoteService.class), this.b, 64);
    return 1;
  }
  
  class MyBinder extends IMyAidlInterface.Stub {
    MyBinder(AutoStartService this$0) {}
    
    public String a() throws RemoteException {
      return AutoStartService.class.getSimpleName();
    }
  }
  
  class MyConn implements ServiceConnection {
    MyConn(AutoStartService this$0) {}
    
    public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      Logger.a("AutoStartService", new Object[] { "AutoStartService onServiceConnected" });
      AutoStartService.a(this.a, param1IBinder);
    }
    
    public void onServiceDisconnected(ComponentName param1ComponentName) {
      Logger.a("AutoStartService", new Object[] { "onServiceDisconnected" });
      Logger.a("AutoStartService", new Object[] { "restart RemoteService onServiceDisconnected" });
      try {
        ServiceUtils.a((Context)this.a, RemoteService.class, null);
        this.a.bindService(new Intent((Context)this.a, RemoteService.class), AutoStartService.a(this.a), 64);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\service\AutoStartService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */