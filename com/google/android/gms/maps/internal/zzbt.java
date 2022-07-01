package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzbt extends zzb implements zzbs {
  public zzbt() {
    super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
        return false; 
      zzb(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
    } else {
      onSnapshotReady((Bitmap)zzc.zza(paramParcel1, Bitmap.CREATOR));
    } 
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */