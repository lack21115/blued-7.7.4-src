package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzdll extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzdlm();
  
  private String zzlib;
  
  private zzdlu[] zzlig;
  
  public final zzdlf zzlih;
  
  private zzdlf zzlii;
  
  private zzdlf zzlij;
  
  public final String zzlik;
  
  private float zzlil;
  
  private int zzlim;
  
  private boolean zzlin;
  
  public final int zzlio;
  
  public final int zzlip;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzdll(zzdlu[] paramArrayOfzzdlu, zzdlf paramzzdlf1, zzdlf paramzzdlf2, zzdlf paramzzdlf3, String paramString1, float paramFloat, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
    this.zzlig = paramArrayOfzzdlu;
    this.zzlih = paramzzdlf1;
    this.zzlii = paramzzdlf2;
    this.zzlij = paramzzdlf3;
    this.zzlik = paramString1;
    this.zzlil = paramFloat;
    this.zzlib = paramString2;
    this.zzlim = paramInt1;
    this.zzlin = paramBoolean;
    this.zzlio = paramInt2;
    this.zzlip = paramInt3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zza$2d7953c6(paramParcel, 2, (Parcelable[])this.zzlig, paramInt);
    zzbgo.zza(paramParcel, 3, this.zzlih, paramInt, false);
    zzbgo.zza(paramParcel, 4, this.zzlii, paramInt, false);
    zzbgo.zza(paramParcel, 5, this.zzlij, paramInt, false);
    zzbgo.zza(paramParcel, 6, this.zzlik, false);
    zzbgo.zza(paramParcel, 7, this.zzlil);
    zzbgo.zza(paramParcel, 8, this.zzlib, false);
    zzbgo.zzc(paramParcel, 9, this.zzlim);
    zzbgo.zza(paramParcel, 10, this.zzlin);
    zzbgo.zzc(paramParcel, 11, this.zzlio);
    zzbgo.zzc(paramParcel, 12, this.zzlip);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */