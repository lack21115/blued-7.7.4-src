package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberedThreadFactory implements ThreadFactory {
  private final String zza;
  
  private final int zzb;
  
  private final AtomicInteger zzc = new AtomicInteger();
  
  private final ThreadFactory zzd = Executors.defaultThreadFactory();
  
  public NumberedThreadFactory(String paramString) {
    this(paramString, 0);
  }
  
  private NumberedThreadFactory(String paramString, int paramInt) {
    this.zza = (String)Preconditions.checkNotNull(paramString, "Name must not be null");
    this.zzb = 0;
  }
  
  public Thread newThread(Runnable paramRunnable) {
    paramRunnable = this.zzd.newThread(new zza(paramRunnable, 0));
    String str = this.zza;
    int i = this.zzc.getAndIncrement();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 13);
    stringBuilder.append(str);
    stringBuilder.append("[");
    stringBuilder.append(i);
    stringBuilder.append("]");
    paramRunnable.setName(stringBuilder.toString());
    return (Thread)paramRunnable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\concurrent\NumberedThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */