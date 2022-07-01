package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.zzr;

public final class zzz extends GoogleApi {
  private final Api.zza zzfth;
  
  final Api.zze zzfwd;
  
  private final zzt zzfwe;
  
  private final zzr zzfwf;
  
  public zzz(Context paramContext, Api paramApi, Looper paramLooper, Api.zze paramzze, zzt paramzzt, zzr paramzzr, Api.zza paramzza) {
    super(paramContext, paramApi, paramLooper);
    this.zzfwd = paramzze;
    this.zzfwe = paramzzt;
    this.zzfwf = paramzzr;
    this.zzfth = paramzza;
    zzbm zzbm = this.zzfsq;
    zzbm.mHandler.sendMessage(zzbm.mHandler.obtainMessage(7, this));
  }
  
  public final Api.zze zza(Looper paramLooper, zzbo paramzzbo) {
    this.zzfwe.zzfvp = paramzzbo;
    return this.zzfwd;
  }
  
  public final zzcv zza(Context paramContext, Handler paramHandler) {
    return new zzcv(paramContext, paramHandler, this.zzfwf, this.zzfth);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */