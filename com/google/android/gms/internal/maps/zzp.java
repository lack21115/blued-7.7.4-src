package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class zzp extends zza implements zzn {
  zzp(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
  }
  
  public final int getActiveLevelIndex() throws RemoteException {
    Parcel parcel = zza(1, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final int getDefaultLevelIndex() throws RemoteException {
    Parcel parcel = zza(2, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final List<IBinder> getLevels() throws RemoteException {
    Parcel parcel = zza(3, zza());
    ArrayList<IBinder> arrayList = parcel.createBinderArrayList();
    parcel.recycle();
    return arrayList;
  }
  
  public final boolean isUnderground() throws RemoteException {
    Parcel parcel = zza(4, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean zzb(zzn paramzzn) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zza(parcel2, paramzzn);
    Parcel parcel1 = zza(5, parcel2);
    boolean bool = zzc.zza(parcel1);
    parcel1.recycle();
    return bool;
  }
  
  public final int zzj() throws RemoteException {
    Parcel parcel = zza(6, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */