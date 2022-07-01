package com.google.android.gms.internal;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzdln extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzdlo();
  
  public final Rect zzliq = new Rect();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzdln() {}
  
  public zzdln(Rect paramRect) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza(paramParcel, 2, (Parcelable)this.zzliq, paramInt, false);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */