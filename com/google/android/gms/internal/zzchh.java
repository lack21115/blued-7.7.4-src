package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzx;

public final class zzchh extends zzcfq {
  final zzcha zziuk;
  
  public zzchh(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzr paramzzr) {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramzzr);
    this.zziuk = new zzcha(paramContext, this.zzitk);
  }
  
  public final void disconnect() {
    synchronized (this.zziuk) {
      boolean bool = isConnected();
      if (bool)
        try {
          null = this.zziuk;
          synchronized (null.zziue) {
            for (zzchf zzchf : null.zziue.values()) {
              if (zzchf != null)
                ((zzcgw)null.zzitk.zzalw()).zza(zzchn.zza((zzx)zzchf, (zzcgr)null)); 
            } 
            null.zziue.clear();
            synchronized (null.zziug) {
              for (zzchb zzchb : null.zziug.values()) {
                if (zzchb != null)
                  ((zzcgw)null.zzitk.zzalw()).zza(zzchn.zza((zzu)zzchb, (zzcgr)null)); 
              } 
              null.zziug.clear();
              synchronized (null.zziuf) {
                for (zzche zzche : null.zziuf.values()) {
                  if (zzche != null)
                    ((zzcgw)null.zzitk.zzalw()).zza(new zzcfw(2, null, zzche.asBinder(), null)); 
                } 
                null.zziuf.clear();
                null = this.zziuk;
                if (null.zziud) {
                  null.zzitk.zzalv();
                  ((zzcgw)null.zzitk.zzalw()).zzbo(false);
                  null.zziud = false;
                } 
              } 
            } 
          } 
        } catch (Exception exception) {
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", exception);
        }  
      super.disconnect();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzchh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */