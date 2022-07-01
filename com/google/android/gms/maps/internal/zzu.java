package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

public abstract class zzu extends zzb implements zzt {
  public zzu() {
    super("com.google.android.gms.maps.internal.IOnCameraMoveStartedListener");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      onCameraMoveStarted(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */