package com.google.android.gms.common.internal;

import android.util.Log;

public final class GmsLogger {
  private static final int zza = 15;
  
  private static final String zzb;
  
  private final String zzc;
  
  private final String zzd;
  
  public GmsLogger(String paramString) {
    this(paramString, null);
  }
  
  public GmsLogger(String paramString1, String paramString2) {
    boolean bool;
    Preconditions.checkNotNull(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
    this.zzc = paramString1;
    if (paramString2 == null || paramString2.length() <= 0) {
      this.zzd = null;
      return;
    } 
    this.zzd = paramString2;
  }
  
  private final String zza(String paramString) {
    String str = this.zzd;
    return (str == null) ? paramString : str.concat(paramString);
  }
  
  private final String zza(String paramString, Object... paramVarArgs) {
    paramString = String.format(paramString, paramVarArgs);
    String str = this.zzd;
    return (str == null) ? paramString : str.concat(paramString);
  }
  
  public final boolean canLog(int paramInt) {
    return Log.isLoggable(this.zzc, paramInt);
  }
  
  public final boolean canLogPii() {
    return false;
  }
  
  public final void d(String paramString1, String paramString2) {
    if (canLog(3))
      Log.d(paramString1, zza(paramString2)); 
  }
  
  public final void d(String paramString1, String paramString2, Throwable paramThrowable) {
    if (canLog(3))
      Log.d(paramString1, zza(paramString2), paramThrowable); 
  }
  
  public final void e(String paramString1, String paramString2) {
    if (canLog(6))
      Log.e(paramString1, zza(paramString2)); 
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable) {
    if (canLog(6))
      Log.e(paramString1, zza(paramString2), paramThrowable); 
  }
  
  public final void efmt(String paramString1, String paramString2, Object... paramVarArgs) {
    if (canLog(6))
      Log.e(paramString1, zza(paramString2, paramVarArgs)); 
  }
  
  public final void i(String paramString1, String paramString2) {
    if (canLog(4))
      Log.i(paramString1, zza(paramString2)); 
  }
  
  public final void i(String paramString1, String paramString2, Throwable paramThrowable) {
    if (canLog(4))
      Log.i(paramString1, zza(paramString2), paramThrowable); 
  }
  
  public final void pii(String paramString1, String paramString2) {
    if (canLogPii()) {
      paramString1 = String.valueOf(paramString1);
      if (" PII_LOG".length() != 0) {
        paramString1 = paramString1.concat(" PII_LOG");
      } else {
        paramString1 = new String(paramString1);
      } 
      Log.i(paramString1, zza(paramString2));
    } 
  }
  
  public final void pii(String paramString1, String paramString2, Throwable paramThrowable) {
    if (canLogPii()) {
      paramString1 = String.valueOf(paramString1);
      if (" PII_LOG".length() != 0) {
        paramString1 = paramString1.concat(" PII_LOG");
      } else {
        paramString1 = new String(paramString1);
      } 
      Log.i(paramString1, zza(paramString2), paramThrowable);
    } 
  }
  
  public final void v(String paramString1, String paramString2) {
    if (canLog(2))
      Log.v(paramString1, zza(paramString2)); 
  }
  
  public final void v(String paramString1, String paramString2, Throwable paramThrowable) {
    if (canLog(2))
      Log.v(paramString1, zza(paramString2), paramThrowable); 
  }
  
  public final void w(String paramString1, String paramString2) {
    if (canLog(5))
      Log.w(paramString1, zza(paramString2)); 
  }
  
  public final void w(String paramString1, String paramString2, Throwable paramThrowable) {
    if (canLog(5))
      Log.w(paramString1, zza(paramString2), paramThrowable); 
  }
  
  public final void wfmt(String paramString1, String paramString2, Object... paramVarArgs) {
    if (canLog(5))
      Log.w(this.zzc, zza(paramString2, paramVarArgs)); 
  }
  
  public final void wtf(String paramString1, String paramString2, Throwable paramThrowable) {
    if (canLog(7)) {
      Log.e(paramString1, zza(paramString2), paramThrowable);
      Log.wtf(paramString1, zza(paramString2), paramThrowable);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\GmsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */