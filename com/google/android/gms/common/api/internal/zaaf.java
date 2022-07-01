package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zau;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zam;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zaaf implements zaaw {
  private final zaaz zaa;
  
  private final Lock zab;
  
  private final Context zac;
  
  private final GoogleApiAvailabilityLight zad;
  
  private ConnectionResult zae;
  
  private int zaf;
  
  private int zag = 0;
  
  private int zah;
  
  private final Bundle zai = new Bundle();
  
  private final Set<Api.AnyClientKey> zaj = new HashSet<Api.AnyClientKey>();
  
  private zad zak;
  
  private boolean zal;
  
  private boolean zam;
  
  private boolean zan;
  
  private IAccountAccessor zao;
  
  private boolean zap;
  
  private boolean zaq;
  
  private final ClientSettings zar;
  
  private final Map<Api<?>, Boolean> zas;
  
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zat;
  
  private ArrayList<Future<?>> zau = new ArrayList<Future<?>>();
  
  public zaaf(zaaz paramzaaz, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Lock paramLock, Context paramContext) {
    this.zaa = paramzaaz;
    this.zar = paramClientSettings;
    this.zas = paramMap;
    this.zad = paramGoogleApiAvailabilityLight;
    this.zat = paramAbstractClientBuilder;
    this.zab = paramLock;
    this.zac = paramContext;
  }
  
  private final void zaa(zam paramzam) {
    String str;
    if (!zab(0))
      return; 
    ConnectionResult connectionResult = paramzam.zaa();
    if (connectionResult.isSuccess()) {
      zau zau = (zau)Preconditions.checkNotNull(paramzam.zab());
      ConnectionResult connectionResult1 = zau.zab();
      if (!connectionResult1.isSuccess()) {
        str = String.valueOf(connectionResult1);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 48);
        stringBuilder.append("Sign-in succeeded with resolve account failure: ");
        stringBuilder.append(str);
        Log.wtf("GACConnecting", stringBuilder.toString(), new Exception());
        zab(connectionResult1);
        return;
      } 
      this.zan = true;
      this.zao = (IAccountAccessor)Preconditions.checkNotNull(str.zaa());
      this.zap = str.zac();
      this.zaq = str.zad();
      zae();
      return;
    } 
    if (zaa((ConnectionResult)str)) {
      zag();
      zae();
      return;
    } 
    zab((ConnectionResult)str);
  }
  
  private final void zaa(boolean paramBoolean) {
    zad zad1 = this.zak;
    if (zad1 != null) {
      if (zad1.isConnected() && paramBoolean)
        zad1.zaa(); 
      zad1.disconnect();
      if (((ClientSettings)Preconditions.checkNotNull(this.zar)).zae())
        this.zak = null; 
      this.zao = null;
    } 
  }
  
  private final boolean zaa(ConnectionResult paramConnectionResult) {
    return (this.zal && !paramConnectionResult.hasResolution());
  }
  
  private final void zab(ConnectionResult paramConnectionResult) {
    zah();
    zaa(paramConnectionResult.hasResolution() ^ true);
    this.zaa.zaa(paramConnectionResult);
    this.zaa.zae.zaa(paramConnectionResult);
  }
  
  private final void zab(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual zaa : ()Lcom/google/android/gms/common/api/Api$BaseClientBuilder;
    //   4: invokevirtual getPriority : ()I
    //   7: istore #7
    //   9: iconst_0
    //   10: istore #6
    //   12: iload_3
    //   13: ifeq -> 58
    //   16: aload_1
    //   17: invokevirtual hasResolution : ()Z
    //   20: ifeq -> 29
    //   23: iconst_1
    //   24: istore #4
    //   26: goto -> 49
    //   29: aload_0
    //   30: getfield zad : Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   33: aload_1
    //   34: invokevirtual getErrorCode : ()I
    //   37: invokevirtual getErrorResolutionIntent : (I)Landroid/content/Intent;
    //   40: ifnull -> 46
    //   43: goto -> 23
    //   46: iconst_0
    //   47: istore #4
    //   49: iload #6
    //   51: istore #5
    //   53: iload #4
    //   55: ifeq -> 81
    //   58: aload_0
    //   59: getfield zae : Lcom/google/android/gms/common/ConnectionResult;
    //   62: ifnull -> 78
    //   65: iload #6
    //   67: istore #5
    //   69: iload #7
    //   71: aload_0
    //   72: getfield zaf : I
    //   75: if_icmpge -> 81
    //   78: iconst_1
    //   79: istore #5
    //   81: iload #5
    //   83: ifeq -> 97
    //   86: aload_0
    //   87: aload_1
    //   88: putfield zae : Lcom/google/android/gms/common/ConnectionResult;
    //   91: aload_0
    //   92: iload #7
    //   94: putfield zaf : I
    //   97: aload_0
    //   98: getfield zaa : Lcom/google/android/gms/common/api/internal/zaaz;
    //   101: getfield zab : Ljava/util/Map;
    //   104: aload_2
    //   105: invokevirtual zac : ()Lcom/google/android/gms/common/api/Api$AnyClientKey;
    //   108: aload_1
    //   109: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: return
  }
  
  private final boolean zab(int paramInt) {
    if (this.zag != paramInt) {
      Log.w("GACConnecting", this.zaa.zad.zac());
      String str2 = String.valueOf(this);
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str2).length() + 23);
      stringBuilder2.append("Unexpected callback in ");
      stringBuilder2.append(str2);
      Log.w("GACConnecting", stringBuilder2.toString());
      int i = this.zah;
      StringBuilder stringBuilder1 = new StringBuilder(33);
      stringBuilder1.append("mRemainingConnections=");
      stringBuilder1.append(i);
      Log.w("GACConnecting", stringBuilder1.toString());
      String str1 = zac(this.zag);
      String str3 = zac(paramInt);
      StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(str1).length() + 70 + String.valueOf(str3).length());
      stringBuilder3.append("GoogleApiClient connecting is in step ");
      stringBuilder3.append(str1);
      stringBuilder3.append(" but received callback for step ");
      stringBuilder3.append(str3);
      Log.e("GACConnecting", stringBuilder3.toString(), new Exception());
      zab(new ConnectionResult(8, null));
      return false;
    } 
    return true;
  }
  
  private static String zac(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE") : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
  }
  
  private final boolean zad() {
    int i = --this.zah;
    if (i > 0)
      return false; 
    if (i < 0) {
      Log.w("GACConnecting", this.zaa.zad.zac());
      Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zab(new ConnectionResult(8, null));
      return false;
    } 
    ConnectionResult connectionResult = this.zae;
    if (connectionResult != null) {
      this.zaa.zac = this.zaf;
      zab(connectionResult);
      return false;
    } 
    return true;
  }
  
  private final void zae() {
    if (this.zah != 0)
      return; 
    if (!this.zam || this.zan) {
      ArrayList<Api.Client> arrayList = new ArrayList();
      this.zag = 1;
      this.zah = this.zaa.zaa.size();
      for (Api.AnyClientKey<?> anyClientKey : this.zaa.zaa.keySet()) {
        if (this.zaa.zab.containsKey(anyClientKey)) {
          if (zad())
            zaf(); 
          continue;
        } 
        arrayList.add(this.zaa.zaa.get(anyClientKey));
      } 
      if (!arrayList.isEmpty())
        this.zau.add(zaba.zaa().submit(new zaal(this, arrayList))); 
    } 
  }
  
  private final void zaf() {
    Bundle bundle;
    this.zaa.zai();
    zaba.zaa().execute(new zaae(this));
    zad zad1 = this.zak;
    if (zad1 != null) {
      if (this.zap)
        zad1.zaa((IAccountAccessor)Preconditions.checkNotNull(this.zao), this.zaq); 
      zaa(false);
    } 
    for (Api.AnyClientKey<?> anyClientKey : this.zaa.zab.keySet())
      ((Api.Client)Preconditions.checkNotNull(this.zaa.zaa.get(anyClientKey))).disconnect(); 
    if (this.zai.isEmpty()) {
      zad1 = null;
    } else {
      bundle = this.zai;
    } 
    this.zaa.zae.zaa(bundle);
  }
  
  private final void zag() {
    this.zam = false;
    this.zaa.zad.zac = Collections.emptySet();
    for (Api.AnyClientKey<?> anyClientKey : this.zaj) {
      if (!this.zaa.zab.containsKey(anyClientKey))
        this.zaa.zab.put(anyClientKey, new ConnectionResult(17, null)); 
    } 
  }
  
  private final void zah() {
    ArrayList<Future<?>> arrayList = this.zau;
    int j = arrayList.size();
    int i = 0;
    while (i < j) {
      Future future = (Future)arrayList.get(i);
      i++;
      ((Future)future).cancel(true);
    } 
    this.zau.clear();
  }
  
  private final Set<Scope> zai() {
    ClientSettings clientSettings = this.zar;
    if (clientSettings == null)
      return Collections.emptySet(); 
    HashSet<Scope> hashSet = new HashSet(clientSettings.getRequiredScopes());
    Map map = this.zar.zaa();
    for (Api api : map.keySet()) {
      if (!this.zaa.zab.containsKey(api.zac()))
        hashSet.addAll(((ClientSettings.zaa)map.get(api)).zaa); 
    } 
    return hashSet;
  }
  
  public final <A extends Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T paramT) {
    this.zaa.zad.zaa.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
    return paramT;
  }
  
  public final void zaa() {
    this.zaa.zab.clear();
    this.zam = false;
    this.zae = null;
    this.zag = 0;
    this.zal = true;
    this.zan = false;
    this.zap = false;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Iterator<Api> iterator = this.zas.keySet().iterator();
    int i = 0;
    while (iterator.hasNext()) {
      byte b;
      Api<?> api = iterator.next();
      Api.Client client = (Api.Client)Preconditions.checkNotNull(this.zaa.zaa.get(api.zac()));
      if (api.zaa().getPriority() == 1) {
        b = 1;
      } else {
        b = 0;
      } 
      i |= b;
      boolean bool = ((Boolean)this.zas.get(api)).booleanValue();
      if (client.requiresSignIn()) {
        this.zam = true;
        if (bool) {
          this.zaj.add(api.zac());
        } else {
          this.zal = false;
        } 
      } 
      hashMap.put(client, new zaah(this, api, bool));
    } 
    if (i != 0)
      this.zam = false; 
    if (this.zam) {
      Preconditions.checkNotNull(this.zar);
      Preconditions.checkNotNull(this.zat);
      this.zar.zaa(Integer.valueOf(System.identityHashCode(this.zaa.zad)));
      zaam zaam = new zaam(this, null);
      Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.zat;
      Context context = this.zac;
      Looper looper = this.zaa.zad.getLooper();
      ClientSettings clientSettings = this.zar;
      this.zak = (zad)abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.zac(), zaam, zaam);
    } 
    this.zah = this.zaa.zaa.size();
    this.zau.add(zaba.zaa().submit(new zaag(this, (Map)hashMap)));
  }
  
  public final void zaa(int paramInt) {
    zab(new ConnectionResult(8, null));
  }
  
  public final void zaa(Bundle paramBundle) {
    if (!zab(1))
      return; 
    if (paramBundle != null)
      this.zai.putAll(paramBundle); 
    if (zad())
      zaf(); 
  }
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {
    if (!zab(1))
      return; 
    zab(paramConnectionResult, paramApi, paramBoolean);
    if (zad())
      zaf(); 
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T zab(T paramT) {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final boolean zab() {
    zah();
    zaa(true);
    this.zaa.zaa((ConnectionResult)null);
    return true;
  }
  
  public final void zac() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */