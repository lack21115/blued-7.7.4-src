package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class zze extends zzi {
  private int statusCode;
  
  private Bundle zzgfj;
  
  protected zze(zzd paramzzd, int paramInt, Bundle paramBundle) {
    super(paramzzd, Boolean.valueOf(true));
    this.statusCode = paramInt;
    this.zzgfj = paramBundle;
  }
  
  protected abstract boolean zzama();
  
  protected abstract void zzj(ConnectionResult paramConnectionResult);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */