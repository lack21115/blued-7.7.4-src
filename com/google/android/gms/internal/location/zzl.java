package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzak;
import com.google.android.gms.location.zzan;

public final class zzl extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzl> CREATOR = new zzo();
  
  private int zza;
  
  private zzj zzb;
  
  private zzak zzc;
  
  private zzai zzd;
  
  zzl(int paramInt, zzj paramzzj, IBinder paramIBinder1, IBinder paramIBinder2) {
    zzak zzak1;
    IInterface iInterface;
    this.zza = paramInt;
    this.zzb = paramzzj;
    zzak zzak2 = null;
    if (paramIBinder1 == null) {
      paramzzj = null;
    } else {
      zzak1 = zzan.zza(paramIBinder1);
    } 
    this.zzc = zzak1;
    if (paramIBinder2 == null) {
      zzak1 = zzak2;
    } else if (paramIBinder2 == null) {
      zzak1 = zzak2;
    } else {
      iInterface = paramIBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
      if (iInterface instanceof zzai) {
        iInterface = iInterface;
      } else {
        iInterface = new zzak(paramIBinder2);
      } 
    } 
    this.zzd = (zzai)iInterface;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    IBinder iBinder2;
    IBinder iBinder1;
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zzb, paramInt, false);
    zzak zzak1 = this.zzc;
    zzai zzai2 = null;
    if (zzak1 == null) {
      zzak1 = null;
    } else {
      iBinder2 = zzak1.asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 3, iBinder2, false);
    zzai zzai1 = this.zzd;
    if (zzai1 == null) {
      zzai1 = zzai2;
    } else {
      iBinder1 = zzai1.asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 4, iBinder1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */