package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzd implements Runnable {
  zzd(zzc paramzzc, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run() {
    if (zzc.zza(this.zzc) > 0) {
      Bundle bundle;
      LifecycleCallback lifecycleCallback = this.zza;
      if (zzc.zzb(this.zzc) != null) {
        bundle = zzc.zzb(this.zzc).getBundle(this.zzb);
      } else {
        bundle = null;
      } 
      lifecycleCallback.onCreate(bundle);
    } 
    if (zzc.zza(this.zzc) >= 2)
      this.zza.onStart(); 
    if (zzc.zza(this.zzc) >= 3)
      this.zza.onResume(); 
    if (zzc.zza(this.zzc) >= 4)
      this.zza.onStop(); 
    if (zzc.zza(this.zzc) >= 5)
      this.zza.onDestroy(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */