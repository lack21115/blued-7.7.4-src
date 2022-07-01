package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class zzv implements zzcc {
  private final Context mContext;
  
  private final zzba zzfvq;
  
  final zzbi zzfvr;
  
  final zzbi zzfvs;
  
  private final Map zzfvt;
  
  private final Set zzfvu = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
  
  private final Api.zze zzfvv;
  
  Bundle zzfvw;
  
  ConnectionResult zzfvx = null;
  
  ConnectionResult zzfvy = null;
  
  boolean zzfvz = false;
  
  final Lock zzfwa;
  
  private int zzfwb = 0;
  
  private zzv(Context paramContext, zzba paramzzba, Lock paramLock, Looper paramLooper, zzf paramzzf, Map paramMap1, Map paramMap2, zzr paramzzr, Api.zza paramzza, Api.zze paramzze, ArrayList paramArrayList1, ArrayList paramArrayList2, Map paramMap3, Map paramMap4) {
    this.mContext = paramContext;
    this.zzfvq = paramzzba;
    this.zzfwa = paramLock;
    this.zzfvv = paramzze;
    this.zzfvr = new zzbi(paramContext, this.zzfvq, paramLock, paramLooper, paramzzf, paramMap2, null, paramMap4, null, paramArrayList2, new zzx(this, (byte)0));
    this.zzfvs = new zzbi(paramContext, this.zzfvq, paramLock, paramLooper, paramzzf, paramMap1, paramzzr, paramMap3, paramzza, paramArrayList1, new zzy(this, (byte)0));
    ArrayMap arrayMap = new ArrayMap();
    Iterator<Api.zzc> iterator = paramMap2.keySet().iterator();
    while (iterator.hasNext())
      arrayMap.put(iterator.next(), this.zzfvr); 
    iterator = paramMap1.keySet().iterator();
    while (iterator.hasNext())
      arrayMap.put(iterator.next(), this.zzfvs); 
    this.zzfvt = Collections.unmodifiableMap((Map<?, ?>)arrayMap);
  }
  
  public static zzv zza(Context paramContext, zzba paramzzba, Lock paramLock, Looper paramLooper, zzf paramzzf, Map paramMap1, zzr paramzzr, Map paramMap2, Api.zza paramzza, ArrayList<Object> paramArrayList) {
    Api.zze zze1;
    ArrayMap<Api.zzc, Api.zze> arrayMap2 = new ArrayMap();
    ArrayMap<Api.zzc, Api.zze> arrayMap3 = new ArrayMap();
    Iterator<Map.Entry> iterator = paramMap1.entrySet().iterator();
    paramMap1 = null;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Api.zze zze2 = (Api.zze)entry.getValue();
      if (zze2.zzacn())
        zze1 = zze2; 
      if (zze2.zzacc()) {
        arrayMap2.put((Api.zzc)entry.getKey(), zze2);
        continue;
      } 
      arrayMap3.put((Api.zzc)entry.getKey(), zze2);
    } 
    zzbq.zza(arrayMap2.isEmpty() ^ true, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    ArrayMap<Api, Boolean> arrayMap1 = new ArrayMap();
    ArrayMap<Api, Boolean> arrayMap4 = new ArrayMap();
    for (Api api : paramMap2.keySet()) {
      Api.zzc zzc = api.zzahm();
      if (arrayMap2.containsKey(zzc)) {
        arrayMap1.put(api, (Boolean)paramMap2.get(api));
        continue;
      } 
      if (arrayMap3.containsKey(zzc)) {
        arrayMap4.put(api, (Boolean)paramMap2.get(api));
        continue;
      } 
      throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
    } 
    ArrayList<zzt> arrayList1 = new ArrayList();
    ArrayList<zzt> arrayList2 = new ArrayList();
    paramArrayList = paramArrayList;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j) {
      zzt zzt = (zzt)paramArrayList.get(i);
      i++;
      zzt = zzt;
      if (arrayMap1.containsKey(zzt.zzfop)) {
        arrayList1.add(zzt);
        continue;
      } 
      if (arrayMap4.containsKey(zzt.zzfop)) {
        arrayList2.add(zzt);
        continue;
      } 
      throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
    } 
    return new zzv(paramContext, paramzzba, paramLock, paramLooper, paramzzf, (Map)arrayMap2, (Map)arrayMap3, paramzzr, paramzza, zze1, arrayList1, arrayList2, (Map)arrayMap1, (Map)arrayMap4);
  }
  
  private final void zza(ConnectionResult paramConnectionResult) {
    switch (this.zzfwb) {
      default:
        Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        break;
      case 2:
        this.zzfvq.zzc(paramConnectionResult);
      case 1:
        zzaiu();
        break;
    } 
    this.zzfwb = 0;
  }
  
  private final void zzaiu() {
    Iterator iterator = this.zzfvu.iterator();
    while (iterator.hasNext())
      iterator.next(); 
    this.zzfvu.clear();
  }
  
  private final boolean zzaiv() {
    return (this.zzfvy != null && this.zzfvy.zzcc == 4);
  }
  
  private static boolean zzb(ConnectionResult paramConnectionResult) {
    return (paramConnectionResult != null && paramConnectionResult.isSuccess());
  }
  
  public final void connect() {
    this.zzfwb = 2;
    this.zzfvz = false;
    this.zzfvy = null;
    this.zzfvx = null;
    this.zzfvr.connect();
    this.zzfvs.connect();
  }
  
  public final void disconnect() {
    this.zzfvy = null;
    this.zzfvx = null;
    this.zzfwb = 0;
    this.zzfvr.disconnect();
    this.zzfvs.disconnect();
    zzaiu();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zzfvs.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.zzfvr.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean isConnected() {
    this.zzfwa.lock();
    try {
      boolean bool = this.zzfvr.isConnected();
      boolean bool1 = true;
      if (bool) {
        bool = bool1;
        if (!this.zzfvs.isConnected()) {
          bool = bool1;
          if (!zzaiv()) {
            int i = this.zzfwb;
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
      this.zzfwa.unlock();
    } 
  }
  
  public final void zzais() {
    this.zzfvr.zzais();
    this.zzfvs.zzais();
  }
  
  public final zzm zze(zzm paramzzm) {
    Api.zzc zzc = paramzzm.zzfus;
    zzbq.checkArgument(this.zzfvt.containsKey(zzc), "GoogleApiClient is not configured to use the API required for this call.");
    if (((zzbi)this.zzfvt.get(zzc)).equals(this.zzfvs)) {
      if (zzaiv()) {
        PendingIntent pendingIntent;
        if (this.zzfvv == null) {
          zzc = null;
        } else {
          pendingIntent = PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfvq), this.zzfvv.getSignInIntent(), 134217728);
        } 
        paramzzm.zzu(new Status(4, null, pendingIntent));
        return paramzzm;
      } 
      return this.zzfvs.zze(paramzzm);
    } 
    return this.zzfvr.zze(paramzzm);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */