package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzaa;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbr;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzr;

public final class zzcyt extends zzab implements zzcyj {
  private final zzr zzfwf;
  
  private Integer zzgft;
  
  private final boolean zzklw = true;
  
  private final Bundle zzklx;
  
  private zzcyt(Context paramContext, Looper paramLooper, zzr paramzzr, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramLooper, 44, paramzzr, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzfwf = paramzzr;
    this.zzklx = paramBundle;
    this.zzgft = paramzzr.zzgft;
  }
  
  public zzcyt(Context paramContext, Looper paramLooper, zzr paramzzr, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, paramzzr, bundle, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public final void connect() {
    zza((zzj)new zzm((zzd)this));
  }
  
  public final void zza(zzan paramzzan, boolean paramBoolean) {
    try {
      ((zzcyr)zzalw()).zza(paramzzan, this.zzgft.intValue(), paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
      return;
    } 
  }
  
  public final void zza(zzcyp paramzzcyp) {
    zzbq.checkNotNull(paramzzcyp, "Expecting a valid ISignInCallbacks");
    try {
      Account account;
      GoogleSignInAccount googleSignInAccount;
      zzr zzr1 = this.zzfwf;
      if (zzr1.zzeho != null) {
        account = zzr1.zzeho;
      } else {
        account = new Account("<<default account>>", "com.google");
      } 
      zzaa zzaa = null;
      if ("<<default account>>".equals(account.name)) {
        zzaa = zzaa.zzbs(((zzd)this).mContext);
        googleSignInAccount = zzaa.zzfe(zzaa.zzfg("defaultGoogleSignInAccount"));
      } 
      zzbr zzbr = new zzbr(account, this.zzgft.intValue(), googleSignInAccount);
      ((zzcyr)zzalw()).zza(new zzcyu(zzbr), paramzzcyp);
      return;
    } catch (RemoteException remoteException) {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try {
        paramzzcyp.zzb(new zzcyw());
        return;
      } catch (RemoteException remoteException1) {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", (Throwable)remoteException);
        return;
      } 
    } 
  }
  
  protected final Bundle zzabt() {
    String str = this.zzfwf.zzehh;
    if (!((zzd)this).mContext.getPackageName().equals(str))
      this.zzklx.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzfwf.zzehh); 
    return this.zzklx;
  }
  
  public final boolean zzacc() {
    return this.zzklw;
  }
  
  public final void zzbet() {
    try {
      ((zzcyr)zzalw()).zzev(this.zzgft.intValue());
      return;
    } catch (RemoteException remoteException) {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
      return;
    } 
  }
  
  protected final String zzhm() {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected final String zzhn() {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */