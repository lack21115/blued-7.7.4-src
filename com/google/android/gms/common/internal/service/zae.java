package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class zae extends zaa {
  private final BaseImplementation.ResultHolder<Status> zaa;
  
  public zae(BaseImplementation.ResultHolder<Status> paramResultHolder) {
    this.zaa = paramResultHolder;
  }
  
  public final void zaa(int paramInt) throws RemoteException {
    this.zaa.setResult(new Status(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\service\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */