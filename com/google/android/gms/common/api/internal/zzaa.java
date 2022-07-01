package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbic;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzaa implements zzcc {
  private final Looper zzalj;
  
  private final zzbm zzfsq;
  
  final Lock zzfwa;
  
  private final zzr zzfwf;
  
  final Map zzfwg = new HashMap<Object, Object>();
  
  final Map zzfwh = new HashMap<Object, Object>();
  
  private final Map zzfwi;
  
  final zzba zzfwj;
  
  private final zzf zzfwk;
  
  final Condition zzfwl;
  
  private final boolean zzfwm;
  
  final boolean zzfwn;
  
  private final Queue zzfwo = new LinkedList();
  
  boolean zzfwp;
  
  Map zzfwq;
  
  Map zzfwr;
  
  private zzad zzfws;
  
  ConnectionResult zzfwt;
  
  public zzaa(Context paramContext, Lock paramLock, Looper paramLooper, zzf paramzzf, Map paramMap1, zzr paramzzr, Map paramMap2, Api.zza paramzza, ArrayList<ArrayList> paramArrayList, zzba paramzzba, boolean paramBoolean) {
    this.zzfwa = paramLock;
    this.zzalj = paramLooper;
    this.zzfwl = paramLock.newCondition();
    this.zzfwk = paramzzf;
    this.zzfwj = paramzzba;
    this.zzfwi = paramMap2;
    this.zzfwf = paramzzr;
    this.zzfwm = paramBoolean;
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    for (Api api : paramMap2.keySet())
      hashMap1.put(api.zzahm(), api); 
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    ArrayList<ArrayList> arrayList = paramArrayList;
    int j = arrayList.size();
    int i = 0;
    while (i < j) {
      paramArrayList = arrayList.get(i);
      i++;
      zzt zzt = (zzt)paramArrayList;
      hashMap2.put(zzt.zzfop, zzt);
    } 
    Iterator<Map.Entry> iterator = paramMap1.entrySet().iterator();
    paramBoolean = true;
    int k = 0;
    j = 1;
    for (i = 0; iterator.hasNext(); i = m) {
      Map.Entry entry = iterator.next();
      Api api = (Api)hashMap1.get(entry.getKey());
      Api.zze zze = (Api.zze)entry.getValue();
      if (zze.zzahn()) {
        if (!((Boolean)this.zzfwi.get(api)).booleanValue()) {
          k = 1;
        } else {
          k = i;
        } 
        i = 1;
      } else {
        j = k;
        k = i;
        boolean bool = false;
        i = j;
        j = bool;
      } 
      zzz zzz = new zzz(paramContext, api, paramLooper, zze, (zzt)hashMap2.get(api), paramzzr, paramzza);
      this.zzfwg.put((Api.zzc)entry.getKey(), zzz);
      if (zze.zzacc())
        this.zzfwh.put((Api.zzc)entry.getKey(), zzz); 
      int m = k;
      k = i;
    } 
    if (k == 0 || j != 0 || i != 0)
      paramBoolean = false; 
    this.zzfwn = paramBoolean;
    this.zzfsq = zzbm.zzajy();
  }
  
  private final ConnectionResult zzb(Api.zzc paramzzc) {
    this.zzfwa.lock();
    try {
      zzz zzz = (zzz)this.zzfwg.get(paramzzc);
      if (this.zzfwq != null && zzz != null)
        return (ConnectionResult)this.zzfwq.get(zzz.zzfsn); 
      return null;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void connect() {
    this.zzfwa.lock();
    try {
      boolean bool = this.zzfwp;
      if (bool)
        return; 
      this.zzfwp = true;
      this.zzfwq = null;
      this.zzfwr = null;
      this.zzfws = null;
      this.zzfwt = null;
      this.zzfsq.zzaih();
      zzbm zzbm1 = this.zzfsq;
      Collection collection = this.zzfwg.values();
      zzj zzj = new zzj(collection);
      for (GoogleApi googleApi : collection) {
        zzbo zzbo = (zzbo)zzbm1.zzfwg.get(googleApi.zzfsn);
        if (zzbo == null || !zzbo.isConnected()) {
          zzbm1.mHandler.sendMessage(zzbm1.mHandler.obtainMessage(2, zzj));
          break;
        } 
        zzj.zza(googleApi.zzfsn, ConnectionResult.zzfqt, zzbo.zzfwd.zzahp());
      } 
      zzj.zzful.zzlel.addOnCompleteListener((Executor)new zzbic(this.zzalj), new zzac(this, (byte)0));
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void disconnect() {
    this.zzfwa.lock();
    try {
      this.zzfwp = false;
      this.zzfwq = null;
      this.zzfwr = null;
      if (this.zzfws != null)
        this.zzfws = null; 
      this.zzfwt = null;
      while (!this.zzfwo.isEmpty()) {
        zzm zzm = this.zzfwo.remove();
        zzm.zza((zzdn)null);
        zzm.cancel();
      } 
      this.zzfwl.signalAll();
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final boolean isConnected() {
    this.zzfwa.lock();
    try {
      if (this.zzfwq != null) {
        ConnectionResult connectionResult = this.zzfwt;
        if (connectionResult == null)
          return true; 
      } 
      return false;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void zzais() {}
  
  public final zzm zze(zzm paramzzm) {
    // Byte code:
    //   0: aload_1
    //   1: getfield zzfus : Lcom/google/android/gms/common/api/Api$zzc;
    //   4: astore #4
    //   6: aload_0
    //   7: getfield zzfwm : Z
    //   10: ifeq -> 167
    //   13: aload_1
    //   14: getfield zzfus : Lcom/google/android/gms/common/api/Api$zzc;
    //   17: astore_3
    //   18: aload_0
    //   19: aload_3
    //   20: invokespecial zzb : (Lcom/google/android/gms/common/api/Api$zzc;)Lcom/google/android/gms/common/ConnectionResult;
    //   23: astore #5
    //   25: aload #5
    //   27: ifnull -> 159
    //   30: aload #5
    //   32: getfield zzcc : I
    //   35: iconst_4
    //   36: if_icmpne -> 159
    //   39: aload_0
    //   40: getfield zzfsq : Lcom/google/android/gms/common/api/internal/zzbm;
    //   43: astore #5
    //   45: aload_0
    //   46: getfield zzfwg : Ljava/util/Map;
    //   49: aload_3
    //   50: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast com/google/android/gms/common/api/internal/zzz
    //   58: getfield zzfsn : Lcom/google/android/gms/common/api/internal/zzh;
    //   61: astore_3
    //   62: aload_0
    //   63: getfield zzfwj : Lcom/google/android/gms/common/api/internal/zzba;
    //   66: invokestatic identityHashCode : (Ljava/lang/Object;)I
    //   69: istore_2
    //   70: aload #5
    //   72: getfield zzfwg : Ljava/util/Map;
    //   75: aload_3
    //   76: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast com/google/android/gms/common/api/internal/zzbo
    //   84: astore_3
    //   85: aload_3
    //   86: ifnonnull -> 94
    //   89: aconst_null
    //   90: astore_3
    //   91: goto -> 140
    //   94: aload_3
    //   95: getfield zzfzx : Lcom/google/android/gms/common/api/internal/zzcv;
    //   98: ifnonnull -> 106
    //   101: aconst_null
    //   102: astore_3
    //   103: goto -> 114
    //   106: aload_3
    //   107: getfield zzfzx : Lcom/google/android/gms/common/api/internal/zzcv;
    //   110: getfield zzfxl : Lcom/google/android/gms/internal/zzcyj;
    //   113: astore_3
    //   114: aload_3
    //   115: ifnonnull -> 121
    //   118: goto -> 89
    //   121: aload #5
    //   123: getfield mContext : Landroid/content/Context;
    //   126: iload_2
    //   127: aload_3
    //   128: invokeinterface getSignInIntent : ()Landroid/content/Intent;
    //   133: ldc_w 134217728
    //   136: invokestatic getActivity : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   139: astore_3
    //   140: aload_1
    //   141: new com/google/android/gms/common/api/Status
    //   144: dup
    //   145: iconst_4
    //   146: aconst_null
    //   147: aload_3
    //   148: invokespecial <init> : (ILjava/lang/String;Landroid/app/PendingIntent;)V
    //   151: invokevirtual zzu : (Lcom/google/android/gms/common/api/Status;)V
    //   154: iconst_1
    //   155: istore_2
    //   156: goto -> 161
    //   159: iconst_0
    //   160: istore_2
    //   161: iload_2
    //   162: ifeq -> 167
    //   165: aload_1
    //   166: areturn
    //   167: aload_0
    //   168: getfield zzfwj : Lcom/google/android/gms/common/api/internal/zzba;
    //   171: getfield zzfyp : Lcom/google/android/gms/common/api/internal/zzdk;
    //   174: aload_1
    //   175: invokevirtual zzb : (Lcom/google/android/gms/common/api/internal/BasePendingResult;)V
    //   178: aload_0
    //   179: getfield zzfwg : Ljava/util/Map;
    //   182: aload #4
    //   184: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   189: checkcast com/google/android/gms/common/api/internal/zzz
    //   192: aload_1
    //   193: invokevirtual zzb : (Lcom/google/android/gms/common/api/internal/zzm;)Lcom/google/android/gms/common/api/internal/zzm;
    //   196: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */