package com.mcs.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IMcsSdkService$Stub extends Binder implements IMcsSdkService {
  public IMcsSdkService$Stub() {
    attachInterface(this, "com.mcs.aidl.IMcsSdkService");
  }
  
  public static IMcsSdkService a(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.mcs.aidl.IMcsSdkService");
    return (iInterface != null && iInterface instanceof IMcsSdkService) ? (IMcsSdkService)iInterface : new IMcsSdkService$Stub$Proxy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (paramInt1 != 1) {
      if (paramInt1 != 1598968902)
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
      paramParcel2.writeString("com.mcs.aidl.IMcsSdkService");
      return true;
    } 
    paramParcel1.enforceInterface("com.mcs.aidl.IMcsSdkService");
    if (paramParcel1.readInt() != 0) {
      Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    } 
    a((Bundle)paramParcel1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\mcs\aidl\IMcsSdkService$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */