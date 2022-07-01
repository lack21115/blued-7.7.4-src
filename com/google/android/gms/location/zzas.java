package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzd;

public final class zzas extends zzb implements zzaq {
  zzas(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.location.ILocationListener");
  }
  
  public final void zza(Location paramLocation) throws RemoteException {
    Parcel parcel = b_();
    zzd.zza(parcel, (Parcelable)paramLocation);
    zzc(1, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */