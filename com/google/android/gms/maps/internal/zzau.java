package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzu;

public abstract class zzau extends zzb implements zzat {
  public zzau() {
    super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        if (paramInt1 != 3)
          return false; 
        zzc(zzu.zzg(paramParcel1.readStrongBinder()));
      } else {
        zzd(zzu.zzg(paramParcel1.readStrongBinder()));
      } 
    } else {
      zzb(zzu.zzg(paramParcel1.readStrongBinder()));
    } 
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */