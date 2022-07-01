package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public final class zzbt extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzbu();
  
  private int zzehz;
  
  public ConnectionResult zzfuw;
  
  public boolean zzfxq;
  
  private IBinder zzghx;
  
  public boolean zzghy;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  zzbt(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2) {
    this.zzehz = paramInt;
    this.zzghx = paramIBinder;
    this.zzfuw = paramConnectionResult;
    this.zzfxq = paramBoolean1;
    this.zzghy = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzbt))
      return false; 
    paramObject = paramObject;
    return (this.zzfuw.equals(((zzbt)paramObject).zzfuw) && zzamy().equals(paramObject.zzamy()));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.zzehz);
    zzbgo.zza$cdac282(paramParcel, 2, this.zzghx);
    zzbgo.zza(paramParcel, 3, (Parcelable)this.zzfuw, paramInt, false);
    zzbgo.zza(paramParcel, 4, this.zzfxq);
    zzbgo.zza(paramParcel, 5, this.zzghy);
    zzbgo.zzah(paramParcel, i);
  }
  
  public final zzan zzamy() {
    IBinder iBinder = this.zzghx;
    if (iBinder == null)
      return null; 
    IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
    return (iInterface instanceof zzan) ? (zzan)iInterface : new zzap(iBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */