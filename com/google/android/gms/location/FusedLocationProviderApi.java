package com.google.android.gms.location;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

@Deprecated
public interface FusedLocationProviderApi {
  Location getLastLocation(GoogleApiClient paramGoogleApiClient);
  
  PendingResult removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener);
  
  PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\location\FusedLocationProviderApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */