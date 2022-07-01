package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public final class zzc extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzd();
  
  public int mode;
  
  public int zzlhp;
  
  public int zzlhq;
  
  public boolean zzlhr;
  
  public boolean zzlhs;
  
  public float zzlht;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzc() {}
  
  public zzc(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat) {
    this.mode = paramInt1;
    this.zzlhp = paramInt2;
    this.zzlhq = paramInt3;
    this.zzlhr = paramBoolean1;
    this.zzlhs = paramBoolean2;
    this.zzlht = paramFloat;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 2, this.mode);
    zzbgo.zzc(paramParcel, 3, this.zzlhp);
    zzbgo.zzc(paramParcel, 4, this.zzlhq);
    zzbgo.zza(paramParcel, 5, this.zzlhr);
    zzbgo.zza(paramParcel, 6, this.zzlhs);
    zzbgo.zza(paramParcel, 7, this.zzlht);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */