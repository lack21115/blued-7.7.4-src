package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zai;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zaar extends GoogleApiClient implements zabn {
  final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zaa;
  
  final Map<Api.AnyClientKey<?>, Api.Client> zab;
  
  Set<Scope> zac;
  
  Set<zaci> zad;
  
  final zacn zae;
  
  private final Lock zaf;
  
  private final zaj zag;
  
  private zabm zah;
  
  private final int zai;
  
  private final Context zaj;
  
  private final Looper zak;
  
  private volatile boolean zal;
  
  private long zam;
  
  private long zan;
  
  private final zaau zao;
  
  private final GoogleApiAvailability zap;
  
  private zabl zaq;
  
  private final ClientSettings zar;
  
  private final Map<Api<?>, Boolean> zas;
  
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zat;
  
  private final ListenerHolders zau;
  
  private final ArrayList<zaq> zav;
  
  private Integer zaw;
  
  private final zai zax;
  
  public zaar(Context paramContext, Lock paramLock, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiAvailability paramGoogleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Map<Api<?>, Boolean> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, int paramInt1, int paramInt2, ArrayList<zaq> paramArrayList) {
    long l;
    this.zah = null;
    this.zaa = new LinkedList<BaseImplementation.ApiMethodImpl<?, ?>>();
    if (ClientLibraryUtils.isPackageSide()) {
      l = 10000L;
    } else {
      l = 120000L;
    } 
    this.zam = l;
    this.zan = 5000L;
    this.zac = new HashSet<Scope>();
    this.zau = new ListenerHolders();
    this.zaw = null;
    this.zad = null;
    this.zax = new zaaq(this);
    this.zaj = paramContext;
    this.zaf = paramLock;
    this.zag = new zaj(paramLooper, this.zax);
    this.zak = paramLooper;
    this.zao = new zaau(this, paramLooper);
    this.zap = paramGoogleApiAvailability;
    this.zai = paramInt1;
    if (this.zai >= 0)
      this.zaw = Integer.valueOf(paramInt2); 
    this.zas = paramMap;
    this.zab = paramMap1;
    this.zav = paramArrayList;
    this.zae = new zacn();
    for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : paramList)
      this.zag.zaa(connectionCallbacks); 
    for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : paramList1)
      this.zag.zaa(onConnectionFailedListener); 
    this.zar = paramClientSettings;
    this.zat = paramAbstractClientBuilder;
  }
  
  public static int zaa(Iterable<Api.Client> paramIterable, boolean paramBoolean) {
    Iterator<Api.Client> iterator = paramIterable.iterator();
    boolean bool2 = false;
    boolean bool1 = false;
    while (iterator.hasNext()) {
      Api.Client client = iterator.next();
      boolean bool = bool2;
      if (client.requiresSignIn())
        bool = true; 
      bool2 = bool;
      if (client.providesSignIn()) {
        bool1 = true;
        bool2 = bool;
      } 
    } 
    return bool2 ? ((bool1 && paramBoolean) ? 2 : 1) : 3;
  }
  
  private final void zaa(int paramInt) {
    Integer integer = this.zaw;
    if (integer == null) {
      this.zaw = Integer.valueOf(paramInt);
    } else if (integer.intValue() != paramInt) {
      String str1 = zab(paramInt);
      String str2 = zab(this.zaw.intValue());
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 51 + String.valueOf(str2).length());
      stringBuilder.append("Cannot use sign-in mode: ");
      stringBuilder.append(str1);
      stringBuilder.append(". Mode was already set to ");
      stringBuilder.append(str2);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    if (this.zah != null)
      return; 
    Iterator<Api.Client> iterator = this.zab.values().iterator();
    boolean bool = false;
    paramInt = 0;
    while (iterator.hasNext()) {
      Api.Client client = iterator.next();
      boolean bool1 = bool;
      if (client.requiresSignIn())
        bool1 = true; 
      bool = bool1;
      if (client.providesSignIn()) {
        paramInt = 1;
        bool = bool1;
      } 
    } 
    int i = this.zaw.intValue();
    if (i != 1) {
      if (i == 2 && bool) {
        this.zah = zas.zaa(this.zaj, this, this.zaf, this.zak, (GoogleApiAvailabilityLight)this.zap, this.zab, this.zar, this.zas, this.zat, this.zav);
        return;
      } 
    } else if (bool) {
      if (paramInt != 0)
        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead."); 
    } else {
      throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
    } 
    this.zah = new zaaz(this.zaj, this, this.zaf, this.zak, (GoogleApiAvailabilityLight)this.zap, this.zab, this.zar, this.zas, this.zat, this.zav, (zabn)this);
  }
  
  private final void zaa(GoogleApiClient paramGoogleApiClient, StatusPendingResult paramStatusPendingResult, boolean paramBoolean) {
    Common.zaa.zaa(paramGoogleApiClient).setResultCallback(new zaav(this, paramStatusPendingResult, paramBoolean, paramGoogleApiClient));
  }
  
  private static String zab(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? "UNKNOWN" : "SIGN_IN_MODE_NONE") : "SIGN_IN_MODE_OPTIONAL") : "SIGN_IN_MODE_REQUIRED";
  }
  
  private final void zad() {
    this.zag.zab();
    ((zabm)Preconditions.checkNotNull(this.zah)).zaa();
  }
  
  private final void zae() {
    this.zaf.lock();
    try {
      if (this.zal)
        zad(); 
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  private final void zaf() {
    this.zaf.lock();
    try {
      if (zab())
        zad(); 
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  private final boolean zag() {
    this.zaf.lock();
    try {
      Set<zaci> set = this.zad;
      if (set == null)
        return false; 
      boolean bool = this.zad.isEmpty();
      return bool ^ true;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final ConnectionResult blockingConnect() {
    boolean bool1;
    null = Looper.myLooper();
    Looper looper = Looper.getMainLooper();
    boolean bool2 = true;
    if (null != looper) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkState(bool1, "blockingConnect must not be called on the UI thread");
    this.zaf.lock();
    try {
      if (this.zai >= 0) {
        if (this.zaw != null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        } 
        Preconditions.checkState(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
      } else if (this.zaw == null) {
        this.zaw = Integer.valueOf(zaa(this.zab.values(), false));
      } else if (this.zaw.intValue() == 2) {
        throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      } 
      zaa(((Integer)Preconditions.checkNotNull(this.zaw)).intValue());
      this.zag.zab();
      return ((zabm)Preconditions.checkNotNull(this.zah)).zab();
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "blockingConnect must not be called on the UI thread");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    this.zaf.lock();
    try {
      if (this.zaw == null) {
        this.zaw = Integer.valueOf(zaa(this.zab.values(), false));
      } else if (this.zaw.intValue() == 2) {
        throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      } 
      zaa(((Integer)Preconditions.checkNotNull(this.zaw)).intValue());
      this.zag.zab();
      return ((zabm)Preconditions.checkNotNull(this.zah)).zaa(paramLong, paramTimeUnit);
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final PendingResult<Status> clearDefaultAccountAndReconnect() {
    boolean bool;
    Preconditions.checkState(super.isConnected(), "GoogleApiClient is not connected yet.");
    Integer integer = this.zaw;
    if (integer == null || integer.intValue() != 2) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
    StatusPendingResult statusPendingResult = new StatusPendingResult(this);
    if (this.zab.containsKey(Common.CLIENT_KEY)) {
      zaa(this, statusPendingResult, false);
      return statusPendingResult;
    } 
    AtomicReference<GoogleApiClient> atomicReference = new AtomicReference();
    zaat zaat = new zaat(this, atomicReference, statusPendingResult);
    zaas zaas = new zaas(this, statusPendingResult);
    GoogleApiClient googleApiClient = (new GoogleApiClient.Builder(this.zaj)).addApi(Common.API).addConnectionCallbacks(zaat).addOnConnectionFailedListener(zaas).setHandler((Handler)this.zao).build();
    atomicReference.set(googleApiClient);
    googleApiClient.connect();
    return statusPendingResult;
  }
  
  public final void connect() {
    this.zaf.lock();
    try {
      int i = this.zai;
      boolean bool = false;
      if (i >= 0) {
        if (this.zaw != null)
          bool = true; 
        Preconditions.checkState(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      } else if (this.zaw == null) {
        this.zaw = Integer.valueOf(zaa(this.zab.values(), false));
      } else if (this.zaw.intValue() == 2) {
        throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      } 
      super.connect(((Integer)Preconditions.checkNotNull(this.zaw)).intValue());
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final void connect(int paramInt) {
    this.zaf.lock();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 3) {
      bool1 = bool2;
      if (paramInt != 1)
        if (paramInt == 2) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }  
    } 
    try {
      StringBuilder stringBuilder = new StringBuilder(33);
      stringBuilder.append("Illegal sign-in mode: ");
      stringBuilder.append(paramInt);
      Preconditions.checkArgument(bool1, stringBuilder.toString());
      zaa(paramInt);
      zad();
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final void disconnect() {
    this.zaf.lock();
    try {
      this.zae.zaa();
      if (this.zah != null)
        this.zah.zac(); 
      this.zau.zaa();
      for (BaseImplementation.ApiMethodImpl<?, ?> apiMethodImpl : this.zaa) {
        apiMethodImpl.zaa((zaco)null);
        apiMethodImpl.cancel();
      } 
      this.zaa.clear();
      zabm zabm1 = this.zah;
      if (zabm1 == null)
        return; 
      zab();
      this.zag.zaa();
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.append(paramString).append("mContext=").println(this.zaj);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zal);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
    zacn zacn1 = this.zae;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(zacn1.zab.size());
    zabm zabm1 = this.zah;
    if (zabm1 != null)
      zabm1.zaa(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString); 
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT) {
    String str;
    Api<?> api = paramT.getApi();
    boolean bool = this.zab.containsKey(paramT.getClientKey());
    if (api != null) {
      str = api.zad();
    } else {
      str = "the API";
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 65);
    stringBuilder.append("GoogleApiClient is not configured to use ");
    stringBuilder.append(str);
    stringBuilder.append(" required for this call.");
    Preconditions.checkArgument(bool, stringBuilder.toString());
    this.zaf.lock();
    try {
      if (this.zah == null) {
        this.zaa.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
        return paramT;
      } 
      paramT = this.zah.zaa(paramT);
      return paramT;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT) {
    String str;
    Api<?> api = paramT.getApi();
    boolean bool = this.zab.containsKey(paramT.getClientKey());
    if (api != null) {
      str = api.zad();
    } else {
      str = "the API";
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 65);
    stringBuilder.append("GoogleApiClient is not configured to use ");
    stringBuilder.append(str);
    stringBuilder.append(" required for this call.");
    Preconditions.checkArgument(bool, stringBuilder.toString());
    this.zaf.lock();
    try {
      zabm zabm1 = this.zah;
      if (zabm1 != null) {
        BaseImplementation.ApiMethodImpl<? extends Result> apiMethodImpl;
        if (this.zal) {
          this.zaa.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
          while (!this.zaa.isEmpty()) {
            apiMethodImpl = (BaseImplementation.ApiMethodImpl)this.zaa.remove();
            this.zae.zaa(apiMethodImpl);
            apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
          } 
          return paramT;
        } 
        paramT = apiMethodImpl.zab(paramT);
        return paramT;
      } 
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> paramAnyClientKey) {
    Api.Client client = this.zab.get(paramAnyClientKey);
    Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
    return (C)client;
  }
  
  public final ConnectionResult getConnectionResult(Api<?> paramApi) {
    this.zaf.lock();
    try {
      if (super.isConnected() || this.zal) {
        ConnectionResult connectionResult;
        if (this.zab.containsKey(paramApi.zac())) {
          ConnectionResult connectionResult1 = ((zabm)Preconditions.checkNotNull(this.zah)).zaa(paramApi);
          if (connectionResult1 == null) {
            if (this.zal) {
              connectionResult = ConnectionResult.RESULT_SUCCESS;
              return connectionResult;
            } 
            Log.w("GoogleApiClientImpl", zac());
            Log.wtf("GoogleApiClientImpl", String.valueOf(connectionResult.zad()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
            connectionResult = new ConnectionResult(8, null);
            return connectionResult;
          } 
          return connectionResult1;
        } 
        throw new IllegalArgumentException(String.valueOf(connectionResult.zad()).concat(" was never registered with GoogleApiClient"));
      } 
      throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final Context getContext() {
    return this.zaj;
  }
  
  public final Looper getLooper() {
    return this.zak;
  }
  
  public final boolean hasApi(Api<?> paramApi) {
    return this.zab.containsKey(paramApi.zac());
  }
  
  public final boolean hasConnectedApi(Api<?> paramApi) {
    if (!super.isConnected())
      return false; 
    Api.Client client = this.zab.get(paramApi.zac());
    return (client != null && client.isConnected());
  }
  
  public final boolean isConnected() {
    zabm zabm1 = this.zah;
    return (zabm1 != null && zabm1.zad());
  }
  
  public final boolean isConnecting() {
    zabm zabm1 = this.zah;
    return (zabm1 != null && zabm1.zae());
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    return this.zag.zab(paramConnectionCallbacks);
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    return this.zag.zab(paramOnConnectionFailedListener);
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener) {
    zabm zabm1 = this.zah;
    return (zabm1 != null && zabm1.zaa(paramSignInConnectionListener));
  }
  
  public final void maybeSignOut() {
    zabm zabm1 = this.zah;
    if (zabm1 != null)
      zabm1.zag(); 
  }
  
  public final void reconnect() {
    super.disconnect();
    super.connect();
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    this.zag.zaa(paramConnectionCallbacks);
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.zag.zaa(paramOnConnectionFailedListener);
  }
  
  public final <L> ListenerHolder<L> registerListener(L paramL) {
    this.zaf.lock();
    try {
      return this.zau.zaa(paramL, this.zak, "NO_TYPE");
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final void stopAutoManage(FragmentActivity paramFragmentActivity) {
    LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity)paramFragmentActivity);
    if (this.zai >= 0) {
      zai.zaa(lifecycleActivity).zaa(this.zai);
      return;
    } 
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    this.zag.zac(paramConnectionCallbacks);
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.zag.zac(paramOnConnectionFailedListener);
  }
  
  public final void zaa(int paramInt, boolean paramBoolean) {
    if (paramInt == 1 && !paramBoolean && !this.zal) {
      this.zal = true;
      if (this.zaq == null && !ClientLibraryUtils.isPackageSide())
        try {
          this.zaq = this.zap.zaa(this.zaj.getApplicationContext(), new zaax(this));
        } catch (SecurityException securityException) {} 
      zaau zaau1 = this.zao;
      zaau1.sendMessageDelayed(zaau1.obtainMessage(1), this.zam);
      zaau1 = this.zao;
      zaau1.sendMessageDelayed(zaau1.obtainMessage(2), this.zan);
    } 
    Set<BasePendingResult<?>> set = this.zae.zab;
    int i = 0;
    BasePendingResult[] arrayOfBasePendingResult = set.<BasePendingResult>toArray(new BasePendingResult[0]);
    int j = arrayOfBasePendingResult.length;
    while (i < j) {
      arrayOfBasePendingResult[i].forceFailureUnlessReady(zacn.zaa);
      i++;
    } 
    this.zag.zaa(paramInt);
    this.zag.zaa();
    if (paramInt == 2)
      zad(); 
  }
  
  public final void zaa(Bundle paramBundle) {
    while (!this.zaa.isEmpty())
      super.execute(this.zaa.remove()); 
    this.zag.zaa(paramBundle);
  }
  
  public final void zaa(ConnectionResult paramConnectionResult) {
    if (!this.zap.isPlayServicesPossiblyUpdating(this.zaj, paramConnectionResult.getErrorCode()))
      zab(); 
    if (!this.zal) {
      this.zag.zaa(paramConnectionResult);
      this.zag.zaa();
    } 
  }
  
  public final void zaa(zaci paramzaci) {
    this.zaf.lock();
    try {
      if (this.zad == null)
        this.zad = new HashSet<zaci>(); 
      this.zad.add(paramzaci);
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final void zab(zaci paramzaci) {
    this.zaf.lock();
    try {
      Set<zaci> set = this.zad;
      if (set == null) {
        Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
      } else if (!this.zad.remove(paramzaci)) {
        Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
      } else if (!zag() && this.zah != null) {
        this.zah.zaf();
      } 
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  final boolean zab() {
    if (!this.zal)
      return false; 
    this.zal = false;
    this.zao.removeMessages(2);
    this.zao.removeMessages(1);
    zabl zabl1 = this.zaq;
    if (zabl1 != null) {
      zabl1.zaa();
      this.zaq = null;
    } 
    return true;
  }
  
  final String zac() {
    StringWriter stringWriter = new StringWriter();
    super.dump("", null, new PrintWriter(stringWriter), null);
    return stringWriter.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */