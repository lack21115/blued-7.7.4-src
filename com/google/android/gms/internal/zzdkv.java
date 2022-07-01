package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzdkv extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzdkw();
  
  private int zzlgq;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzdkv() {}
  
  public zzdkv(int paramInt) {
    this.zzlgq = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 2, this.zzlgq);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdkv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */