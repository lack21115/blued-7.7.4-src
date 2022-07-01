package org.chromium.android_webview.services;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

public abstract class IVariationsSeedServer$Stub extends Binder implements IVariationsSeedServer {
  public IVariationsSeedServer$Stub() {
    attachInterface(this, "org.chromium.android_webview.services.IVariationsSeedServer");
  }
  
  public static IVariationsSeedServer asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("org.chromium.android_webview.services.IVariationsSeedServer");
    return (iInterface != null && iInterface instanceof IVariationsSeedServer) ? (IVariationsSeedServer)iInterface : new IVariationsSeedServer$Stub$Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (paramInt1 != 1) {
      if (paramInt1 != 1598968902)
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
      paramParcel2.writeString("org.chromium.android_webview.services.IVariationsSeedServer");
      return true;
    } 
    paramParcel1.enforceInterface("org.chromium.android_webview.services.IVariationsSeedServer");
    if (paramParcel1.readInt() != 0) {
      ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel2 = null;
    } 
    getSeed((ParcelFileDescriptor)paramParcel2, paramParcel1.readLong());
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\IVariationsSeedServer$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */