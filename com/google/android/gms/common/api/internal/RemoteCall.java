package com.google.android.gms.common.api.internal;

import android.os.RemoteException;

public interface RemoteCall<T, U> {
  void accept(T paramT, U paramU) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\RemoteCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */