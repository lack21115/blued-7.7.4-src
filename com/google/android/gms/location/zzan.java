package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;

public class zzan extends zza implements zzak {
  public static zzak zza(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
    return (iInterface instanceof zzak) ? (zzak)iInterface : new zzam(paramIBinder);
  }
  
  public final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    throw new NoSuchMethodError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */