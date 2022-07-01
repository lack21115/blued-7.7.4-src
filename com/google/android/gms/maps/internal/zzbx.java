package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

public final class zzbx extends zza implements IUiSettingsDelegate {
  zzbx(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
  }
  
  public final boolean isCompassEnabled() throws RemoteException {
    Parcel parcel = zza(10, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isIndoorLevelPickerEnabled() throws RemoteException {
    Parcel parcel = zza(17, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isMapToolbarEnabled() throws RemoteException {
    Parcel parcel = zza(19, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isMyLocationButtonEnabled() throws RemoteException {
    Parcel parcel = zza(11, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isRotateGesturesEnabled() throws RemoteException {
    Parcel parcel = zza(15, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isScrollGesturesEnabled() throws RemoteException {
    Parcel parcel = zza(12, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isScrollGesturesEnabledDuringRotateOrZoom() throws RemoteException {
    Parcel parcel = zza(21, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isTiltGesturesEnabled() throws RemoteException {
    Parcel parcel = zza(14, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isZoomControlsEnabled() throws RemoteException {
    Parcel parcel = zza(9, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isZoomGesturesEnabled() throws RemoteException {
    Parcel parcel = zza(13, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(8, parcel);
  }
  
  public final void setCompassEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(2, parcel);
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(16, parcel);
  }
  
  public final void setMapToolbarEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(18, parcel);
  }
  
  public final void setMyLocationButtonEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(3, parcel);
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(7, parcel);
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(4, parcel);
  }
  
  public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(20, parcel);
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(6, parcel);
  }
  
  public final void setZoomControlsEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(1, parcel);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(5, parcel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */