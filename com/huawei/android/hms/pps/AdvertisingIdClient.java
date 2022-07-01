package com.huawei.android.hms.pps;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.util.Log;
import com.huawei.android.hms.pps.a.a;
import com.huawei.android.hms.pps.a.b;
import java.io.IOException;

@Keep
public class AdvertisingIdClient {
  @Keep
  public static Info getAdvertisingIdInfo(Context paramContext) {
    Log.i(getTag(), "getAdvertisingIdInfo " + System.currentTimeMillis());
    if (Looper.myLooper() != Looper.getMainLooper())
      try {
        paramContext.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        a a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (paramContext.bindService(intent, (ServiceConnection)a, 1)) {
          Log.i(getTag(), "bind ok");
          try {
            if (!a.a) {
              a.a = true;
              b b = new b(a.b.take());
              return new Info(b.e(), b.d());
            } 
            throw new IllegalStateException();
          } catch (InterruptedException interruptedException) {
            Log.e(getTag(), "bind hms service InterruptedException");
            throw new IOException("bind hms service InterruptedException");
          } catch (RemoteException remoteException) {
            Log.e(getTag(), "bind hms service RemoteException");
            throw new IOException("bind hms service RemoteException");
          } finally {
            paramContext.unbindService((ServiceConnection)a);
          } 
        } 
        Log.w(getTag(), "bind failed");
        throw new IOException("bind failed");
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.w(getTag(), "HMS not found");
        throw new IOException("Service not found");
      }  
    Log.w(getTag(), "Cannot be called from the main thread");
    throw new IllegalStateException("Cannot be called from the main thread");
  }
  
  private static String getTag() {
    return "AdId";
  }
  
  @Keep
  public static final class Info {
    private final String advertisingId;
    
    private final boolean limitAdTrackingEnabled;
    
    Info(String param1String, boolean param1Boolean) {
      this.advertisingId = param1String;
      this.limitAdTrackingEnabled = param1Boolean;
    }
    
    @Keep
    public final String getId() {
      return this.advertisingId;
    }
    
    @Keep
    public final boolean isLimitAdTrackingEnabled() {
      return this.limitAdTrackingEnabled;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\huawei\android\hms\pps\AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */