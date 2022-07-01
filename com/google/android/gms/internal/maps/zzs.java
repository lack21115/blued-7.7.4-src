package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzs extends zza implements zzq {
  zzs(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
  }
  
  public final void activate() throws RemoteException {
    zzb(3, zza());
  }
  
  public final String getName() throws RemoteException {
    Parcel parcel = zza(1, zza());
    String str = parcel.readString();
    parcel.recycle();
    return str;
  }
  
  public final String getShortName() throws RemoteException {
    Parcel parcel = zza(2, zza());
    String str = parcel.readString();
    parcel.recycle();
    return str;
  }
  
  public final boolean zzb(zzq paramzzq) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zza(parcel2, paramzzq);
    Parcel parcel1 = zza(4, parcel2);
    boolean bool = zzc.zza(parcel1);
    parcel1.recycle();
    return bool;
  }
  
  public final int zzj() throws RemoteException {
    Parcel parcel = zza(5, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */