package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzr extends zzb implements zzq {
  public static zzq zzf(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    return (iInterface instanceof zzq) ? (zzq)iInterface : new zzs(paramIBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */