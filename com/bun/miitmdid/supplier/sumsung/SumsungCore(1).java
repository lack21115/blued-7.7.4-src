package com.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.deviceidservice.IDeviceIdService;

public class SumsungCore {
  private static boolean DBG = false;
  
  private static String SAMSUNGTAG = "Samsung_DeviceIdService";
  
  private static String TAG = "SumsungCore library";
  
  private com.bun.miitmdid.c.e.a mCallerCallBack = null;
  
  private ServiceConnection mConnection;
  
  private Context mContext = null;
  
  private IDeviceIdService mDeviceidInterface;
  
  public SumsungCore(Context paramContext, com.bun.miitmdid.c.e.a parama) {
    if (paramContext != null) {
      this.mContext = paramContext;
      this.mCallerCallBack = parama;
      this.mConnection = new a(this);
      Intent intent = new Intent();
      intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
      if (this.mContext.bindService(intent, this.mConnection, 1)) {
        com.bun.lib.a.b(TAG, "bindService Successful!");
        return;
      } 
      this.mContext.unbindService(this.mConnection);
      com.bun.lib.a.b(TAG, "bindService Failed!");
      com.bun.miitmdid.c.e.a a1 = this.mCallerCallBack;
      if (a1 != null)
        a1.b(); 
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  public native String getAAID();
  
  public native String getOAID();
  
  public native String getUDID();
  
  public native String getVAID();
  
  public native boolean isSupported();
  
  public native void shutdown();
  
  class a implements ServiceConnection {
    a(SumsungCore this$0) {}
    
    public synchronized native void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
    
    public native void onServiceDisconnected(ComponentName param1ComponentName);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\supplier\sumsung\SumsungCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */