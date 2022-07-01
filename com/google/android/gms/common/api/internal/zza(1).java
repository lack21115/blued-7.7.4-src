package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zza implements Runnable {
  zza(zzb paramzzb, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run() {
    if (zzb.zza(this.zzc) > 0) {
      Bundle bundle;
      LifecycleCallback lifecycleCallback = this.zza;
      if (zzb.zzb(this.zzc) != null) {
        bundle = zzb.zzb(this.zzc).getBundle(this.zzb);
      } else {
        bundle = null;
      } 
      lifecycleCallback.onCreate(bundle);
    } 
    if (zzb.zza(this.zzc) >= 2)
      this.zza.onStart(); 
    if (zzb.zza(this.zzc) >= 3)
      this.zza.onResume(); 
    if (zzb.zza(this.zzc) >= 4)
      this.zza.onStop(); 
    if (zzb.zza(this.zzc) >= 5)
      this.zza.onDestroy(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */