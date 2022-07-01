package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;
import com.google.android.gms.internal.location.zzd;

public abstract class zzao extends zza implements zzap {
  public zzao() {
    super("com.google.android.gms.location.ILocationCallback");
  }
  
  public static zzap zza(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
    return (iInterface instanceof zzap) ? (zzap)iInterface : new zzar(paramIBinder);
  }
  
  public final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
        return false; 
      zza((LocationAvailability)zzd.zza(paramParcel1, LocationAvailability.CREATOR));
      return true;
    } 
    zza((LocationResult)zzd.zza(paramParcel1, LocationResult.CREATOR));
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */