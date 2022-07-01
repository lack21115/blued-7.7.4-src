package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbt;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzcyg;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.internal.zzcyo;
import com.google.android.gms.internal.zzcyp;
import com.google.android.gms.internal.zzcyw;
import java.util.Set;

public final class zzcv extends zzcyo implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
  private static Api.zza zzgbc = zzcyg.zzegv;
  
  final Context mContext;
  
  final Handler mHandler;
  
  Set zzenh;
  
  final Api.zza zzfsa;
  
  zzr zzfwf;
  
  zzcyj zzfxl;
  
  zzcy zzgbd;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzcv(Context paramContext, Handler paramHandler, zzr paramzzr) {
    this(paramContext, paramHandler, paramzzr, zzgbc);
  }
  
  public zzcv(Context paramContext, Handler paramHandler, zzr paramzzr, Api.zza paramzza) {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.zzfwf = (zzr)zzbq.checkNotNull(paramzzr, "ClientSettings must not be null");
    this.zzenh = paramzzr.zzfsw;
    this.zzfsa = paramzza;
  }
  
  public final void onConnected(Bundle paramBundle) {
    this.zzfxl.zza((zzcyp)this);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    this.zzgbd.zzh(paramConnectionResult);
  }
  
  public final void onConnectionSuspended(int paramInt) {
    this.zzfxl.disconnect();
  }
  
  public final void zzb(zzcyw paramzzcyw) {
    this.mHandler.post(new zzcx(this, paramzzcyw));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */