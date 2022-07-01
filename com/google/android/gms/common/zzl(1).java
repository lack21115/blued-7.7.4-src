package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzl {
  private static final zzl zzb = new zzl(true, null, null);
  
  final boolean zza;
  
  @Nullable
  private final String zzc;
  
  @Nullable
  private final Throwable zzd;
  
  zzl(boolean paramBoolean, @Nullable String paramString, @Nullable Throwable paramThrowable) {
    this.zza = paramBoolean;
    this.zzc = paramString;
    this.zzd = paramThrowable;
  }
  
  static zzl zza() {
    return zzb;
  }
  
  static zzl zza(String paramString) {
    return new zzl(false, paramString, null);
  }
  
  static zzl zza(String paramString, Throwable paramThrowable) {
    return new zzl(false, paramString, paramThrowable);
  }
  
  static zzl zza(Callable<String> paramCallable) {
    return new zzn(paramCallable, null);
  }
  
  static String zza(String paramString, zzd paramzzd, boolean paramBoolean1, boolean paramBoolean2) {
    String str;
    if (paramBoolean2) {
      str = "debug cert rejected";
    } else {
      str = "not whitelisted";
    } 
    return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[] { str, paramString, Hex.bytesToStringLowercase(AndroidUtilsLight.zza("SHA-1").digest(paramzzd.zza())), Boolean.valueOf(paramBoolean1), "12451009.false" });
  }
  
  @Nullable
  String zzb() {
    return this.zzc;
  }
  
  final void zzc() {
    if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
      if (this.zzd != null) {
        Log.d("GoogleCertificatesRslt", zzb(), this.zzd);
        return;
      } 
      Log.d("GoogleCertificatesRslt", zzb());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */