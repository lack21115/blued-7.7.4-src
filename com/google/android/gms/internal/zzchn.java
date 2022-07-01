package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzx;
import com.google.android.gms.location.zzy;

public final class zzchn extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzcho();
  
  private PendingIntent zzekd;
  
  private int zzitp;
  
  private zzcgr zzits;
  
  private zzchl zziur;
  
  private zzx zzius;
  
  private zzu zziut;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  zzchn(int paramInt, zzchl paramzzchl, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2, IBinder paramIBinder3) {
    zzx zzx1;
    zzu zzu1;
    IInterface iInterface;
    this.zzitp = paramInt;
    this.zziur = paramzzchl;
    zzu zzu2 = null;
    if (paramIBinder1 == null) {
      paramzzchl = null;
    } else {
      zzx1 = zzy.zzbf(paramIBinder1);
    } 
    this.zzius = zzx1;
    this.zzekd = paramPendingIntent;
    if (paramIBinder2 == null) {
      zzx1 = null;
    } else {
      zzu1 = zzv.zzbe(paramIBinder2);
    } 
    this.zziut = zzu1;
    if (paramIBinder3 == null) {
      zzu1 = zzu2;
    } else if (paramIBinder3 == null) {
      zzu1 = zzu2;
    } else {
      iInterface = paramIBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
      if (iInterface instanceof zzcgr) {
        iInterface = iInterface;
      } else {
        iInterface = new zzcgt(paramIBinder3);
      } 
    } 
    this.zzits = (zzcgr)iInterface;
  }
  
  public static zzchn zza(zzu paramzzu, zzcgr paramzzcgr) {
    IBinder iBinder = paramzzu.asBinder();
    if (paramzzcgr != null) {
      IBinder iBinder1 = paramzzcgr.asBinder();
    } else {
      paramzzu = null;
    } 
    return new zzchn(2, null, null, null, iBinder, (IBinder)paramzzu);
  }
  
  public static zzchn zza(zzx paramzzx, zzcgr paramzzcgr) {
    IBinder iBinder = paramzzx.asBinder();
    if (paramzzcgr != null) {
      IBinder iBinder1 = paramzzcgr.asBinder();
    } else {
      paramzzx = null;
    } 
    return new zzchn(2, null, iBinder, null, null, (IBinder)paramzzx);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    IBinder iBinder1;
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.zzitp);
    zzbgo.zza(paramParcel, 2, this.zziur, paramInt, false);
    zzx zzx1 = this.zzius;
    IBinder iBinder2 = null;
    if (zzx1 == null) {
      zzx1 = null;
    } else {
      iBinder1 = this.zzius.asBinder();
    } 
    zzbgo.zza$cdac282(paramParcel, 3, iBinder1);
    zzbgo.zza(paramParcel, 4, (Parcelable)this.zzekd, paramInt, false);
    if (this.zziut == null) {
      iBinder1 = null;
    } else {
      iBinder1 = this.zziut.asBinder();
    } 
    zzbgo.zza$cdac282(paramParcel, 5, iBinder1);
    if (this.zzits == null) {
      iBinder1 = iBinder2;
    } else {
      iBinder1 = this.zzits.asBinder();
    } 
    zzbgo.zza$cdac282(paramParcel, 6, iBinder1);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzchn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */