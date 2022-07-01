package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class zzg implements Handler.Callback {
  private zzg(zzf paramzzf) {}
  
  public final boolean handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 0) {
      if (i != 1)
        return false; 
      synchronized (zzf.zza(this.zza)) {
        GmsClientSupervisor.zza zza = (GmsClientSupervisor.zza)paramMessage.obj;
        zzh zzh = (zzh)zzf.zza(this.zza).get(zza);
        if (zzh != null && zzh.zzb() == 3) {
          String str = String.valueOf(zza);
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 47);
          stringBuilder.append("Timeout waiting for ServiceConnection callback ");
          stringBuilder.append(str);
          Log.e("GmsClientSupervisor", stringBuilder.toString(), new Exception());
          ComponentName componentName2 = zzh.zze();
          ComponentName componentName1 = componentName2;
          if (componentName2 == null)
            componentName1 = zza.zzb(); 
          componentName2 = componentName1;
          if (componentName1 == null)
            componentName2 = new ComponentName(Preconditions.<String>checkNotNull(zza.zza()), "unknown"); 
          zzh.onServiceDisconnected(componentName2);
        } 
        return true;
      } 
    } 
    synchronized (zzf.zza(this.zza)) {
      GmsClientSupervisor.zza zza = (GmsClientSupervisor.zza)paramMessage.obj;
      zzh zzh = (zzh)zzf.zza(this.zza).get(zza);
      if (zzh != null && zzh.zzc()) {
        if (zzh.zza())
          zzh.zzb("GmsClientSupervisor"); 
        zzf.zza(this.zza).remove(zza);
      } 
      return true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */