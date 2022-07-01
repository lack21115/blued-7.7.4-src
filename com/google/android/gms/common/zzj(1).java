package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

public final class zzj extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzj> CREATOR = new zzm();
  
  private final String zza;
  
  @Nullable
  private final zzd zzb;
  
  private final boolean zzc;
  
  private final boolean zzd;
  
  zzj(String paramString, @Nullable IBinder paramIBinder, boolean paramBoolean1, boolean paramBoolean2) {
    this.zza = paramString;
    this.zzb = zza(paramIBinder);
    this.zzc = paramBoolean1;
    this.zzd = paramBoolean2;
  }
  
  zzj(String paramString, @Nullable zzd paramzzd, boolean paramBoolean1, boolean paramBoolean2) {
    this.zza = paramString;
    this.zzb = paramzzd;
    this.zzc = paramBoolean1;
    this.zzd = paramBoolean2;
  }
  
  @Nullable
  private static zzd zza(@Nullable IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    try {
      byte[] arrayOfByte;
      IObjectWrapper iObjectWrapper = zzn.zza(paramIBinder).zzb();
      if (iObjectWrapper == null) {
        iObjectWrapper = null;
      } else {
        arrayOfByte = (byte[])ObjectWrapper.unwrap(iObjectWrapper);
      } 
      if (arrayOfByte != null)
        return new zzg(arrayOfByte); 
      Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
      return null;
    } catch (RemoteException remoteException) {
      Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", (Throwable)remoteException);
      return null;
    } 
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    IBinder iBinder;
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    zzd zzd1 = this.zzb;
    if (zzd1 == null) {
      Log.w("GoogleCertificatesQuery", "certificate binder is null");
      zzd1 = null;
    } else {
      iBinder = zzd1.asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 2, iBinder, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzd);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */