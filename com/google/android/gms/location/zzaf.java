package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.internal.location.zzac;
import com.google.android.gms.internal.location.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzaf extends zzah {
  zzaf(FusedLocationProviderClient paramFusedLocationProviderClient, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void a_() {}
  
  public final void zza(zzac paramzzac) throws RemoteException {
    Status status = paramzzac.getStatus();
    if (status == null) {
      this.zza.trySetException((Exception)new ApiException(new Status(8, "Got null status from location service")));
      return;
    } 
    if (status.getStatusCode() == 0) {
      this.zza.setResult(Boolean.valueOf(true));
      return;
    } 
    this.zza.trySetException((Exception)ApiExceptionUtil.fromStatus(status));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */