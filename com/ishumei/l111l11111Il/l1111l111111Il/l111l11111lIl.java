package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

public final class l111l11111lIl extends l111l1111lI1l {
  private Context l1111l111111Il;
  
  private ServiceConnection l111l11111I1l = new ServiceConnection(this) {
      public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        try {
          l111l11111lIl.l1111l111111Il(this.l1111l111111Il).put(param1IBinder);
          return;
        } catch (Exception exception) {
          return;
        } 
      }
      
      public final void onServiceDisconnected(ComponentName param1ComponentName) {}
    };
  
  private final LinkedBlockingQueue<IBinder> l111l11111lIl = new LinkedBlockingQueue<IBinder>(1);
  
  l111l11111lIl(Context paramContext) {
    this.l1111l111111Il = paramContext;
  }
  
  public final String l1111l111111Il() {
    try {
      this.l1111l111111Il.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
      Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
      intent.setPackage("com.huawei.hwid");
      boolean bool = this.l1111l111111Il.bindService(intent, this.l111l11111I1l, 1);
      if (bool)
        try {
          IBinder iBinder = this.l111l11111lIl.take();
          intent = null;
          Parcel parcel2 = Parcel.obtain();
          Parcel parcel1 = Parcel.obtain();
          try {
            parcel2.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            iBinder.transact(1, parcel2, parcel1, 0);
            parcel1.readException();
            String str2 = parcel1.readString();
            parcel2.recycle();
            String str1 = str2;
          } finally {
            iBinder = null;
          } 
          return (String)intent;
        } catch (Exception exception) {
        
        } finally {
          this.l1111l111111Il.unbindService(this.l111l11111I1l);
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l111l11111lIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */