package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;

public abstract class zzv extends zzew implements zzu {
  public static zzu zzbe(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
    return (iInterface instanceof zzu) ? (zzu)iInterface : new zzw(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (zza(paramInt1, paramParcel1, paramParcel2, paramInt2))
      return true; 
    switch (paramInt1) {
      default:
        return false;
      case 2:
        onLocationAvailability((LocationAvailability)zzex.zza(paramParcel1, LocationAvailability.CREATOR));
        return true;
      case 1:
        break;
    } 
    onLocationResult((LocationResult)zzex.zza(paramParcel1, LocationResult.CREATOR));
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\location\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */