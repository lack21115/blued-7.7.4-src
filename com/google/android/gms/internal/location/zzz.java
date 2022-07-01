package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class zzz extends zzah {
  private final BaseImplementation.ResultHolder<Status> zza;
  
  public zzz(BaseImplementation.ResultHolder<Status> paramResultHolder) {
    this.zza = paramResultHolder;
  }
  
  public final void a_() {}
  
  public final void zza(zzac paramzzac) {
    this.zza.setResult(paramzzac.getStatus());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */