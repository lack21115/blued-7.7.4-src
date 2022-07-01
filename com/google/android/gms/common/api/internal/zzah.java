package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;

public final class zzah extends zzo {
  private zzbm zzfsq;
  
  private ArraySet zzfxa;
  
  private final void zzajg() {
    if (!this.zzfxa.isEmpty()) {
      null = this.zzfsq;
      synchronized (zzbm.sLock) {
        if (null.zzfzn != this) {
          null.zzfzn = this;
          null.zzfzo.clear();
          null.zzfzo.addAll((Collection)this.zzfxa);
        } 
        return;
      } 
    } 
  }
  
  public final void onResume() {
    super.onResume();
    zzajg();
  }
  
  public final void onStart() {
    super.onStart();
    zzajg();
  }
  
  public final void onStop() {
    super.onStop();
    null = this.zzfsq;
    synchronized (zzbm.sLock) {
      if (null.zzfzn == this) {
        null.zzfzn = null;
        null.zzfzo.clear();
      } 
      return;
    } 
  }
  
  protected final void zza(ConnectionResult paramConnectionResult, int paramInt) {
    this.zzfsq.zza(paramConnectionResult, paramInt);
  }
  
  protected final void zzaih() {
    this.zzfsq.zzaih();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */