package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzb implements IInterface {
  private final IBinder zza;
  
  private final String zzb;
  
  public zzb(IBinder paramIBinder, String paramString) {
    this.zza = paramIBinder;
    this.zzb = paramString;
  }
  
  public IBinder asBinder() {
    return this.zza;
  }
  
  public final Parcel b_() {
    Parcel parcel = Parcel.obtain();
    parcel.writeInterfaceToken(this.zzb);
    return parcel;
  }
  
  protected final Parcel zza(int paramInt, Parcel paramParcel) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    try {
      this.zza.transact(paramInt, paramParcel, parcel, 0);
      parcel.readException();
      paramParcel.recycle();
      return parcel;
    } catch (RuntimeException runtimeException) {
      parcel.recycle();
      throw runtimeException;
    } finally {}
    paramParcel.recycle();
    throw parcel;
  }
  
  protected final void zzb(int paramInt, Parcel paramParcel) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    try {
      this.zza.transact(paramInt, paramParcel, parcel, 0);
      parcel.readException();
      return;
    } finally {
      paramParcel.recycle();
      parcel.recycle();
    } 
  }
  
  public final void zzc(int paramInt, Parcel paramParcel) throws RemoteException {
    try {
      this.zza.transact(paramInt, paramParcel, null, 1);
      return;
    } finally {
      paramParcel.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */