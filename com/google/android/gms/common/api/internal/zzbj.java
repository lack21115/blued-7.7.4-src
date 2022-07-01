package com.google.android.gms.common.api.internal;

abstract class zzbj {
  private final zzbh zzfzd;
  
  protected zzbj(zzbh paramzzbh) {
    this.zzfzd = paramzzbh;
  }
  
  protected abstract void zzajj();
  
  public final void zzc(zzbi paramzzbi) {
    paramzzbi.zzfwa.lock();
    try {
      zzbh zzbh1 = paramzzbi.zzfyz;
      zzbh zzbh2 = this.zzfzd;
      if (zzbh1 != zzbh2)
        return; 
      zzajj();
      return;
    } finally {
      paramzzbi.zzfwa.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */