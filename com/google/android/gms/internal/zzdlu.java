package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzdlu extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzdlv();
  
  private String zzlib;
  
  private zzdlf zzlih;
  
  private zzdlf zzlii;
  
  private String zzlik;
  
  private float zzlil;
  
  private zzdlp[] zzlir;
  
  private boolean zzlis;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzdlu(zzdlp[] paramArrayOfzzdlp, zzdlf paramzzdlf1, zzdlf paramzzdlf2, String paramString1, float paramFloat, String paramString2, boolean paramBoolean) {
    this.zzlir = paramArrayOfzzdlp;
    this.zzlih = paramzzdlf1;
    this.zzlii = paramzzdlf2;
    this.zzlik = paramString1;
    this.zzlil = paramFloat;
    this.zzlib = paramString2;
    this.zzlis = paramBoolean;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza$2d7953c6(paramParcel, 2, (Parcelable[])this.zzlir, paramInt);
    zzbgo.zza(paramParcel, 3, this.zzlih, paramInt, false);
    zzbgo.zza(paramParcel, 4, this.zzlii, paramInt, false);
    zzbgo.zza(paramParcel, 5, this.zzlik, false);
    zzbgo.zza(paramParcel, 6, this.zzlil);
    zzbgo.zza(paramParcel, 7, this.zzlib, false);
    zzbgo.zza(paramParcel, 8, this.zzlis);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdlu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */