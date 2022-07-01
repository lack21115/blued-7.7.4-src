package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbr;

public final class zzcyu extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzcyv();
  
  private int zzehz;
  
  private zzbr zzkly;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  zzcyu(int paramInt, zzbr paramzzbr) {
    this.zzehz = paramInt;
    this.zzkly = paramzzbr;
  }
  
  public zzcyu(zzbr paramzzbr) {
    this(1, paramzzbr);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.zzehz);
    zzbgo.zza(paramParcel, 2, (Parcelable)this.zzkly, paramInt, false);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcyu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */