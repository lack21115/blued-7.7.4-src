package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

public final class zam extends zab implements zak {
  zam(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.service.ICommonService");
  }
  
  public final void zaa(zai paramzai) throws RemoteException {
    Parcel parcel = zaa();
    zad.zaa(parcel, paramzai);
    zac(1, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\service\zam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */