package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzp;

public final class zzj {
  final ArrayMap zzfse = new ArrayMap();
  
  private final ArrayMap zzfuk = new ArrayMap();
  
  final TaskCompletionSource zzful = new TaskCompletionSource();
  
  private int zzfum;
  
  private boolean zzfun = false;
  
  public zzj(Iterable paramIterable) {
    for (GoogleApi googleApi : paramIterable)
      this.zzfse.put(googleApi.zzfsn, null); 
    this.zzfum = this.zzfse.keySet().size();
  }
  
  public final void zza(zzh paramzzh, ConnectionResult paramConnectionResult, String paramString) {
    this.zzfse.put(paramzzh, paramConnectionResult);
    this.zzfuk.put(paramzzh, paramString);
    this.zzfum--;
    if (!paramConnectionResult.isSuccess())
      this.zzfun = true; 
    if (this.zzfum == 0) {
      if (this.zzfun) {
        null = new AvailabilityException(this.zzfse);
        zzp zzp = this.zzful.zzlel;
        zzbq.checkNotNull(null, "Exception must not be null");
        synchronized (zzp.mLock) {
          zzp.zzble();
          zzp.zzleo = true;
          zzp.zzleq = (Exception)null;
          zzp.zzlen.zzb((Task)zzp);
          return;
        } 
      } 
      null = this.zzful.zzlel;
      synchronized (null.mLock) {
        null.zzble();
        null.zzleo = true;
        null.zzlen.zzb((Task)null);
        return;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */