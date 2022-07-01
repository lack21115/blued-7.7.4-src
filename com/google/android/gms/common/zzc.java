package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public final class zzc extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzd();
  
  private String name;
  
  private int version;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzc(String paramString, int paramInt) {
    this.name = paramString;
    this.version = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 1, this.name, false);
    zzbgo.zzc(paramParcel, 2, this.version);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */