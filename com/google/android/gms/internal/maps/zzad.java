package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzad extends zzb implements zzac {
  public static zzac zzj(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    return (iInterface instanceof zzac) ? (zzac)iInterface : new zzae(paramIBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */