package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

public final class l1111l111111Il extends l111l1111lI1l {
  private Context l1111l111111Il;
  
  private ServiceConnection l111l11111I1l = new ServiceConnection(this) {
      public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        try {
          l1111l111111Il.l1111l111111Il(this.l1111l111111Il).put(param1IBinder);
          return;
        } catch (Exception exception) {
          return;
        } 
      }
      
      public final void onServiceDisconnected(ComponentName param1ComponentName) {}
    };
  
  private final LinkedBlockingQueue<IBinder> l111l11111lIl = new LinkedBlockingQueue<IBinder>(1);
  
  l1111l111111Il(Context paramContext) {
    this.l1111l111111Il = paramContext;
  }
  
  public final String l1111l111111Il() {
    Intent intent = new Intent();
    intent.setAction("com.asus.msa.action.ACCESS_DID");
    intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
    boolean bool = this.l1111l111111Il.bindService(intent, this.l111l11111I1l, 1);
    String str1 = "";
    String str2 = str1;
    if (bool) {
      str2 = str1;
      try {
        IBinder iBinder = this.l111l11111lIl.take();
        str2 = str1;
        Parcel parcel1 = Parcel.obtain();
        str2 = str1;
        Parcel parcel2 = Parcel.obtain();
        str2 = str1;
        try {
          parcel1.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
          str2 = str1;
          iBinder.transact(3, parcel1, parcel2, 0);
          str2 = str1;
          parcel2.readException();
          str2 = str1;
          str1 = parcel2.readString();
          str2 = str1;
        } finally {
          str1 = null;
        } 
        str2 = str1;
        parcel1.recycle();
        str2 = str1;
        parcel2.recycle();
        return str1;
      } catch (Exception exception) {
        return str2;
      } 
    } 
    return str2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */