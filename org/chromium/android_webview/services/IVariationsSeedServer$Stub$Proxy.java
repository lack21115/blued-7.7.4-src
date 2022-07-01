package org.chromium.android_webview.services;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

final class IVariationsSeedServer$Stub$Proxy implements IVariationsSeedServer {
  private IBinder mRemote;
  
  IVariationsSeedServer$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.mRemote;
  }
  
  public final void getSeed(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("org.chromium.android_webview.services.IVariationsSeedServer");
      if (paramParcelFileDescriptor != null) {
        parcel.writeInt(1);
        paramParcelFileDescriptor.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      parcel.writeLong(paramLong);
      this.mRemote.transact(1, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\IVariationsSeedServer$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */