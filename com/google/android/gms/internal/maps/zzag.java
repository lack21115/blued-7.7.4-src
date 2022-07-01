package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public abstract class zzag extends zzb implements zzaf {
  public zzag() {
    super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
  }
  
  public static zzaf zzk(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    return (iInterface instanceof zzaf) ? (zzaf)iInterface : new zzah(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      Tile tile = getTile(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      zzc.zzb(paramParcel2, (Parcelable)tile);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */