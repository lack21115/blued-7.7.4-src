package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public final class zzz extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzaa();
  
  private int version = 3;
  
  private int zzggb;
  
  private int zzggc;
  
  String zzggd;
  
  IBinder zzgge;
  
  Scope[] zzggf;
  
  Bundle zzggg;
  
  Account zzggh;
  
  zzc[] zzggi;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzz(int paramInt) {
    this.zzggc = zzf.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzggb = paramInt;
  }
  
  zzz(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, zzc[] paramArrayOfzzc) {
    this.zzggb = paramInt2;
    this.zzggc = paramInt3;
    if ("com.google.android.gms".equals(paramString)) {
      this.zzggd = "com.google.android.gms";
    } else {
      this.zzggd = paramString;
    } 
    if (paramInt1 < 2) {
      Account account;
      paramString = null;
      paramAccount = null;
      if (paramIBinder != null) {
        IInterface iInterface;
        if (paramIBinder == null) {
          Account account1 = paramAccount;
        } else {
          iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
          if (iInterface instanceof zzan) {
            iInterface = iInterface;
          } else {
            iInterface = new zzap(paramIBinder);
          } 
        } 
        account = zza.zza((zzan)iInterface);
      } 
      this.zzggh = account;
    } else {
      this.zzgge = paramIBinder;
      this.zzggh = paramAccount;
    } 
    this.zzggf = paramArrayOfScope;
    this.zzggg = paramBundle;
    this.zzggi = paramArrayOfzzc;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.version);
    zzbgo.zzc(paramParcel, 2, this.zzggb);
    zzbgo.zzc(paramParcel, 3, this.zzggc);
    zzbgo.zza(paramParcel, 4, this.zzggd, false);
    zzbgo.zza$cdac282(paramParcel, 5, this.zzgge);
    zzbgo.zza$2d7953c6(paramParcel, 6, (Parcelable[])this.zzggf, paramInt);
    Bundle bundle = this.zzggg;
    if (bundle != null) {
      int j = zzbgo.zzag(paramParcel, 7);
      paramParcel.writeBundle(bundle);
      zzbgo.zzah(paramParcel, j);
    } 
    zzbgo.zza(paramParcel, 8, (Parcelable)this.zzggh, paramInt, false);
    zzbgo.zza$2d7953c6(paramParcel, 10, (Parcelable[])this.zzggi, paramInt);
    zzbgo.zzah(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */