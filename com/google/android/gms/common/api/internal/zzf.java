package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzf extends zzb {
  private zzck zzfuc;
  
  public zzf(zzck paramzzck, TaskCompletionSource paramTaskCompletionSource) {
    super(paramTaskCompletionSource);
    this.zzfuc = paramzzck;
  }
  
  public final void zzb(zzbo paramzzbo) {
    zzcr zzcr = (zzcr)paramzzbo.zzfzv.remove(this.zzfuc);
    if (zzcr != null) {
      zzcr.zzfty.zzgbb.zzgat = null;
      return;
    } 
    this.zzejm.zzlel.trySetResult$5d527815();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */