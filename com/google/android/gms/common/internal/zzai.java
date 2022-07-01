package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;

final class zzai extends zzag implements Handler.Callback {
  private final Context mApplicationContext;
  
  private final Handler mHandler;
  
  private final HashMap zzggw = new HashMap<Object, Object>();
  
  private final zza zzggx;
  
  private final long zzggy;
  
  private final long zzggz;
  
  zzai(Context paramContext) {
    this.mApplicationContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.zzggx = zza.zzanm();
    this.zzggy = 5000L;
    this.zzggz = 300000L;
  }
  
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return false;
      case 1:
        synchronized (this.zzggw) {
          zzah zzah = (zzah)paramMessage.obj;
          zzaj zzaj = (zzaj)this.zzggw.get(zzah);
          if (zzaj != null && zzaj.mState == 3) {
            String str = String.valueOf(zzah);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 47);
            stringBuilder.append("Timeout waiting for ServiceConnection callback ");
            stringBuilder.append(str);
            Log.wtf("GmsClientSupervisor", stringBuilder.toString(), new Exception());
            ComponentName componentName2 = zzaj.mComponentName;
            ComponentName componentName1 = componentName2;
            if (componentName2 == null)
              componentName1 = zzah.mComponentName; 
            componentName2 = componentName1;
            if (componentName1 == null)
              componentName2 = new ComponentName(zzah.zzggu, "unknown"); 
            zzaj.onServiceDisconnected(componentName2);
          } 
          return true;
        } 
      case 0:
        break;
    } 
    synchronized (this.zzggw) {
      zzah zzah = (zzah)paramMessage.obj;
      zzaj zzaj = (zzaj)this.zzggw.get(zzah);
      if (zzaj != null && zzaj.zzamv()) {
        if (zzaj.zzghb) {
          zzaj.zzghd.mHandler.removeMessages(1, zzaj.zzghc);
          zzaj.zzghd.mApplicationContext.unbindService(zzaj);
          zzaj.zzghb = false;
          zzaj.mState = 2;
        } 
        this.zzggw.remove(zzah);
      } 
      return true;
    } 
  }
  
  protected final boolean zza$2a82e825(zzah paramzzah, ServiceConnection paramServiceConnection) {
    zzbq.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzggw) {
      zzaj zzaj1;
      zzaj zzaj2 = (zzaj)this.zzggw.get(paramzzah);
      if (zzaj2 == null) {
        zzaj2 = new zzaj(this, paramzzah);
        zzaj2.zza$2d8eac7(paramServiceConnection);
        zzaj2.zzgr$552c4e01();
        this.zzggw.put(paramzzah, zzaj2);
        zzaj1 = zzaj2;
      } else {
        this.mHandler.removeMessages(0, zzaj1);
        if (!zzaj2.zza(paramServiceConnection)) {
          boolean bool;
          zzaj2.zza$2d8eac7(paramServiceConnection);
          switch (zzaj2.mState) {
            case 2:
              zzaj2.zzgr$552c4e01();
              zzaj1 = zzaj2;
              bool = zzaj1.zzghb;
              return bool;
            case 1:
              paramServiceConnection.onServiceConnected(zzaj2.mComponentName, zzaj2.zzgfp);
              zzaj1 = zzaj2;
              bool = zzaj1.zzghb;
              return bool;
          } 
        } else {
          String str = String.valueOf(zzaj1);
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 81);
          stringBuilder.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString());
        } 
        zzaj1 = zzaj2;
      } 
      return zzaj1.zzghb;
    } 
  }
  
  protected final void zzb$2a82e821(zzah paramzzah, ServiceConnection paramServiceConnection) {
    zzbq.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzggw) {
      zzaj zzaj = (zzaj)this.zzggw.get(paramzzah);
      if (zzaj != null) {
        Message message;
        if (zzaj.zza(paramServiceConnection)) {
          zzaj.zzgha.remove(paramServiceConnection);
          if (zzaj.zzamv()) {
            message = this.mHandler.obtainMessage(0, paramzzah);
            this.mHandler.sendMessageDelayed(message, this.zzggy);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */