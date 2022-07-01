package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzaw extends zzb implements zzav {
  public zzaw() {
    super("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      boolean bool = onMyLocationButtonClick();
      paramParcel2.writeNoException();
      zzc.writeBoolean(paramParcel2, bool);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */