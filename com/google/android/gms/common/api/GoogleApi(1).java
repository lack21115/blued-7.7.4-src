package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zabi;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.api.internal.zay;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ConcurrentModificationException;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
  private final Context zaa;
  
  private final String zab;
  
  private final Api<O> zac;
  
  private final O zad;
  
  private final ApiKey<O> zae;
  
  private final Looper zaf;
  
  private final int zag;
  
  @NotOnlyInitialized
  private final GoogleApiClient zah;
  
  private final StatusExceptionMapper zai;
  
  private final GoogleApiManager zaj;
  
  public GoogleApi(Activity paramActivity, Api<O> paramApi, O paramO, Settings paramSettings) {
    Preconditions.checkNotNull(paramActivity, "Null activity is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    this.zaa = paramActivity.getApplicationContext();
    this.zab = zaa(paramActivity);
    this.zac = paramApi;
    this.zad = paramO;
    this.zaf = paramSettings.zab;
    this.zae = ApiKey.getSharedApiKey(this.zac, (Api.ApiOptions)this.zad);
    this.zah = (GoogleApiClient)new zabi(this);
    this.zaj = GoogleApiManager.zaa(this.zaa);
    this.zag = this.zaj.zab();
    this.zai = paramSettings.zaa;
    if (!(paramActivity instanceof GoogleApiActivity))
      try {
        zay.zaa(paramActivity, this.zaj, this.zae);
      } catch (ConcurrentModificationException|IllegalStateException concurrentModificationException) {} 
    this.zaj.zaa(this);
  }
  
  @Deprecated
  public GoogleApi(Activity paramActivity, Api<O> paramApi, O paramO, StatusExceptionMapper paramStatusExceptionMapper) {
    this(paramActivity, paramApi, paramO, (new Settings.Builder()).setMapper(paramStatusExceptionMapper).setLooper(paramActivity.getMainLooper()).build());
  }
  
  @Deprecated
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, Looper paramLooper, StatusExceptionMapper paramStatusExceptionMapper) {
    this(paramContext, paramApi, paramO, (new Settings.Builder()).setLooper(paramLooper).setMapper(paramStatusExceptionMapper).build());
  }
  
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, Settings paramSettings) {
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    this.zaa = paramContext.getApplicationContext();
    this.zab = zaa(paramContext);
    this.zac = paramApi;
    this.zad = paramO;
    this.zaf = paramSettings.zab;
    this.zae = ApiKey.getSharedApiKey(this.zac, (Api.ApiOptions)this.zad);
    this.zah = (GoogleApiClient)new zabi(this);
    this.zaj = GoogleApiManager.zaa(this.zaa);
    this.zag = this.zaj.zab();
    this.zai = paramSettings.zaa;
    this.zaj.zaa(this);
  }
  
  @Deprecated
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, StatusExceptionMapper paramStatusExceptionMapper) {
    this(paramContext, paramApi, paramO, (new Settings.Builder()).setMapper(paramStatusExceptionMapper).build());
  }
  
  private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaa(int paramInt, T paramT) {
    paramT.zab();
    this.zaj.zaa(this, paramInt, (BaseImplementation.ApiMethodImpl)paramT);
    return paramT;
  }
  
  private final <TResult, A extends Api.AnyClient> Task<TResult> zaa(int paramInt, TaskApiCall<A, TResult> paramTaskApiCall) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.zaj.zaa(this, paramInt, paramTaskApiCall, taskCompletionSource, this.zai);
    return taskCompletionSource.getTask();
  }
  
  private static String zaa(Object paramObject) {
    if (PlatformVersion.isAtLeastR())
      try {
        return (String)Context.class.getMethod("getAttributionTag", new Class[0]).invoke(paramObject, new Object[0]);
      } catch (NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException noSuchMethodException) {} 
    return null;
  }
  
  public GoogleApiClient asGoogleApiClient() {
    return this.zah;
  }
  
  protected ClientSettings.Builder createClientSettingsBuilder() {
    // Byte code:
    //   0: new com/google/android/gms/common/internal/ClientSettings$Builder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield zad : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   12: astore_1
    //   13: aload_1
    //   14: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   17: ifeq -> 42
    //   20: aload_1
    //   21: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   24: invokeinterface getGoogleSignInAccount : ()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull -> 42
    //   34: aload_1
    //   35: invokevirtual getAccount : ()Landroid/accounts/Account;
    //   38: astore_1
    //   39: goto -> 69
    //   42: aload_0
    //   43: getfield zad : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   46: astore_1
    //   47: aload_1
    //   48: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasAccountOptions
    //   51: ifeq -> 67
    //   54: aload_1
    //   55: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasAccountOptions
    //   58: invokeinterface getAccount : ()Landroid/accounts/Account;
    //   63: astore_1
    //   64: goto -> 69
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_2
    //   70: aload_1
    //   71: invokevirtual zaa : (Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/ClientSettings$Builder;
    //   74: astore_2
    //   75: aload_0
    //   76: getfield zad : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   79: astore_1
    //   80: aload_1
    //   81: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   84: ifeq -> 109
    //   87: aload_1
    //   88: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   91: invokeinterface getGoogleSignInAccount : ()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull -> 109
    //   101: aload_1
    //   102: invokevirtual getRequestedScopes : ()Ljava/util/Set;
    //   105: astore_1
    //   106: goto -> 113
    //   109: invokestatic emptySet : ()Ljava/util/Set;
    //   112: astore_1
    //   113: aload_2
    //   114: aload_1
    //   115: invokevirtual zaa : (Ljava/util/Collection;)Lcom/google/android/gms/common/internal/ClientSettings$Builder;
    //   118: aload_0
    //   119: getfield zaa : Landroid/content/Context;
    //   122: invokevirtual getClass : ()Ljava/lang/Class;
    //   125: invokevirtual getName : ()Ljava/lang/String;
    //   128: invokevirtual zaa : (Ljava/lang/String;)Lcom/google/android/gms/common/internal/ClientSettings$Builder;
    //   131: aload_0
    //   132: getfield zaa : Landroid/content/Context;
    //   135: invokevirtual getPackageName : ()Ljava/lang/String;
    //   138: invokevirtual setRealClientPackageName : (Ljava/lang/String;)Lcom/google/android/gms/common/internal/ClientSettings$Builder;
    //   141: areturn
  }
  
  protected Task<Boolean> disconnectService() {
    return this.zaj.zab(this);
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T paramT) {
    return zaa(2, paramT);
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> paramTaskApiCall) {
    return zaa(2, paramTaskApiCall);
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T paramT) {
    return zaa(0, paramT);
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> paramTaskApiCall) {
    return zaa(0, paramTaskApiCall);
  }
  
  @Deprecated
  public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T paramT, U paramU) {
    Preconditions.checkNotNull(paramT);
    Preconditions.checkNotNull(paramU);
    Preconditions.checkNotNull(paramT.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramU.getListenerKey(), "Listener has already been released.");
    Preconditions.checkArgument(Objects.equal(paramT.getListenerKey(), paramU.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return this.zaj.zaa(this, (RegisterListenerMethod)paramT, (UnregisterListenerMethod)paramU, zac.zaa);
  }
  
  public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> paramRegistrationMethods) {
    Preconditions.checkNotNull(paramRegistrationMethods);
    Preconditions.checkNotNull(paramRegistrationMethods.zaa.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramRegistrationMethods.zab.getListenerKey(), "Listener has already been released.");
    return this.zaj.zaa(this, paramRegistrationMethods.zaa, paramRegistrationMethods.zab, paramRegistrationMethods.zac);
  }
  
  public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> paramListenerKey) {
    Preconditions.checkNotNull(paramListenerKey, "Listener key cannot be null.");
    return this.zaj.zaa(this, paramListenerKey);
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T paramT) {
    return zaa(1, paramT);
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> paramTaskApiCall) {
    return zaa(1, paramTaskApiCall);
  }
  
  public ApiKey<O> getApiKey() {
    return this.zae;
  }
  
  public O getApiOptions() {
    return this.zad;
  }
  
  public Context getApplicationContext() {
    return this.zaa;
  }
  
  protected String getContextAttributionTag() {
    return this.zab;
  }
  
  @Deprecated
  protected String getContextFeatureId() {
    return this.zab;
  }
  
  public Looper getLooper() {
    return this.zaf;
  }
  
  public <L> ListenerHolder<L> registerListener(L paramL, String paramString) {
    return ListenerHolders.createListenerHolder(paramL, this.zaf, paramString);
  }
  
  public final int zaa() {
    return this.zag;
  }
  
  public final Api.Client zaa(Looper paramLooper, GoogleApiManager.zaa<O> paramzaa) {
    ClientSettings clientSettings = createClientSettingsBuilder().build();
    return ((Api.AbstractClientBuilder<Api.Client, O>)Preconditions.checkNotNull(this.zac.zab())).buildClient(this.zaa, paramLooper, clientSettings, this.zad, (GoogleApiClient.ConnectionCallbacks)paramzaa, (GoogleApiClient.OnConnectionFailedListener)paramzaa);
  }
  
  public final zacc zaa(Context paramContext, Handler paramHandler) {
    return new zacc(paramContext, paramHandler, createClientSettingsBuilder().build());
  }
  
  public static class Settings {
    public static final Settings DEFAULT_SETTINGS = (new Builder()).build();
    
    public final StatusExceptionMapper zaa;
    
    public final Looper zab;
    
    private Settings(StatusExceptionMapper param1StatusExceptionMapper, Account param1Account, Looper param1Looper) {
      this.zaa = param1StatusExceptionMapper;
      this.zab = param1Looper;
    }
    
    public static class Builder {
      private StatusExceptionMapper zaa;
      
      private Looper zab;
      
      public GoogleApi.Settings build() {
        if (this.zaa == null)
          this.zaa = (StatusExceptionMapper)new ApiExceptionMapper(); 
        if (this.zab == null)
          this.zab = Looper.getMainLooper(); 
        return new GoogleApi.Settings(this.zaa, null, this.zab, null);
      }
      
      public Builder setLooper(Looper param2Looper) {
        Preconditions.checkNotNull(param2Looper, "Looper must not be null.");
        this.zab = param2Looper;
        return this;
      }
      
      public Builder setMapper(StatusExceptionMapper param2StatusExceptionMapper) {
        Preconditions.checkNotNull(param2StatusExceptionMapper, "StatusExceptionMapper must not be null.");
        this.zaa = param2StatusExceptionMapper;
        return this;
      }
    }
  }
  
  public static class Builder {
    private StatusExceptionMapper zaa;
    
    private Looper zab;
    
    public GoogleApi.Settings build() {
      if (this.zaa == null)
        this.zaa = (StatusExceptionMapper)new ApiExceptionMapper(); 
      if (this.zab == null)
        this.zab = Looper.getMainLooper(); 
      return new GoogleApi.Settings(this.zaa, null, this.zab, null);
    }
    
    public Builder setLooper(Looper param1Looper) {
      Preconditions.checkNotNull(param1Looper, "Looper must not be null.");
      this.zab = param1Looper;
      return this;
    }
    
    public Builder setMapper(StatusExceptionMapper param1StatusExceptionMapper) {
      Preconditions.checkNotNull(param1StatusExceptionMapper, "StatusExceptionMapper must not be null.");
      this.zaa = param1StatusExceptionMapper;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\GoogleApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */