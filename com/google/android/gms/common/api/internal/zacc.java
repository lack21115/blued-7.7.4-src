package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zau;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zam;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zacc extends zad implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
  private static Api.AbstractClientBuilder<? extends zad, SignInOptions> zaa = zaa.zaa;
  
  private final Context zab;
  
  private final Handler zac;
  
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zad;
  
  private Set<Scope> zae;
  
  private ClientSettings zaf;
  
  private zad zag;
  
  private zacd zah;
  
  public zacc(Context paramContext, Handler paramHandler, ClientSettings paramClientSettings) {
    this(paramContext, paramHandler, paramClientSettings, zaa);
  }
  
  private zacc(Context paramContext, Handler paramHandler, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder) {
    this.zab = paramContext;
    this.zac = paramHandler;
    this.zaf = (ClientSettings)Preconditions.checkNotNull(paramClientSettings, "ClientSettings must not be null");
    this.zae = paramClientSettings.getRequiredScopes();
    this.zad = paramAbstractClientBuilder;
  }
  
  private final void zab(zam paramzam) {
    String str;
    ConnectionResult connectionResult = paramzam.zaa();
    if (connectionResult.isSuccess()) {
      zau zau = (zau)Preconditions.checkNotNull(paramzam.zab());
      ConnectionResult connectionResult1 = zau.zab();
      if (!connectionResult1.isSuccess()) {
        str = String.valueOf(connectionResult1);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 48);
        stringBuilder.append("Sign-in succeeded with resolve account failure: ");
        stringBuilder.append(str);
        Log.wtf("SignInCoordinator", stringBuilder.toString(), new Exception());
        this.zah.zaa(connectionResult1);
        this.zag.disconnect();
        return;
      } 
      this.zah.zaa(str.zaa(), this.zae);
    } else {
      this.zah.zaa((ConnectionResult)str);
    } 
    this.zag.disconnect();
  }
  
  public final void onConnected(Bundle paramBundle) {
    this.zag.zaa((zac)this);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    this.zah.zaa(paramConnectionResult);
  }
  
  public final void onConnectionSuspended(int paramInt) {
    this.zag.disconnect();
  }
  
  public final void zaa() {
    zad zad1 = this.zag;
    if (zad1 != null)
      zad1.disconnect(); 
  }
  
  public final void zaa(zacd paramzacd) {
    zad zad1 = this.zag;
    if (zad1 != null)
      zad1.disconnect(); 
    this.zaf.zaa(Integer.valueOf(System.identityHashCode(this)));
    Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.zad;
    Context context = this.zab;
    Looper looper = this.zac.getLooper();
    ClientSettings clientSettings = this.zaf;
    this.zag = (zad)abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.zac(), this, this);
    this.zah = paramzacd;
    Set<Scope> set = this.zae;
    if (set == null || set.isEmpty()) {
      this.zac.post(new zacb(this));
      return;
    } 
    this.zag.zab();
  }
  
  public final void zaa(zam paramzam) {
    this.zac.post(new zace(this, paramzam));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zacc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */