package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class zzo extends zzb implements IGmsCallbacks {
  zzo(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  public final void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle) throws RemoteException {
    Parcel parcel = a_();
    parcel.writeInt(paramInt);
    parcel.writeStrongBinder(paramIBinder);
    zzd.zza(parcel, (Parcelable)paramBundle);
    zzb(1, parcel);
  }
  
  public final void zza(int paramInt, Bundle paramBundle) throws RemoteException {
    Parcel parcel = a_();
    parcel.writeInt(paramInt);
    zzd.zza(parcel, (Parcelable)paramBundle);
    zzb(2, parcel);
  }
  
  public final void zza(int paramInt, IBinder paramIBinder, zzc paramzzc) throws RemoteException {
    Parcel parcel = a_();
    parcel.writeInt(paramInt);
    parcel.writeStrongBinder(paramIBinder);
    zzd.zza(parcel, (Parcelable)paramzzc);
    zzb(3, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */