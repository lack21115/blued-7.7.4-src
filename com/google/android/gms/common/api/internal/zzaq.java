package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzj;
import java.lang.ref.WeakReference;

final class zzaq implements zzj {
  private final Api zzfop;
  
  final boolean zzfvo;
  
  private final WeakReference zzfxu;
  
  public zzaq(zzao paramzzao, Api paramApi, boolean paramBoolean) {
    this.zzfxu = new WeakReference<zzao>(paramzzao);
    this.zzfop = paramApi;
    this.zzfvo = paramBoolean;
  }
  
  public final void zzf(ConnectionResult paramConnectionResult) {
    boolean bool;
    zzao zzao = this.zzfxu.get();
    if (zzao == null)
      return; 
    if (Looper.myLooper() == zzao.zzfxd.zzfvq.getLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    zzbq.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zzao.zzfwa.lock();
    try {
      bool = zzao.zzbs(0);
      if (!bool)
        return; 
      if (!paramConnectionResult.isSuccess())
        zzao.zzb(paramConnectionResult, this.zzfop, this.zzfvo); 
      if (zzao.zzajk())
        zzao.zzajl(); 
      return;
    } finally {
      zzao.zzfwa.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */