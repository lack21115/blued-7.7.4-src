package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzao;
import com.google.android.gms.location.zzap;
import com.google.android.gms.location.zzaq;
import com.google.android.gms.location.zzat;

public final class zzbe extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzbe> CREATOR = new zzbd();
  
  private int zza;
  
  private zzbc zzb;
  
  private zzaq zzc;
  
  private PendingIntent zzd;
  
  private zzap zze;
  
  private zzai zzf;
  
  zzbe(int paramInt, zzbc paramzzbc, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2, IBinder paramIBinder3) {
    zzaq zzaq1;
    zzap zzap1;
    IInterface iInterface;
    this.zza = paramInt;
    this.zzb = paramzzbc;
    zzap zzap2 = null;
    if (paramIBinder1 == null) {
      paramzzbc = null;
    } else {
      zzaq1 = zzat.zza(paramIBinder1);
    } 
    this.zzc = zzaq1;
    this.zzd = paramPendingIntent;
    if (paramIBinder2 == null) {
      zzaq1 = null;
    } else {
      zzap1 = zzao.zza(paramIBinder2);
    } 
    this.zze = zzap1;
    if (paramIBinder3 == null) {
      zzap1 = zzap2;
    } else if (paramIBinder3 == null) {
      zzap1 = zzap2;
    } else {
      iInterface = paramIBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
      if (iInterface instanceof zzai) {
        iInterface = iInterface;
      } else {
        iInterface = new zzak(paramIBinder3);
      } 
    } 
    this.zzf = (zzai)iInterface;
  }
  
  public static zzbe zza(zzbc paramzzbc, PendingIntent paramPendingIntent, zzai paramzzai) {
    if (paramzzai != null) {
      IBinder iBinder = paramzzai.asBinder();
    } else {
      paramzzai = null;
    } 
    return new zzbe(1, paramzzbc, null, paramPendingIntent, null, (IBinder)paramzzai);
  }
  
  public static zzbe zza(zzap paramzzap, zzai paramzzai) {
    IBinder iBinder = paramzzap.asBinder();
    if (paramzzai != null) {
      IBinder iBinder1 = paramzzai.asBinder();
    } else {
      paramzzap = null;
    } 
    return new zzbe(2, null, null, null, iBinder, (IBinder)paramzzap);
  }
  
  public static zzbe zza(zzaq paramzzaq, zzai paramzzai) {
    IBinder iBinder = paramzzaq.asBinder();
    if (paramzzai != null) {
      IBinder iBinder1 = paramzzai.asBinder();
    } else {
      paramzzaq = null;
    } 
    return new zzbe(2, null, iBinder, null, null, (IBinder)paramzzaq);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    IBinder iBinder3;
    IBinder iBinder2;
    IBinder iBinder1;
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zzb, paramInt, false);
    zzaq zzaq1 = this.zzc;
    zzai zzai2 = null;
    if (zzaq1 == null) {
      zzaq1 = null;
    } else {
      iBinder3 = zzaq1.asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 3, iBinder3, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)this.zzd, paramInt, false);
    zzap zzap1 = this.zze;
    if (zzap1 == null) {
      zzap1 = null;
    } else {
      iBinder2 = zzap1.asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 5, iBinder2, false);
    zzai zzai1 = this.zzf;
    if (zzai1 == null) {
      zzai1 = zzai2;
    } else {
      iBinder1 = zzai1.asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 6, iBinder1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */