package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public final class zzn implements FusedLocationProviderApi {
  public final PendingResult<Status> flushLocations(GoogleApiClient paramGoogleApiClient) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzu(this, paramGoogleApiClient));
  }
  
  public final Location getLastLocation(GoogleApiClient paramGoogleApiClient) {
    zzay zzay = LocationServices.zza(paramGoogleApiClient);
    try {
      return zzay.zza((String)null);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public final LocationAvailability getLocationAvailability(GoogleApiClient paramGoogleApiClient) {
    zzay zzay = LocationServices.zza(paramGoogleApiClient);
    try {
      return zzay.zza();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public final PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzx(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationCallback paramLocationCallback) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzp(this, paramGoogleApiClient, paramLocationCallback));
  }
  
  public final PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzy(this, paramGoogleApiClient, paramLocationListener));
  }
  
  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, PendingIntent paramPendingIntent) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzv(this, paramGoogleApiClient, paramLocationRequest, paramPendingIntent));
  }
  
  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzw(this, paramGoogleApiClient, paramLocationRequest, paramLocationCallback, paramLooper));
  }
  
  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener) {
    Preconditions.checkNotNull(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzq(this, paramGoogleApiClient, paramLocationRequest, paramLocationListener));
  }
  
  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzt(this, paramGoogleApiClient, paramLocationRequest, paramLocationListener, paramLooper));
  }
  
  public final PendingResult<Status> setMockLocation(GoogleApiClient paramGoogleApiClient, Location paramLocation) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzr(this, paramGoogleApiClient, paramLocation));
  }
  
  public final PendingResult<Status> setMockMode(GoogleApiClient paramGoogleApiClient, boolean paramBoolean) {
    return (PendingResult<Status>)paramGoogleApiClient.execute((BaseImplementation.ApiMethodImpl)new zzs(this, paramGoogleApiClient, paramBoolean));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */