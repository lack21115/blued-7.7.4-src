package org.chromium.base.process_launcher;

import android.os.IBinder;
import android.os.Parcel;

final class ICallbackInt$Stub$Proxy implements ICallbackInt {
  private IBinder mRemote;
  
  ICallbackInt$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.mRemote;
  }
  
  public final void call(int paramInt) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("org.chromium.base.process_launcher.ICallbackInt");
      parcel.writeInt(paramInt);
      this.mRemote.transact(1, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ICallbackInt$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */