package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.LocationStatusCodes;

final class zzax extends zzam {
  private BaseImplementation.ResultHolder<Status> zza;
  
  public zzax(BaseImplementation.ResultHolder<Status> paramResultHolder) {
    this.zza = paramResultHolder;
  }
  
  public final void zza(int paramInt, PendingIntent paramPendingIntent) {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult", new Exception());
  }
  
  public final void zza(int paramInt, String[] paramArrayOfString) {
    if (this.zza == null) {
      Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times", new Exception());
      return;
    } 
    Status status = LocationStatusCodes.zzb(LocationStatusCodes.zza(paramInt));
    this.zza.setResult(status);
    this.zza = null;
  }
  
  public final void zzb(int paramInt, String[] paramArrayOfString) {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult", new Exception());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */