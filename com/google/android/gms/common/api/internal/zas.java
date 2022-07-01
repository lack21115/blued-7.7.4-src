package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zas implements zabm {
  private final Context zaa;
  
  private final zaar zab;
  
  private final Looper zac;
  
  private final zaaz zad;
  
  private final zaaz zae;
  
  private final Map<Api.AnyClientKey<?>, zaaz> zaf;
  
  private final Set<SignInConnectionListener> zag = Collections.newSetFromMap(new WeakHashMap<SignInConnectionListener, Boolean>());
  
  private final Api.Client zah;
  
  private Bundle zai;
  
  private ConnectionResult zaj = null;
  
  private ConnectionResult zak = null;
  
  private boolean zal = false;
  
  private final Lock zam;
  
  private int zan = 0;
  
  private zas(Context paramContext, zaar paramzaar, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, Map<Api.AnyClientKey<?>, Api.Client> paramMap2, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Api.Client paramClient, ArrayList<zaq> paramArrayList1, ArrayList<zaq> paramArrayList2, Map<Api<?>, Boolean> paramMap3, Map<Api<?>, Boolean> paramMap4) {
    this.zaa = paramContext;
    this.zab = paramzaar;
    this.zam = paramLock;
    this.zac = paramLooper;
    this.zah = paramClient;
    this.zad = new zaaz(paramContext, this.zab, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap2, null, paramMap4, null, paramArrayList2, new zau(this, null));
    this.zae = new zaaz(paramContext, this.zab, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap1, paramClientSettings, paramMap3, paramAbstractClientBuilder, paramArrayList1, new zat(this, null));
    ArrayMap arrayMap = new ArrayMap();
    Iterator<Api.AnyClientKey> iterator = paramMap2.keySet().iterator();
    while (iterator.hasNext())
      arrayMap.put(iterator.next(), this.zad); 
    iterator = paramMap1.keySet().iterator();
    while (iterator.hasNext())
      arrayMap.put(iterator.next(), this.zae); 
    this.zaf = Collections.unmodifiableMap((Map<? extends Api.AnyClientKey<?>, ? extends zaaz>)arrayMap);
  }
  
  public static zas zaa(Context paramContext, zaar paramzaar, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList) {
    Api.Client client;
    ArrayMap<Api.AnyClientKey, Api.Client> arrayMap2 = new ArrayMap();
    ArrayMap<Api.AnyClientKey, Api.Client> arrayMap3 = new ArrayMap();
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    paramMap = null;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Api.Client client1 = (Api.Client)entry.getValue();
      if (client1.providesSignIn())
        client = client1; 
      if (client1.requiresSignIn()) {
        arrayMap2.put((Api.AnyClientKey)entry.getKey(), client1);
        continue;
      } 
      arrayMap3.put((Api.AnyClientKey)entry.getKey(), client1);
    } 
    Preconditions.checkState(arrayMap2.isEmpty() ^ true, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    ArrayMap<Api, Boolean> arrayMap1 = new ArrayMap();
    ArrayMap<Api, Boolean> arrayMap4 = new ArrayMap();
    for (Api<?> api : paramMap1.keySet()) {
      Api.AnyClientKey anyClientKey = api.zac();
      if (arrayMap2.containsKey(anyClientKey)) {
        arrayMap1.put(api, paramMap1.get(api));
        continue;
      } 
      if (arrayMap3.containsKey(anyClientKey)) {
        arrayMap4.put(api, paramMap1.get(api));
        continue;
      } 
      throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
    } 
    ArrayList<zaq> arrayList1 = new ArrayList();
    ArrayList<zaq> arrayList2 = new ArrayList();
    paramArrayList = paramArrayList;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j) {
      zaq zaq = (zaq)paramArrayList.get(i);
      i++;
      zaq = zaq;
      if (arrayMap1.containsKey(zaq.zaa)) {
        arrayList1.add(zaq);
        continue;
      } 
      if (arrayMap4.containsKey(zaq.zaa)) {
        arrayList2.add(zaq);
        continue;
      } 
      throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
    } 
    return new zas(paramContext, paramzaar, paramLock, paramLooper, paramGoogleApiAvailabilityLight, (Map)arrayMap2, (Map)arrayMap3, paramClientSettings, paramAbstractClientBuilder, client, arrayList1, arrayList2, (Map)arrayMap1, (Map)arrayMap4);
  }
  
  private final void zaa(int paramInt, boolean paramBoolean) {
    this.zab.zaa(paramInt, paramBoolean);
    this.zak = null;
    this.zaj = null;
  }
  
  private final void zaa(Bundle paramBundle) {
    Bundle bundle = this.zai;
    if (bundle == null) {
      this.zai = paramBundle;
      return;
    } 
    if (paramBundle != null)
      bundle.putAll(paramBundle); 
  }
  
  private final void zaa(ConnectionResult paramConnectionResult) {
    int i = this.zan;
    if (i != 1) {
      if (i != 2) {
        Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
      } else {
        this.zab.zaa(paramConnectionResult);
        zai();
      } 
      this.zan = 0;
      return;
    } 
    zai();
  }
  
  private static boolean zab(ConnectionResult paramConnectionResult) {
    return (paramConnectionResult != null && paramConnectionResult.isSuccess());
  }
  
  private final boolean zac(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> paramApiMethodImpl) {
    Api.AnyClientKey<? extends Api.AnyClient> anyClientKey = paramApiMethodImpl.getClientKey();
    zaaz zaaz1 = this.zaf.get(anyClientKey);
    Preconditions.checkNotNull(zaaz1, "GoogleApiClient is not configured to use the API required for this call.");
    return zaaz1.equals(this.zae);
  }
  
  private final void zah() {
    if (zab(this.zaj)) {
      if (zab(this.zak) || zaj()) {
        int i = this.zan;
        if (i != 1) {
          if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
          } else {
            ((zaar)Preconditions.checkNotNull(this.zab)).zaa(this.zai);
            zai();
          } 
          this.zan = 0;
          return;
        } 
      } else {
        ConnectionResult connectionResult = this.zak;
        if (connectionResult != null) {
          if (this.zan == 1) {
            zai();
            return;
          } 
          zaa(connectionResult);
          this.zad.zac();
          return;
        } 
        return;
      } 
    } else {
      if (this.zaj != null && zab(this.zak)) {
        this.zae.zac();
        zaa((ConnectionResult)Preconditions.checkNotNull(this.zaj));
        return;
      } 
      ConnectionResult connectionResult = this.zaj;
      if (connectionResult != null && this.zak != null) {
        if (this.zae.zac < this.zad.zac)
          connectionResult = this.zak; 
        zaa(connectionResult);
      } 
      return;
    } 
    zai();
  }
  
  private final void zai() {
    Iterator<SignInConnectionListener> iterator = this.zag.iterator();
    while (iterator.hasNext())
      ((SignInConnectionListener)iterator.next()).onComplete(); 
    this.zag.clear();
  }
  
  private final boolean zaj() {
    ConnectionResult connectionResult = this.zak;
    return (connectionResult != null && connectionResult.getErrorCode() == 4);
  }
  
  private final PendingIntent zak() {
    return (this.zah == null) ? null : PendingIntent.getActivity(this.zaa, System.identityHashCode(this.zab), this.zah.getSignInIntent(), 134217728);
  }
  
  public final ConnectionResult zaa(long paramLong, TimeUnit paramTimeUnit) {
    throw new UnsupportedOperationException();
  }
  
  public final ConnectionResult zaa(Api<?> paramApi) {
    return Objects.equal(this.zaf.get(paramApi.zac()), this.zae) ? (zaj() ? new ConnectionResult(4, zak()) : this.zae.zaa(paramApi)) : this.zad.zaa(paramApi);
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T paramT) {
    if (zac((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>)paramT)) {
      if (zaj()) {
        paramT.setFailedResult(new Status(4, null, zak()));
        return paramT;
      } 
      return this.zae.zaa(paramT);
    } 
    return this.zad.zaa(paramT);
  }
  
  public final void zaa() {
    this.zan = 2;
    this.zal = false;
    this.zak = null;
    this.zaj = null;
    this.zad.zaa();
    this.zae.zaa();
  }
  
  public final void zaa(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zae.zaa(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.zad.zaa(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean zaa(SignInConnectionListener paramSignInConnectionListener) {
    this.zam.lock();
    try {
      if ((zae() || zad()) && !this.zae.zad()) {
        this.zag.add(paramSignInConnectionListener);
        if (this.zan == 0)
          this.zan = 1; 
        this.zak = null;
        this.zae.zaa();
        return true;
      } 
      return false;
    } finally {
      this.zam.unlock();
    } 
  }
  
  public final ConnectionResult zab() {
    throw new UnsupportedOperationException();
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T paramT) {
    if (zac((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>)paramT)) {
      if (zaj()) {
        paramT.setFailedResult(new Status(4, null, zak()));
        return paramT;
      } 
      return this.zae.zab(paramT);
    } 
    return this.zad.zab(paramT);
  }
  
  public final void zac() {
    this.zak = null;
    this.zaj = null;
    this.zan = 0;
    this.zad.zac();
    this.zae.zac();
    zai();
  }
  
  public final boolean zad() {
    this.zam.lock();
    try {
      boolean bool = this.zad.zad();
      boolean bool1 = true;
      if (bool) {
        bool = bool1;
        if (!this.zae.zad()) {
          bool = bool1;
          if (!zaj()) {
            int i = this.zan;
            if (i == 1) {
              bool = bool1;
              return bool;
            } 
          } else {
            return bool;
          } 
        } else {
          return bool;
        } 
      } 
      bool = false;
      return bool;
    } finally {
      this.zam.unlock();
    } 
  }
  
  public final boolean zae() {
    this.zam.lock();
    try {
      boolean bool;
      int i = this.zan;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } finally {
      this.zam.unlock();
    } 
  }
  
  public final void zaf() {
    this.zad.zaf();
    this.zae.zaf();
  }
  
  public final void zag() {
    this.zam.lock();
    try {
      boolean bool = zae();
      this.zae.zac();
      this.zak = new ConnectionResult(4);
      if (bool) {
        (new zap(this.zac)).post(new zar(this));
      } else {
        zai();
      } 
      return;
    } finally {
      this.zam.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */