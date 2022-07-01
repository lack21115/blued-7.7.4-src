package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.api.internal.zaci;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public abstract class GoogleApiClient {
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  
  private static final Set<GoogleApiClient> zaa = Collections.newSetFromMap(new WeakHashMap<GoogleApiClient, Boolean>());
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    // Byte code:
    //   0: getstatic com/google/android/gms/common/api/GoogleApiClient.zaa : Ljava/util/Set;
    //   3: astore #5
    //   5: aload #5
    //   7: monitorenter
    //   8: iconst_0
    //   9: istore #4
    //   11: aload_0
    //   12: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   15: ldc '  '
    //   17: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   20: astore #6
    //   22: getstatic com/google/android/gms/common/api/GoogleApiClient.zaa : Ljava/util/Set;
    //   25: invokeinterface iterator : ()Ljava/util/Iterator;
    //   30: astore #7
    //   32: aload #7
    //   34: invokeinterface hasNext : ()Z
    //   39: ifeq -> 88
    //   42: aload #7
    //   44: invokeinterface next : ()Ljava/lang/Object;
    //   49: checkcast com/google/android/gms/common/api/GoogleApiClient
    //   52: astore #8
    //   54: aload_2
    //   55: aload_0
    //   56: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   59: ldc 'GoogleApiClient#'
    //   61: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   64: iload #4
    //   66: invokevirtual println : (I)V
    //   69: aload #8
    //   71: aload #6
    //   73: aload_1
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   79: iload #4
    //   81: iconst_1
    //   82: iadd
    //   83: istore #4
    //   85: goto -> 32
    //   88: aload #5
    //   90: monitorexit
    //   91: return
    //   92: astore_0
    //   93: aload #5
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   11	32	92	finally
    //   32	79	92	finally
    //   88	91	92	finally
    //   93	96	92	finally
  }
  
  public static Set<GoogleApiClient> getAllClients() {
    synchronized (zaa) {
      return zaa;
    } 
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public <A extends Api.AnyClient, R extends Result, T extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT) {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.AnyClient, T extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT) {
    throw new UnsupportedOperationException();
  }
  
  public <C extends Api.Client> C getClient(Api.AnyClientKey<C> paramAnyClientKey) {
    throw new UnsupportedOperationException();
  }
  
  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);
  
  public Context getContext() {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper() {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasApi(Api<?> paramApi) {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener) {
    throw new UnsupportedOperationException();
  }
  
  public void maybeSignOut() {
    throw new UnsupportedOperationException();
  }
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public <L> ListenerHolder<L> registerListener(L paramL) {
    throw new UnsupportedOperationException();
  }
  
  public abstract void stopAutoManage(FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public void zaa(zaci paramzaci) {
    throw new UnsupportedOperationException();
  }
  
  public void zab(zaci paramzaci) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static final class Builder {
    private Account zaa;
    
    private final Set<Scope> zab = new HashSet<Scope>();
    
    private final Set<Scope> zac = new HashSet<Scope>();
    
    private int zad;
    
    private View zae;
    
    private String zaf;
    
    private String zag;
    
    private final Map<Api<?>, ClientSettings.zaa> zah = (Map<Api<?>, ClientSettings.zaa>)new ArrayMap();
    
    private boolean zai = false;
    
    private final Context zaj;
    
    private final Map<Api<?>, Api.ApiOptions> zak = (Map<Api<?>, Api.ApiOptions>)new ArrayMap();
    
    private LifecycleActivity zal;
    
    private int zam = -1;
    
    private GoogleApiClient.OnConnectionFailedListener zan;
    
    private Looper zao;
    
    private GoogleApiAvailability zap = GoogleApiAvailability.getInstance();
    
    private Api.AbstractClientBuilder<? extends zad, SignInOptions> zaq = zaa.zaa;
    
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zar = new ArrayList<GoogleApiClient.ConnectionCallbacks>();
    
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zas = new ArrayList<GoogleApiClient.OnConnectionFailedListener>();
    
    public Builder(Context param1Context) {
      this.zaj = param1Context;
      this.zao = param1Context.getMainLooper();
      this.zaf = param1Context.getPackageName();
      this.zag = param1Context.getClass().getName();
    }
    
    public Builder(Context param1Context, GoogleApiClient.ConnectionCallbacks param1ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      this(param1Context);
      Preconditions.checkNotNull(param1ConnectionCallbacks, "Must provide a connected listener");
      this.zar.add(param1ConnectionCallbacks);
      Preconditions.checkNotNull(param1OnConnectionFailedListener, "Must provide a connection failed listener");
      this.zas.add(param1OnConnectionFailedListener);
    }
    
    private final <O extends Api.ApiOptions> void zaa(Api<O> param1Api, O param1O, Scope... param1VarArgs) {
      HashSet<Scope> hashSet = new HashSet<Scope>(((Api.BaseClientBuilder)Preconditions.checkNotNull(param1Api.zaa(), "Base client builder must not be null")).getImpliedScopes(param1O));
      int j = param1VarArgs.length;
      int i;
      for (i = 0; i < j; i++)
        hashSet.add(param1VarArgs[i]); 
      this.zah.put(param1Api, new ClientSettings.zaa(hashSet));
    }
    
    public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> param1Api) {
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      this.zak.put(param1Api, null);
      List<Scope> list = ((Api.BaseClientBuilder)Preconditions.checkNotNull(param1Api.zaa(), "Base client builder must not be null")).getImpliedScopes(null);
      this.zac.addAll(list);
      this.zab.addAll(list);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> param1Api, O param1O) {
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      Preconditions.checkNotNull(param1O, "Null options are not permitted for this Api");
      this.zak.put(param1Api, (Api.ApiOptions)param1O);
      List<Scope> list = ((Api.BaseClientBuilder)Preconditions.checkNotNull(param1Api.zaa(), "Base client builder must not be null")).getImpliedScopes(param1O);
      this.zac.addAll(list);
      this.zab.addAll(list);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> param1Api, O param1O, Scope... param1VarArgs) {
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      Preconditions.checkNotNull(param1O, "Null options are not permitted for this Api");
      this.zak.put(param1Api, (Api.ApiOptions)param1O);
      zaa((Api)param1Api, (Api.ApiOptions)param1O, param1VarArgs);
      return this;
    }
    
    public final <T extends Api.ApiOptions.NotRequiredOptions> Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> param1Api, Scope... param1VarArgs) {
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      this.zak.put(param1Api, null);
      zaa(param1Api, null, param1VarArgs);
      return this;
    }
    
    public final Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks param1ConnectionCallbacks) {
      Preconditions.checkNotNull(param1ConnectionCallbacks, "Listener must not be null");
      this.zar.add(param1ConnectionCallbacks);
      return this;
    }
    
    public final Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      Preconditions.checkNotNull(param1OnConnectionFailedListener, "Listener must not be null");
      this.zas.add(param1OnConnectionFailedListener);
      return this;
    }
    
    public final Builder addScope(Scope param1Scope) {
      Preconditions.checkNotNull(param1Scope, "Scope must not be null");
      this.zab.add(param1Scope);
      return this;
    }
    
    public final Builder addScopeNames(String[] param1ArrayOfString) {
      for (int i = 0; i < param1ArrayOfString.length; i++)
        this.zab.add(new Scope(param1ArrayOfString[i])); 
      return this;
    }
    
    public final GoogleApiClient build() {
      String str;
      StringBuilder stringBuilder;
      Preconditions.checkArgument(this.zak.isEmpty() ^ true, "must call addApi() to add at least one API");
      ClientSettings clientSettings = buildClientSettings();
      Api api = null;
      Map map = clientSettings.zaa();
      ArrayMap<Api, Boolean> arrayMap = new ArrayMap();
      ArrayMap<Api.AnyClientKey<?>, zaq> arrayMap1 = new ArrayMap();
      ArrayList<zaq> arrayList = new ArrayList();
      Iterator<Api> iterator = this.zak.keySet().iterator();
      int i = 0;
      while (iterator.hasNext()) {
        boolean bool;
        Api api1 = iterator.next();
        Object object = this.zak.get(api1);
        if (map.get(api1) != null) {
          bool = true;
        } else {
          bool = false;
        } 
        arrayMap.put(api1, Boolean.valueOf(bool));
        zaq zaq = new zaq(api1, bool);
        arrayList.add(zaq);
        Api.AbstractClientBuilder abstractClientBuilder = (Api.AbstractClientBuilder)Preconditions.checkNotNull(api1.zab());
        zaq = (zaq)abstractClientBuilder.buildClient(this.zaj, this.zao, clientSettings, object, (GoogleApiClient.ConnectionCallbacks)zaq, (GoogleApiClient.OnConnectionFailedListener)zaq);
        arrayMap1.put(api1.zac(), zaq);
        int j = i;
        if (abstractClientBuilder.getPriority() == 1) {
          if (object != null) {
            i = 1;
          } else {
            i = 0;
          } 
          j = i;
        } 
        i = j;
        if (zaq.providesSignIn()) {
          if (api == null) {
            api = api1;
            i = j;
            continue;
          } 
          String str1 = api1.zad();
          str = api.zad();
          stringBuilder = new StringBuilder(String.valueOf(str1).length() + 21 + String.valueOf(str).length());
          stringBuilder.append(str1);
          stringBuilder.append(" cannot be used with ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } 
      if (str != null)
        if (!i) {
          boolean bool;
          if (this.zaa == null) {
            bool = true;
          } else {
            bool = false;
          } 
          Preconditions.checkState(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { str.zad() });
          Preconditions.checkState(this.zab.equals(this.zac), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { str.zad() });
        } else {
          str = str.zad();
          StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str).length() + 82);
          stringBuilder1.append("With using ");
          stringBuilder1.append(str);
          stringBuilder1.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
          throw new IllegalStateException(stringBuilder1.toString());
        }  
      i = zaar.zaa(arrayMap1.values(), true);
      null = new zaar(this.zaj, new ReentrantLock(), this.zao, (ClientSettings)stringBuilder, this.zap, this.zaq, (Map)arrayMap, this.zar, this.zas, (Map)arrayMap1, this.zam, i, arrayList);
      synchronized (GoogleApiClient.zaa()) {
        GoogleApiClient.zaa().add(null);
        if (this.zam >= 0)
          zai.zaa(this.zal).zaa(this.zam, (GoogleApiClient)null, this.zan); 
        return (GoogleApiClient)null;
      } 
    }
    
    public final ClientSettings buildClientSettings() {
      SignInOptions signInOptions = SignInOptions.zaa;
      if (this.zak.containsKey(zaa.zab))
        signInOptions = (SignInOptions)this.zak.get(zaa.zab); 
      return new ClientSettings(this.zaa, this.zab, this.zah, this.zad, this.zae, this.zaf, this.zag, signInOptions, false);
    }
    
    public final Builder enableAutoManage(FragmentActivity param1FragmentActivity, int param1Int, GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      boolean bool;
      LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity)param1FragmentActivity);
      if (param1Int >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "clientId must be non-negative");
      this.zam = param1Int;
      this.zan = param1OnConnectionFailedListener;
      this.zal = lifecycleActivity;
      return this;
    }
    
    public final Builder enableAutoManage(FragmentActivity param1FragmentActivity, GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      return enableAutoManage(param1FragmentActivity, 0, param1OnConnectionFailedListener);
    }
    
    public final Builder setAccountName(String param1String) {
      Account account;
      if (param1String == null) {
        param1String = null;
      } else {
        account = new Account(param1String, "com.google");
      } 
      this.zaa = account;
      return this;
    }
    
    public final Builder setGravityForPopups(int param1Int) {
      this.zad = param1Int;
      return this;
    }
    
    public final Builder setHandler(Handler param1Handler) {
      Preconditions.checkNotNull(param1Handler, "Handler must not be null");
      this.zao = param1Handler.getLooper();
      return this;
    }
    
    public final Builder setViewForPopups(View param1View) {
      Preconditions.checkNotNull(param1View, "View must not be null");
      this.zae = param1View;
      return this;
    }
    
    public final Builder useDefaultAccount() {
      return setAccountName("<<default account>>");
    }
  }
  
  @Deprecated
  public static interface ConnectionCallbacks extends ConnectionCallbacks {
    public static final int CAUSE_NETWORK_LOST = 2;
    
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
  }
  
  @Deprecated
  public static interface OnConnectionFailedListener extends OnConnectionFailedListener {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */