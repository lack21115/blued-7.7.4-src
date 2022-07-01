package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

public abstract class zzbq extends zzb implements zzbp {
  public zzbq() {
    super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate;
      IBinder iBinder = paramParcel1.readStrongBinder();
      if (iBinder == null) {
        iBinder = null;
      } else {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (iInterface instanceof IStreetViewPanoramaDelegate) {
          iStreetViewPanoramaDelegate = (IStreetViewPanoramaDelegate)iInterface;
        } else {
          iStreetViewPanoramaDelegate = new zzbu((IBinder)iStreetViewPanoramaDelegate);
        } 
      } 
      zza(iStreetViewPanoramaDelegate);
      paramParcel2.writeNoException();
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */