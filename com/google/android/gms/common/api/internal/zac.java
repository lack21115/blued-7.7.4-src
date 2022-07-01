package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zac<T> extends zad {
  protected final TaskCompletionSource<T> zab;
  
  public zac(int paramInt, TaskCompletionSource<T> paramTaskCompletionSource) {
    super(paramInt);
    this.zab = paramTaskCompletionSource;
  }
  
  public void zaa(Status paramStatus) {
    this.zab.trySetException((Exception)new ApiException(paramStatus));
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa) throws DeadObjectException {
    try {
      zab(paramzaa);
      return;
    } catch (DeadObjectException deadObjectException) {
      super.zaa(zab.zaa((RemoteException)deadObjectException));
      throw deadObjectException;
    } catch (RemoteException remoteException) {
      super.zaa(zab.zaa(remoteException));
      return;
    } catch (RuntimeException runtimeException) {
      super.zaa(runtimeException);
      return;
    } 
  }
  
  public void zaa(zav paramzav, boolean paramBoolean) {}
  
  public void zaa(Exception paramException) {
    this.zab.trySetException(paramException);
  }
  
  protected abstract void zab(GoogleApiManager.zaa<?> paramzaa) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */