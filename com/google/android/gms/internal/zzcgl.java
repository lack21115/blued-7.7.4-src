package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzcgl extends zzbgl implements Result {
  public static final Parcelable.Creator CREATOR = new zzcgm();
  
  final Status mStatus;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzcgl(Status paramStatus) {
    this.mStatus = paramStatus;
  }
  
  public final Status getStatus() {
    return this.mStatus;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 1, (Parcelable)this.mStatus, paramInt, false);
    zzbgo.zzah(paramParcel, i);
  }
  
  static {
    new zzcgl(Status.zzftq);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */