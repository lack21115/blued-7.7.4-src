package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzba();
  
  private final List<LocationRequest> zza;
  
  private final boolean zzb;
  
  private final boolean zzc;
  
  private zzay zzd;
  
  LocationSettingsRequest(List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2, zzay paramzzay) {
    this.zza = paramList;
    this.zzb = paramBoolean1;
    this.zzc = paramBoolean2;
    this.zzd = paramzzay;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, Collections.unmodifiableList(this.zza), false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeParcelable(paramParcel, 5, (Parcelable)this.zzd, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static final class Builder {
    private final ArrayList<LocationRequest> zza = new ArrayList<LocationRequest>();
    
    private boolean zzb = false;
    
    private boolean zzc = false;
    
    private zzay zzd = null;
    
    public final Builder addAllLocationRequests(Collection<LocationRequest> param1Collection) {
      for (LocationRequest locationRequest : param1Collection) {
        if (locationRequest != null)
          this.zza.add(locationRequest); 
      } 
      return this;
    }
    
    public final Builder addLocationRequest(LocationRequest param1LocationRequest) {
      if (param1LocationRequest != null)
        this.zza.add(param1LocationRequest); 
      return this;
    }
    
    public final LocationSettingsRequest build() {
      return new LocationSettingsRequest(this.zza, this.zzb, this.zzc, null);
    }
    
    public final Builder setAlwaysShow(boolean param1Boolean) {
      this.zzb = param1Boolean;
      return this;
    }
    
    public final Builder setNeedBle(boolean param1Boolean) {
      this.zzc = param1Boolean;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\LocationSettingsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */