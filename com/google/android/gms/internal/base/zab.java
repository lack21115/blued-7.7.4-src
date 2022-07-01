package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zab implements IInterface {
  private final IBinder zaa;
  
  private final String zab;
  
  public zab(IBinder paramIBinder, String paramString) {
    this.zaa = paramIBinder;
    this.zab = paramString;
  }
  
  public IBinder asBinder() {
    return this.zaa;
  }
  
  public final Parcel zaa() {
    Parcel parcel = Parcel.obtain();
    parcel.writeInterfaceToken(this.zab);
    return parcel;
  }
  
  public final Parcel zaa(int paramInt, Parcel paramParcel) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    try {
      this.zaa.transact(2, paramParcel, parcel, 0);
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
  
  public final void zab(int paramInt, Parcel paramParcel) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    try {
      this.zaa.transact(paramInt, paramParcel, parcel, 0);
      parcel.readException();
      return;
    } finally {
      paramParcel.recycle();
      parcel.recycle();
    } 
  }
  
  public final void zac(int paramInt, Parcel paramParcel) throws RemoteException {
    try {
      this.zaa.transact(1, paramParcel, null, 1);
      return;
    } finally {
      paramParcel.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\base\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */