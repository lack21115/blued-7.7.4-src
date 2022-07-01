package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

public final class zzai extends zza implements zzah {
  zzai(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.internal.IOnLocationChangeListener");
  }
  
  public final void zza(Location paramLocation) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramLocation);
    zzb(2, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */