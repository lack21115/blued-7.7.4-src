package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

public final class LocationSettingsStates extends AbstractSafeParcelable {
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzbc();
  
  private final boolean zza;
  
  private final boolean zzb;
  
  private final boolean zzc;
  
  private final boolean zzd;
  
  private final boolean zze;
  
  private final boolean zzf;
  
  public LocationSettingsStates(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
    this.zza = paramBoolean1;
    this.zzb = paramBoolean2;
    this.zzc = paramBoolean3;
    this.zzd = paramBoolean4;
    this.zze = paramBoolean5;
    this.zzf = paramBoolean6;
  }
  
  public static LocationSettingsStates fromIntent(Intent paramIntent) {
    return (LocationSettingsStates)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
  }
  
  public final boolean isBlePresent() {
    return this.zzf;
  }
  
  public final boolean isBleUsable() {
    return this.zzc;
  }
  
  public final boolean isGpsPresent() {
    return this.zzd;
  }
  
  public final boolean isGpsUsable() {
    return this.zza;
  }
  
  public final boolean isLocationPresent() {
    return (this.zzd || this.zze);
  }
  
  public final boolean isLocationUsable() {
    return (this.zza || this.zzb);
  }
  
  public final boolean isNetworkLocationPresent() {
    return this.zze;
  }
  
  public final boolean isNetworkLocationUsable() {
    return this.zzb;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, isGpsUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 2, isNetworkLocationUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isBleUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 4, isGpsPresent());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isNetworkLocationPresent());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isBlePresent());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\LocationSettingsStates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */