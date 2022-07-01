package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.internal.maps.zzb;

public abstract class zzbg extends zzb implements zzbf {
  public zzbg() {
    super("com.google.android.gms.maps.internal.IOnPolylineClickListener");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      zza(zzaa.zzi(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */