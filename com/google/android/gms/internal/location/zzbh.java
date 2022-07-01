package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public final class zzbh implements SettingsApi {
  public final PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient paramGoogleApiClient, LocationSettingsRequest paramLocationSettingsRequest) {
    return (PendingResult<LocationSettingsResult>)paramGoogleApiClient.enqueue((BaseImplementation.ApiMethodImpl)new zzbk(this, paramGoogleApiClient, paramLocationSettingsRequest, null));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */