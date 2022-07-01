package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzac extends AbstractSafeParcelable implements Result {
  public static final Parcelable.Creator<zzac> CREATOR;
  
  private static final zzac zza = new zzac(Status.RESULT_SUCCESS);
  
  private final Status zzb;
  
  static {
    CREATOR = new zzab();
  }
  
  public zzac(Status paramStatus) {
    this.zzb = paramStatus;
  }
  
  public final Status getStatus() {
    return this.zzb;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, (Parcelable)getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */