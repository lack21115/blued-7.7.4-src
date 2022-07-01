package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbz;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class zzbo implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzu {
  private final zzh zzfsn;
  
  final Api.zze zzfwd;
  
  boolean zzfye;
  
  private final Queue zzfzr = new LinkedList();
  
  final zzae zzfzt;
  
  final Set zzfzu = new HashSet();
  
  final Map zzfzv = new HashMap<Object, Object>();
  
  final int zzfzw;
  
  final zzcv zzfzx;
  
  private ConnectionResult zzfzz = null;
  
  public zzbo(zzbm paramzzbm, GoogleApi paramGoogleApi) {
    this.zzfwd = paramGoogleApi.zza(zzbm.zza(paramzzbm).getLooper(), this);
    if (this.zzfwd instanceof zzbz)
      zzbz.zzanb(); 
    this.zzfsn = paramGoogleApi.zzfsn;
    this.zzfzt = new zzae();
    this.zzfzw = paramGoogleApi.mId;
    if (this.zzfwd.zzacc()) {
      this.zzfzx = paramGoogleApi.zza(zzbm.zzc(paramzzbm), zzbm.zza(paramzzbm));
      return;
    } 
    this.zzfzx = null;
  }
  
  private final void zzake() {
    zzbm.zza(this.zzfzq, -1);
  }
  
  private final void zzb(zza paramzza) {
    paramzza.zza(this.zzfzt, zzacc());
    try {
      paramzza.zza(this);
      return;
    } catch (DeadObjectException deadObjectException) {
      onConnectionSuspended(1);
      this.zzfwd.disconnect();
      return;
    } 
  }
  
  private final void zzi(ConnectionResult paramConnectionResult) {
    for (zzj zzj : this.zzfzu) {
      String str = null;
      if (paramConnectionResult == ConnectionResult.zzfqt)
        str = this.zzfwd.zzahp(); 
      zzj.zza(this.zzfsn, paramConnectionResult, str);
    } 
    this.zzfzu.clear();
  }
  
  public final void connect() {
    zzbq.zza(zzbm.zza(this.zzfzq));
    if (!this.zzfwd.isConnected()) {
      if (this.zzfwd.isConnecting())
        return; 
      if (this.zzfwd.zzahn() && zzbm.zzb(this.zzfzq) != 0) {
        zzbm.zzh(this.zzfzq);
        int i = GoogleApiAvailability.zzc(zzbm.zzc(this.zzfzq), this.zzfwd.zzahq());
        zzbm.zza(this.zzfzq, i);
        if (i != 0) {
          onConnectionFailed(new ConnectionResult(i, null));
          return;
        } 
      } 
      zzbu zzbu = new zzbu(this.zzfzq, this.zzfwd, this.zzfsn);
      if (this.zzfwd.zzacc()) {
        zzcv zzcv1 = this.zzfzx;
        if (zzcv1.zzfxl != null)
          zzcv1.zzfxl.disconnect(); 
        zzcv1.zzfwf.zzgft = Integer.valueOf(System.identityHashCode(zzcv1));
        zzcv1.zzfxl = (zzcyj)zzcv1.zzfsa.zza(zzcv1.mContext, zzcv1.mHandler.getLooper(), zzcv1.zzfwf, zzcv1.zzfwf.zzgfs, zzcv1, zzcv1);
        zzcv1.zzgbd = zzbu;
        if (zzcv1.zzenh == null || zzcv1.zzenh.isEmpty()) {
          zzcv1.mHandler.post(new zzcw(zzcv1));
        } else {
          zzcv1.zzfxl.connect();
        } 
      } 
      this.zzfwd.zza(zzbu);
      return;
    } 
  }
  
  final boolean isConnected() {
    return this.zzfwd.isConnected();
  }
  
  public final void onConnected(Bundle paramBundle) {
    if (Looper.myLooper() == zzbm.zza(this.zzfzq).getLooper()) {
      zzakf();
      return;
    } 
    zzbm.zza(this.zzfzq).post(new zzbp(this));
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    zzbq.zza(zzbm.zza(this.zzfzq));
    if (this.zzfzx != null) {
      zzcv zzcv1 = this.zzfzx;
      if (zzcv1.zzfxl != null)
        zzcv1.zzfxl.disconnect(); 
    } 
    zzaki();
    zzake();
    zzi(paramConnectionResult);
    if (paramConnectionResult.zzcc == 4) {
      zzw(zzbm.zzakc());
      return;
    } 
    if (this.zzfzr.isEmpty()) {
      this.zzfzz = paramConnectionResult;
      return;
    } 
    synchronized (zzbm.zzakd()) {
      if (zzbm.zzf(this.zzfzq) != null && zzbm.zzg(this.zzfzq).contains(this.zzfsn)) {
        zzbm.zzf(this.zzfzq).zzb(paramConnectionResult, this.zzfzw);
        return;
      } 
      if (!this.zzfzq.zzc(paramConnectionResult, this.zzfzw)) {
        if (paramConnectionResult.zzcc == 18)
          this.zzfye = true; 
        if (this.zzfye) {
          zzbm.zza(this.zzfzq).sendMessageDelayed(Message.obtain(zzbm.zza(this.zzfzq), 9, this.zzfsn), zzbm.zzd(this.zzfzq));
          return;
        } 
        String str = this.zzfsn.zzfop.mName;
        null = new StringBuilder(String.valueOf(str).length() + 38);
        null.append("API: ");
        null.append(str);
        null.append(" is not available on this device.");
        zzw(new Status(17, null.toString()));
      } 
      return;
    } 
  }
  
  public final void onConnectionSuspended(int paramInt) {
    if (Looper.myLooper() == zzbm.zza(this.zzfzq).getLooper()) {
      zzakg();
      return;
    } 
    zzbm.zza(this.zzfzq).post(new zzbq(this));
  }
  
  public final void signOut() {
    zzbq.zza(zzbm.zza(this.zzfzq));
    zzw(zzbm.zzfzg);
    zzae zzae1 = this.zzfzt;
    Status status = zzbm.zzfzg;
    int i = 0;
    zzae1.zza(false, status);
    zzck[] arrayOfZzck = (zzck[])this.zzfzv.keySet().toArray((Object[])new zzck[this.zzfzv.size()]);
    int j = arrayOfZzck.length;
    while (i < j) {
      zza(new zzf(arrayOfZzck[i], new TaskCompletionSource()));
      i++;
    } 
    zzi(new ConnectionResult(4));
    if (this.zzfwd.isConnected())
      this.zzfwd.zza(new zzbs(this)); 
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api paramApi, boolean paramBoolean) {
    if (Looper.myLooper() == zzbm.zza(this.zzfzq).getLooper()) {
      onConnectionFailed(paramConnectionResult);
      return;
    } 
    zzbm.zza(this.zzfzq).post(new zzbr(this, paramConnectionResult));
  }
  
  public final void zza(zza paramzza) {
    zzbq.zza(zzbm.zza(this.zzfzq));
    if (this.zzfwd.isConnected()) {
      zzb(paramzza);
      zzakl();
      return;
    } 
    this.zzfzr.add(paramzza);
    if (this.zzfzz != null && this.zzfzz.hasResolution()) {
      onConnectionFailed(this.zzfzz);
      return;
    } 
    connect();
  }
  
  public final boolean zzacc() {
    return this.zzfwd.zzacc();
  }
  
  final void zzakf() {
    zzaki();
    zzi(ConnectionResult.zzfqt);
    zzakk();
    Iterator iterator = this.zzfzv.values().iterator();
    while (iterator.hasNext()) {
      iterator.next();
      try {
        new TaskCompletionSource();
      } catch (DeadObjectException deadObjectException) {
        onConnectionSuspended(1);
        this.zzfwd.disconnect();
        break;
      } catch (RemoteException remoteException) {}
    } 
    while (this.zzfwd.isConnected() && !this.zzfzr.isEmpty())
      zzb(this.zzfzr.remove()); 
    zzakl();
  }
  
  final void zzakg() {
    zzaki();
    this.zzfye = true;
    this.zzfzt.zza(true, zzdk.zzgbq);
    zzbm.zza(this.zzfzq).sendMessageDelayed(Message.obtain(zzbm.zza(this.zzfzq), 9, this.zzfsn), zzbm.zzd(this.zzfzq));
    zzbm.zza(this.zzfzq).sendMessageDelayed(Message.obtain(zzbm.zza(this.zzfzq), 11, this.zzfsn), zzbm.zze(this.zzfzq));
    zzake();
  }
  
  public final void zzaki() {
    zzbq.zza(zzbm.zza(this.zzfzq));
    this.zzfzz = null;
  }
  
  public final ConnectionResult zzakj() {
    zzbq.zza(zzbm.zza(this.zzfzq));
    return this.zzfzz;
  }
  
  final void zzakk() {
    if (this.zzfye) {
      zzbm.zza(this.zzfzq).removeMessages(11, this.zzfsn);
      zzbm.zza(this.zzfzq).removeMessages(9, this.zzfsn);
      this.zzfye = false;
    } 
  }
  
  final void zzakl() {
    zzbm.zza(this.zzfzq).removeMessages(12, this.zzfsn);
    zzbm.zza(this.zzfzq).sendMessageDelayed(zzbm.zza(this.zzfzq).obtainMessage(12, this.zzfsn), zzbm.zzi(this.zzfzq));
  }
  
  public final void zzw(Status paramStatus) {
    zzbq.zza(zzbm.zza(this.zzfzq));
    Iterator<zza> iterator = this.zzfzr.iterator();
    while (iterator.hasNext())
      ((zza)iterator.next()).zzs(paramStatus); 
    this.zzfzr.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */