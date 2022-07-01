package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class LocationSettingsResult extends AbstractSafeParcelable implements Result {
  public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzbb();
  
  private final Status zza;
  
  private final LocationSettingsStates zzb;
  
  public LocationSettingsResult(Status paramStatus) {
    this(paramStatus, null);
  }
  
  public LocationSettingsResult(Status paramStatus, LocationSettingsStates paramLocationSettingsStates) {
    this.zza = paramStatus;
    this.zzb = paramLocationSettingsStates;
  }
  
  public final LocationSettingsStates getLocationSettingsStates() {
    return this.zzb;
  }
  
  public final Status getStatus() {
    return this.zza;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, (Parcelable)getStatus(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)getLocationSettingsStates(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\LocationSettingsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */