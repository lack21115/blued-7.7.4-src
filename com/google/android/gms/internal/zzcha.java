package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.internal.zzci;
import java.util.HashMap;
import java.util.Map;

public final class zzcha {
  final Context mContext;
  
  final zzchr zzitk;
  
  boolean zziud = false;
  
  final Map zziue = new HashMap<Object, Object>();
  
  final Map zziuf = new HashMap<Object, Object>();
  
  final Map zziug = new HashMap<Object, Object>();
  
  public zzcha(Context paramContext, zzchr paramzzchr) {
    this.mContext = paramContext;
    this.zzitk = paramzzchr;
  }
  
  final zzchf zzm(zzci paramzzci) {
    synchronized (this.zziue) {
      zzchf zzchf2 = (zzchf)this.zziue.get(paramzzci.zzgau);
      zzchf zzchf1 = zzchf2;
      if (zzchf2 == null)
        zzchf1 = new zzchf(paramzzci); 
      this.zziue.put(paramzzci.zzgau, zzchf1);
      return zzchf1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */