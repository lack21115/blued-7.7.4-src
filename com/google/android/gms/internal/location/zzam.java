package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzam extends zza implements zzaj {
  public zzam() {
    super("com.google.android.gms.location.internal.IGeofencerCallbacks");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        if (paramInt1 != 3)
          return false; 
        zza(paramParcel1.readInt(), zzd.<PendingIntent>zza(paramParcel1, PendingIntent.CREATOR));
        return true;
      } 
      zzb(paramParcel1.readInt(), paramParcel1.createStringArray());
      return true;
    } 
    zza(paramParcel1.readInt(), paramParcel1.createStringArray());
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */