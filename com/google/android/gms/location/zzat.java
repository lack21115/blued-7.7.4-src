package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;
import com.google.android.gms.internal.location.zzd;

public abstract class zzat extends zza implements zzaq {
  public zzat() {
    super("com.google.android.gms.location.ILocationListener");
  }
  
  public static zzaq zza(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
    return (iInterface instanceof zzaq) ? (zzaq)iInterface : new zzas(paramIBinder);
  }
  
  public final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      zza((Location)zzd.zza(paramParcel1, Location.CREATOR));
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */