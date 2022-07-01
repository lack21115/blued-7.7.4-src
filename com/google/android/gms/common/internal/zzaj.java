package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzaj implements ServiceConnection {
  ComponentName mComponentName;
  
  int mState;
  
  IBinder zzgfp;
  
  final Set zzgha;
  
  boolean zzghb;
  
  final zzah zzghc;
  
  public zzaj(zzai paramzzai, zzah paramzzah) {
    this.zzghc = paramzzah;
    this.zzgha = new HashSet();
    this.mState = 2;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    synchronized (zzai.zza(this.zzghd)) {
      zzai.zzb(this.zzghd).removeMessages(1, this.zzghc);
      this.zzgfp = paramIBinder;
      this.mComponentName = paramComponentName;
      Iterator<ServiceConnection> iterator = this.zzgha.iterator();
      while (iterator.hasNext())
        ((ServiceConnection)iterator.next()).onServiceConnected(paramComponentName, paramIBinder); 
      this.mState = 1;
      return;
    } 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    synchronized (zzai.zza(this.zzghd)) {
      zzai.zzb(this.zzghd).removeMessages(1, this.zzghc);
      this.zzgfp = null;
      this.mComponentName = paramComponentName;
      Iterator<ServiceConnection> iterator = this.zzgha.iterator();
      while (iterator.hasNext())
        ((ServiceConnection)iterator.next()).onServiceDisconnected(paramComponentName); 
      this.mState = 2;
      return;
    } 
  }
  
  public final boolean zza(ServiceConnection paramServiceConnection) {
    return this.zzgha.contains(paramServiceConnection);
  }
  
  public final void zza$2d8eac7(ServiceConnection paramServiceConnection) {
    zzai.zzd(this.zzghd);
    zzai.zzc(this.zzghd);
    zzah zzah1 = this.zzghc;
    zzai.zzc(this.zzghd);
    zzah1.zzcq$7ec49240();
    this.zzgha.add(paramServiceConnection);
  }
  
  public final boolean zzamv() {
    return this.zzgha.isEmpty();
  }
  
  public final void zzgr$552c4e01() {
    this.mState = 3;
    zzai.zzd(this.zzghd);
    Context context = zzai.zzc(this.zzghd);
    zzah zzah1 = this.zzghc;
    zzai.zzc(this.zzghd);
    this.zzghb = zza.zza$58d5677d(context, zzah1.zzcq$7ec49240(), this, this.zzghc.zzggv);
    if (this.zzghb) {
      Message message = zzai.zzb(this.zzghd).obtainMessage(1, this.zzghc);
      zzai.zzb(this.zzghd).sendMessageDelayed(message, zzai.zze(this.zzghd));
      return;
    } 
    this.mState = 2;
    try {
      zzai.zzd(this.zzghd);
      zzai.zzc(this.zzghd).unbindService(this);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */