package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzan;

public final class zzcys extends zzev implements zzcyr {
  zzcys(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.signin.internal.ISignInService");
  }
  
  public final void zza(zzan paramzzan, int paramInt, boolean paramBoolean) {
    Parcel parcel = zzbc();
    zzex.zza(parcel, (IInterface)paramzzan);
    parcel.writeInt(paramInt);
    zzex.zza(parcel, paramBoolean);
    zzb(9, parcel);
  }
  
  public final void zza(zzcyu paramzzcyu, zzcyp paramzzcyp) {
    Parcel parcel = zzbc();
    zzex.zza(parcel, paramzzcyu);
    zzex.zza(parcel, paramzzcyp);
    zzb(12, parcel);
  }
  
  public final void zzev(int paramInt) {
    Parcel parcel = zzbc();
    parcel.writeInt(paramInt);
    zzb(7, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */