package com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

public interface SVSD {
  IBinder onBind(Intent paramIntent);
  
  void onConfigurationChanged(Configuration paramConfiguration);
  
  void onCreate();
  
  void onDestroy();
  
  void onLowMemory();
  
  void onRebind(Intent paramIntent);
  
  int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2);
  
  void onTaskRemoved(Intent paramIntent);
  
  void onTrimMemory(int paramInt);
  
  boolean onUnbind(Intent paramIntent);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\SVSD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */