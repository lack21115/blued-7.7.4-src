package com.google.android.gms.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;

public final class zzcgx extends zzev implements zzcgw {
  zzcgx(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
  }
  
  public final void zza(zzcfw paramzzcfw) {
    Parcel parcel = zzbc();
    zzex.zza(parcel, paramzzcfw);
    zzb(75, parcel);
  }
  
  public final void zza(zzchn paramzzchn) {
    Parcel parcel = zzbc();
    zzex.zza(parcel, paramzzchn);
    zzb(59, parcel);
  }
  
  public final void zzbo(boolean paramBoolean) {
    Parcel parcel = zzbc();
    zzex.zza(parcel, paramBoolean);
    zzb(12, parcel);
  }
  
  public final Location zzim(String paramString) {
    Parcel parcel2 = zzbc();
    parcel2.writeString(paramString);
    Parcel parcel1 = zza(21, parcel2);
    Location location = (Location)zzex.zza(parcel1, Location.CREATOR);
    parcel1.recycle();
    return location;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */