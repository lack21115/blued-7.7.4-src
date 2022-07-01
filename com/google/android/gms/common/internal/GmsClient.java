package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, zai {
  private final ClientSettings zaa;
  
  private final Set<Scope> zab;
  
  private final Account zac;
  
  protected GmsClient(Context paramContext, Handler paramHandler, int paramInt, ClientSettings paramClientSettings) {
    this(paramContext, paramHandler, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, (GoogleApiClient.ConnectionCallbacks)null, (GoogleApiClient.OnConnectionFailedListener)null);
  }
  
  @Deprecated
  private GmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramHandler, paramGmsClientSupervisor, paramGoogleApiAvailability, paramInt, paramClientSettings, (ConnectionCallbacks)null, (OnConnectionFailedListener)null);
  }
  
  private GmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramHandler, paramGmsClientSupervisor, (GoogleApiAvailabilityLight)paramGoogleApiAvailability, paramInt, zaa((ConnectionCallbacks)null), zaa((OnConnectionFailedListener)null));
    this.zaa = Preconditions.<ClientSettings>checkNotNull(paramClientSettings);
    this.zac = paramClientSettings.getAccount();
    this.zab = zaa(paramClientSettings.getAllRequestedScopes());
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings) {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, (GoogleApiClient.ConnectionCallbacks)null, (GoogleApiClient.OnConnectionFailedListener)null);
  }
  
  @Deprecated
  public GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, paramInt, paramClientSettings, (ConnectionCallbacks)paramConnectionCallbacks, (OnConnectionFailedListener)paramOnConnectionFailedListener);
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, Preconditions.<ConnectionCallbacks>checkNotNull(paramConnectionCallbacks), Preconditions.<OnConnectionFailedListener>checkNotNull(paramOnConnectionFailedListener));
  }
  
  private GmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, paramGmsClientSupervisor, paramGoogleApiAvailability, paramInt, paramClientSettings, (ConnectionCallbacks)null, (OnConnectionFailedListener)null);
  }
  
  private GmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramLooper, paramGmsClientSupervisor, (GoogleApiAvailabilityLight)paramGoogleApiAvailability, paramInt, zaa(paramConnectionCallbacks), zaa(paramOnConnectionFailedListener), paramClientSettings.zab());
    this.zaa = paramClientSettings;
    this.zac = paramClientSettings.getAccount();
    this.zab = zaa(paramClientSettings.getAllRequestedScopes());
  }
  
  private static BaseGmsClient.BaseConnectionCallbacks zaa(ConnectionCallbacks paramConnectionCallbacks) {
    return (paramConnectionCallbacks == null) ? null : new zah(paramConnectionCallbacks);
  }
  
  private static BaseGmsClient.BaseOnConnectionFailedListener zaa(OnConnectionFailedListener paramOnConnectionFailedListener) {
    return (paramOnConnectionFailedListener == null) ? null : new zag(paramOnConnectionFailedListener);
  }
  
  private final Set<Scope> zaa(Set<Scope> paramSet) {
    Set<Scope> set = validateScopes(paramSet);
    Iterator<Scope> iterator = set.iterator();
    while (iterator.hasNext()) {
      if (paramSet.contains(iterator.next()))
        continue; 
      throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
    } 
    return set;
  }
  
  public final Account getAccount() {
    return this.zac;
  }
  
  protected final ClientSettings getClientSettings() {
    return this.zaa;
  }
  
  public Feature[] getRequiredFeatures() {
    return new Feature[0];
  }
  
  protected final Set<Scope> getScopes() {
    return this.zab;
  }
  
  public Set<Scope> getScopesForConnectionlessNonSignIn() {
    return requiresSignIn() ? this.zab : Collections.emptySet();
  }
  
  protected Set<Scope> validateScopes(Set<Scope> paramSet) {
    return paramSet;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\GmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */