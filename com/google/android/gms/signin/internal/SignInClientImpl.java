package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

public class SignInClientImpl extends GmsClient<zae> implements zad {
  private final boolean zaa;
  
  private final ClientSettings zab;
  
  private final Bundle zac;
  
  private final Integer zad;
  
  public SignInClientImpl(Context paramContext, Looper paramLooper, boolean paramBoolean, ClientSettings paramClientSettings, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramLooper, 44, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zaa = paramBoolean;
    this.zab = paramClientSettings;
    this.zac = paramBundle;
    this.zad = paramClientSettings.zad();
  }
  
  public SignInClientImpl(Context paramContext, Looper paramLooper, boolean paramBoolean, ClientSettings paramClientSettings, SignInOptions paramSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, true, paramClientSettings, createBundleFromClientSettings(paramClientSettings), paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public static Bundle createBundleFromClientSettings(ClientSettings paramClientSettings) {
    SignInOptions signInOptions = paramClientSettings.zac();
    Integer integer = paramClientSettings.zad();
    Bundle bundle = new Bundle();
    bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", (Parcelable)paramClientSettings.getAccount());
    if (integer != null)
      bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", integer.intValue()); 
    if (signInOptions != null) {
      bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", signInOptions.zaa());
      bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", signInOptions.zab());
      bundle.putString("com.google.android.gms.signin.internal.serverClientId", signInOptions.zac());
      bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", signInOptions.zad());
      bundle.putString("com.google.android.gms.signin.internal.hostedDomain", signInOptions.zae());
      bundle.putString("com.google.android.gms.signin.internal.logSessionId", signInOptions.zaf());
      bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", signInOptions.zag());
      Long long_ = signInOptions.zah();
      if (long_ != null)
        bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", long_.longValue()); 
      long_ = signInOptions.zai();
      if (long_ != null)
        bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", long_.longValue()); 
    } 
    return bundle;
  }
  
  public Bundle getGetServiceRequestExtraArgs() {
    String str = this.zab.getRealClientPackageName();
    if (!getContext().getPackageName().equals(str))
      this.zac.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zab.getRealClientPackageName()); 
    return this.zac;
  }
  
  public int getMinApkVersion() {
    return 12451000;
  }
  
  public String getServiceDescriptor() {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public String getStartServiceAction() {
    return "com.google.android.gms.signin.service.START";
  }
  
  public boolean requiresSignIn() {
    return this.zaa;
  }
  
  public final void zaa() {
    try {
      ((zae)getService()).zaa(((Integer)Preconditions.checkNotNull(this.zad)).intValue());
      return;
    } catch (RemoteException remoteException) {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
      return;
    } 
  }
  
  public final void zaa(IAccountAccessor paramIAccountAccessor, boolean paramBoolean) {
    try {
      ((zae)getService()).zaa(paramIAccountAccessor, ((Integer)Preconditions.checkNotNull(this.zad)).intValue(), paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
      return;
    } 
  }
  
  public final void zaa(zac paramzac) {
    Preconditions.checkNotNull(paramzac, "Expecting a valid ISignInCallbacks");
    try {
      Account account = this.zab.getAccountOrDefault();
      GoogleSignInAccount googleSignInAccount = null;
      if ("<<default account>>".equals(account.name))
        googleSignInAccount = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount(); 
      zas zas = new zas(account, ((Integer)Preconditions.checkNotNull(this.zad)).intValue(), googleSignInAccount);
      ((zae)getService()).zaa(new zak(zas), paramzac);
      return;
    } catch (RemoteException remoteException) {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try {
        paramzac.zaa(new zam(8));
        return;
      } catch (RemoteException remoteException1) {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", (Throwable)remoteException);
        return;
      } 
    } 
  }
  
  public final void zab() {
    connect((BaseGmsClient.ConnectionProgressReportCallbacks)new BaseGmsClient.LegacyClientCallbackAdapter((BaseGmsClient)this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\internal\SignInClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */