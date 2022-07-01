package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzo extends zzb implements zzn {
  public static zzn zze(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
    return (iInterface instanceof zzn) ? (zzn)iInterface : new zzp(paramIBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */