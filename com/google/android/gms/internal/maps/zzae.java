package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzae extends zza implements zzac {
  zzae(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
  }
  
  public final void clearTileCache() throws RemoteException {
    zzb(2, zza());
  }
  
  public final boolean getFadeIn() throws RemoteException {
    Parcel parcel = zza(11, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final String getId() throws RemoteException {
    Parcel parcel = zza(3, zza());
    String str = parcel.readString();
    parcel.recycle();
    return str;
  }
  
  public final float getTransparency() throws RemoteException {
    Parcel parcel = zza(13, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final float getZIndex() throws RemoteException {
    Parcel parcel = zza(5, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final boolean isVisible() throws RemoteException {
    Parcel parcel = zza(7, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final void remove() throws RemoteException {
    zzb(1, zza());
  }
  
  public final void setFadeIn(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(10, parcel);
  }
  
  public final void setTransparency(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(12, parcel);
  }
  
  public final void setVisible(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(6, parcel);
  }
  
  public final void setZIndex(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(4, parcel);
  }
  
  public final boolean zza(zzac paramzzac) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zza(parcel2, paramzzac);
    Parcel parcel1 = zza(8, parcel2);
    boolean bool = zzc.zza(parcel1);
    parcel1.recycle();
    return bool;
  }
  
  public final int zzj() throws RemoteException {
    Parcel parcel = zza(9, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */