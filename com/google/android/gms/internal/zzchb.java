package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;

final class zzchb extends zzv {
  private final zzci zzgbb;
  
  public final void onLocationAvailability(LocationAvailability paramLocationAvailability) {
    this.zzgbb.zza(new zzchd());
  }
  
  public final void onLocationResult(LocationResult paramLocationResult) {
    this.zzgbb.zza(new zzchc());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzchb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */