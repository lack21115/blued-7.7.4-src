package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.tasks.zzb;
import java.util.concurrent.Executor;

public final class TaskExecutors {
  public static final Executor MAIN_THREAD = new zza();
  
  static final Executor zza = new zzt();
  
  static final class zza implements Executor {
    private final Handler zza = (Handler)new zzb(Looper.getMainLooper());
    
    public final void execute(Runnable param1Runnable) {
      this.zza.post(param1Runnable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\TaskExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */