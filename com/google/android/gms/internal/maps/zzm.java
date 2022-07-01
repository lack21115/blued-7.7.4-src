package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzm extends zza implements zzk {
  zzm(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
  }
  
  public final float getBearing() throws RemoteException {
    Parcel parcel = zza(12, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final LatLngBounds getBounds() throws RemoteException {
    Parcel parcel = zza(10, zza());
    LatLngBounds latLngBounds = zzc.<LatLngBounds>zza(parcel, LatLngBounds.CREATOR);
    parcel.recycle();
    return latLngBounds;
  }
  
  public final float getHeight() throws RemoteException {
    Parcel parcel = zza(8, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final String getId() throws RemoteException {
    Parcel parcel = zza(2, zza());
    String str = parcel.readString();
    parcel.recycle();
    return str;
  }
  
  public final LatLng getPosition() throws RemoteException {
    Parcel parcel = zza(4, zza());
    LatLng latLng = zzc.<LatLng>zza(parcel, LatLng.CREATOR);
    parcel.recycle();
    return latLng;
  }
  
  public final float getTransparency() throws RemoteException {
    Parcel parcel = zza(18, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final float getWidth() throws RemoteException {
    Parcel parcel = zza(7, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final float getZIndex() throws RemoteException {
    Parcel parcel = zza(14, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final boolean isClickable() throws RemoteException {
    Parcel parcel = zza(23, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isVisible() throws RemoteException {
    Parcel parcel = zza(16, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final void remove() throws RemoteException {
    zzb(1, zza());
  }
  
  public final void setBearing(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(11, parcel);
  }
  
  public final void setClickable(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(22, parcel);
  }
  
  public final void setDimensions(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(5, parcel);
  }
  
  public final void setPosition(LatLng paramLatLng) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramLatLng);
    zzb(3, parcel);
  }
  
  public final void setPositionFromBounds(LatLngBounds paramLatLngBounds) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramLatLngBounds);
    zzb(9, parcel);
  }
  
  public final void setTransparency(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(17, parcel);
  }
  
  public final void setVisible(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(15, parcel);
  }
  
  public final void setZIndex(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(13, parcel);
  }
  
  public final void zza(float paramFloat1, float paramFloat2) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat1);
    parcel.writeFloat(paramFloat2);
    zzb(6, parcel);
  }
  
  public final boolean zzb(zzk paramzzk) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zza(parcel2, paramzzk);
    Parcel parcel1 = zza(19, parcel2);
    boolean bool = zzc.zza(parcel1);
    parcel1.recycle();
    return bool;
  }
  
  public final void zze(IObjectWrapper paramIObjectWrapper) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzb(24, parcel);
  }
  
  public final void zzf(IObjectWrapper paramIObjectWrapper) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzb(21, parcel);
  }
  
  public final int zzj() throws RemoteException {
    Parcel parcel = zza(20, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final IObjectWrapper zzk() throws RemoteException {
    Parcel parcel = zza(25, zza());
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
    parcel.recycle();
    return iObjectWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */