package org.chromium.android_webview.services;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

public abstract class ICrashReceiverService$Stub extends Binder implements ICrashReceiverService {
  public ICrashReceiverService$Stub() {
    attachInterface(this, "org.chromium.android_webview.services.ICrashReceiverService");
  }
  
  public static ICrashReceiverService asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("org.chromium.android_webview.services.ICrashReceiverService");
    return (iInterface != null && iInterface instanceof ICrashReceiverService) ? (ICrashReceiverService)iInterface : new ICrashReceiverService$Stub$Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (paramInt1 != 1) {
      if (paramInt1 != 1598968902)
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
      paramParcel2.writeString("org.chromium.android_webview.services.ICrashReceiverService");
      return true;
    } 
    paramParcel1.enforceInterface("org.chromium.android_webview.services.ICrashReceiverService");
    transmitCrashes((ParcelFileDescriptor[])paramParcel1.createTypedArray(ParcelFileDescriptor.CREATOR));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\ICrashReceiverService$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */