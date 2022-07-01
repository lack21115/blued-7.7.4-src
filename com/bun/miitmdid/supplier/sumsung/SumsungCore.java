package com.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.util.Log;
import com.samsung.android.deviceidservice.IDeviceIdService;

@Keep
public class SumsungCore {
  private static boolean DBG = false;
  
  private static String SAMSUNGTAG = "Samsung_DeviceIdService";
  
  private static String TAG = "SumsungCore library";
  
  private com.bun.miitmdid.c.e.a mCallerCallBack = null;
  
  private ServiceConnection mConnection;
  
  private Context mContext = null;
  
  private IDeviceIdService mDeviceidInterface;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
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
      if (a1 != null) {
        a1.b();
        return;
      } 
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  public String getAAID() {
    Context context = this.mContext;
    if (context != null) {
      String str = context.getPackageName();
      com.bun.lib.a.b(TAG, "liufeng, getAAID package：" + str);
      if (str != null && !str.equals("")) {
        try {
          if (this.mDeviceidInterface != null) {
            Log.d(SAMSUNGTAG, "getAAID Package: " + str);
            return this.mDeviceidInterface.getAAID(str);
          } 
        } catch (RemoteException remoteException) {
          com.bun.lib.a.b(TAG, "getAAID error, RemoteException!");
        } 
        return null;
      } 
      com.bun.lib.a.b(TAG, "input package is null!");
      return null;
    } 
    com.bun.lib.a.b(TAG, "Context is null.");
    throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
  }
  
  public String getOAID() {
    if (this.mContext != null) {
      try {
        if (this.mDeviceidInterface != null) {
          Log.d(SAMSUNGTAG, "getOAID call");
          return this.mDeviceidInterface.getOAID();
        } 
      } catch (RemoteException remoteException) {
        com.bun.lib.a.a(TAG, "getOAID error, RemoteException!");
        remoteException.printStackTrace();
      } 
      return null;
    } 
    com.bun.lib.a.a(TAG, "Context is null.");
    throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
  }
  
  public String getUDID() {
    return "";
  }
  
  public String getVAID() {
    Context context = this.mContext;
    if (context != null) {
      String str = context.getPackageName();
      com.bun.lib.a.b(TAG, "liufeng, getVAID package：" + str);
      if (str != null && !str.equals("")) {
        try {
          if (this.mDeviceidInterface != null) {
            Log.d(SAMSUNGTAG, "getVAID Package: " + str);
            return this.mDeviceidInterface.getVAID(str);
          } 
        } catch (RemoteException remoteException) {
          com.bun.lib.a.b(TAG, "getVAID error, RemoteException!");
          remoteException.printStackTrace();
        } 
        return null;
      } 
      com.bun.lib.a.b(TAG, "input package is null!");
      return null;
    } 
    com.bun.lib.a.b(TAG, "Context is null.");
    throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
  }
  
  public boolean isSupported() {
    boolean bool = false;
    try {
      if (this.mDeviceidInterface != null) {
        com.bun.lib.a.b(TAG, "Device support opendeviceid");
        bool = true;
      } 
      return bool;
    } catch (Exception exception) {
      com.bun.lib.a.b(TAG, "isSupport error, RemoteException!");
      return false;
    } 
  }
  
  public void shutdown() {
    try {
      this.mContext.unbindService(this.mConnection);
      com.bun.lib.a.b(TAG, "unBind Service successful");
    } catch (IllegalArgumentException illegalArgumentException) {
      com.bun.lib.a.b(TAG, "unBind Service exception");
    } 
    this.mDeviceidInterface = null;
  }
  
  class a implements ServiceConnection {
    a(SumsungCore this$0) {}
    
    public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Lcom/bun/miitmdid/supplier/sumsung/SumsungCore;
      //   6: aload_2
      //   7: invokestatic a : (Landroid/os/IBinder;)Lcom/samsung/android/deviceidservice/IDeviceIdService;
      //   10: invokestatic access$002 : (Lcom/bun/miitmdid/supplier/sumsung/SumsungCore;Lcom/samsung/android/deviceidservice/IDeviceIdService;)Lcom/samsung/android/deviceidservice/IDeviceIdService;
      //   13: pop
      //   14: aload_0
      //   15: getfield a : Lcom/bun/miitmdid/supplier/sumsung/SumsungCore;
      //   18: invokestatic access$100 : (Lcom/bun/miitmdid/supplier/sumsung/SumsungCore;)Lcom/bun/miitmdid/c/e/a;
      //   21: ifnull -> 37
      //   24: aload_0
      //   25: getfield a : Lcom/bun/miitmdid/supplier/sumsung/SumsungCore;
      //   28: invokestatic access$100 : (Lcom/bun/miitmdid/supplier/sumsung/SumsungCore;)Lcom/bun/miitmdid/c/e/a;
      //   31: iconst_1
      //   32: invokeinterface a : (Z)V
      //   37: invokestatic access$200 : ()Ljava/lang/String;
      //   40: ldc 'Service onServiceConnected'
      //   42: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   45: aload_0
      //   46: monitorexit
      //   47: return
      //   48: astore_1
      //   49: aload_0
      //   50: monitorexit
      //   51: aload_1
      //   52: athrow
      // Exception table:
      //   from	to	target	type
      //   2	37	48	finally
      //   37	45	48	finally
    }
    
    public void onServiceDisconnected(ComponentName param1ComponentName) {
      SumsungCore.access$002(this.a, null);
      com.bun.lib.a.b(SumsungCore.TAG, "Service onServiceDisconnected");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\supplier\sumsung\SumsungCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */