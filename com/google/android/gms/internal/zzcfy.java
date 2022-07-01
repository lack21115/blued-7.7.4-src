package com.google.android.gms.internal;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public final class zzcfy implements FusedLocationProviderApi {
  public final Location getLastLocation(GoogleApiClient paramGoogleApiClient) {
    zzchh zzchh = LocationServices.zzi(paramGoogleApiClient);
    try {
      zzcha zzcha = zzchh.zziuk;
      zzcha.zzitk.zzalv();
      return ((zzcgw)zzcha.zzitk.zzalw()).zzim(zzcha.mContext.getPackageName());
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public final PendingResult removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener) {
    return (PendingResult)paramGoogleApiClient.zze((zzm)new zzcgh(paramGoogleApiClient, paramLocationListener));
  }
  
  public final PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper) {
    return (PendingResult)paramGoogleApiClient.zze((zzm)new zzcge(paramGoogleApiClient, paramLocationRequest, paramLocationListener, paramLooper));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */