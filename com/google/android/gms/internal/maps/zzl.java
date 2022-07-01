package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzl extends zzb implements zzk {
  public static zzk zzd(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    return (iInterface instanceof zzk) ? (zzk)iInterface : new zzm(paramIBinder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */