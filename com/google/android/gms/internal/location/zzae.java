package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.zzbe;
import java.util.List;

public final class zzae implements GeofencingApi {
  private final PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, zzbe paramzzbe) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzag(this, paramGoogleApiClient, paramzzbe));
  }
  
  public final PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzad(this, paramGoogleApiClient, paramGeofencingRequest, paramPendingIntent));
  }
  
  @Deprecated
  public final PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, List<Geofence> paramList, PendingIntent paramPendingIntent) {
    GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
    builder.addGeofences(paramList);
    builder.setInitialTrigger(5);
    return addGeofences(paramGoogleApiClient, builder.build(), paramPendingIntent);
  }
  
  public final PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent) {
    return zza(paramGoogleApiClient, zzbe.zza(paramPendingIntent));
  }
  
  public final PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, List<String> paramList) {
    return zza(paramGoogleApiClient, zzbe.zza(paramList));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */