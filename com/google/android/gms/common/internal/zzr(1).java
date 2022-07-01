package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class zzr extends zzb implements zzq {
  zzr(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
  }
  
  public final boolean zza(zzj paramzzj, IObjectWrapper paramIObjectWrapper) throws RemoteException {
    Parcel parcel2 = a_();
    zzd.zza(parcel2, (Parcelable)paramzzj);
    zzd.zza(parcel2, (IInterface)paramIObjectWrapper);
    Parcel parcel1 = zza(5, parcel2);
    boolean bool = zzd.zza(parcel1);
    parcel1.recycle();
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */