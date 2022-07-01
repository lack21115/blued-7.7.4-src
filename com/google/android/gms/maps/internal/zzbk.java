package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public abstract class zzbk extends zzb implements zzbj {
  public zzbk() {
    super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      onStreetViewPanoramaChange((StreetViewPanoramaLocation)zzc.zza(paramParcel1, StreetViewPanoramaLocation.CREATOR));
      paramParcel2.writeNoException();
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */