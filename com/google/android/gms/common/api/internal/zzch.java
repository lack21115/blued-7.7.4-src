package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzch implements Runnable {
  zzch(zzcg paramzzcg, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run() {
    if (zzcg.zza(this.zzgar) > 0) {
      Bundle bundle;
      LifecycleCallback lifecycleCallback = this.zzgaq;
      if (zzcg.zzb(this.zzgar) != null) {
        bundle = zzcg.zzb(this.zzgar).getBundle(this.zzas);
      } else {
        bundle = null;
      } 
      lifecycleCallback.onCreate(bundle);
    } 
    if (zzcg.zza(this.zzgar) >= 2)
      this.zzgaq.onStart(); 
    if (zzcg.zza(this.zzgar) >= 3)
      this.zzgaq.onResume(); 
    if (zzcg.zza(this.zzgar) >= 4)
      this.zzgaq.onStop(); 
    zzcg.zza(this.zzgar);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */