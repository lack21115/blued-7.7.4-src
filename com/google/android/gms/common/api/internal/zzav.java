package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzcyo;
import com.google.android.gms.internal.zzcyw;
import java.lang.ref.WeakReference;

final class zzav extends zzcyo {
  private final WeakReference zzfxu;
  
  zzav(zzao paramzzao) {
    this.zzfxu = new WeakReference<zzao>(paramzzao);
  }
  
  public final void zzb(zzcyw paramzzcyw) {
    zzao zzao = this.zzfxu.get();
    if (zzao == null)
      return; 
    zzao.zzfxd.zza(new zzaw(zzao, zzao, paramzzcyw));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */