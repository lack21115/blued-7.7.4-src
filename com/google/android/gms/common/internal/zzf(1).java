package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;

final class zzf extends GmsClientSupervisor {
  private final HashMap<GmsClientSupervisor.zza, zzh> zza = new HashMap<GmsClientSupervisor.zza, zzh>();
  
  private final Context zzb;
  
  private final Handler zzc;
  
  private final ConnectionTracker zzd;
  
  private final long zze;
  
  private final long zzf;
  
  zzf(Context paramContext) {
    this.zzb = paramContext.getApplicationContext();
    this.zzc = (Handler)new zzi(paramContext.getMainLooper(), new zzg(this, null));
    this.zzd = ConnectionTracker.getInstance();
    this.zze = 5000L;
    this.zzf = 300000L;
  }
  
  protected final boolean zza(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString) {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zza) {
      zzh zzh1;
      String str;
      zzh zzh2 = this.zza.get(paramzza);
      if (zzh2 == null) {
        zzh2 = new zzh(this, paramzza);
        zzh2.zza(paramServiceConnection, paramServiceConnection, paramString);
        zzh2.zza(paramString);
        this.zza.put(paramzza, zzh2);
        zzh1 = zzh2;
      } else {
        this.zzc.removeMessages(0, zzh1);
        if (!zzh2.zza(paramServiceConnection)) {
          zzh2.zza(paramServiceConnection, paramServiceConnection, paramString);
          int i = zzh2.zzb();
          if (i != 1) {
            if (i != 2) {
              zzh1 = zzh2;
            } else {
              zzh2.zza(paramString);
              zzh1 = zzh2;
            } 
          } else {
            paramServiceConnection.onServiceConnected(zzh2.zze(), zzh2.zzd());
            zzh1 = zzh2;
          } 
          return zzh1.zza();
        } 
        str = String.valueOf(zzh1);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 81);
        stringBuilder.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
        stringBuilder.append(str);
        throw new IllegalStateException(stringBuilder.toString());
      } 
      return str.zza();
    } 
  }
  
  protected final void zzb(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString) {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zza) {
      zzh zzh = this.zza.get(paramzza);
      if (zzh != null) {
        Message message;
        if (zzh.zza(paramServiceConnection)) {
          zzh.zza(paramServiceConnection, paramString);
          if (zzh.zzc()) {
            message = this.zzc.obtainMessage(0, paramzza);
            this.zzc.sendMessageDelayed(message, this.zze);
          } 
          return;
        } 
        str = String.valueOf(message);
        StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str).length() + 76);
        stringBuilder1.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
        stringBuilder1.append(str);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      String str = String.valueOf(str);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 50);
      stringBuilder.append("Nonexistent connection status for service config: ");
      stringBuilder.append(str);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */