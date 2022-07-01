package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzd;

public final class zzar extends zzb implements zzap {
  zzar(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.location.ILocationCallback");
  }
  
  public final void zza(LocationAvailability paramLocationAvailability) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramLocationAvailability);
    zzc(2, parcel);
  }
  
  public final void zza(LocationResult paramLocationResult) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramLocationResult);
    zzc(1, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */