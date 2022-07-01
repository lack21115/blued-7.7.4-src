package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class GetServiceRequest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();
  
  String zza;
  
  IBinder zzb;
  
  Scope[] zzc;
  
  Bundle zzd;
  
  Account zze;
  
  Feature[] zzf;
  
  Feature[] zzg;
  
  private final int zzh = 4;
  
  private final int zzi;
  
  private int zzj;
  
  private boolean zzk;
  
  private int zzl;
  
  public GetServiceRequest(int paramInt) {
    this.zzj = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzi = paramInt;
    this.zzk = true;
  }
  
  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, Feature[] paramArrayOfFeature1, Feature[] paramArrayOfFeature2, boolean paramBoolean, int paramInt4) {
    this.zzi = paramInt2;
    this.zzj = paramInt3;
    if ("com.google.android.gms".equals(paramString)) {
      this.zza = "com.google.android.gms";
    } else {
      this.zza = paramString;
    } 
    if (paramInt1 < 2) {
      Account account;
      paramString = null;
      if (paramIBinder != null)
        account = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(paramIBinder)); 
      this.zze = account;
    } else {
      this.zzb = paramIBinder;
      this.zze = paramAccount;
    } 
    this.zzc = paramArrayOfScope;
    this.zzd = paramBundle;
    this.zzf = paramArrayOfFeature1;
    this.zzg = paramArrayOfFeature2;
    this.zzk = paramBoolean;
    this.zzl = paramInt4;
  }
  
  public Bundle getExtraArgs() {
    return this.zzd;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzh);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzi);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzj);
    SafeParcelWriter.writeString(paramParcel, 4, this.zza, false);
    SafeParcelWriter.writeIBinder(paramParcel, 5, this.zzb, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 6, (Parcelable[])this.zzc, paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzd, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, (Parcelable)this.zze, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 10, (Parcelable[])this.zzf, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 11, (Parcelable[])this.zzg, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 12, this.zzk);
    SafeParcelWriter.writeInt(paramParcel, 13, this.zzl);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\GetServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */