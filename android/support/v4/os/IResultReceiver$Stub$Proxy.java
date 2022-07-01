package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class IResultReceiver$Stub$Proxy implements IResultReceiver {
  private IBinder mRemote;
  
  IResultReceiver$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.mRemote;
  }
  
  public final void send(int paramInt, Bundle paramBundle) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
      parcel.writeInt(paramInt);
      if (paramBundle != null) {
        parcel.writeInt(1);
        paramBundle.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(1, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\os\IResultReceiver$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */