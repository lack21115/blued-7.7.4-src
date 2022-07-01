package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzc extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzc> CREATOR = new zzb();
  
  Bundle zza;
  
  Feature[] zzb;
  
  private int zzc;
  
  public zzc() {}
  
  zzc(Bundle paramBundle, Feature[] paramArrayOfFeature, int paramInt) {
    this.zza = paramBundle;
    this.zzb = paramArrayOfFeature;
    this.zzc = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, (Parcelable[])this.zzb, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzc);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */