package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.vision.Frame;

public final class zzdld extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzdle();
  
  public int height;
  
  private int id;
  
  public int rotation;
  
  public int width;
  
  private long zzitd;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzdld() {}
  
  public zzdld(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4) {
    this.width = paramInt1;
    this.height = paramInt2;
    this.id = paramInt3;
    this.zzitd = paramLong;
    this.rotation = paramInt4;
  }
  
  public static zzdld zzc(Frame paramFrame) {
    zzdld zzdld1 = new zzdld();
    zzdld1.width = paramFrame.zzlgd.zzalt;
    zzdld1.height = paramFrame.zzlgd.zzalu;
    zzdld1.rotation = paramFrame.zzlgd.zzcma;
    zzdld1.id = paramFrame.zzlgd.mId;
    zzdld1.zzitd = paramFrame.zzlgd.zziee;
    return zzdld1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 2, this.width);
    zzbgo.zzc(paramParcel, 3, this.height);
    zzbgo.zzc(paramParcel, 4, this.id);
    zzbgo.zza(paramParcel, 5, this.zzitd);
    zzbgo.zzc(paramParcel, 6, this.rotation);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */