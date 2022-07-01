package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzu extends zzb implements zzt {
  public static zzt zzg(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
    return (iInterface instanceof zzt) ? (zzt)iInterface : new zzv(paramIBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */