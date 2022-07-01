package com.mcs.aidl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class IMcsSdkService$Stub$Proxy implements IMcsSdkService {
  private IBinder a;
  
  IMcsSdkService$Stub$Proxy(IBinder paramIBinder) {
    this.a = paramIBinder;
  }
  
  public void a(Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("com.mcs.aidl.IMcsSdkService");
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.a.transact(1, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public IBinder asBinder() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\mcs\aidl\IMcsSdkService$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */