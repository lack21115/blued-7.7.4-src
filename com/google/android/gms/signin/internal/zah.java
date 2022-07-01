package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

public final class zah extends zab implements zae {
  zah(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.signin.internal.ISignInService");
  }
  
  public final void zaa(int paramInt) throws RemoteException {
    Parcel parcel = zaa();
    parcel.writeInt(paramInt);
    zab(7, parcel);
  }
  
  public final void zaa(IAccountAccessor paramIAccountAccessor, int paramInt, boolean paramBoolean) throws RemoteException {
    Parcel parcel = zaa();
    zad.zaa(parcel, (IInterface)paramIAccountAccessor);
    parcel.writeInt(paramInt);
    zad.zaa(parcel, paramBoolean);
    zab(9, parcel);
  }
  
  public final void zaa(zak paramzak, zac paramzac) throws RemoteException {
    Parcel parcel = zaa();
    zad.zaa(parcel, (Parcelable)paramzak);
    zad.zaa(parcel, paramzac);
    zab(12, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\internal\zah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */