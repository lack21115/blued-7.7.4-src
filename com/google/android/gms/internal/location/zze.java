package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.ActivityRecognitionApi;

public final class zze implements ActivityRecognitionApi {
  public final PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzf(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, long paramLong, PendingIntent paramPendingIntent) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzg(this, paramGoogleApiClient, paramLong, paramPendingIntent));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */