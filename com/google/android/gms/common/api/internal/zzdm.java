package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zze;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class zzdm implements IBinder.DeathRecipient, zzdn {
  private final WeakReference zzgbv;
  
  private final WeakReference zzgbw;
  
  private final WeakReference zzgbx;
  
  private zzdm(BasePendingResult paramBasePendingResult, zze paramzze, IBinder paramIBinder) {
    this.zzgbw = new WeakReference<zze>(paramzze);
    this.zzgbv = new WeakReference<BasePendingResult>(paramBasePendingResult);
    this.zzgbx = new WeakReference<IBinder>(paramIBinder);
  }
  
  private final void zzale() {
    BasePendingResult basePendingResult = this.zzgbv.get();
    zze zze = this.zzgbw.get();
    if (zze != null && basePendingResult != null) {
      basePendingResult.zzaid().intValue();
      zze.remove$13462e();
    } 
    IBinder iBinder = this.zzgbx.get();
    if (iBinder != null)
      try {
        iBinder.unlinkToDeath(this, 0);
        return;
      } catch (NoSuchElementException noSuchElementException) {} 
  }
  
  public final void binderDied() {
    zzale();
  }
  
  public final void zzc(BasePendingResult paramBasePendingResult) {
    zzale();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */