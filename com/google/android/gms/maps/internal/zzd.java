package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

public abstract class zzd extends zzb implements zzc {
  public zzd() {
    super("com.google.android.gms.maps.internal.ICancelableCallback");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
        return false; 
      onCancel();
    } else {
      onFinish();
    } 
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */