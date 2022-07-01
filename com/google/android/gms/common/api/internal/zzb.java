package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzb extends zza {
  protected final TaskCompletionSource zzejm;
  
  public zzb(TaskCompletionSource paramTaskCompletionSource) {
    this.zzejm = paramTaskCompletionSource;
  }
  
  public void zza(zzae paramzzae, boolean paramBoolean) {}
  
  public final void zza(zzbo paramzzbo) {
    try {
      zzb(paramzzbo);
      return;
    } catch (DeadObjectException deadObjectException) {
      super.zzs(zza.zzb((RemoteException)deadObjectException));
      throw deadObjectException;
    } catch (RemoteException remoteException) {
      super.zzs(zza.zzb(remoteException));
      return;
    } catch (RuntimeException runtimeException) {
      zza(runtimeException);
      return;
    } 
  }
  
  public void zza(RuntimeException paramRuntimeException) {
    this.zzejm.trySetException(paramRuntimeException);
  }
  
  protected abstract void zzb(zzbo paramzzbo);
  
  public void zzs(Status paramStatus) {
    this.zzejm.trySetException((Exception)new ApiException(paramStatus));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */