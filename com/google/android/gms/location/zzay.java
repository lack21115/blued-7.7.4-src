package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
public final class zzay extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzay> CREATOR = new zzaz();
  
  private final String zza;
  
  private final String zzb;
  
  private final String zzc;
  
  zzay(String paramString1, String paramString2, String paramString3) {
    this.zzc = paramString1;
    this.zza = paramString2;
    this.zzb = paramString3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzc, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */