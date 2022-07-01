package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.LocationStatusCodes;

final class zzba extends zzam {
  private BaseImplementation.ResultHolder<Status> zza;
  
  public zzba(BaseImplementation.ResultHolder<Status> paramResultHolder) {
    this.zza = paramResultHolder;
  }
  
  private final void zza(int paramInt) {
    if (this.zza == null) {
      Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times", new Exception());
      return;
    } 
    Status status = LocationStatusCodes.zzb(LocationStatusCodes.zza(paramInt));
    this.zza.setResult(status);
    this.zza = null;
  }
  
  public final void zza(int paramInt, PendingIntent paramPendingIntent) {
    zza(paramInt);
  }
  
  public final void zza(int paramInt, String[] paramArrayOfString) {
    Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult", new Exception());
  }
  
  public final void zzb(int paramInt, String[] paramArrayOfString) {
    zza(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */