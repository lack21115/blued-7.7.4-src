package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzi extends zzb implements zzh {
  public static zzh zzc(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
    return (iInterface instanceof zzh) ? (zzh)iInterface : new zzj(paramIBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */