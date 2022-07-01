package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public final class zzah extends zza implements zzaf {
  zzah(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt1);
    parcel.writeInt(paramInt2);
    parcel.writeInt(paramInt3);
    parcel = zza(1, parcel);
    Tile tile = zzc.<Tile>zza(parcel, Tile.CREATOR);
    parcel.recycle();
    return tile;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */