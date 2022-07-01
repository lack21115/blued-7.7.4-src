package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzbq;

final class zzcj extends Handler {
  public zzcj(zzci paramzzci, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    zzbq.checkArgument(bool);
    zzci zzci1 = this.zzgav;
    zzcl zzcl = (zzcl)paramMessage.obj;
    Object object = zzci1.zzgat;
    if (object != null)
      try {
        zzcl.zzu(object);
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */