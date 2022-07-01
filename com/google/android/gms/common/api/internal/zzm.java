package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbz;

public abstract class zzm extends BasePendingResult implements zzn {
  final Api zzfop;
  
  final Api.zzc zzfus;
  
  public zzm(Api paramApi, GoogleApiClient paramGoogleApiClient) {
    super((GoogleApiClient)zzbq.checkNotNull(paramGoogleApiClient, "GoogleApiClient must not be null"));
    zzbq.checkNotNull(paramApi, "Api must not be null");
    this.zzfus = paramApi.zzahm();
    this.zzfop = paramApi;
  }
  
  private final void zzc(RemoteException paramRemoteException) {
    zzu(new Status(8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  public abstract void zza(Api.zzb paramzzb);
  
  public final void zzb(Api.zzb paramzzb) {
    Api.zzg zzg;
    Api.zzb zzb1 = paramzzb;
    if (paramzzb instanceof zzbz)
      zzg = zzbz.zzanb(); 
    try {
      zza((Api.zzb)zzg);
      return;
    } catch (DeadObjectException deadObjectException) {
      zzc((RemoteException)deadObjectException);
      throw deadObjectException;
    } catch (RemoteException remoteException) {
      zzc(remoteException);
      return;
    } 
  }
  
  public final void zzu(Status paramStatus) {
    zzbq.checkArgument(paramStatus.isSuccess() ^ true, "Failed result must not be success");
    setResult(zzb(paramStatus));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */