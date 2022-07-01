package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public abstract class zzbm extends zzb implements zzbl {
  public zzbm() {
    super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      onStreetViewPanoramaClick((StreetViewPanoramaOrientation)zzc.zza(paramParcel1, StreetViewPanoramaOrientation.CREATOR));
      paramParcel2.writeNoException();
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */