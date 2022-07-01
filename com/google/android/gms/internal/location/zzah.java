package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzah extends zza implements zzai {
  public zzah() {
    super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
        return false; 
      a_();
      return true;
    } 
    zza(zzd.<zzac>zza(paramParcel1, zzac.CREATOR));
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */