package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzaf;

final class zzs implements TileProvider {
  private final zzaf zzel = TileOverlayOptions.zza(this.zzem);
  
  zzs(TileOverlayOptions paramTileOverlayOptions) {}
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3) {
    try {
      return this.zzel.getTile(paramInt1, paramInt2, paramInt3);
    } catch (RemoteException remoteException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */