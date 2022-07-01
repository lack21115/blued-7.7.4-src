package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class zzh implements ServiceConnection, zzj {
  private final Map<ServiceConnection, ServiceConnection> zza;
  
  private int zzb;
  
  private boolean zzc;
  
  private IBinder zzd;
  
  private final GmsClientSupervisor.zza zze;
  
  private ComponentName zzf;
  
  public zzh(zzf paramzzf, GmsClientSupervisor.zza paramzza) {
    this.zze = paramzza;
    this.zza = new HashMap<ServiceConnection, ServiceConnection>();
    this.zzb = 2;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    synchronized (zzf.zza(this.zzg)) {
      zzf.zzb(this.zzg).removeMessages(1, this.zze);
      this.zzd = paramIBinder;
      this.zzf = paramComponentName;
      Iterator<ServiceConnection> iterator = this.zza.values().iterator();
      while (iterator.hasNext())
        ((ServiceConnection)iterator.next()).onServiceConnected(paramComponentName, paramIBinder); 
      this.zzb = 1;
      return;
    } 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    synchronized (zzf.zza(this.zzg)) {
      zzf.zzb(this.zzg).removeMessages(1, this.zze);
      this.zzd = null;
      this.zzf = paramComponentName;
      Iterator<ServiceConnection> iterator = this.zza.values().iterator();
      while (iterator.hasNext())
        ((ServiceConnection)iterator.next()).onServiceDisconnected(paramComponentName); 
      this.zzb = 2;
      return;
    } 
  }
  
  public final void zza(ServiceConnection paramServiceConnection1, ServiceConnection paramServiceConnection2, String paramString) {
    this.zza.put(paramServiceConnection1, paramServiceConnection2);
  }
  
  public final void zza(ServiceConnection paramServiceConnection, String paramString) {
    this.zza.remove(paramServiceConnection);
  }
  
  public final void zza(String paramString) {
    this.zzb = 3;
    this.zzc = zzf.zzd(this.zzg).zza(zzf.zzc(this.zzg), paramString, this.zze.zza(zzf.zzc(this.zzg)), this, this.zze.zzc());
    if (this.zzc) {
      Message message = zzf.zzb(this.zzg).obtainMessage(1, this.zze);
      zzf.zzb(this.zzg).sendMessageDelayed(message, zzf.zze(this.zzg));
      return;
    } 
    this.zzb = 2;
    try {
      zzf.zzd(this.zzg).unbindService(zzf.zzc(this.zzg), this);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      return;
    } 
  }
  
  public final boolean zza() {
    return this.zzc;
  }
  
  public final boolean zza(ServiceConnection paramServiceConnection) {
    return this.zza.containsKey(paramServiceConnection);
  }
  
  public final int zzb() {
    return this.zzb;
  }
  
  public final void zzb(String paramString) {
    zzf.zzb(this.zzg).removeMessages(1, this.zze);
    zzf.zzd(this.zzg).unbindService(zzf.zzc(this.zzg), this);
    this.zzc = false;
    this.zzb = 2;
  }
  
  public final boolean zzc() {
    return this.zza.isEmpty();
  }
  
  public final IBinder zzd() {
    return this.zzd;
  }
  
  public final ComponentName zze() {
    return this.zzf;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */