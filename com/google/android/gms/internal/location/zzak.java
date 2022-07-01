package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzak extends zzb implements zzai {
  zzak(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
  }
  
  public final void a_() throws RemoteException {
    zzc(2, b_());
  }
  
  public final void zza(zzac paramzzac) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramzzac);
    zzc(1, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */