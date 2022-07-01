package com.google.android.gms.common.api.internal;

import android.os.Message;

abstract class zzay implements Runnable {
  private zzay(zzao paramzzao) {}
  
  public void run() {
    Exception exception;
    this.zzfxt.zzfwa.lock();
    try {
      boolean bool = Thread.interrupted();
      if (bool) {
        this.zzfxt.zzfwa.unlock();
        return;
      } 
      zzajj();
      this.zzfxt.zzfwa.unlock();
      return;
    } catch (RuntimeException runtimeException) {
      zzbi zzbi = this.zzfxt.zzfxd;
      Message message = zzbi.zzfyx.obtainMessage(2, runtimeException);
      zzbi.zzfyx.sendMessage(message);
      this.zzfxt.zzfwa.unlock();
      return;
    } finally {}
    this.zzfxt.zzfwa.unlock();
    throw exception;
  }
  
  protected abstract void zzajj();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */