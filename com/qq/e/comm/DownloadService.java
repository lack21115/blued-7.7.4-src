package com.qq.e.comm;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class DownloadService extends Service {
  private SVSD a;
  
  private boolean a(String paramString) {
    if (this.a == null)
      try {
      
      } finally {
        paramString = null;
      }  
    return (this.a != null);
  }
  
  public IBinder onBind(Intent paramIntent) {
    GDTLogger.d("DownloadService.onBind");
    SVSD sVSD = this.a;
    if (sVSD == null) {
      String str = paramIntent.getStringExtra("GDT_APPID");
      StringBuilder stringBuilder = new StringBuilder("DownloadService.onBind,appID=");
      stringBuilder.append(str);
      GDTLogger.d(stringBuilder.toString());
      if (!StringUtil.isEmpty(str) && a(str)) {
        sVSD = this.a;
        return sVSD.onBind(paramIntent);
      } 
      return null;
    } 
    return sVSD.onBind(paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    SVSD sVSD = this.a;
    if (sVSD != null)
      sVSD.onConfigurationChanged(paramConfiguration); 
  }
  
  public void onCreate() {
    super.onCreate();
  }
  
  public void onDestroy() {
    SVSD sVSD = this.a;
    if (sVSD != null)
      sVSD.onDestroy(); 
  }
  
  public void onLowMemory() {
    SVSD sVSD = this.a;
    if (sVSD != null)
      sVSD.onLowMemory(); 
  }
  
  public void onRebind(Intent paramIntent) {
    SVSD sVSD = this.a;
    if (sVSD != null)
      sVSD.onRebind(paramIntent); 
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    if (paramIntent == null) {
      stopSelf(paramInt2);
    } else {
      String str = paramIntent.getStringExtra("GDT_APPID");
      if (!StringUtil.isEmpty(str) && a(str))
        return this.a.onStartCommand(paramIntent, paramInt1, paramInt2); 
      GDTLogger.w("Failto Start new download Service");
    } 
    return 2;
  }
  
  public void onTaskRemoved(Intent paramIntent) {
    SVSD sVSD = this.a;
    if (sVSD != null)
      sVSD.onTaskRemoved(paramIntent); 
  }
  
  public void onTrimMemory(int paramInt) {
    SVSD sVSD = this.a;
    if (sVSD != null)
      sVSD.onTrimMemory(paramInt); 
  }
  
  public boolean onUnbind(Intent paramIntent) {
    SVSD sVSD = this.a;
    return (sVSD != null) ? sVSD.onUnbind(paramIntent) : super.onUnbind(paramIntent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */