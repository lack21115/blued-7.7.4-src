package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
  private static final Object zza = new Object();
  
  private static ClassLoader zzb = null;
  
  private static Integer zzc = null;
  
  private boolean zzd = false;
  
  protected static boolean canUnparcelSafely(String paramString) {
    zza();
    return true;
  }
  
  protected static Integer getUnparcelClientVersion() {
    synchronized (zza) {
      return null;
    } 
  }
  
  private static ClassLoader zza() {
    synchronized (zza) {
      return null;
    } 
  }
  
  protected abstract boolean prepareForClientVersion(int paramInt);
  
  public void setShouldDowngrade(boolean paramBoolean) {
    this.zzd = paramBoolean;
  }
  
  protected boolean shouldDowngrade() {
    return this.zzd;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\DowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */