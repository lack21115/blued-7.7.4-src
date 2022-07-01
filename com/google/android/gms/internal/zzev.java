package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zzev implements IInterface {
  private final IBinder zzala;
  
  private final String zzalb;
  
  public zzev(IBinder paramIBinder, String paramString) {
    this.zzala = paramIBinder;
    this.zzalb = paramString;
  }
  
  public IBinder asBinder() {
    return this.zzala;
  }
  
  public final Parcel zza(int paramInt, Parcel paramParcel) {
    Parcel parcel = Parcel.obtain();
    try {
      this.zzala.transact(paramInt, paramParcel, parcel, 0);
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
  
  public final void zzb(int paramInt, Parcel paramParcel) {
    Parcel parcel = Parcel.obtain();
    try {
      this.zzala.transact(paramInt, paramParcel, parcel, 0);
      parcel.readException();
      return;
    } finally {
      paramParcel.recycle();
      parcel.recycle();
    } 
  }
  
  public final Parcel zzbc() {
    Parcel parcel = Parcel.obtain();
    parcel.writeInterfaceToken(this.zzalb);
    return parcel;
  }
  
  public final void zzc(int paramInt, Parcel paramParcel) {
    try {
      this.zzala.transact(paramInt, paramParcel, null, 1);
      return;
    } finally {
      paramParcel.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */