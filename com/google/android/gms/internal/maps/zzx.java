package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzx extends zzb implements zzw {
  public static zzw zzh(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
    return (iInterface instanceof zzw) ? (zzw)iInterface : new zzy(paramIBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */