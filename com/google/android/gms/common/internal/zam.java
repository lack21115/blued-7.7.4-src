package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

public final class zam extends zab implements zak {
  zam(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
  }
  
  public final IObjectWrapper zaa(IObjectWrapper paramIObjectWrapper, zaw paramzaw) throws RemoteException {
    Parcel parcel2 = zaa();
    zad.zaa(parcel2, (IInterface)paramIObjectWrapper);
    zad.zaa(parcel2, (Parcelable)paramzaw);
    Parcel parcel1 = zaa(2, parcel2);
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return iObjectWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */