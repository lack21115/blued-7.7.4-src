package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public abstract class zzbo extends zzb implements zzbn {
  public zzbo() {
    super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaLongClickListener");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      onStreetViewPanoramaLongClick((StreetViewPanoramaOrientation)zzc.zza(paramParcel1, StreetViewPanoramaOrientation.CREATOR));
      paramParcel2.writeNoException();
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */