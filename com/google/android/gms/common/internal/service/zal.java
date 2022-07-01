package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zaa;

public abstract class zal extends zaa implements zai {
  public zal() {
    super("com.google.android.gms.common.internal.service.ICommonCallbacks");
  }
  
  public final boolean zaa(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      zaa(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\service\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */