package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class zzaq extends zza implements zzan {
  public zzaq() {
    super("com.google.android.gms.location.internal.ISettingsCallbacks");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      zza(zzd.<LocationSettingsResult>zza(paramParcel1, LocationSettingsResult.CREATOR));
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */