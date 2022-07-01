package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzdlf extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzdlg();
  
  public final int height;
  
  public final int left;
  
  public final int top;
  
  public final int width;
  
  public final float zzlif;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzdlf(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat) {
    this.left = paramInt1;
    this.top = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.zzlif = paramFloat;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 2, this.left);
    zzbgo.zzc(paramParcel, 3, this.top);
    zzbgo.zzc(paramParcel, 4, this.width);
    zzbgo.zzc(paramParcel, 5, this.height);
    zzbgo.zza(paramParcel, 6, this.zzlif);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdlf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */