package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzbi implements zzcc, zzu {
  final Context mContext;
  
  Api.zza zzfth;
  
  final zzba zzfvq;
  
  final Lock zzfwa;
  
  zzr zzfwf;
  
  Map zzfwi;
  
  final zzf zzfwk;
  
  final Map zzfyj;
  
  final Condition zzfyw;
  
  final zzbk zzfyx;
  
  final Map zzfyy = new HashMap<Object, Object>();
  
  volatile zzbh zzfyz;
  
  int zzfzb;
  
  final zzcd zzfzc;
  
  public zzbi(Context paramContext, zzba paramzzba, Lock paramLock, Looper paramLooper, zzf paramzzf, Map paramMap1, zzr paramzzr, Map paramMap2, Api.zza paramzza, ArrayList<zzba> paramArrayList, zzcd paramzzcd) {
    this.mContext = paramContext;
    this.zzfwa = paramLock;
    this.zzfwk = paramzzf;
    this.zzfyj = paramMap1;
    this.zzfwf = paramzzr;
    this.zzfwi = paramMap2;
    this.zzfth = paramzza;
    this.zzfvq = paramzzba;
    this.zzfzc = paramzzcd;
    ArrayList<zzba> arrayList = paramArrayList;
    int j = arrayList.size();
    int i = 0;
    while (i < j) {
      paramzzba = arrayList.get(i);
      i++;
      ((zzt)paramzzba).zzfvp = this;
    } 
    this.zzfyx = new zzbk(this, paramLooper);
    this.zzfyw = paramLock.newCondition();
    this.zzfyz = new zzaz(this);
  }
  
  public final void connect() {
    this.zzfyz.connect();
  }
  
  public final void disconnect() {
    if (this.zzfyz.disconnect())
      this.zzfyy.clear(); 
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.zzfyz);
    for (Api api : this.zzfwi.keySet()) {
      paramPrintWriter.append(paramString).append(api.mName).println(":");
      ((Api.zze)this.zzfyj.get(api.zzahm())).dump$ec96877(str, paramPrintWriter);
    } 
  }
  
  public final boolean isConnected() {
    return this.zzfyz instanceof zzal;
  }
  
  public final void onConnected(Bundle paramBundle) {
    this.zzfwa.lock();
    try {
      this.zzfyz.onConnected(paramBundle);
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void onConnectionSuspended(int paramInt) {
    this.zzfwa.lock();
    try {
      this.zzfyz.onConnectionSuspended(paramInt);
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api paramApi, boolean paramBoolean) {
    this.zzfwa.lock();
    try {
      this.zzfyz.zza(paramConnectionResult, paramApi, paramBoolean);
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  final void zza(zzbj paramzzbj) {
    Message message = this.zzfyx.obtainMessage(1, paramzzbj);
    this.zzfyx.sendMessage(message);
  }
  
  public final void zzais() {
    if (isConnected()) {
      zzal zzal = (zzal)this.zzfyz;
      if (zzal.zzfxe) {
        zzal.zzfxe = false;
        zzal.zzfxd.zzfvq.zzfyp.release();
        zzal.disconnect();
      } 
    } 
  }
  
  public final zzm zze(zzm paramzzm) {
    paramzzm.zzaiq();
    return this.zzfyz.zze(paramzzm);
  }
  
  final void zzg$5d4cef71() {
    this.zzfwa.lock();
    try {
      this.zzfyz = new zzaz(this);
      this.zzfyz.begin();
      this.zzfyw.signalAll();
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */