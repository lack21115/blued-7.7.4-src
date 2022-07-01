package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zzew extends Binder implements IInterface {
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (paramInt1 > 16777215)
      return onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
    paramParcel1.enforceInterface(getInterfaceDescriptor());
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */