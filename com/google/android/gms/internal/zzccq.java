package com.google.android.gms.internal;

import android.os.StrictMode;
import java.util.concurrent.Callable;

public final class zzccq {
  public static Object zzb(Callable<Callable> paramCallable) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
    try {
      StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
      paramCallable = paramCallable.call();
      return paramCallable;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzccq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */