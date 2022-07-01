package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingServiceConnection implements ServiceConnection {
  private boolean zza = false;
  
  private final BlockingQueue<IBinder> zzb = new LinkedBlockingQueue<IBinder>();
  
  public IBinder getService() throws InterruptedException {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
    if (!this.zza) {
      this.zza = true;
      return this.zzb.take();
    } 
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  public IBinder getServiceWithTimeout(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, TimeoutException {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (!this.zza) {
      this.zza = true;
      IBinder iBinder = this.zzb.poll(paramLong, paramTimeUnit);
      if (iBinder != null)
        return iBinder; 
      throw new TimeoutException("Timed out waiting for the service connection");
    } 
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    this.zzb.add(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\BlockingServiceConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */