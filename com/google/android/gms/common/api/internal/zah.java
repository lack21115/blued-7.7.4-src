package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zah<ResultT> extends zad {
  private final TaskApiCall<Api.AnyClient, ResultT> zab;
  
  private final TaskCompletionSource<ResultT> zac;
  
  private final StatusExceptionMapper zad;
  
  public zah(int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper) {
    super(paramInt);
    this.zac = paramTaskCompletionSource;
    this.zab = paramTaskApiCall;
    this.zad = paramStatusExceptionMapper;
    if (paramInt == 2) {
      if (!paramTaskApiCall.shouldAutoResolveMissingFeatures())
        return; 
      throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
    } 
  }
  
  public final void zaa(Status paramStatus) {
    this.zac.trySetException(this.zad.getException(paramStatus));
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa) throws DeadObjectException {
    try {
      this.zab.doExecute(paramzaa.zab(), this.zac);
      return;
    } catch (DeadObjectException deadObjectException) {
      throw deadObjectException;
    } catch (RemoteException remoteException) {
      super.zaa(zab.zaa(remoteException));
      return;
    } catch (RuntimeException runtimeException) {
      super.zaa(runtimeException);
      return;
    } 
  }
  
  public final void zaa(zav paramzav, boolean paramBoolean) {
    paramzav.zaa(this.zac, paramBoolean);
  }
  
  public final void zaa(Exception paramException) {
    this.zac.trySetException(paramException);
  }
  
  public final Feature[] zac(GoogleApiManager.zaa<?> paramzaa) {
    return this.zab.zaa();
  }
  
  public final boolean zad(GoogleApiManager.zaa<?> paramzaa) {
    return this.zab.shouldAutoResolveMissingFeatures();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */