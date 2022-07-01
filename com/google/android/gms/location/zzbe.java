package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;

public final class zzbe extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzbe> CREATOR = new zzbg();
  
  private final List<String> zza;
  
  private final PendingIntent zzb;
  
  private final String zzc;
  
  zzbe(List<String> paramList, PendingIntent paramPendingIntent, String paramString) {
    if (paramList == null) {
      paramList = Collections.emptyList();
    } else {
      paramList = Collections.unmodifiableList(paramList);
    } 
    this.zza = paramList;
    this.zzb = paramPendingIntent;
    this.zzc = paramString;
  }
  
  public static zzbe zza(PendingIntent paramPendingIntent) {
    Preconditions.checkNotNull(paramPendingIntent, "PendingIntent can not be null.");
    return new zzbe(null, paramPendingIntent, "");
  }
  
  public static zzbe zza(List<String> paramList) {
    Preconditions.checkNotNull(paramList, "geofence can't be null.");
    Preconditions.checkArgument(paramList.isEmpty() ^ true, "Geofences must contains at least one id.");
    return new zzbe(paramList, null, "");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringList(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zzb, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzc, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */