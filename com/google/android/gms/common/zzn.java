package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzn extends zzl {
  private final Callable<String> zzb;
  
  private zzn(Callable<String> paramCallable) {
    super(false, null, null);
    this.zzb = paramCallable;
  }
  
  final String zzb() {
    try {
      return this.zzb.call();
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */