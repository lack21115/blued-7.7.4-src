package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

public final class zzcgt extends zzev implements zzcgr {
  zzcgt(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
  }
  
  public final void zza(zzcgl paramzzcgl) {
    Parcel parcel = zzbc();
    zzex.zza(parcel, paramzzcgl);
    zzc(1, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */