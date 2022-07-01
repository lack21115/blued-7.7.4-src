package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

public final class l111l11111I1l extends l111l1111lI1l {
  private final Context l1111l111111Il;
  
  private ServiceConnection l111l11111I1l = new ServiceConnection(this) {
      public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        try {
          l111l11111I1l.l1111l111111Il(this.l1111l111111Il).put(param1IBinder);
          return;
        } catch (InterruptedException interruptedException) {
          return;
        } 
      }
      
      public final void onServiceDisconnected(ComponentName param1ComponentName) {}
    };
  
  private final LinkedBlockingQueue<IBinder> l111l11111lIl = new LinkedBlockingQueue<IBinder>(1);
  
  l111l11111I1l(Context paramContext) {
    this.l1111l111111Il = paramContext;
  }
  
  public final String l1111l111111Il() {
    Intent intent = new Intent();
    intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
    if (this.l1111l111111Il.bindService(intent, this.l111l11111I1l, 1)) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder = this.l111l11111lIl.take();
        parcel1.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
        iBinder.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } catch (Exception exception) {
      
      } finally {
        parcel2.recycle();
        parcel1.recycle();
        this.l1111l111111Il.unbindService(this.l111l11111I1l);
      } 
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l111l11111I1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */