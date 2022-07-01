package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzbq;

public final class zzci {
  private final zzcj zzgas;
  
  public volatile Object zzgat;
  
  public final zzck zzgau;
  
  public zzci(Looper paramLooper, Object paramObject, String paramString) {
    this.zzgas = new zzcj(this, paramLooper);
    this.zzgat = zzbq.checkNotNull(paramObject, "Listener must not be null");
    this.zzgau = new zzck(paramObject, zzbq.zzgv(paramString));
  }
  
  public final void zza(zzcl paramzzcl) {
    zzbq.checkNotNull(paramzzcl, "Notifier must not be null");
    Message message = this.zzgas.obtainMessage(1, paramzzcl);
    this.zzgas.sendMessage(message);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */