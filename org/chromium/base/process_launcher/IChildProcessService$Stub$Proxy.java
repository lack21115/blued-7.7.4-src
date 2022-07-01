package org.chromium.base.process_launcher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

final class IChildProcessService$Stub$Proxy implements IChildProcessService {
  private IBinder mRemote;
  
  IChildProcessService$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.mRemote;
  }
  
  public final boolean bindToCaller() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("org.chromium.base.process_launcher.IChildProcessService");
      IBinder iBinder = this.mRemote;
      boolean bool = false;
      iBinder.transact(1, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      if (i != 0)
        bool = true; 
      return bool;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void forceKill() {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("org.chromium.base.process_launcher.IChildProcessService");
      this.mRemote.transact(3, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onMemoryPressure(int paramInt) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("org.chromium.base.process_launcher.IChildProcessService");
      parcel.writeInt(paramInt);
      this.mRemote.transact(4, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void setupConnection(Bundle paramBundle, ICallbackInt paramICallbackInt, List paramList) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("org.chromium.base.process_launcher.IChildProcessService");
      if (paramBundle != null) {
        parcel.writeInt(1);
        paramBundle.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      if (paramICallbackInt != null) {
        IBinder iBinder = paramICallbackInt.asBinder();
      } else {
        paramBundle = null;
      } 
      parcel.writeStrongBinder((IBinder)paramBundle);
      parcel.writeBinderList(paramList);
      this.mRemote.transact(2, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\IChildProcessService$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */