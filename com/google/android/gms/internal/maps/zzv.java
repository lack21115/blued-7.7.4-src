package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

public final class zzv extends zza implements zzt {
  zzv(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
  }
  
  public final float getAlpha() throws RemoteException {
    Parcel parcel = zza(26, zza());
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
  
  public final float getRotation() throws RemoteException {
    Parcel parcel = zza(23, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final String getSnippet() throws RemoteException {
    Parcel parcel = zza(8, zza());
    String str = parcel.readString();
    parcel.recycle();
    return str;
  }
  
  public final String getTitle() throws RemoteException {
    Parcel parcel = zza(6, zza());
    String str = parcel.readString();
    parcel.recycle();
    return str;
  }
  
  public final float getZIndex() throws RemoteException {
    Parcel parcel = zza(28, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final void hideInfoWindow() throws RemoteException {
    zzb(12, zza());
  }
  
  public final boolean isDraggable() throws RemoteException {
    Parcel parcel = zza(10, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isFlat() throws RemoteException {
    Parcel parcel = zza(21, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isInfoWindowShown() throws RemoteException {
    Parcel parcel = zza(13, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isVisible() throws RemoteException {
    Parcel parcel = zza(15, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final void remove() throws RemoteException {
    zzb(1, zza());
  }
  
  public final void setAlpha(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(25, parcel);
  }
  
  public final void setAnchor(float paramFloat1, float paramFloat2) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat1);
    parcel.writeFloat(paramFloat2);
    zzb(19, parcel);
  }
  
  public final void setDraggable(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(9, parcel);
  }
  
  public final void setFlat(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(20, parcel);
  }
  
  public final void setInfoWindowAnchor(float paramFloat1, float paramFloat2) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat1);
    parcel.writeFloat(paramFloat2);
    zzb(24, parcel);
  }
  
  public final void setPosition(LatLng paramLatLng) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramLatLng);
    zzb(3, parcel);
  }
  
  public final void setRotation(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(22, parcel);
  }
  
  public final void setSnippet(String paramString) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeString(paramString);
    zzb(7, parcel);
  }
  
  public final void setTitle(String paramString) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeString(paramString);
    zzb(5, parcel);
  }
  
  public final void setVisible(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(14, parcel);
  }
  
  public final void setZIndex(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(27, parcel);
  }
  
  public final void showInfoWindow() throws RemoteException {
    zzb(11, zza());
  }
  
  public final void zze(IObjectWrapper paramIObjectWrapper) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzb(29, parcel);
  }
  
  public final void zzg(IObjectWrapper paramIObjectWrapper) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzb(18, parcel);
  }
  
  public final int zzj() throws RemoteException {
    Parcel parcel = zza(17, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final boolean zzj(zzt paramzzt) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zza(parcel2, paramzzt);
    Parcel parcel1 = zza(16, parcel2);
    boolean bool = zzc.zza(parcel1);
    parcel1.recycle();
    return bool;
  }
  
  public final IObjectWrapper zzk() throws RemoteException {
    Parcel parcel = zza(30, zza());
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
    parcel.recycle();
    return iObjectWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */