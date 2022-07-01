package com.google.android.gms.location;

import com.google.android.gms.tasks.TaskCompletionSource;

final class zzad extends LocationCallback {
  zzad(FusedLocationProviderClient paramFusedLocationProviderClient, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void onLocationAvailability(LocationAvailability paramLocationAvailability) {}
  
  public final void onLocationResult(LocationResult paramLocationResult) {
    this.zza.trySetResult(paramLocationResult.getLastLocation());
    this.zzb.removeLocationUpdates(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */