package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;

public final class zzm extends zzb implements zzl {
  zzm(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.ICertData");
  }
  
  public final IObjectWrapper zzb() throws RemoteException {
    Parcel parcel = zza(1, a_());
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
    parcel.recycle();
    return iObjectWrapper;
  }
  
  public final int zzc() throws RemoteException {
    Parcel parcel = zza(2, a_());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */