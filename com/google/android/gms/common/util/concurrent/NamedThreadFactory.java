package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {
  private final String zza;
  
  private final int zzb;
  
  private final ThreadFactory zzc = Executors.defaultThreadFactory();
  
  public NamedThreadFactory(String paramString) {
    this(paramString, 0);
  }
  
  private NamedThreadFactory(String paramString, int paramInt) {
    this.zza = (String)Preconditions.checkNotNull(paramString, "Name must not be null");
    this.zzb = 0;
  }
  
  public Thread newThread(Runnable paramRunnable) {
    paramRunnable = this.zzc.newThread(new zza(paramRunnable, 0));
    paramRunnable.setName(this.zza);
    return (Thread)paramRunnable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\concurrent\NamedThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */