package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzbid;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzcs {
  private static final ExecutorService zzfzf = new ThreadPoolExecutor(0, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)new zzbid("GAC_Transform"));
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static ExecutorService zzajx() {
    return zzfzf;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */