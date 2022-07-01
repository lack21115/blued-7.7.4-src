package com.google.android.gms.common.config;

import android.content.Context;
import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import java.util.Set;

public abstract class GservicesValue<T> {
  private static final Object zzc = new Object();
  
  private static zza zzd = null;
  
  private static int zze = 0;
  
  private static Context zzf;
  
  private static Set<String> zzg;
  
  protected final String zza;
  
  protected final T zzb;
  
  private T zzh = null;
  
  protected GservicesValue(String paramString, T paramT) {
    this.zza = paramString;
    this.zzb = paramT;
  }
  
  public static boolean isInitialized() {
    synchronized (zzc) {
      return false;
    } 
  }
  
  public static GservicesValue<Float> value(String paramString, Float paramFloat) {
    return new zzc(paramString, paramFloat);
  }
  
  public static GservicesValue<Integer> value(String paramString, Integer paramInteger) {
    return new zzd(paramString, paramInteger);
  }
  
  public static GservicesValue<Long> value(String paramString, Long paramLong) {
    return new zza(paramString, paramLong);
  }
  
  public static GservicesValue<String> value(String paramString1, String paramString2) {
    return new zze(paramString1, paramString2);
  }
  
  public static GservicesValue<Boolean> value(String paramString, boolean paramBoolean) {
    return new zzb(paramString, Boolean.valueOf(paramBoolean));
  }
  
  private static boolean zza() {
    synchronized (zzc) {
      return false;
    } 
  }
  
  public final T get() {
    T t = this.zzh;
    if (t != null)
      return t; 
    null = StrictMode.allowThreadDiskReads();
    synchronized (zzc) {
      synchronized (zzc) {
        zzg = null;
        zzf = null;
        try {
          null = zza(this.zza);
          StrictMode.setThreadPolicy(null);
          return (T)null;
        } catch (SecurityException null) {
          long l = Binder.clearCallingIdentity();
          try {
            null = (SecurityException)zza(this.zza);
            Binder.restoreCallingIdentity(l);
            return (T)null;
          } finally {
            Binder.restoreCallingIdentity(l);
          } 
        } finally {}
        StrictMode.setThreadPolicy(null);
        throw null;
      } 
    } 
  }
  
  @Deprecated
  public final T getBinderSafe() {
    return get();
  }
  
  public void override(T paramT) {
    Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
    this.zzh = paramT;
    synchronized (zzc) {
      zza();
      return;
    } 
  }
  
  public void resetOverride() {
    this.zzh = null;
  }
  
  protected abstract T zza(String paramString);
  
  static interface zza {
    Boolean zza(String param1String, Boolean param1Boolean);
    
    Float zza(String param1String, Float param1Float);
    
    Integer zza(String param1String, Integer param1Integer);
    
    Long zza(String param1String, Long param1Long);
    
    String zza(String param1String1, String param1String2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\config\GservicesValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */