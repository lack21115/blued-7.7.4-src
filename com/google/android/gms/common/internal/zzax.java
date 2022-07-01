package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;

public abstract class zzax extends zzew implements zzaw {
  public zzax() {
    attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (zza(paramInt1, paramParcel1, paramParcel2, paramInt2))
      return true; 
    switch (paramInt1) {
      default:
        return false;
      case 2:
        paramParcel1.readInt();
        zzex.zza(paramParcel1, Bundle.CREATOR);
        zza$68e2e3e6();
        paramParcel2.writeNoException();
        return true;
      case 1:
        break;
    } 
    zza(paramParcel1.readInt(), paramParcel1.readStrongBinder(), (Bundle)zzex.zza(paramParcel1, Bundle.CREATOR));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */