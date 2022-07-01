package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class zab {
  public final int zaa;
  
  public zab(int paramInt) {
    this.zaa = paramInt;
  }
  
  private static Status zab(RemoteException paramRemoteException) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramRemoteException.getClass().getSimpleName());
    stringBuilder.append(": ");
    stringBuilder.append(paramRemoteException.getLocalizedMessage());
    return new Status(19, stringBuilder.toString());
  }
  
  public abstract void zaa(Status paramStatus);
  
  public abstract void zaa(GoogleApiManager.zaa<?> paramzaa) throws DeadObjectException;
  
  public abstract void zaa(zav paramzav, boolean paramBoolean);
  
  public abstract void zaa(Exception paramException);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */