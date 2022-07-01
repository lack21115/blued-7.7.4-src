package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends Api.ApiOptions> {
  private final AbstractClientBuilder<?, O> zaa;
  
  private final zac<?, O> zab;
  
  private final ClientKey<?> zac;
  
  private final zab<?> zad;
  
  private final String zae;
  
  public <C extends Client> Api(String paramString, AbstractClientBuilder<C, O> paramAbstractClientBuilder, ClientKey<C> paramClientKey) {
    Preconditions.checkNotNull(paramAbstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
    Preconditions.checkNotNull(paramClientKey, "Cannot construct an Api with a null ClientKey");
    this.zae = paramString;
    this.zaa = paramAbstractClientBuilder;
    this.zab = null;
    this.zac = paramClientKey;
    this.zad = null;
  }
  
  public final BaseClientBuilder<?, O> zaa() {
    return (BaseClientBuilder<?, O>)Preconditions.checkNotNull(this.zaa);
  }
  
  public final AbstractClientBuilder<?, O> zab() {
    boolean bool;
    if (this.zaa != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
    return this.zaa;
  }
  
  public final AnyClientKey<?> zac() {
    ClientKey<?> clientKey = this.zac;
    if (clientKey != null)
      return clientKey; 
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
  
  public final String zad() {
    return this.zae;
  }
  
  public static class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
    @Deprecated
    public T buildClient(Context param1Context, Looper param1Looper, ClientSettings param1ClientSettings, O param1O, GoogleApiClient.ConnectionCallbacks param1ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      return buildClient(param1Context, param1Looper, param1ClientSettings, param1O, param1ConnectionCallbacks, param1OnConnectionFailedListener);
    }
    
    public T buildClient(Context param1Context, Looper param1Looper, ClientSettings param1ClientSettings, O param1O, ConnectionCallbacks param1ConnectionCallbacks, OnConnectionFailedListener param1OnConnectionFailedListener) {
      throw new UnsupportedOperationException("buildClient must be implemented");
    }
  }
  
  public static interface AnyClient {}
  
  public static class AnyClientKey<C extends AnyClient> {}
  
  public static interface ApiOptions {
    public static final NoOptions NO_OPTIONS = new NoOptions(null);
    
    public static interface HasAccountOptions extends HasOptions, NotRequiredOptions {
      Account getAccount();
    }
    
    public static interface HasGoogleSignInAccountOptions extends HasOptions {
      GoogleSignInAccount getGoogleSignInAccount();
    }
    
    public static interface HasOptions extends ApiOptions {}
    
    public static final class NoOptions implements NotRequiredOptions {
      private NoOptions() {}
    }
    
    public static interface NotRequiredOptions extends ApiOptions {}
    
    public static interface Optional extends HasOptions, NotRequiredOptions {}
  }
  
  public static interface HasAccountOptions extends ApiOptions.HasOptions, ApiOptions.NotRequiredOptions {
    Account getAccount();
  }
  
  public static interface HasGoogleSignInAccountOptions extends ApiOptions.HasOptions {
    GoogleSignInAccount getGoogleSignInAccount();
  }
  
  public static interface HasOptions extends ApiOptions {}
  
  public static final class NoOptions implements ApiOptions.NotRequiredOptions {
    private NoOptions() {}
  }
  
  public static interface NotRequiredOptions extends ApiOptions {}
  
  public static interface Optional extends ApiOptions.HasOptions, ApiOptions.NotRequiredOptions {}
  
  public static class BaseClientBuilder<T extends AnyClient, O> {
    public static final int API_PRIORITY_GAMES = 1;
    
    public static final int API_PRIORITY_OTHER = 2147483647;
    
    public static final int API_PRIORITY_PLUS = 2;
    
    public List<Scope> getImpliedScopes(O param1O) {
      return Collections.emptyList();
    }
    
    public int getPriority() {
      return Integer.MAX_VALUE;
    }
  }
  
  public static interface Client extends AnyClient {
    void connect(BaseGmsClient.ConnectionProgressReportCallbacks param1ConnectionProgressReportCallbacks);
    
    void disconnect();
    
    void disconnect(String param1String);
    
    void dump(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString);
    
    Feature[] getAvailableFeatures();
    
    String getEndpointPackageName();
    
    String getLastDisconnectMessage();
    
    int getMinApkVersion();
    
    void getRemoteService(IAccountAccessor param1IAccountAccessor, Set<Scope> param1Set);
    
    Feature[] getRequiredFeatures();
    
    Set<Scope> getScopesForConnectionlessNonSignIn();
    
    IBinder getServiceBrokerBinder();
    
    Intent getSignInIntent();
    
    boolean isConnected();
    
    boolean isConnecting();
    
    void onUserSignOut(BaseGmsClient.SignOutCallbacks param1SignOutCallbacks);
    
    boolean providesSignIn();
    
    boolean requiresAccount();
    
    boolean requiresGooglePlayServices();
    
    boolean requiresSignIn();
  }
  
  public static final class ClientKey<C extends Client> extends AnyClientKey<C> {}
  
  public static interface zaa<T extends IInterface> extends AnyClient {}
  
  public static final class zab<C extends zaa<? extends IInterface>> extends AnyClientKey<C> {}
  
  public static class zac<T extends zaa<? extends IInterface>, O> extends BaseClientBuilder<T, O> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */