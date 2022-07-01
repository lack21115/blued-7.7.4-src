package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zaaz implements zabm, zap {
  final Map<Api.AnyClientKey<?>, Api.Client> zaa;
  
  final Map<Api.AnyClientKey<?>, ConnectionResult> zab = new HashMap<Api.AnyClientKey<?>, ConnectionResult>();
  
  int zac;
  
  final zaar zad;
  
  final zabn zae;
  
  private final Lock zaf;
  
  private final Condition zag;
  
  private final Context zah;
  
  private final GoogleApiAvailabilityLight zai;
  
  private final zabb zaj;
  
  private final ClientSettings zak;
  
  private final Map<Api<?>, Boolean> zal;
  
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zam;
  
  @NotOnlyInitialized
  private volatile zaaw zan;
  
  private ConnectionResult zao = null;
  
  public zaaz(Context paramContext, zaar paramzaar, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList, zabn paramzabn) {
    this.zah = paramContext;
    this.zaf = paramLock;
    this.zai = paramGoogleApiAvailabilityLight;
    this.zaa = paramMap;
    this.zak = paramClientSettings;
    this.zal = paramMap1;
    this.zam = paramAbstractClientBuilder;
    this.zad = paramzaar;
    this.zae = paramzabn;
    ArrayList<zaq> arrayList = paramArrayList;
    int j = arrayList.size();
    int i = 0;
    while (i < j) {
      paramzaar = (zaar)arrayList.get(i);
      i++;
      ((zaq)paramzaar).zaa(this);
    } 
    this.zaj = new zabb(this, paramLooper);
    this.zag = paramLock.newCondition();
    this.zan = new zaao(this);
  }
  
  public final void onConnected(Bundle paramBundle) {
    this.zaf.lock();
    try {
      this.zan.zaa(paramBundle);
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final void onConnectionSuspended(int paramInt) {
    this.zaf.lock();
    try {
      this.zan.zaa(paramInt);
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final ConnectionResult zaa(long paramLong, TimeUnit paramTimeUnit) {
    zaa();
    for (paramLong = paramTimeUnit.toNanos(paramLong); zae(); paramLong = this.zag.awaitNanos(paramLong)) {
      if (paramLong <= 0L)
        try {
          zac();
          return new ConnectionResult(14, null);
        } catch (InterruptedException interruptedException) {
          Thread.currentThread().interrupt();
          return new ConnectionResult(15, null);
        }  
    } 
    if (zad())
      return ConnectionResult.RESULT_SUCCESS; 
    ConnectionResult connectionResult = this.zao;
    return (connectionResult != null) ? connectionResult : new ConnectionResult(13, null);
  }
  
  public final ConnectionResult zaa(Api<?> paramApi) {
    Api.AnyClientKey anyClientKey = paramApi.zac();
    if (this.zaa.containsKey(anyClientKey)) {
      if (((Api.Client)this.zaa.get(anyClientKey)).isConnected())
        return ConnectionResult.RESULT_SUCCESS; 
      if (this.zab.containsKey(anyClientKey))
        return this.zab.get(anyClientKey); 
    } 
    return null;
  }
  
  public final <A extends Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T paramT) {
    paramT.zab();
    return this.zan.zaa(paramT);
  }
  
  public final void zaa() {
    this.zan.zac();
  }
  
  final void zaa(ConnectionResult paramConnectionResult) {
    this.zaf.lock();
    try {
      this.zao = paramConnectionResult;
      this.zan = new zaao(this);
      this.zan.zaa();
      this.zag.signalAll();
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {
    this.zaf.lock();
    try {
      this.zan.zaa(paramConnectionResult, paramApi, paramBoolean);
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  final void zaa(zaay paramzaay) {
    Message message = this.zaj.obtainMessage(1, paramzaay);
    this.zaj.sendMessage(message);
  }
  
  final void zaa(RuntimeException paramRuntimeException) {
    Message message = this.zaj.obtainMessage(2, paramRuntimeException);
    this.zaj.sendMessage(message);
  }
  
  public final void zaa(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.zan);
    for (Api<?> api : this.zal.keySet()) {
      paramPrintWriter.append(paramString).append(api.zad()).println(":");
      ((Api.Client)Preconditions.checkNotNull(this.zaa.get(api.zac()))).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    } 
  }
  
  public final boolean zaa(SignInConnectionListener paramSignInConnectionListener) {
    return false;
  }
  
  public final ConnectionResult zab() {
    zaa();
    while (true) {
      if (zae()) {
        try {
          this.zag.await();
        } catch (InterruptedException interruptedException) {
          Thread.currentThread().interrupt();
          return new ConnectionResult(15, null);
        } 
        continue;
      } 
      if (zad())
        return ConnectionResult.RESULT_SUCCESS; 
      ConnectionResult connectionResult = this.zao;
      return (connectionResult != null) ? connectionResult : new ConnectionResult(13, null);
    } 
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T zab(T paramT) {
    paramT.zab();
    return this.zan.zab(paramT);
  }
  
  public final void zac() {
    if (this.zan.zab())
      this.zab.clear(); 
  }
  
  public final boolean zad() {
    return this.zan instanceof zaaa;
  }
  
  public final boolean zae() {
    return this.zan instanceof zaaf;
  }
  
  public final void zaf() {
    if (zad())
      ((zaaa)this.zan).zad(); 
  }
  
  public final void zag() {}
  
  final void zah() {
    this.zaf.lock();
    try {
      this.zan = new zaaf(this, this.zak, this.zal, this.zai, this.zam, this.zaf, this.zah);
      this.zan.zaa();
      this.zag.signalAll();
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
  
  final void zai() {
    this.zaf.lock();
    try {
      this.zad.zab();
      this.zan = new zaaa(this);
      this.zan.zaa();
      this.zag.signalAll();
      return;
    } finally {
      this.zaf.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */