package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbt;

public final class zzcyw extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzcyx();
  
  private int zzehz;
  
  public final ConnectionResult zzfuw;
  
  public final zzbt zzklz;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzcyw() {
    this(new ConnectionResult(8, null));
  }
  
  zzcyw(int paramInt, ConnectionResult paramConnectionResult, zzbt paramzzbt) {
    this.zzehz = paramInt;
    this.zzfuw = paramConnectionResult;
    this.zzklz = paramzzbt;
  }
  
  private zzcyw(ConnectionResult paramConnectionResult) {
    this(1, paramConnectionResult, null);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.zzehz);
    zzbgo.zza(paramParcel, 2, (Parcelable)this.zzfuw, paramInt, false);
    zzbgo.zza(paramParcel, 3, (Parcelable)this.zzklz, paramInt, false);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcyw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */