package org.chromium.android_webview.services;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

final class ICrashReceiverService$Stub$Proxy implements ICrashReceiverService {
  private IBinder mRemote;
  
  ICrashReceiverService$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.mRemote;
  }
  
  public final void transmitCrashes(ParcelFileDescriptor[] paramArrayOfParcelFileDescriptor) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("org.chromium.android_webview.services.ICrashReceiverService");
      parcel1.writeTypedArray((Parcelable[])paramArrayOfParcelFileDescriptor, 0);
      this.mRemote.transact(1, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\ICrashReceiverService$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */