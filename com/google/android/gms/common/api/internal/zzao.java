package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzcyj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zzao implements zzbh {
  final Context mContext;
  
  private final Api.zza zzfth;
  
  final Lock zzfwa;
  
  final zzr zzfwf;
  
  private final Map zzfwi;
  
  private ConnectionResult zzfwt;
  
  final zzbi zzfxd;
  
  private int zzfxg;
  
  private int zzfxh = 0;
  
  private int zzfxi;
  
  private final Bundle zzfxj = new Bundle();
  
  private final Set zzfxk = new HashSet();
  
  zzcyj zzfxl;
  
  private boolean zzfxm;
  
  boolean zzfxn;
  
  boolean zzfxo;
  
  zzan zzfxp;
  
  boolean zzfxq;
  
  boolean zzfxr;
  
  private ArrayList zzfxs = new ArrayList();
  
  public zzao(zzbi paramzzbi, zzr paramzzr, Map paramMap, Api.zza paramzza, Lock paramLock, Context paramContext) {
    this.zzfxd = paramzzbi;
    this.zzfwf = paramzzr;
    this.zzfwi = paramMap;
    this.zzfth = paramzza;
    this.zzfwa = paramLock;
    this.mContext = paramContext;
  }
  
  private final void zzajm() {
    Bundle bundle;
    zzbi zzbi1 = this.zzfxd;
    zzbi1.zzfwa.lock();
    try {
      zzbi1.zzfvq.zzajs();
      zzbi1.zzfyz = new zzal(zzbi1);
      zzbi1.zzfyz.begin();
      zzbi1.zzfyw.signalAll();
      zzbi1.zzfwa.unlock();
      zzbl.zzajx().execute(new zzap(this));
      if (this.zzfxl != null) {
        if (this.zzfxq)
          this.zzfxl.zza(this.zzfxp, this.zzfxr); 
        zzbk(false);
      } 
      for (Api.zzc zzc : this.zzfxd.zzfyy.keySet())
        ((Api.zze)this.zzfxd.zzfyj.get(zzc)).disconnect(); 
      if (this.zzfxj.isEmpty()) {
        zzbi1 = null;
      } else {
        bundle = this.zzfxj;
      } 
      return;
    } finally {
      ((zzbi)bundle).zzfwa.unlock();
    } 
  }
  
  private final void zzajo() {
    ArrayList<Object> arrayList = this.zzfxs;
    int j = arrayList.size();
    int i = 0;
    while (i < j) {
      Future future = (Future)arrayList.get(i);
      i++;
      ((Future)future).cancel(true);
    } 
    this.zzfxs.clear();
  }
  
  private final void zzbk(boolean paramBoolean) {
    if (this.zzfxl != null) {
      if (this.zzfxl.isConnected() && paramBoolean)
        this.zzfxl.zzbet(); 
      this.zzfxl.disconnect();
      this.zzfxp = null;
    } 
  }
  
  private static String zzbt(int paramInt) {
    switch (paramInt) {
      default:
        return "UNKNOWN";
      case 1:
        return "STEP_GETTING_REMOTE_SERVICE";
      case 0:
        break;
    } 
    return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
  }
  
  public final void begin() {
    this.zzfxd.zzfyy.clear();
    this.zzfxn = false;
    this.zzfwt = null;
    this.zzfxh = 0;
    this.zzfxm = true;
    this.zzfxo = false;
    this.zzfxq = false;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Api api : this.zzfwi.keySet()) {
      Api.zze zze = (Api.zze)this.zzfxd.zzfyj.get(api.zzahm());
      boolean bool = ((Boolean)this.zzfwi.get(api)).booleanValue();
      if (zze.zzacc()) {
        this.zzfxn = true;
        if (bool) {
          this.zzfxk.add(api.zzahm());
        } else {
          this.zzfxm = false;
        } 
      } 
      hashMap.put(zze, new zzaq(this, api, bool));
    } 
    if (this.zzfxn) {
      this.zzfwf.zzgft = Integer.valueOf(System.identityHashCode(this.zzfxd.zzfvq));
      zzax zzax = new zzax(this, (byte)0);
      this.zzfxl = (zzcyj)this.zzfth.zza(this.mContext, this.zzfxd.zzfvq.getLooper(), this.zzfwf, this.zzfwf.zzgfs, zzax, zzax);
    } 
    this.zzfxi = this.zzfxd.zzfyj.size();
    this.zzfxs.add(zzbl.zzajx().submit(new zzar(this, hashMap)));
  }
  
  public final void connect() {}
  
  public final boolean disconnect() {
    zzajo();
    zzbk(true);
    this.zzfxd.zzg$5d4cef71();
    return true;
  }
  
  public final void onConnected(Bundle paramBundle) {
    if (!zzbs(1))
      return; 
    if (paramBundle != null)
      this.zzfxj.putAll(paramBundle); 
    if (zzajk())
      zzajm(); 
  }
  
  public final void onConnectionSuspended(int paramInt) {
    zze(new ConnectionResult(8, null));
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api paramApi, boolean paramBoolean) {
    if (!zzbs(1))
      return; 
    zzb(paramConnectionResult, paramApi, paramBoolean);
    if (zzajk())
      zzajm(); 
  }
  
  final boolean zzajk() {
    this.zzfxi--;
    if (this.zzfxi > 0)
      return false; 
    if (this.zzfxi < 0) {
      Log.w("GoogleApiClientConnecting", this.zzfxd.zzfvq.zzaju());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      ConnectionResult connectionResult = new ConnectionResult(8, null);
      zze(connectionResult);
      return false;
    } 
    if (this.zzfwt != null) {
      this.zzfxd.zzfzb = this.zzfxg;
      ConnectionResult connectionResult = this.zzfwt;
      zze(connectionResult);
      return false;
    } 
    return true;
  }
  
  final void zzajl() {
    if (this.zzfxi != 0)
      return; 
    if (!this.zzfxn || this.zzfxo) {
      ArrayList<Api.zze> arrayList = new ArrayList();
      this.zzfxh = 1;
      this.zzfxi = this.zzfxd.zzfyj.size();
      for (Api.zzc zzc : this.zzfxd.zzfyj.keySet()) {
        if (this.zzfxd.zzfyy.containsKey(zzc)) {
          if (zzajk())
            zzajm(); 
          continue;
        } 
        arrayList.add((Api.zze)this.zzfxd.zzfyj.get(zzc));
      } 
      if (!arrayList.isEmpty())
        this.zzfxs.add(zzbl.zzajx().submit(new zzau(this, arrayList))); 
    } 
  }
  
  final void zzajn() {
    this.zzfxn = false;
    this.zzfxd.zzfvq.zzfyk = Collections.emptySet();
    for (Api.zzc zzc : this.zzfxk) {
      if (!this.zzfxd.zzfyy.containsKey(zzc))
        this.zzfxd.zzfyy.put(zzc, new ConnectionResult(17, null)); 
    } 
  }
  
  final void zzb(ConnectionResult paramConnectionResult, Api paramApi, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #5
    //   3: iload_3
    //   4: ifeq -> 41
    //   7: aload_1
    //   8: invokevirtual hasResolution : ()Z
    //   11: ifeq -> 20
    //   14: iconst_1
    //   15: istore #4
    //   17: goto -> 36
    //   20: aload_1
    //   21: getfield zzcc : I
    //   24: invokestatic zzbo : (I)Landroid/content/Intent;
    //   27: ifnull -> 33
    //   30: goto -> 14
    //   33: iconst_0
    //   34: istore #4
    //   36: iload #4
    //   38: ifeq -> 61
    //   41: aload_0
    //   42: getfield zzfwt : Lcom/google/android/gms/common/ConnectionResult;
    //   45: ifnull -> 68
    //   48: ldc_w 2147483647
    //   51: aload_0
    //   52: getfield zzfxg : I
    //   55: if_icmpge -> 61
    //   58: goto -> 68
    //   61: iload #5
    //   63: istore #4
    //   65: goto -> 71
    //   68: iconst_1
    //   69: istore #4
    //   71: iload #4
    //   73: ifeq -> 88
    //   76: aload_0
    //   77: aload_1
    //   78: putfield zzfwt : Lcom/google/android/gms/common/ConnectionResult;
    //   81: aload_0
    //   82: ldc_w 2147483647
    //   85: putfield zzfxg : I
    //   88: aload_0
    //   89: getfield zzfxd : Lcom/google/android/gms/common/api/internal/zzbi;
    //   92: getfield zzfyy : Ljava/util/Map;
    //   95: aload_2
    //   96: invokevirtual zzahm : ()Lcom/google/android/gms/common/api/Api$zzc;
    //   99: aload_1
    //   100: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: return
  }
  
  final boolean zzbs(int paramInt) {
    if (this.zzfxh != paramInt) {
      Log.w("GoogleApiClientConnecting", this.zzfxd.zzfvq.zzaju());
      String str2 = String.valueOf(this);
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str2).length() + 23);
      stringBuilder2.append("Unexpected callback in ");
      stringBuilder2.append(str2);
      Log.w("GoogleApiClientConnecting", stringBuilder2.toString());
      int i = this.zzfxi;
      StringBuilder stringBuilder1 = new StringBuilder(33);
      stringBuilder1.append("mRemainingConnections=");
      stringBuilder1.append(i);
      Log.w("GoogleApiClientConnecting", stringBuilder1.toString());
      String str1 = zzbt(this.zzfxh);
      String str3 = zzbt(paramInt);
      StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(str1).length() + 70 + String.valueOf(str3).length());
      stringBuilder3.append("GoogleApiClient connecting is in step ");
      stringBuilder3.append(str1);
      stringBuilder3.append(" but received callback for step ");
      stringBuilder3.append(str3);
      Log.wtf("GoogleApiClientConnecting", stringBuilder3.toString(), new Exception());
      zze(new ConnectionResult(8, null));
      return false;
    } 
    return true;
  }
  
  final boolean zzd(ConnectionResult paramConnectionResult) {
    return (this.zzfxm && !paramConnectionResult.hasResolution());
  }
  
  public final zzm zze(zzm paramzzm) {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  final void zze(ConnectionResult paramConnectionResult) {
    zzajo();
    zzbk(paramConnectionResult.hasResolution() ^ true);
    this.zzfxd.zzg$5d4cef71();
    this.zzfxd.zzfzc.zzc(paramConnectionResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */