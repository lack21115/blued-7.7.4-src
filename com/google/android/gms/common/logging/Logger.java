package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public class Logger {
  private final String zza;
  
  private final String zzb;
  
  private final GmsLogger zzc;
  
  private final int zzd;
  
  private Logger(String paramString1, String paramString2) {
    this.zzb = paramString2;
    this.zza = paramString1;
    this.zzc = new GmsLogger(paramString1);
    int i;
    for (i = 2; 7 >= i && !Log.isLoggable(this.zza, i); i++);
    this.zzd = i;
  }
  
  public Logger(String paramString, String... paramVarArgs) {
    this(paramString, str);
  }
  
  public void d(String paramString, Throwable paramThrowable, Object... paramVarArgs) {
    if (isLoggable(3))
      Log.d(this.zza, format(paramString, paramVarArgs), paramThrowable); 
  }
  
  public void d(String paramString, Object... paramVarArgs) {
    if (isLoggable(3))
      Log.d(this.zza, format(paramString, paramVarArgs)); 
  }
  
  public void e(String paramString, Throwable paramThrowable, Object... paramVarArgs) {
    Log.e(this.zza, format(paramString, paramVarArgs), paramThrowable);
  }
  
  public void e(String paramString, Object... paramVarArgs) {
    Log.e(this.zza, format(paramString, paramVarArgs));
  }
  
  protected String format(String paramString, Object... paramVarArgs) {
    String str = paramString;
    if (paramVarArgs != null) {
      str = paramString;
      if (paramVarArgs.length > 0)
        str = String.format(Locale.US, paramString, paramVarArgs); 
    } 
    return this.zzb.concat(str);
  }
  
  public String getTag() {
    return this.zza;
  }
  
  public void i(String paramString, Object... paramVarArgs) {
    Log.i(this.zza, format(paramString, paramVarArgs));
  }
  
  public boolean isLoggable(int paramInt) {
    return (this.zzd <= paramInt);
  }
  
  public void v(String paramString, Throwable paramThrowable, Object... paramVarArgs) {
    if (isLoggable(2))
      Log.v(this.zza, format(paramString, paramVarArgs), paramThrowable); 
  }
  
  public void v(String paramString, Object... paramVarArgs) {
    if (isLoggable(2))
      Log.v(this.zza, format(paramString, paramVarArgs)); 
  }
  
  public void w(String paramString, Object... paramVarArgs) {
    Log.w(this.zza, format(paramString, paramVarArgs));
  }
  
  public void wtf(String paramString, Throwable paramThrowable, Object... paramVarArgs) {
    Log.wtf(this.zza, format(paramString, paramVarArgs), paramThrowable);
  }
  
  public void wtf(Throwable paramThrowable) {
    Log.wtf(this.zza, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\logging\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */