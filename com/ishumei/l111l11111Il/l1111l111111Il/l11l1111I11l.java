package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

public final class l11l1111I11l extends l111l1111lI1l {
  public final LinkedBlockingQueue<IBinder> l1111l111111Il = new LinkedBlockingQueue<IBinder>(1);
  
  private ServiceConnection l111l11111I1l = new ServiceConnection(this) {
      public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        try {
          this.l1111l111111Il.l1111l111111Il.put(param1IBinder);
          return;
        } catch (InterruptedException interruptedException) {
          return;
        } 
      }
      
      public final void onServiceDisconnected(ComponentName param1ComponentName) {}
    };
  
  private Context l111l11111lIl;
  
  l11l1111I11l(Context paramContext) {
    this.l111l11111lIl = paramContext;
  }
  
  public final String l1111l111111Il() {
    Intent intent = new Intent();
    intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
    boolean bool = this.l111l11111lIl.bindService(intent, this.l111l11111I1l, 1);
    String str2 = "";
    if (!bool)
      return ""; 
    String str1 = str2;
    try {
      Context context;
      IBinder iBinder = this.l1111l111111Il.take();
      str1 = str2;
      Parcel parcel1 = Parcel.obtain();
      str1 = str2;
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
        iBinder.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        String str = parcel2.readString();
        str1 = str;
        parcel2.recycle();
        str1 = str;
        parcel1.recycle();
        str1 = str;
        Context context1 = this.l111l11111lIl;
        str2 = str;
        context = context1;
      } finally {}
      str1 = str2;
      context.unbindService(this.l111l11111I1l);
      return str2;
    } catch (InterruptedException interruptedException) {
      return str1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l11l1111I11l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */