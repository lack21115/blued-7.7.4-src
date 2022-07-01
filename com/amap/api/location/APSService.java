package com.amap.api.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.loc.ej;
import com.loc.f;

public class APSService extends Service {
  f a;
  
  int b = 0;
  
  boolean c = false;
  
  public IBinder onBind(Intent paramIntent) {
    try {
      return this.a.a(paramIntent);
    } finally {
      paramIntent = null;
      ej.a((Throwable)paramIntent, "APSService", "onBind");
    } 
  }
  
  public void onCreate() {
    onCreate((Context)this);
  }
  
  public void onCreate(Context paramContext) {
    try {
      if (this.a == null)
        this.a = new f(paramContext); 
    } finally {
      paramContext = null;
    } 
    super.onCreate();
  }
  
  public void onDestroy() {
    try {
      this.a.b();
      if (this.c)
        stopForeground(true); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    if (paramIntent != null)
      try {
        paramInt1 = paramIntent.getIntExtra("g", 0);
        return 0;
      } finally {
        paramIntent = null;
      }  
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\location\APSService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */