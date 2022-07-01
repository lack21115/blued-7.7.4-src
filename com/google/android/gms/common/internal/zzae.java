package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzae implements Handler.Callback {
  public final Handler mHandler;
  
  public final Object mLock = new Object();
  
  public final zzaf zzggl;
  
  public final ArrayList zzggm = new ArrayList();
  
  public ArrayList zzggn = new ArrayList();
  
  public final ArrayList zzggo = new ArrayList();
  
  public volatile boolean zzggp = false;
  
  public final AtomicInteger zzggq = new AtomicInteger(0);
  
  public boolean zzggr = false;
  
  public zzae(Looper paramLooper, zzaf paramzzaf) {
    this.zzggl = paramzzaf;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public final boolean handleMessage(Message paramMessage) {
    if (paramMessage.what == 1) {
      null = (GoogleApiClient.ConnectionCallbacks)paramMessage.obj;
      synchronized (this.mLock) {
        if (this.zzggp && this.zzggl.isConnected() && this.zzggm.contains(null))
          null.onConnected(this.zzggl.zzagp()); 
        return true;
      } 
    } 
    int i = paramMessage.what;
    StringBuilder stringBuilder = new StringBuilder(45);
    stringBuilder.append("Don't know how to handle message: ");
    stringBuilder.append(i);
    Log.wtf("GmsClientEvents", stringBuilder.toString(), new Exception());
    return false;
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    zzbq.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock) {
      String str;
      if (this.zzggo.contains(paramOnConnectionFailedListener)) {
        str = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 67);
        stringBuilder.append("registerConnectionFailedListener(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } else {
        this.zzggo.add(str);
      } 
      return;
    } 
  }
  
  public final void zzams() {
    this.zzggp = false;
    this.zzggq.incrementAndGet();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */