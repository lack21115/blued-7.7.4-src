package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.Iterator;

public final class zzaz implements zzbh {
  private final zzbi zzfxd;
  
  public zzaz(zzbi paramzzbi) {
    this.zzfxd = paramzzbi;
  }
  
  public final void begin() {
    Iterator<Api.zze> iterator = this.zzfxd.zzfyj.values().iterator();
    while (iterator.hasNext())
      ((Api.zze)iterator.next()).disconnect(); 
    this.zzfxd.zzfvq.zzfyk = Collections.emptySet();
  }
  
  public final void connect() {
    zzbi zzbi1 = this.zzfxd;
    zzbi1.zzfwa.lock();
    try {
      zzbi1.zzfyz = new zzao(zzbi1, zzbi1.zzfwf, zzbi1.zzfwi, zzbi1.zzfth, zzbi1.zzfwa, zzbi1.mContext);
      zzbi1.zzfyz.begin();
      zzbi1.zzfyw.signalAll();
      return;
    } finally {
      zzbi1.zzfwa.unlock();
    } 
  }
  
  public final boolean disconnect() {
    return true;
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt) {}
  
  public final void zza(ConnectionResult paramConnectionResult, Api paramApi, boolean paramBoolean) {}
  
  public final zzm zze(zzm paramzzm) {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */