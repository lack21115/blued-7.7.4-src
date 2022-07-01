package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

final class zacl implements Runnable {
  zacl(zaci paramzaci, Result paramResult) {}
  
  public final void run() {
    Exception exception;
    try {
      BasePendingResult.zaa.set(Boolean.valueOf(true));
      PendingResult pendingResult = ((ResultTransform)Preconditions.checkNotNull(zaci.zaa(this.zab))).onSuccess(this.zaa);
      zaci.zab(this.zab).sendMessage(zaci.zab(this.zab).obtainMessage(0, pendingResult));
      BasePendingResult.zaa.set(Boolean.valueOf(false));
      zaci.zaa(this.zab, this.zaa);
      GoogleApiClient googleApiClient1 = zaci.zac(this.zab).get();
      if (googleApiClient1 != null)
        googleApiClient1.zab(this.zab); 
      return;
    } catch (RuntimeException runtimeException) {
      zaci.zab(this.zab).sendMessage(zaci.zab(this.zab).obtainMessage(1, runtimeException));
      BasePendingResult.zaa.set(Boolean.valueOf(false));
      zaci.zaa(this.zab, this.zaa);
      GoogleApiClient googleApiClient1 = zaci.zac(this.zab).get();
      if (googleApiClient1 != null)
        googleApiClient1.zab(this.zab); 
      return;
    } finally {}
    BasePendingResult.zaa.set(Boolean.valueOf(false));
    zaci.zaa(this.zab, this.zaa);
    GoogleApiClient googleApiClient = zaci.zac(this.zab).get();
    if (googleApiClient != null)
      googleApiClient.zab(this.zab); 
    throw exception;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zacl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */